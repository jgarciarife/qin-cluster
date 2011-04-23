package com.qin.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.qin.entity.Enunciado;
import com.qin.entity.ItemProductoAcademico;
import com.qin.entity.Materia;
import com.qin.entity.TrabajoPractico;
import com.qin.manager.colaboracion.ColaboracionManager;

@Controller
public class ElaboracionTPController extends MultiActionController {

	@Autowired
	private ColaboracionManager colaboracionManager;

	@ModelAttribute("materias")
	public List<Materia> popularMaterias() throws Exception {
		return  colaboracionManager.findAllMaterias();
	}

	@RequestMapping(value = "/alta_tp.html")
	public String altaTP(Model model) throws Exception {
		List<Materia> materias = colaboracionManager.findAllMaterias();
		model.addAttribute("materia", materias.get(0).getCodigo());
		return "tp.alta";
	}

	@RequestMapping(value = "/guardar_tp.html")
	public String guardarTP(@RequestParam("contenido") String contenido) throws Exception {
		Materia materia = new Materia();
		materia.setId(null);
		materia.setAnio(new Long(2011));
		materia.setCarrera("Ingeniería en Informática");
		materia.setCuatrimestre(1);
		materia.setCodigo("7565");
		materia.setNombre("75.65 - Manufactura Integrada por Computadora (CIM) I");

		Enunciado punto1 = new Enunciado();
		punto1.setId(null);
		punto1.setPuntos(new Double(10));
		punto1.setEnunciado(contenido);

		List<ItemProductoAcademico> itemProductoAcademicos = new ArrayList<ItemProductoAcademico>();
		itemProductoAcademicos.add(punto1);
		TrabajoPractico trabajoPractico = new TrabajoPractico();
		trabajoPractico.setId(null);
		trabajoPractico.setDictamen(null);
		trabajoPractico.setMateria(materia);
		trabajoPractico.setItemProductoAcademicos(itemProductoAcademicos);
		colaboracionManager.insertTP(trabajoPractico);

		return "tp.alta";
	}

	public void setColaboracionManager(ColaboracionManager colaboracionManager) {
		this.colaboracionManager = colaboracionManager;
	}

	public ColaboracionManager getColaboracionManager() {
		return colaboracionManager;
	}

}
