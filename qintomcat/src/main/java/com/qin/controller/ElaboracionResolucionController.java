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

import com.qin.entity.Alumno;
import com.qin.entity.Materia;
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;
import com.qin.entity.Usuario;
import com.qin.manager.administracion.AdministracionManager;
import com.qin.manager.colaboracion.ColaboracionManager;
import com.qin.manager.resolucion.ResolucionManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;
import com.qin.utils.ProfilingUtils;

@Controller
public class ElaboracionResolucionController {
	protected static Logger logger = LoggerFactory
			.getLogger(ElaboracionResolucionController.class);

	public static final String CODIGO_RESOLUCION_COMPARTIDA = "codigo";

	@Autowired
	private ColaboracionManager colaboracionManager;

	@Autowired
	private ResolucionManager resolucionManager;

	@Autowired
	private TrabajoPracticoManager trabajoPracticoManager;

	@Autowired
	private AdministracionManager administracionManager;

	@ModelAttribute("materias")
	public List<Materia> popularMaterias() throws Exception {
		long inicio = ProfilingUtils.iniciar();
		List<Materia> retorno = colaboracionManager.findAllMaterias();
		ProfilingUtils
				.logear(inicio,
						"com.qin.controller.ElaboracionResolucionController.popularMaterias: List<Materia> retorno = colaboracionManager.findAllMaterias()");
		return retorno;
	}

	@RequestMapping(value = "/guardar_resolucion.html", method = RequestMethod.POST)
	public String guardarTP(Resolucion resol, Model model) throws Exception {
		long inicio = ProfilingUtils.iniciar();
		colaboracionManager.saveResolucion(resol);
		model.addAttribute("trabajoPractico", trabajoPracticoManager
				.findById(resol.getTrabajoPractico().getId()));
		model.addAttribute("resolucion",
				resolucionManager.findById(resol.getId()));
		ProfilingUtils.logear(inicio,
				"com.qin.controller.ElaboracionResolucionController.guardarResolucion");
		return "resolucion.alta";
	}

	@RequestMapping(value = "/unirse_resolucion_codigo.html")
	protected String unirseAResolucionTPs(
			@RequestParam(value = "codigo", required = true) String codigo,
			@RequestParam(value = "tpId", required = true) Long tpId,
			Model model, HttpSession session) throws Exception {
		long inicio = ProfilingUtils.iniciar();
		String retorno = altaTP(null, tpId, codigo, model, session);
		ProfilingUtils
				.logear(inicio,
						"com.qin.controller.ElaboracionResolucionController.unirseAResolucionTPs: String retorno = altaTP(null, tpId, codigo, model, session)");
		return retorno;
	}

	@RequestMapping(value = "/alta_resolucion.html")
	public String altaTP(@RequestParam(value = "id", required = false) Long id,
			@RequestParam(value = "tpId", required = false) Long tpId,
			@RequestParam(value = "codigo", required = false) String codigo,
			Model model, HttpSession session) throws Exception {
		long iniciar = ProfilingUtils.iniciar();
		long inicio = ProfilingUtils.iniciar();
		Usuario usuario = (Usuario) session
				.getAttribute(ControllerKeys.USUARIO);
		Alumno alumno = getAdministracionManager().findAlumnoByUsuario(usuario);
		ProfilingUtils
		.logear(inicio,
				"com.qin.controller.ElaboracionResolucionController.altaTP: getAdministracionManager().findAlumnoByUsuario(usuario)");
		TrabajoPractico trabajoPractico = null;
		Resolucion resolucion = null;
		if (id != null) {
			resolucion = resolucionManager.findById(id);
			ProfilingUtils
			.logear(inicio,
					"com.qin.controller.ElaboracionResolucionController.altaTP: resolucionManager.findById(id)");
			trabajoPractico = trabajoPracticoManager.findById(resolucion
					.getTrabajoPractico().getId());
			ProfilingUtils
			.logear(inicio,
					"com.qin.controller.ElaboracionResolucionController.altaTP: trabajoPracticoManager.findById(resolucion.getTrabajoPractico().getId())");
		} else if (id == null && tpId != null) {
			trabajoPractico = trabajoPracticoManager.findById(tpId);
			ProfilingUtils
			.logear(inicio,
					"com.qin.controller.ElaboracionResolucionController.altaTP: trabajoPractico = trabajoPracticoManager.findById(tpId)");
		}
		if (codigo == null) {
			codigo = colaboracionManager
					.generateCodigoResolucionCompartida(usuario);
			ProfilingUtils
			.logear(inicio,
					"com.qin.controller.ElaboracionResolucionController.altaTP: codigo = colaboracionManager.generateCodigoResolucionCompartida(usuario)");
		}
		resolucion = resolucionManager.joinResolucion(resolucion,
				trabajoPractico, alumno, codigo);
		ProfilingUtils
		.logear(inicio,
				"com.qin.controller.ElaboracionResolucionController.altaTP: resolucion = resolucionManager.joinResolucion(resolucion,trabajoPractico, alumno, codigo)");
		if (resolucion != null
				&& resolucion.getCodigoResolucionCompartida() != null
				&& !resolucion.getCodigoResolucionCompartida().equals(codigo)) {
			codigo = resolucion.getCodigoResolucionCompartida();
		}
		session.setAttribute(CODIGO_RESOLUCION_COMPARTIDA, codigo);
		model.addAttribute("trabajoPractico", trabajoPractico);
		model.addAttribute("resolucion", resolucion);
		model.addAttribute("codigo", codigo);
		ProfilingUtils
		.logear(iniciar,
				"com.qin.controller.ElaboracionResolucionController.altaTP");
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

	public void setAdministracionManager(
			AdministracionManager administracionManager) {
		this.administracionManager = administracionManager;
	}

	public AdministracionManager getAdministracionManager() {
		return administracionManager;
	}
}