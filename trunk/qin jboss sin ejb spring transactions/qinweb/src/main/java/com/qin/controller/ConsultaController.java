package com.qin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qin.entity.Usuario;
import com.qin.manager.registracion.Registracion;

@Controller
public class ConsultaController {

	@Autowired
	private Registracion registracionBean;

	@RequestMapping(value = "/consultar.html")
	protected String consultar(Model model, HttpSession session)
			throws Exception {
		Usuario usuario = (Usuario) session
				.getAttribute(ControllerKeys.USUARIO);

		model.addAttribute("nombre",
				usuario.getNombre() + " " + usuario.getApellido());
		return "consulta";
	}

	public void setRegistracionBean(Registracion registracionBean) {
		this.registracionBean = registracionBean;
	}

	public Registracion getRegistracionBean() {
		return registracionBean;
	}
}
