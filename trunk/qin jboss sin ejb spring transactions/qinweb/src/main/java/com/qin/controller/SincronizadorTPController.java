package com.qin.controller;

import java.util.LinkedList;

import javax.jms.JMSException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qin.manager.colaboracion.SincronizadorTexto;
import com.qin.utils.ProfilingUtils;
import com.qin.utils.diff_match_patch;
import com.qin.utils.diff_match_patch.Diff;
import com.qin.utils.diff_match_patch.Patch;

@Controller
public class SincronizadorTPController {

	private static Logger logger = LoggerFactory
			.getLogger(SincronizadorTPController.class);

	@Autowired
	private SincronizadorTexto sincronizadorTexto;

	@RequestMapping(value = "/sincronizar.html", method = RequestMethod.GET)
	public @ResponseBody
	TextoResolucion sincronizar(@RequestParam Integer id,
			@RequestParam String texto, HttpSession session)
			throws JMSException {
		long inicio = ProfilingUtils.iniciar();
		String codigo = (String) session
				.getAttribute(ElaboracionResolucionController.CODIGO_RESOLUCION_COMPARTIDA);
		diff_match_patch dmp = new diff_match_patch();
		String idTextoCompartido = codigo + id;
		sincronizadorTexto.activarTp(idTextoCompartido, texto);
		boolean mergear = true;
		String resolucionEnSesison = "miTexto_" + codigo + "_" + id;
		String textoBase = (String) session.getAttribute(resolucionEnSesison);
		if (textoBase == null) {
			textoBase = sincronizadorTexto.obtenerTp(idTextoCompartido);
			if (texto.trim().equals("")) {
				mergear = false;
			}
		}
		String textoNuevo = "";
		if (mergear) {
			LinkedList<Diff> diffs = null;
			try {
				diffs = dmp.diff_main(textoBase, texto);
			} catch (Throwable t) {
				logger.debug("Excepcion de diff");
			}
			LinkedList<Patch> patches = null;
			try {
				patches = dmp.patch_make(diffs);
			} catch (Throwable t) {
				logger.debug("Excepcion de diff");
			}
			try {
				textoNuevo = sincronizadorTexto.actualizarTp(idTextoCompartido,
						patches);
			} catch (Throwable t) {
				logger.debug("Excepcion de diff");
			}
		} else {
			textoNuevo = textoBase;

		}
		session.setAttribute(resolucionEnSesison, textoNuevo);
		TextoResolucion retorno = new TextoResolucion(textoNuevo);
		ProfilingUtils.logear(inicio,
				"com.qin.controller.SincronizadorTPController.sincronizar");
		return retorno;
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