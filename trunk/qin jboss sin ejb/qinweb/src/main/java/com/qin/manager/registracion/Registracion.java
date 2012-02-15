package com.qin.manager.registracion;

import com.qin.entity.Usuario;

public interface Registracion {

	Usuario login(String loginName) throws UsuarioIncorrectoException;

	Usuario getUsuario(Long id) throws Exception;
}
