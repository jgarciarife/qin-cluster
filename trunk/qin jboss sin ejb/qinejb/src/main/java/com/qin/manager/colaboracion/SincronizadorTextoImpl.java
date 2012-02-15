package com.qin.manager.colaboracion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.utils.diff_match_patch;
import com.qin.utils.diff_match_patch.Patch;

@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class SincronizadorTextoImpl implements SincronizadorTexto {

	protected static Logger logger = LoggerFactory
			.getLogger(SincronizadorTextoImpl.class);

	private Map<String, String> tpsActivos = new HashMap<String, String>();

	@Lock(LockType.READ)
	public void activarTp(String id, String texto) {
		if (tpsActivos.get(id) == null) {
			tpsActivos.put(id, texto);
		}
	}

	@Lock(LockType.WRITE)
	public void desactivarTp(String id) {
		tpsActivos.remove(id);
	}

	@Lock(LockType.WRITE)
	public String actualizarTp(String id, LinkedList<Patch> patches) {
		String textoBase = tpsActivos.get(id);
		diff_match_patch dmp = new diff_match_patch();
		Object[] patch_apply = dmp.patch_apply(patches, textoBase);
		String nuevoTexto = (String) patch_apply[0];
		tpsActivos.put(id, nuevoTexto);
		return nuevoTexto;
	}

	@Lock(LockType.READ)
	public String obtenerTp(String id) {
		return tpsActivos.get(id);
	}

}
