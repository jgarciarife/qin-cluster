package com.qin.manager.colaboracion;

import java.util.LinkedList;

import com.qin.utils.diff_match_patch.Patch;

public interface SincronizadorTexto {

	void activarTp(Integer id, String texto);

	void desactivarTp(Integer id);

	String actualizarTp(Integer id, LinkedList<Patch> patches);

	String obtenerTp(Integer id);

}
