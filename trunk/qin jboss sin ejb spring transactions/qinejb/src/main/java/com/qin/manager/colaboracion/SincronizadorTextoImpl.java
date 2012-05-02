package com.qin.manager.colaboracion;

import java.util.LinkedList;

import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.cache.pojo.manager.PojoCacheManager;
import com.qin.cache.pojo.manager.PojoCacheManagerImpl;
import com.qin.utils.HAUtils;
import com.qin.utils.diff_match_patch;
import com.qin.utils.diff_match_patch.Patch;

@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
@Singleton
public class SincronizadorTextoImpl implements SincronizadorTexto {

	protected static Logger logger = LoggerFactory
			.getLogger(SincronizadorTextoImpl.class);

	// private Map<String, String> tpsActivos = new HashMap<String, String>();

	// @Lock(LockType.READ)
	// public void activarTp(String id, String texto) {
	// if (tpsActivos.get(id) == null) {
	// tpsActivos.put(id, texto);
	// }
	// }

	@Lock(LockType.READ)
	public void activarTp(String id, String texto) {
		try {
			PojoCacheManager pojoCacheManager = (PojoCacheManager) HAUtils
					.lookup(PojoCacheManagerImpl.JNDI_NAME);
			if (!pojoCacheManager.existsKey(id)) {
				pojoCacheManager.setValue(id, texto);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}

	// @Lock(LockType.WRITE)
	// public void desactivarTp(String id) {
	// tpsActivos.remove(id);
	// }

	@Lock(LockType.WRITE)
	public void desactivarTp(String id) {
		try {
			PojoCacheManager pojoCacheManager = (PojoCacheManager) HAUtils
					.lookup(PojoCacheManagerImpl.JNDI_NAME);
			pojoCacheManager.removeKey(id);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}

	// @Lock(LockType.WRITE)
	// public String actualizarTp(String id, LinkedList<Patch> patches) {
	// String textoBase = tpsActivos.get(id);
	// diff_match_patch dmp = new diff_match_patch();
	// Object[] patch_apply = dmp.patch_apply(patches, textoBase);
	// String nuevoTexto = (String) patch_apply[0];
	// tpsActivos.put(id, nuevoTexto);
	// return nuevoTexto;
	// }

	@Lock(LockType.WRITE)
	public String actualizarTp(String id, LinkedList<Patch> patches) {
		try {
			PojoCacheManager pojoCacheManager = (PojoCacheManager) HAUtils
					.lookup(PojoCacheManagerImpl.JNDI_NAME);
			String textoBase = pojoCacheManager.getValue(id);
			diff_match_patch dmp = new diff_match_patch();
			Object[] patch_apply = null;
			try {
				patch_apply = dmp.patch_apply(patches, textoBase);
			} catch (Throwable t) {
				logger.debug("Error de patch_apply");
			}
			String nuevoTexto = null;
			try {
				nuevoTexto = (String) patch_apply[0];
			} catch (Throwable t) {
				logger.debug("Error de patch_apply");
				nuevoTexto = textoBase;
			}
			pojoCacheManager.setValue(id, nuevoTexto);
			return nuevoTexto;
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
			return null;
		}
	}

	// @Lock(LockType.READ)
	// public String obtenerTp(String id) {
	// return tpsActivos.get(id);
	// }

	@Lock(LockType.READ)
	public String obtenerTp(String id) {
		try {
			PojoCacheManager pojoCacheManager = (PojoCacheManager) HAUtils
					.lookup(PojoCacheManagerImpl.JNDI_NAME);
			return pojoCacheManager.getValue(id);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
			return null;
		}
	}
}