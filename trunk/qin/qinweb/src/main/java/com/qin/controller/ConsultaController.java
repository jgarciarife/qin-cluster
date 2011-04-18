package com.qin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qin.Registracion;

@Controller
public class ConsultaController {

	// EJB inyectado por spring
	// si fuera un servlet pelado con "@EJB" alcanza
	@Autowired
	private Registracion registracionBean;
	
	@RequestMapping(value = "/consultar.html")
	protected String consultar(Model model) throws Exception {

		String nombre = getRegistracionBean().getLoginName();
		model.addAttribute("nombre", nombre);
		return "consulta";
	}

	public void setRegistracionBean(Registracion registracionBean) {
		this.registracionBean = registracionBean;
	}

	public Registracion getRegistracionBean() {
		return registracionBean;
	}
}
