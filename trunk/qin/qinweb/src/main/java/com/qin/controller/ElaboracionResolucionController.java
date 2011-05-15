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
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;
import com.qin.manager.colaboracion.ColaboracionManager;
import com.qin.manager.resolucion.ResolucionManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;

@Controller
public class ElaboracionResolucionController {
	protected static Logger logger = LoggerFactory
			.getLogger(ElaboracionResolucionController.class);

	@Autowired
	private ColaboracionManager colaboracionManager;

	@Autowired
	private TrabajoPracticoManager trabajoPracticoManager;
	
	@Autowired
	private ResolucionManager resolucionManager;

	@ModelAttribute("materias")
	public List<Materia> popularMaterias() throws Exception {
		return colaboracionManager.findAllMaterias();
	}
	
	@ModelAttribute("trabajoPractico")
	public TrabajoPractico popularTrabajoPractico() throws Exception {
		return trabajoPracticoManager.findById(1L);
	}

	@RequestMapping(value = "/guardar_resolucion.html", method = RequestMethod.POST)
	public String guardarTP(Resolucion resol, Model model) throws Exception {
		if (resol.getId() == null) {
			colaboracionManager.insertResolucion(resol);
		} else {
			colaboracionManager.updateResolucion(resol);
		}
		model.addAttribute("id", resol.getId());
		return "resolucion.alta";
	}

	@RequestMapping(value = "/alta_resolucion.html")
	public String altaTP(@RequestParam(required = false) Long id, Model model)
			throws Exception {
		Resolucion resolucion = null;
		if (id != null) {
			try {
				logger.info("id " + id);
				resolucion = resolucionManager.findById(id);
			} catch (Exception e) {
				logger.error("error al buscar", e);
			}

		}
		if (resolucion == null) {
			logger.info("creando resolucion");
			resolucion = new Resolucion();
		}
		model.addAttribute("resolucion", resolucion);
		return "resolucion.alta";
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

	public void setResolucionManager(ResolucionManager resolucionManager) {
		this.resolucionManager = resolucionManager;
	}

	public ResolucionManager getResolucionManager() {
		return resolucionManager;
	}

}
