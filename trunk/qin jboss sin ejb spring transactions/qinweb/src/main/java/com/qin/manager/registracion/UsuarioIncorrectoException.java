package com.qin.manager.registracion;

public class UsuarioIncorrectoException extends Exception {

	private static final long serialVersionUID = -4931711455095524796L;

	public UsuarioIncorrectoException() {
		super();
	}

	public UsuarioIncorrectoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UsuarioIncorrectoException(String message) {
		super(message);
	}

	public UsuarioIncorrectoException(Throwable cause) {
		super(cause);
	}

}
