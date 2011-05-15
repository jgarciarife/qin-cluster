package com.qin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.qin.entity.Resolucion;
import com.qin.manager.colaboracion.ColaboracionManager;
import com.qin.manager.resolucion.ResolucionManager;

@Controller
public class BusquedaResolucionesController extends MultiActionController {

	@Autowired
	private ColaboracionManager colaboracionManager;

	@Autowired
	private ResolucionManager resolucionManager;

	@RequestMapping(value = "/buscar_resoluciones.html")
	protected String buscarResoluciones(Long tpId, Model model)
			throws Exception {
		List<Resolucion> tps = null;
		if (tpId == null) {
			tps = resolucionManager.findAll();
		} else {
			tps = resolucionManager.findByTrabajoPracticoId(tpId);
		}
		model.addAttribute("resoluciones", tps);
		return "resolucion.resultado_busqueda";
	}

	public void setColaboracionManager(ColaboracionManager colaboracionManager) {
		this.colaboracionManager = colaboracionManager;
	}

	public ColaboracionManager getColaboracionManager() {
		return colaboracionManager;
	}

	public void setResolucionManager(ResolucionManager resolucionManager) {
		this.resolucionManager = resolucionManager;
	}

	public ResolucionManager getResolucionManager() {
		return resolucionManager;
	}

}
