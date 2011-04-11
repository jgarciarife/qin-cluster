package com.qin.bean;

import com.qin.entity.UsuarioEntity;

public interface Usuario {
	
	void insert(UsuarioEntity usuario) throws Exception;

	void update(UsuarioEntity usuario) throws Exception;

	void delete(UsuarioEntity usuario) throws Exception;

	UsuarioEntity findById(UsuarioEntity usuario) throws Exception;

}
