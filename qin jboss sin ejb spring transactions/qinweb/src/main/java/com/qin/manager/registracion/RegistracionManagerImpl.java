package com.qin.manager.registracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qin.eao.usuario.UsuarioEAO;
import com.qin.entity.Usuario;
@Service
public class RegistracionManagerImpl implements RegistracionManager {

	protected static Logger logger = LoggerFactory
			.getLogger(RegistracionManagerImpl.class);

	@Autowired
	private UsuarioEAO usuarioEAO;

	public RegistracionManagerImpl() {
	}

	@Override
	public void insertUsuario(Usuario usuario) throws Exception {
		usuarioEAO.insert(usuario);
	}

	@Override
	public void updateUsuario(Usuario usuario) throws Exception {
		usuarioEAO.update(usuario);
	}

	@Override
	public void deleteUsuario(Usuario usuario) throws Exception {
		usuarioEAO.delete(usuario);
	}

	@Override
	public Usuario findUsuarioById(Long usuarioId) throws Exception {
		return usuarioEAO.findById(usuarioId);
	}
}