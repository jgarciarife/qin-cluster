package com.qin.cache.pojo.manager;

import java.util.HashMap;
import java.util.Map;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.jboss.ejb3.annotation.Management;
import org.jboss.ejb3.annotation.Service;
import org.jboss.naming.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service(objectName = "qinejb:service=PojoCacheManager")
@Management(PojoCacheManager.class)
public class PojoCacheManagerImpl implements PojoCacheManager {

	protected static Logger logger = LoggerFactory
			.getLogger(PojoCacheManagerImpl.class);

	public static final String JNDI_NAME = "qinear-1.0/PojoCacheManagerImpl/remote";

	private boolean masterNode = false;
	
	private PojoCacheManager reference;
	
	private Map<String, String> pojoCache = new HashMap<String, String>();

	@Override
	public boolean isMasterNode() {
		return masterNode;
	}

	@Override
	public void create() throws Exception {
		logger.debug("create");
	}

	@Override
	public void start() throws Exception {
		try {
			logger.debug("start");
			/*
			 * Remove from local JNDI until started as a singleton,
			 * 
			 * but keep the reference locally so it could be restored later.
			 */
			Context ctx = new InitialContext();
			reference = (PojoCacheManager) ctx.lookup(JNDI_NAME);
			Util.unbind(ctx, JNDI_NAME);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.debug(t.getMessage());
		}
	}

	@Override
	public void stop() {
		logger.debug("stop");
	}

	@Override
	public void destroy() {
		logger.debug("destroy");
	}

	/**
	 * Called by HASingletonController on singleton start
	 */
	@Override
	public void startSingleton() throws NamingException {
		try {
			logger.debug("startSingleton");
			masterNode = true;
			/*
			 * Rebind to JNDI when started as singleton
			 */
			Context ctx = new InitialContext();
			Util.rebind(ctx, JNDI_NAME, reference);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.debug(t.getMessage());
		}
	}

	/**
	 * Called by HASingletonController on singleton stop
	 */
	@Override
	public void stopSingleton() throws NamingException {
		try {
			logger.debug("stopSingleton");
			masterNode = false;
			/*
			 * Unbind from local JNDI when stopped
			 */
			Context ctx = new InitialContext();
			Util.unbind(ctx, JNDI_NAME);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.debug(t.getMessage());
		}
	}
	
	@Override
	public boolean existsKey(String key) {
		try {
			return pojoCache.containsKey(key);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
			return false;
		}
	}

	@Override
	public void setValue(String key, String value) {
		try {
			if (value == null) {
				value = "";
			}
			pojoCache.put(key, value);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}

	@Override
	public void removeKey(String key) {
		try {
			pojoCache.remove(key);
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}

	@Override
	public String getValue(String key) {
		try {
			String retorno = pojoCache.get(key);
			if (retorno == null) {
				retorno = "";
			}
			return retorno;
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
			return null;
		}
	}
}