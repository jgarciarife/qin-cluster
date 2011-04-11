package com.qin.eao;

import com.qin.entity.UsuarioEntity;

public interface UsuarioEAO {

	void insert(UsuarioEntity usuario) throws Exception;

	void update(UsuarioEntity usuario) throws Exception;

	void delete(UsuarioEntity usuario) throws Exception;

	UsuarioEntity findById(UsuarioEntity usuario) throws Exception;
}