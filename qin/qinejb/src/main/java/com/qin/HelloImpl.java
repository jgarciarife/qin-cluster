package com.qin;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.entity.Usuario;
import com.qin.manager.registracion.RegistracionManager;

@Stateless
public class HelloImpl implements Hello {

	protected static Logger logger = LoggerFactory.getLogger(HelloImpl.class);

	@EJB
	private RegistracionManager usuario;

	public String getMessage() {
		try {
			Usuario usuarioEntity = new Usuario();
			usuarioEntity.setId(null);
			usuarioEntity.setApellido("Moreyra");
			usuarioEntity.setNombre("Martín");
			usuarioEntity.setNombreUsuario("mmoreyra");
			usuarioEntity.setContraseniaUsuario("martin1");
			usuario.insert(usuarioEntity);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return "Holaaaaaa";
	}
}
