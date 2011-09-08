package com.qin.manager.colaboracion;

import java.util.LinkedList;

import com.qin.utils.diff_match_patch.Patch;

public interface SincronizadorTexto {
	public void activarTp(String id, String texto);

	public void desactivarTp(String id);

	public String actualizarTp(String id, LinkedList<Patch> patches);

	public String obtenerTp(String id);

}
