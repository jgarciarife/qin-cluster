package com.qin.utils;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HAUtils {

	private static final Properties p = new Properties();

	static {
		p.put(Context.INITIAL_CONTEXT_FACTORY,
				"org.jnp.interfaces.NamingContextFactory");
		p.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");
		p.put("jnp.partitionName",
				System.getProperty("jboss.partition.name", "DefaultPartition"));
	}

	public static Context getHAContext() {
		try {
			return new InitialContext(p);
		} catch (NamingException e) {
			return null;
		}
	}

	public static Object lookup(String name) {
		try {
			return getHAContext().lookup(name);
		} catch (NamingException e) {
			return null;
		}
	}

	public static String nodeName() {
		return System.getProperty("jboss.server.name");
	}
}