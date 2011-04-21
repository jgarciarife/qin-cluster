package com.qin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class BusquedaTPController extends MultiActionController {

	@RequestMapping(value = "/iniciar_busqueda.html")
	protected String inicioBusquedaTPs() throws Exception {
		return "tp.iniciar_busqueda";
	}

	@RequestMapping(value = "/buscar.html")
	protected String buscarTPs() throws Exception {

		return "tp.resultado_busqueda";
	}

}
