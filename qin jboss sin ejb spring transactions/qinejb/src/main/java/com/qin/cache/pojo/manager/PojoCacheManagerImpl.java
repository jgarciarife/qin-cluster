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
		System.out.println("----------------------------------------------------");
		System.out.println("PojoCacheManagerImpl: Is Master Node: " + masterNode);
		System.out.println("----------------------------------------------------");
		return masterNode;
	}

	@Override
	public void create() throws Exception {
		logger.debug("create");
		System.out.println("----------------------------------------------------");
		System.out.println("PojoCacheManagerImpl: create ");
		System.out.println("----------------------------------------------------");
	}

	@Override
	public void start() throws Exception {
		try {
			logger.debug("start");
			// Remove from local JNDI until started as a singleton,
			// but keep the reference locally so it could be restored later.
			Context ctx = new InitialContext();
			reference = (PojoCacheManager) ctx.lookup(JNDI_NAME);
			Util.unbind(ctx, JNDI_NAME);
			System.out.println("----------------------------------------------------");
			System.out.println("PojoCacheManagerImpl: start ");
			System.out.println("----------------------------------------------------");
		} catch (Throwable t) {
			t.printStackTrace();
			logger.debug(t.getMessage());
		}
	}

	@Override
	public void stop() {
		logger.debug("stop");
		System.out.println("----------------------------------------------------");
		System.out.println("PojoCacheManagerImpl: stop ");
		System.out.println("----------------------------------------------------");
	}

	@Override
	public void destroy() {
		logger.debug("destroy");
		System.out.println("----------------------------------------------------");
		System.out.println("PojoCacheManagerImpl: destroy ");
		System.out.println("----------------------------------------------------");
	}

	/**
	 * Called by HASingletonController on singleton start
	 */
	@Override
	public void startSingleton() throws NamingException {
		try {
			logger.debug("startSingleton");
			masterNode = true;
			// Rebind to JNDI when started as singleton
			Context ctx = new InitialContext();
			Util.rebind(ctx, JNDI_NAME, reference);
			System.out.println("----------------------------------------------------");
			System.out.println("PojoCacheManagerImpl: startSingleton ");
			System.out.println("----------------------------------------------------");
		} catch (Throwable t) {
			t.printStackTrace();
			logger.debug(t.getMessage());
			masterNode = false;
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
			// Unbind from local JNDI when stopped
			Context ctx = new InitialContext();
			Util.unbind(ctx, JNDI_NAME);
			System.out.println("----------------------------------------------------");
			System.out.println("PojoCacheManagerImpl: stopSingleton ");
			System.out.println("----------------------------------------------------");
		} catch (Throwable t) {
			t.printStackTrace();
			logger.debug(t.getMessage());
			masterNode = false;
		}
	}

	@Override
	public boolean existsKey(String key) {
		try {
			System.out.println("----------------------------------------------------");
			System.out.println("PojoCacheManagerImpl: existsKey ");
			System.out.println("----------------------------------------------------");
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
			System.out.println("----------------------------------------------------");
			System.out.println("PojoCacheManagerImpl: setValue ");
			System.out.println("----------------------------------------------------");
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}

	@Override
	public void removeKey(String key) {
		try {
			pojoCache.remove(key);
			System.out.println("----------------------------------------------------");
			System.out.println("PojoCacheManagerImpl: removeKey ");
			System.out.println("----------------------------------------------------");
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
			System.out.println("----------------------------------------------------");
			System.out.println("PojoCacheManagerImpl: getValue ");
			System.out.println("----------------------------------------------------");
			return retorno;
		} catch (Throwable t) {
			t.printStackTrace();
			logger.error(t.getMessage());
			return null;
		}
	}
}