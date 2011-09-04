package com.qin.controller;

import java.util.LinkedList;

import javax.jms.JMSException;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qin.manager.colaboracion.SincronizadorTexto;
import com.qin.utils.diff_match_patch;
import com.qin.utils.diff_match_patch.Diff;
import com.qin.utils.diff_match_patch.Patch;

@Controller
public class SincronizadorTPController {

	@Autowired
	private SincronizadorTexto sincronizadorTexto;

	@RequestMapping(value = "/sincronizar.html", method = RequestMethod.GET)
	public @ResponseBody
	TextoResolucion sincronizar(@RequestParam Integer id,
			@RequestParam String texto, HttpSession session)
			throws JMSException {

		diff_match_patch dmp = new diff_match_patch();

		sincronizadorTexto.activarTp(id, texto); // TODO: tiene un if que lo
													// hace
													// una sola vez..
													// igualmente..
													// SACAR DE ACA

		boolean mergear = true;
		String resolucionEnSesison = "miTexto_" + id;
		String textoBase = (String) session.getAttribute(resolucionEnSesison);
		if (textoBase == null) {
			textoBase = sincronizadorTexto.obtenerTp(id);
			if (texto.trim().equals("")) {
				mergear = false;
			}
		}

		String textoNuevo = "";
		if (mergear) {
			LinkedList<Diff> diffs = dmp.diff_main(textoBase, texto);
			LinkedList<Patch> patches = dmp.patch_make(diffs);

			textoNuevo = sincronizadorTexto.actualizarTp(id, patches);
		} else {
			textoNuevo = textoBase;

		}
		session.setAttribute(resolucionEnSesison, textoNuevo);

		return new TextoResolucion(textoNuevo);
	}

	public void setSincronizadorTexto(SincronizadorTexto sincronizadorTexto) {
		this.sincronizadorTexto = sincronizadorTexto;
	}

	public SincronizadorTexto getSincronizadorTexto() {
		return sincronizadorTexto;
	}

	public static class TextoResolucion {
		private String texto;

		public TextoResolucion(String texto) {
			this.texto = texto;
		}

		public void setTexto(String texto) {
			this.texto = texto;
		}

		public String getTexto() {
			return texto;
		}
	}

}
