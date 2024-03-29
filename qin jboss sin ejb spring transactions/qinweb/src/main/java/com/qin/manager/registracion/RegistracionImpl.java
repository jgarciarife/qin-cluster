package com.qin.manager.registracion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.usuario.UsuarioEAO;
import com.qin.entity.Usuario;

@Service
public class RegistracionImpl implements Registracion {

	@Autowired
	private UsuarioEAO usuarioEAO;

	@Transactional
	public Usuario login(String loginName) throws UsuarioIncorrectoException {
		Usuario usuario = usuarioEAO.findByName(loginName);
		if (usuario == null) {
			throw new UsuarioIncorrectoException();
		}
		return usuario;
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
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
