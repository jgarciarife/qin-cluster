package com.qin.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.qin.entity.Materia;
import com.qin.entity.TrabajoPractico;
import com.qin.manager.colaboracion.ColaboracionManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;

@Controller
public class ElaboracionTPController {
	protected static Logger logger = LoggerFactory
			.getLogger(ElaboracionTPController.class);

	@Autowired
	private ColaboracionManager colaboracionManager;

	@Autowired
	private TrabajoPracticoManager trabajoPracticoManager;

	@ModelAttribute("materias")
	public List<Materia> popularMaterias() throws Exception {
		return colaboracionManager.findAllMaterias();
	}

	@RequestMapping(value = "/guardar_tp.html", method = RequestMethod.POST)
	public String guardarTP(TrabajoPractico tp, Model model) throws Exception {
		logger.info("materia " + tp.getMateria().getId());
		if (tp.getId() == null) {
			colaboracionManager.insertTP(tp);
		} else {
			colaboracionManager.updateTP(tp);
		}
		model.addAttribute("id", tp.getId());
		return "tp.alta";
	}

	@RequestMapping(value = "/alta_tp.html")
	public String altaTP(@RequestParam(required = false) Long id, Model model)
			throws Exception {
		TrabajoPractico trabajoPractico = null;
		if (id != null) {
			try {
				logger.info("id " + id);
				trabajoPractico = trabajoPracticoManager.findById(id);
			} catch (Exception e) {
				logger.error("error al buscar", e);
			}

		}
		if (trabajoPractico == null) {
			logger.info("creando un nuevo TP");
			trabajoPractico = new TrabajoPractico();
		}
		model.addAttribute("trabajoPractico", trabajoPractico);
		return "tp.alta";
	}

	public void setColaboracionManager(ColaboracionManager colaboracionManager) {
		this.colaboracionManager = colaboracionManager;
	}

	public ColaboracionManager getColaboracionManager() {
		return colaboracionManager;
	}

	public void setTrabajoPracticoManager(
			TrabajoPracticoManager trabajoPracticoManager) {
		this.trabajoPracticoManager = trabajoPracticoManager;
	}

	public TrabajoPracticoManager getTrabajoPracticoManager() {
		return trabajoPracticoManager;
	}

}
