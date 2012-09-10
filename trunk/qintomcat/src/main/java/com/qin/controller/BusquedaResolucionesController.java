package com.qin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.qin.entity.Grupo;
import com.qin.manager.colaboracion.ColaboracionManager;
import com.qin.manager.resolucion.ResolucionManager;
import com.qin.utils.ProfilingUtils;

@Controller
public class BusquedaResolucionesController extends MultiActionController {

	@Autowired
	private ColaboracionManager colaboracionManager;

	@Autowired
	private ResolucionManager resolucionManager;

	@RequestMapping(value = "/buscar_resoluciones.html")
	protected String buscarResoluciones(Long tpId, Model model)
			throws Exception {
		long inicio = ProfilingUtils.iniciar();
		List<Grupo> tps = null;
		if (tpId == null) {
			tps = resolucionManager.findAllWithGrupo();
			ProfilingUtils.logear(inicio, "com.qin.controller.BusquedaResolucionesController.buscarResoluciones: resolucionManager.findAllWithGrupo()");
		} else {
			tps = resolucionManager.findByTrabajoPracticoIdWithGroup(tpId);
			ProfilingUtils.logear(inicio, "com.qin.controller.BusquedaResolucionesController.buscarResoluciones: resolucionManager.findByTrabajoPracticoIdWithGroup(tpId)");
		}
		model.addAttribute("grupos", tps);
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
