package com.qin.manager.colaboracion;

import java.util.LinkedList;

import javax.ejb.Local;

import com.qin.utils.diff_match_patch.Patch;

@Local
public interface SincronizadorTexto {

	void activarTp(String id, String texto);

	void desactivarTp(String id);

	String actualizarTp(String id, LinkedList<Patch> patches);

	String obtenerTp(String id);

}
