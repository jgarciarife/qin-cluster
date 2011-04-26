package com.qin.eao.usuario;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Usuario;

public interface UsuarioEAO extends BaseEAO {

	Usuario findById(Long usuarioId) throws Exception;
	
	List<Usuario> findAll() throws Exception;
}