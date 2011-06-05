package com.qin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qin.utils.diff_match_patch;

@Controller
public class SincronizadorTPController {

	@RequestMapping(value = "/sincronizar.html", method = RequestMethod.GET)
	public @ResponseBody
	TextoResolucion sincronizar(@RequestParam String texto) {
		TextoResolucion tr = new TextoResolucion();

		diff_match_patch dmp = new diff_match_patch();
		String txt = (String) dmp.patch_apply(
				dmp.patch_make(dmp.diff_main("Algun texto", texto)), texto)[0];
		tr.setTexto(txt);
		return tr;
	}

	public static class TextoResolucion {
		private String texto;

		public void setTexto(String texto) {
			this.texto = texto;
		}

		public String getTexto() {
			return texto;
		}
	}

}
