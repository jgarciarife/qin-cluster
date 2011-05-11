package com.qin;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.manager.administracion.AdministracionManager;
import com.qin.manager.colaboracion.ColaboracionManager;
import com.qin.manager.registracion.RegistracionManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;

@Stateless
public class HelloImpl implements Hello {

	protected static Logger logger = LoggerFactory.getLogger(HelloImpl.class);

	@EJB
	private RegistracionManager usuarioManager;

	@EJB
	private AdministracionManager administracionManager;

	@EJB
	private ColaboracionManager colaboracionManager;

	@EJB
	private TrabajoPracticoManager trabajoPracticoManager;

	public String getMessage() {
		try {
			/*Docente docente = new Docente();
			docente.setId(null);
			docente.setMatricula("asd5680000");
			docente.setApellido("Moreyra");
			docente.setNombre("Martín");
			docente.setNombreUsuario("mmoreyra");
			docente.setContraseniaUsuario("martin1");
			usuarioManager.insertUsuario(docente);
			Alumno alumnoTitular = new Alumno();
			alumnoTitular.setId(null);
			alumnoTitular.setPadron("80183");
			alumnoTitular.setApellido("Barrabino");
			alumnoTitular.setNombre("Diego");
			alumnoTitular.setNombreUsuario("dbarrabino");
			alumnoTitular.setContraseniaUsuario("diego1");
			usuarioManager.insertUsuario(alumnoTitular);
			Alumno alumnoIntgrante1 = new Alumno();
			alumnoIntgrante1.setId(null);
			alumnoIntgrante1.setPadron("80184");
			alumnoIntgrante1.setApellido("Castaña");
			alumnoIntgrante1.setNombre("Cacho");
			alumnoIntgrante1.setNombreUsuario("ccastaña");
			alumnoIntgrante1.setContraseniaUsuario("cacho1");
			usuarioManager.insertUsuario(alumnoIntgrante1);
			Alumno alumnoIntgrante2 = new Alumno();
			alumnoIntgrante2.setId(null);
			alumnoIntgrante2.setPadron("80185");
			alumnoIntgrante2.setApellido("Mercado");
			alumnoIntgrante2.setNombre("Walter");
			alumnoIntgrante2.setNombreUsuario("wmercado");
			alumnoIntgrante2.setContraseniaUsuario("walter1");
			usuarioManager.insertUsuario(alumnoIntgrante2);
			Materia materia = new Materia();
			materia.setId(null);
			materia.setAnio(new Long(2011));
			materia.setCarrera("Ingeniería en Informática");
			materia.setCuatrimestre(1);
			materia.setCodigo("7565");
			materia
					.setNombre("75.65 - Manufactura Integrada por Computadora (CIM) I");
			administracionManager.insertMateria(materia);
			Grupo grupo = new Grupo();
			grupo.setId(null);
			grupo.setAlumno(alumnoTitular);
			grupo.setMateria(materia);
			List<Alumno> integrantes = new ArrayList<Alumno>();
			integrantes.add(alumnoIntgrante1);
			integrantes.add(alumnoIntgrante2);
			grupo.setIntergrantes(integrantes);
			colaboracionManager.insertGrupo(grupo);
			Enunciado punto1 = new Enunciado();
			punto1.setId(null);
			punto1.setPuntos(new Double(10));
			punto1.setEnunciado("Responda esto 1");
			trabajoPracticoManager.insertItemProductoAcademico(punto1);
			Enunciado punto2 = new Enunciado();
			punto2.setId(null);
			punto2.setPuntos(new Double(10));
			punto2.setEnunciado("Responda esto 2");
			trabajoPracticoManager.insertItemProductoAcademico(punto2);
			Enunciado punto3 = new Enunciado();
			punto3.setId(null);
			punto3.setPuntos(new Double(10));
			punto3.setEnunciado("Responda esto 3");
			trabajoPracticoManager.insertItemProductoAcademico(punto3);
			Enunciado punto4 = new Enunciado();
			punto4.setId(null);
			punto4.setPuntos(new Double(10));
			punto4.setEnunciado("Responda esto 4");
			trabajoPracticoManager.insertItemProductoAcademico(punto4);
			Enunciado punto5 = new Enunciado();
			punto5.setId(null);
			punto5.setPuntos(new Double(10));
			punto5.setEnunciado("Responda esto 5");
			trabajoPracticoManager.insertItemProductoAcademico(punto5);
			Enunciado punto6 = new Enunciado();
			punto6.setId(null);
			punto6.setPuntos(new Double(10));
			punto6.setEnunciado("Responda esto 6");
			trabajoPracticoManager.insertItemProductoAcademico(punto6);
			Enunciado punto7 = new Enunciado();
			punto7.setId(null);
			punto7.setPuntos(new Double(10));
			punto7.setEnunciado("Responda esto 7");
			trabajoPracticoManager.insertItemProductoAcademico(punto7);
			Enunciado punto8 = new Enunciado();
			punto8.setId(null);
			punto8.setPuntos(new Double(10));
			punto8.setEnunciado("Responda esto 8");
			trabajoPracticoManager.insertItemProductoAcademico(punto8);
			Enunciado punto9 = new Enunciado();
			punto9.setId(null);
			punto9.setPuntos(new Double(10));
			punto9.setEnunciado("Responda esto 9");
			trabajoPracticoManager.insertItemProductoAcademico(punto9);
			Enunciado punto10 = new Enunciado();
			punto10.setId(null);
			punto10.setPuntos(new Double(10));
			punto10.setEnunciado("Responda esto 10");
			trabajoPracticoManager.insertItemProductoAcademico(punto10);
			List<ItemProductoAcademico> itemProductoAcademicos = new ArrayList<ItemProductoAcademico>();
			itemProductoAcademicos.add(punto1);
			itemProductoAcademicos.add(punto2);
			itemProductoAcademicos.add(punto3);
			itemProductoAcademicos.add(punto4);
			itemProductoAcademicos.add(punto5);
			itemProductoAcademicos.add(punto6);
			itemProductoAcademicos.add(punto7);
			itemProductoAcademicos.add(punto8);
			itemProductoAcademicos.add(punto9);
			itemProductoAcademicos.add(punto10);
			TrabajoPractico trabajoPractico = new TrabajoPractico();
			trabajoPractico.setId(null);
			trabajoPractico.setDictamen(null);
			trabajoPractico.setMateria(materia);
			trabajoPractico.setItemProductoAcademicos(itemProductoAcademicos);
			trabajoPracticoManager.insertProductoAcademico(trabajoPractico);
			Resolucion resolucion1 = new Resolucion();
			resolucion1.setId(null);
			resolucion1.setEnunciado(punto1);
			resolucion1.setPuntos(new Double(0));
			resolucion1.setResolucion("La respuesta es: X1");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion1);
			Resolucion resolucion2 = new Resolucion();
			resolucion2.setId(null);
			resolucion2.setEnunciado(punto2);
			resolucion2.setPuntos(new Double(0));
			resolucion2.setResolucion("La respuesta es: X2");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion2);
			Resolucion resolucion3 = new Resolucion();
			resolucion3.setId(null);
			resolucion3.setEnunciado(punto3);
			resolucion3.setPuntos(new Double(0));
			resolucion3.setResolucion("La respuesta es: X3");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion3);
			Resolucion resolucion4 = new Resolucion();
			resolucion4.setId(null);
			resolucion4.setEnunciado(punto4);
			resolucion4.setPuntos(new Double(0));
			resolucion4.setResolucion("La respuesta es: X4");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion4);
			Resolucion resolucion5 = new Resolucion();
			resolucion5.setId(null);
			resolucion5.setEnunciado(punto5);
			resolucion5.setPuntos(new Double(0));
			resolucion5.setResolucion("La respuesta es: X5");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion5);
			Resolucion resolucion6 = new Resolucion();
			resolucion6.setId(null);
			resolucion6.setEnunciado(punto6);
			resolucion6.setPuntos(new Double(0));
			resolucion6.setResolucion("La respuesta es: X6");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion6);
			Resolucion resolucion7 = new Resolucion();
			resolucion7.setId(null);
			resolucion7.setEnunciado(punto7);
			resolucion7.setPuntos(new Double(0));
			resolucion7.setResolucion("La respuesta es: X7");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion7);
			Resolucion resolucion8 = new Resolucion();
			resolucion8.setId(null);
			resolucion8.setEnunciado(punto8);
			resolucion8.setPuntos(new Double(0));
			resolucion8.setResolucion("La respuesta es: X8");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion8);
			Resolucion resolucion9 = new Resolucion();
			resolucion9.setId(null);
			resolucion9.setEnunciado(punto9);
			resolucion9.setPuntos(new Double(0));
			resolucion9.setResolucion("La respuesta es: X9");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion9);
			Resolucion resolucion10 = new Resolucion();
			resolucion10.setId(null);
			resolucion10.setEnunciado(punto10);
			resolucion10.setPuntos(new Double(0));
			resolucion10.setResolucion("La respuesta es: X10");
			trabajoPracticoManager.insertItemProductoAcademico(resolucion10);
			itemProductoAcademicos = new ArrayList<ItemProductoAcademico>();
			itemProductoAcademicos.add(resolucion1);
			itemProductoAcademicos.add(resolucion2);
			itemProductoAcademicos.add(resolucion3);
			itemProductoAcademicos.add(resolucion4);
			itemProductoAcademicos.add(resolucion5);
			itemProductoAcademicos.add(resolucion6);
			itemProductoAcademicos.add(resolucion7);
			itemProductoAcademicos.add(resolucion8);
			itemProductoAcademicos.add(resolucion9);
			itemProductoAcademicos.add(resolucion10);
			trabajoPracticoManager.updateProductoAcademico(trabajoPractico);
			Dictamen dictamen = new Dictamen();
			dictamen.setId(null);
			dictamen.setDocente(docente);
			dictamen.setMateria(materia);
			dictamen.setNota(new Double(50));
			dictamen.setItemProductoAcademicos(null);
			trabajoPracticoManager.insertProductoAcademico(dictamen);
			trabajoPractico.setDictamen(dictamen);
			resolucion1.setPuntos(new Double(5));
			resolucion2.setPuntos(new Double(5));
			resolucion3.setPuntos(new Double(5));
			resolucion4.setPuntos(new Double(5));
			resolucion5.setPuntos(new Double(5));
			resolucion6.setPuntos(new Double(5));
			resolucion7.setPuntos(new Double(5));
			resolucion8.setPuntos(new Double(5));
			resolucion9.setPuntos(new Double(5));
			resolucion10.setPuntos(new Double(5));
			trabajoPracticoManager.updateProductoAcademico(trabajoPractico);*/
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "Holaaaaaa";
	}
}
