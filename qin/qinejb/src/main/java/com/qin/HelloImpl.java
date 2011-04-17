package com.qin;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.entity.Alumno;
import com.qin.manager.registracion.RegistracionManager;

@Stateless
public class HelloImpl implements Hello {

	protected static Logger logger = LoggerFactory.getLogger(HelloImpl.class);

	@EJB
	private RegistracionManager usuarioManager;

	public String getMessage() {
		try {
			Alumno alumno = new Alumno();
			alumno.setId(null);
			alumno.setPadron("80000");
			alumno.setApellido("Moreyra");
			alumno.setNombre("Martín");
			alumno.setNombreUsuario("mmoreyra");
			alumno.setContraseniaUsuario("martin1");
			usuarioManager.insertUsuario(alumno);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "Holaaaaaa";
	}
}
