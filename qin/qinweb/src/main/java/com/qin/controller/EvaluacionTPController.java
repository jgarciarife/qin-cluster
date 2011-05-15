package com.qin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.qin.entity.Resolucion;
import com.qin.manager.resolucion.ResolucionManager;

@Controller
public class EvaluacionTPController {
	protected static Logger logger = LoggerFactory
			.getLogger(EvaluacionTPController.class);

	@Autowired
	private ResolucionManager resolucionManager;

	@RequestMapping(value = "/evaluar_resolucion.html")
	public String evaluarResol(Long id, Model model) throws Exception {
		Resolucion res = resolucionManager.findById(id);
		model.addAttribute("resolucion", res);
		return "resolucion.evaluacion";
	}

	@RequestMapping(value = "/guardar_evaluacion_resolucion.html", method = RequestMethod.POST)
	public String guardarEvaluacionResolucion(Resolucion resolucion,
			Model model) throws Exception {
		return "resolucion.evaluacion";
	}

	public void setResolucionManager(ResolucionManager resolucionManager) {
		this.resolucionManager = resolucionManager;
	}

	public ResolucionManager getResolucionManager() {
		return resolucionManager;
	}

}
