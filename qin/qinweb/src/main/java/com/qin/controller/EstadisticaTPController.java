package com.qin.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qin.controller.util.JsonControllerUtil;
import com.qin.entity.Materia;
import com.qin.manager.colaboracion.ColaboracionManager;

@Controller
public class EstadisticaTPController {
	protected static Logger logger = LoggerFactory
			.getLogger(EstadisticaTPController.class);

	@Autowired
	private ColaboracionManager colaboracionManager;

	@ModelAttribute("materias")
	public List<Materia> popularMaterias() throws Exception {
		return getColaboracionManager().findAllMaterias();
	}

	@RequestMapping(value = "/estadistica_tp.html")
	public String altaTP(Model model) throws Exception {
		return "tp.estadistica";
	}

	@RequestMapping(value = "/ver_estadistica.html")
	protected String buscarTPs(Long materiaId, HttpServletRequest request)
			throws Exception {
		HashMap<Integer, String> obj = colaboracionManager
				.findAllTPNotaByMateria();
		JsonControllerUtil.sendObjectToClient(obj, request);
		return "tp.ver_estadistica_tp_en_materia";
	}

	public void setColaboracionManager(ColaboracionManager colaboracionManager) {
		this.colaboracionManager = colaboracionManager;
	}

	public ColaboracionManager getColaboracionManager() {
		return colaboracionManager;
	}
}
