package com.qin;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.qin.eao.usuario.UsuarioEAO;
import com.qin.entity.Usuario;
import com.qin.manager.registracion.UsuarioIncorrectoException;

@Stateless
public class RegistracionImpl implements Registracion {

	@EJB
	private UsuarioEAO usuarioEAO;

	public Long login(String loginName) throws UsuarioIncorrectoException {
		Usuario usuario = usuarioEAO.findByName(loginName);
		if (usuario == null) {
			throw new UsuarioIncorrectoException();
		}
		return usuario.getId();
	}

	public Usuario getUsuario(Long id) throws Exception {
		Usuario usuario = usuarioEAO.findById(id);
		return usuario;
	}

	public void setUsuarioEAO(UsuarioEAO usuarioEAO) {
		this.usuarioEAO = usuarioEAO;
	}

	public UsuarioEAO getUsuarioEAO() {
		return usuarioEAO;
	}

}
