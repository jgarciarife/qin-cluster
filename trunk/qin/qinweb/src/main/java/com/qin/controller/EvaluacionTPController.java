package com.qin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qin.entity.TrabajoPractico;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;

@Controller
public class EvaluacionTPController {
	protected static Logger logger = LoggerFactory
			.getLogger(EvaluacionTPController.class);

	@Autowired
	private TrabajoPracticoManager trabajoPracticoManager;

	@ModelAttribute("trabajoPractico")
	public TrabajoPractico newRequest(@RequestParam(required = true) Long id) {
		TrabajoPractico trabajoPractico = null;
		try {
			logger.info("id " + id);
			trabajoPractico = trabajoPracticoManager.findById(id);
		} catch (Exception e) {
			logger.error("error al buscar", e);
		}
		return trabajoPractico;
	}

	@RequestMapping(value = "/evaluar_tp.html")
	public String evaluarTP(TrabajoPractico trabajoPractico, Model model)
			throws Exception {
		return "tp.evaluacion";
	}
	
	@RequestMapping(value = "/guardar_evaluacion_tp.html", method = RequestMethod.POST)
	public String guardarEvaluacionTP(TrabajoPractico trabajoPractico, Model model)
			throws Exception {
		return "tp.evaluacion";
	}

	public void setTrabajoPracticoManager(
			TrabajoPracticoManager trabajoPracticoManager) {
		this.trabajoPracticoManager = trabajoPracticoManager;
	}

	public TrabajoPracticoManager getTrabajoPracticoManager() {
		return trabajoPracticoManager;
	}
}
