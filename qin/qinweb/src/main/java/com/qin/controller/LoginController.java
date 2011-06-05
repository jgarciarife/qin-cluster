package com.qin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qin.Registracion;

@Controller
public class LoginController {

	// EJB inyectado por spring
	// si fuera un servlet pelado con "@EJB" alcanza
	@Autowired
	private Registracion registracionBean;

	@RequestMapping(value = "/login.html")
	protected String home(@RequestParam("user") String user, HttpSession session) {

		try {
			Long id = registracionBean.login(user);
			session.setAttribute(ControllerKeys.USER_ID, id);
		} catch (Exception e) {
			return "error_logueo";
		}
		return "home";
	}

	public void setRegistracionBean(Registracion registracionBean) {
		this.registracionBean = registracionBean;
	}

	public Registracion getRegistracionBean() {
		return registracionBean;
	}
}
