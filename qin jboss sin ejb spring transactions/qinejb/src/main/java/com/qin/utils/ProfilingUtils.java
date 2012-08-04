package com.qin.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class ProfilingUtils {

	public class Estadisticas {

		private String metodo = null;
		private long indice = 0;
		private long cantidadInvocaciones = 0;
		private double sumaTotalTiempoMilisegundos = 0;
		private double sumaTotalTiempoSegundos = 0;
		private double promedioTiempoMilisegundos = 0;
		private double promedioTiempoSegundos = 0;

		public Estadisticas(String metodo) {
			this.metodo = metodo;
		}

		public void registrarInvocacion(double tiempoMilisegundos,
				double tiempoSegundos) {
			cantidadInvocaciones++;
			sumaTotalTiempoMilisegundos += tiempoMilisegundos;
			sumaTotalTiempoSegundos += tiempoSegundos;
			promedioTiempoMilisegundos = sumaTotalTiempoMilisegundos
					/ cantidadInvocaciones;
			promedioTiempoSegundos = sumaTotalTiempoSegundos
					/ cantidadInvocaciones;
		}

		public String getMetodo() {
			return metodo;
		}

		public double getCantidadInvocaciones() {
			return cantidadInvocaciones;
		}

		public double getSumaTotalTiempoMilisegundos() {
			return sumaTotalTiempoMilisegundos;
		}

		public double getSumaTotalTiempoSegundos() {
			return sumaTotalTiempoSegundos;
		}

		public double getPromedioTiempoMilisegundos() {
			return promedioTiempoMilisegundos;
		}

		public double getPromedioTiempoSegundos() {
			return promedioTiempoSegundos;
		}

		public double getIndice() {
			return indice;
		}

		public void setIndice(long indice) {
			this.indice = indice;
		}
	}

	private static Boolean activo = Boolean.TRUE;
	private static String salida = "/opt/salida";
	private static String metodos = "/opt/metodos";
	private static File archivoSalida = null;
	private static BufferedWriter escritorSalida = null;
	private static File archivoMetodos = null;
	private static BufferedWriter escritorMetodos = null;
	private static Map<String, Estadisticas> metodosEstadisticas = null;
	private static long indice = 0;

	public static void inicializar() {
		try {
			if (activo) {
				Date ahora = new Date();
				String anio = Integer.toString(ahora.getYear() + 1900);
				String mes = Integer.toString(ahora.getMonth() + 1);
				if (new Integer(mes).intValue() < 10) {
					mes = "0" + mes;
				}
				String dia = Integer.toString(ahora.getDate());
				if (new Integer(dia).intValue() < 10) {
					dia = "0" + dia;
				}
				String hora = Integer.toString(ahora.getHours());
				if (new Integer(hora).intValue() < 10) {
					hora = "0" + hora;
				}
				String minuto = Integer.toString(ahora.getMinutes());
				if (new Integer(minuto).intValue() < 10) {
					minuto = "0" + minuto;
				}
				String segundo = Integer.toString(ahora.getSeconds());
				if (new Integer(segundo).intValue() < 10) {
					segundo = "0" + segundo;
				}
				String subfijo = anio + mes + dia + hora + minuto + segundo;
				salida = salida + "-" + subfijo + ".log";
				metodos = metodos + "-" + subfijo + ".log";
				archivoSalida = new File(salida);
				escritorSalida = new BufferedWriter(new FileWriter(
						archivoSalida));
				archivoMetodos = new File(metodos);
				escritorMetodos = new BufferedWriter(new FileWriter(
						archivoMetodos));
				metodosEstadisticas = new HashMap<String, Estadisticas>();
				escritorSalida.write("metodo" + "\t" + "tiempo [milisegundos]"
						+ "\t" + "tiempo [segundos]" + "\n");
				escritorSalida.flush();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void cerrar() {
		try {
			if (activo) {
				if (escritorSalida != null) {
					escritorSalida.close();
				}
				TreeSet<String> keys = new TreeSet<String>(
						metodosEstadisticas.keySet());
				escritorMetodos.write("indice" + "\t" + "metodo" + "\t"
						+ "cantidad de invocaciones" + "\t"
						+ "suma total de tiempo [milisegundos]" + "\t"
						+ "suma total de tiempo [segundos]" + "\t"
						+ "promedio de tiempo [milisegundos]" + "\t"
						+ "promedio de tiempo [segundos]" + "\n");
				escritorMetodos.flush();
				for (String key : keys) {
					Estadisticas estadisticas = metodosEstadisticas.get(key);
					escritorMetodos.write(estadisticas.getIndice()
							+ "\t"
							+ estadisticas.getMetodo()
							+ "\t"
							+ Double.toString(estadisticas
									.getCantidadInvocaciones())
							+ "\t"
							+ Double.toString(estadisticas
									.getSumaTotalTiempoMilisegundos())
							+ "\t"
							+ Double.toString(estadisticas
									.getSumaTotalTiempoSegundos())
							+ "\t"
							+ Double.toString(estadisticas
									.getPromedioTiempoMilisegundos())
							+ "\t"
							+ Double.toString(estadisticas
									.getPromedioTiempoSegundos()) + "\n");
					escritorMetodos.flush();
				}
				if (escritorMetodos != null) {
					escritorMetodos.close();
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void setActivo() {
		activo = Boolean.TRUE;
	}

	public static void setInactivo() {
		activo = Boolean.FALSE;
	}

	public static long iniciar() {
		return new Date().getTime();
	}

	public static void logear(long inicio, String nombreMetodo) {
		try {
			if (activo) {
				long fin = new Date().getTime();
				double diferenciaMilisegundos = fin - inicio;
				double diferenciaSegundos = diferenciaMilisegundos / 1000;
				nombreMetodo = nombreMetodo.replaceAll("\\.", " ");
				escritorSalida.write(nombreMetodo + "\t"
						+ Double.toString(diferenciaMilisegundos) + "\t"
						+ Double.toString(diferenciaSegundos) + "\n");
				escritorSalida.flush();
				Estadisticas estadisticas = null;
				if (metodosEstadisticas.containsKey(nombreMetodo)) {
					estadisticas = metodosEstadisticas.get(nombreMetodo);
				} else {
					indice++;
					estadisticas = new ProfilingUtils().new Estadisticas(
							nombreMetodo);
					estadisticas.setIndice(indice);
				}
				estadisticas.registrarInvocacion(diferenciaMilisegundos,
						diferenciaSegundos);
				metodosEstadisticas.put(nombreMetodo, estadisticas);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}