package com.qin.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.qin.entity.Alumno;
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;
import com.qin.entity.Usuario;
import com.qin.manager.administracion.AdministracionManager;
import com.qin.manager.resolucion.ResolucionManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;

@Controller
public class UnirseAResolucionController extends MultiActionController {

	@RequestMapping(value = "/unirse_resolucion.html")
	protected String inicioUnirseAResolucionTPs(
			@RequestParam(value = "tpId", required = false) Long tpId,
			Model model, HttpSession session) throws Exception {
		model.addAttribute("tpId", tpId);
		return "tp.unirse_resolucion";
	}
}
