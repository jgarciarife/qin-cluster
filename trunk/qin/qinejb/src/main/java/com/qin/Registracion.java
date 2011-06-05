package com.qin;

import com.qin.entity.Usuario;
import com.qin.manager.registracion.UsuarioIncorrectoException;

public interface Registracion {

	public Long login(String loginName) throws UsuarioIncorrectoException;

	public Usuario getUsuario(Long id) throws Exception;
}
