package com.qin;

import javax.ejb.Stateful;

@Stateful
public class RegistracionImpl implements Registracion {
	private String loginName = "No lo se";

	public void login(String loginName) {
		this.loginName = loginName;
	}

	public String getLoginName() {
		return loginName;
	}
}
