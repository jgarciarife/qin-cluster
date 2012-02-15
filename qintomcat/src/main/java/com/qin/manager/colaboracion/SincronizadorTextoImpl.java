package com.qin.manager.colaboracion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qin.utils.diff_match_patch;
import com.qin.utils.diff_match_patch.Patch;

@Service
public class SincronizadorTextoImpl implements SincronizadorTexto {

	protected static Logger logger = LoggerFactory
			.getLogger(SincronizadorTextoImpl.class);

	private Map<String, String> tpsActivos = new HashMap<String, String>();

	public void activarTp(String id, String texto) {
		if (tpsActivos.get(id) == null) {
			tpsActivos.put(id, texto);
		}
	}

	public void desactivarTp(String id) {
		tpsActivos.remove(id);
	}

	public String actualizarTp(String id, LinkedList<Patch> patches) {
		String textoBase = tpsActivos.get(id);
		diff_match_patch dmp = new diff_match_patch();
		Object[] patch_apply = dmp.patch_apply(patches, textoBase);
		String nuevoTexto = (String) patch_apply[0];
		tpsActivos.put(id, nuevoTexto);
		return nuevoTexto;
	}

	public String obtenerTp(String id) {
		return tpsActivos.get(id);
	}

}
