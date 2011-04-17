package com.qin;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.entity.Alumno;
import com.qin.entity.Docente;
import com.qin.manager.registracion.RegistracionManager;

@Stateless
public class HelloImpl implements Hello {

	protected static Logger logger = LoggerFactory.getLogger(HelloImpl.class);

	@EJB
	private RegistracionManager usuarioManager;

	public String getMessage() {
		try {
			Docente docente = new Docente();
			docente.setId(null);
			docente.setMatricula("asd5680000");
			docente.setApellido("Moreyra");
			docente.setNombre("Martín");
			docente.setNombreUsuario("mmoreyra");
			docente.setContraseniaUsuario("martin1");
			usuarioManager.insertUsuario(docente);
			Alumno alumno = new Alumno();
			alumno.setId(null);
			alumno.setPadron("80183");
			alumno.setApellido("Barrabino");
			alumno.setNombre("Diego");
			alumno.setNombreUsuario("dbarrabino");
			alumno.setContraseniaUsuario("diego1");
			usuarioManager.insertUsuario(alumno);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "Holaaaaaa";
	}
}
