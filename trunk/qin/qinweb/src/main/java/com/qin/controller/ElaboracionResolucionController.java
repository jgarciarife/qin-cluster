package com.qin.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.qin.entity.Respuesta;
import com.qin.entity.TrabajoPractico;
import com.qin.manager.colaboracion.ColaboracionManager;
import com.qin.manager.resolucion.ResolucionManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;

@Controller
public class ElaboracionResolucionController {
	protected static Logger logger = LoggerFactory
			.getLogger(ElaboracionResolucionController.class);

	public static final String CODIGO_RESOLUCION_COMPARTIDA = "codigo";

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

	@RequestMapping(value = "/guardar_resolucion.html", method = RequestMethod.POST)
	public String guardarTP(Resolucion resol, Model model) throws Exception {
		if (resol.getRespuestas() != null) {
			for (Respuesta r : resol.getRespuestas()) {
				r.setResolucion(resol);
			}
		}
		if (resol.getId() == null) {
			colaboracionManager.insertResolucion(resol);
		} else {
			colaboracionManager.updateResolucion(resol);
		}
		model.addAttribute("trabajoPractico", trabajoPracticoManager
				.findById(resol.getTrabajoPractico().getId()));
		model.addAttribute("resolucion",
				resolucionManager.findById(resol.getId()));
		return "resolucion.alta";
	}

	@RequestMapping(value = "/unirse_resolucion_codigo.html")
	protected String unirseAResolucionTPs(
			@RequestParam(value = "codigo", required = true) String codigo,
			@RequestParam(value = "tpId", required = true) Long tpId,
			Model model, HttpSession session) throws Exception {

		return altaTP(null, tpId, codigo, model, session);
	}

	@RequestMapping(value = "/alta_resolucion.html")
	public String altaTP(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "tpId", required = false) Long tpId,
			@RequestParam(value = "codigo", required = false) String codigo,
			Model model, HttpSession session) throws Exception {

		if (codigo == null) {
			codigo = String.valueOf(Math.round(Math.random() * 1000));
		}

		session.setAttribute(CODIGO_RESOLUCION_COMPARTIDA, codigo);

		Resolucion resolucion = null;
		TrabajoPractico tp = null;
		if (id != null) {
			try {
				logger.info("id " + id);
				resolucion = resolucionManager.findById(id);
				tp = trabajoPracticoManager.findById(resolucion
						.getTrabajoPractico().getId());
			} catch (Exception e) {
				logger.error("error al buscar", e);
			}

		}

		if (id == null && tpId != null) {
			tp = trabajoPracticoManager.findById(tpId);
		}

		if (resolucion == null) {
			logger.info("creando resolucion");
			resolucion = new Resolucion();
		}

		model.addAttribute("trabajoPractico", tp);
		model.addAttribute("resolucion", resolucion);
		model.addAttribute("codigo", codigo);

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
