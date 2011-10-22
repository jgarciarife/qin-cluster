package com.qin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qin.entity.Correccion;
import com.qin.entity.Dictamen;
import com.qin.entity.Resolucion;
import com.qin.manager.dictamen.DictamenManager;
import com.qin.manager.resolucion.ResolucionManager;

@Controller
public class EvaluacionTPController {
	protected static Logger logger = LoggerFactory
			.getLogger(EvaluacionTPController.class);

	@Autowired
	private ResolucionManager resolucionManager;

	@Autowired
	private DictamenManager dictamenManager;

	@RequestMapping(value = "/evaluar_resolucion.html")
	public String evaluarResol(
			@RequestParam(value = "id", required = false) Long id, Model model)
			throws Exception {
		Resolucion res = resolucionManager.findById(id);
		model.addAttribute("resolucion", res);

		Dictamen dictamen = null;
		if (id != null) {
			try {
				logger.info("id " + id);
				dictamen = getDictamenManager().findByResolucionId(id);
			} catch (Exception e) {
				logger.error("error al buscar", e);
			}

		}

		if (dictamen == null) {
			dictamen = new Dictamen();
		}

		model.addAttribute("dictamen", dictamen);
		return "resolucion.evaluacion";
	}

	@RequestMapping(value = "/guardar_evaluacion_resolucion.html", method = RequestMethod.POST)
	public String guardarEvaluacionResolucion(Dictamen dictamen, Model model)
			throws Exception {
		Double total = 0D;
		if (dictamen.getCorreccions() != null) {
			for (Correccion r : dictamen.getCorreccions()) {
				r.setDictamen(dictamen);
				total += r.getPuntaje();
			}
		}
		dictamen.setPuntaje(total);
		if (dictamen.getId() == null) {
			dictamenManager.insert(dictamen);
		} else {
			dictamenManager.update(dictamen);
		}

		dictamen = dictamenManager.findById(dictamen.getId());
		model.addAttribute("dictamen", dictamen);
		Resolucion res = resolucionManager.findById(dictamen.getResolucion()
				.getId());
		model.addAttribute("resolucion", res);
		return "resolucion.evaluacion";
	}

	public void setResolucionManager(ResolucionManager resolucionManager) {
		this.resolucionManager = resolucionManager;
	}

	public ResolucionManager getResolucionManager() {
		return resolucionManager;
	}

	public void setDictamenManager(DictamenManager dictamenManager) {
		this.dictamenManager = dictamenManager;
	}

	public DictamenManager getDictamenManager() {
		return dictamenManager;
	}

}
