package com.qin.manager.colaboracion;

import java.util.LinkedList;

import com.qin.utils.diff_match_patch.Patch;

public interface SincronizadorTexto {
	
	void activarTp(String id, String texto);

	void desactivarTp(String id);

	String actualizarTp(String id, LinkedList<Patch> patches);

	String obtenerTp(String id);

}
