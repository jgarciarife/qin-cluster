package com.qin.bean;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.UsuarioEAO;
import com.qin.entity.UsuarioEntity;

@Stateless
public class UsuarioBean implements Usuario {

	protected static Logger logger = LoggerFactory.getLogger(UsuarioBean.class);

	@EJB
	private UsuarioEAO usuarioEAO;

	@Override
	public void insert(UsuarioEntity usuario) throws Exception {
		usuarioEAO.insert(usuario);
	}

	@Override
	public void update(UsuarioEntity usuario) throws Exception {
		usuarioEAO.update(usuario);
	}

	@Override
	public void delete(UsuarioEntity usuario) throws Exception {
		usuarioEAO.delete(usuario);
	}

	@Override
	public UsuarioEntity findById(UsuarioEntity usuario) throws Exception {
		return usuarioEAO.findById(usuario);
	}

}
