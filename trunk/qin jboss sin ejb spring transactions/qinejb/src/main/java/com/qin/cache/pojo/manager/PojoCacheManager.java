package com.qin.cache.pojo.manager;

import javax.ejb.Remote;
import javax.naming.NamingException;

@Remote
public interface PojoCacheManager {

	boolean isMasterNode();

	void create() throws Exception;

	void start() throws Exception;

	void stop();

	void destroy();

	void startSingleton() throws NamingException;

	void stopSingleton() throws NamingException;

	boolean existsKey(String key);

	void setValue(String key, String value);

	void removeKey(String key);

	String getValue(String key);
}