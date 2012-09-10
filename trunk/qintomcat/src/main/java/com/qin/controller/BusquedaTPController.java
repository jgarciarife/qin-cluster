package com.qin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.qin.entity.Materia;
import com.qin.entity.TrabajoPractico;
import com.qin.manager.colaboracion.ColaboracionManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;
import com.qin.utils.ProfilingUtils;

@Controller
public class BusquedaTPController extends MultiActionController {

	@Autowired
	private ColaboracionManager colaboracionManager;

	@Autowired
	private TrabajoPracticoManager trabajoPracticoManager;

	@ModelAttribute("materias")
	public List<Materia> popularMaterias() throws Exception {
		long inicio = ProfilingUtils.iniciar();
		List<Materia> retorno = colaboracionManager.findAllMaterias();
		ProfilingUtils.logear(inicio, "com.qin.controller.BusquedaTPController.popularMaterias");
		return retorno;
	}

	@RequestMapping(value = "/iniciar_busqueda.html")
	protected String inicioBusquedaTPs() throws Exception {
		return "tp.iniciar_busqueda";
	}

	@RequestMapping(value = "/buscar.html")
	protected String buscarTPs(Long materiaId, Model model) throws Exception {
		long inicio = ProfilingUtils.iniciar();
		List<TrabajoPractico> tps = null;		
		if (materiaId.intValue() == -1){
			tps = trabajoPracticoManager.findAll();
			ProfilingUtils.logear(inicio,
					"com.qin.controller.BusquedaTPController.buscarTPs: trabajoPracticoManager.findAll()");
		} else{
			tps = trabajoPracticoManager
			.findByMateriaId(materiaId);
			ProfilingUtils.logear(inicio,
					"com.qin.controller.BusquedaTPController.buscarTPs: trabajoPracticoManager.findByMateriaId(materiaId)");
		}
		model.addAttribute("trabajos", tps);
		return "tp.resultado_busqueda";
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
