package com.qin.manager.registracion;

import com.qin.entity.Usuario;

public interface RegistracionManager {

	void insertUsuario(Usuario usuario) throws Exception;

	void updateUsuario(Usuario usuario) throws Exception;

	void deleteUsuario(Usuario usuario) throws Exception;

	Usuario findUsuarioById(Long usuarioId) throws Exception;

}
