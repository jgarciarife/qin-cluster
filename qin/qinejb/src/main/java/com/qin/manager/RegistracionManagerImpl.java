package com.qin.manager;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.UsuarioEAO;
import com.qin.entity.Usuario;
import com.qin.manager.base.ManagerBaseImpl;

@Stateless
public class RegistracionManagerImpl extends ManagerBaseImpl implements
		RegistracionManager {

	protected static Logger logger = LoggerFactory
			.getLogger(RegistracionManagerImpl.class);

	@EJB
	private UsuarioEAO usuarioEAO;

	@Override
	public void insert(Usuario usuario) throws Exception {
		usuarioEAO.insert(usuario);
	}

	@Override
	public void update(Usuario usuario) throws Exception {
		usuarioEAO.update(usuario);
	}

	@Override
	public void delete(Usuario usuario) throws Exception {
		usuarioEAO.delete(usuario);
	}

	@Override
	public Usuario findById(Usuario usuario) throws Exception {
		return usuarioEAO.findById(usuario);
	}
}