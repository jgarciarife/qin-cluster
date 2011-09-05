package com.qin;

import com.qin.entity.Usuario;
import com.qin.manager.registracion.UsuarioIncorrectoException;

public interface Registracion {

	Long login(String loginName) throws UsuarioIncorrectoException;

	Usuario getUsuario(Long id) throws Exception;
}
