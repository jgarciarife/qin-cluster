package com.qin.manager.colaboracion;

import java.util.LinkedList;

import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.cache.pojo.manager.PojoCacheManager;
import com.qin.cache.pojo.manager.PojoCacheManagerImpl;
import com.qin.utils.HAUtils;
import com.qin.utils.diff_match_patch;
import com.qin.utils.diff_match_patch.Patch;

@Stateless
public class SincronizadorTextoImpl implements SincronizadorTexto {

	private static Logger logger = LoggerFactory
			.getLogger(SincronizadorTextoImpl.class);

	private PojoCacheManager pojoCacheManager = null;

	public SincronizadorTextoImpl() {
	}

	@Override
	public void activarTp(String id, String texto) {
		try {
			pojoCacheManager = (PojoCacheManager) HAUtils
					.lookup(PojoCacheManagerImpl.JNDI_NAME);
			if (!pojoCacheManager.existsKey(id)) {
				pojoCacheManager.setValue(id, texto);
			}
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}

	@Override
	public void desactivarTp(String id) {
		try {
			pojoCacheManager = (PojoCacheManager) HAUtils
					.lookup(PojoCacheManagerImpl.JNDI_NAME);
			pojoCacheManager.removeKey(id);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}

	@Override
	public String actualizarTp(String id, LinkedList<Patch> patches) {
		try {
			pojoCacheManager = (PojoCacheManager) HAUtils
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

	@Override
	public String obtenerTp(String id) {
		try {
			pojoCacheManager = (PojoCacheManager) HAUtils
					.lookup(PojoCacheManagerImpl.JNDI_NAME);
			String resultado = pojoCacheManager.getValue(id);
			return resultado;
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
			return null;
		}
	}
}