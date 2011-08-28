package com.qin.manager.colaboracion;

import java.util.LinkedList;

import com.qin.utils.diff_match_patch.Patch;

public interface SincronizadorTexto {
	public void activarTp(Integer id, String texto);

	public void desactivarTp(Integer id);

	public String actualizarTp(Integer id, LinkedList<Patch> patches);

	public String obtenerTp(Integer id);

}
