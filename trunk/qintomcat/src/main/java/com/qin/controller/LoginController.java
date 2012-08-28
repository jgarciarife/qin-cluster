package com.qin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.qin.entity.Usuario;
import com.qin.manager.registracion.Registracion;
import com.qin.utils.ProfilingUtils;

@Controller
public class LoginController {

	@Autowired
	private Registracion registracionBean;

	@RequestMapping(value = "/login.html")
	protected String home(@RequestParam("user") String user, HttpSession session) {
		long inicio = ProfilingUtils.iniciar();
		try {
			Usuario usuario = registracionBean.login(user);
			session.setAttribute(ControllerKeys.USUARIO, usuario);
		} catch (Exception e) {
			return "error_logueo";
		}
		ProfilingUtils.logear(inicio,
				"com.qin.controller.LoginController.home");
		return "home";
	}

	public void setRegistracionBean(Registracion registracionBean) {
		this.registracionBean = registracionBean;
	}

	public Registracion getRegistracionBean() {
		return registracionBean;
	}
}
