package com.qin.eao;

import com.qin.entity.Usuario;

public interface UsuarioEAO {

	void insert(Usuario usuario) throws Exception;

	void update(Usuario usuario) throws Exception;

	void delete(Usuario usuario) throws Exception;

	Usuario findById(Usuario usuario) throws Exception;
}