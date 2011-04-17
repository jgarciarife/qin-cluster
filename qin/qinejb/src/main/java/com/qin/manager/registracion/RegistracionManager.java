package com.qin.manager.registracion;

import com.qin.entity.Usuario;

public interface RegistracionManager {

	void insert(Usuario usuario) throws Exception;

	void update(Usuario usuario) throws Exception;

	void delete(Usuario usuario) throws Exception;

	Usuario findById(Long usuarioId) throws Exception;

}
