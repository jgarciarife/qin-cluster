package com.qin.init;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.utils.ProfilingUtils;

public class Init implements ServletContextListener {

	/**
	 * Logger de la clase.
	 */
	private static Logger logger = LoggerFactory.getLogger(Init.class);

	/**
	 * Devuelve el logger de la clase.
	 * 
	 * @return Logger Logger de la clase
	 */
	public static Logger getLogger() {
		return Init.logger;
	}

	/**
	 * Establece el logger de la clase.
	 * 
	 * @param l
	 *            Logger
	 */
	public static void setLogger(final Logger l) {
		Init.logger = l;
	}

	/**
	 * Evento de inicio de la aplicacion.
	 * 
	 * @param servletContextEvent
	 *            contexto de la aplicacion
	 */
	public final void contextInitialized(
			final ServletContextEvent servletContextEvent) {
		try {
			ProfilingUtils.setActivo();
			ProfilingUtils.inicializar();
		} catch (Throwable t) {
			ProfilingUtils.cerrar();
			ProfilingUtils.setInactivo();
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}

	/**
	 * Evento de cierre de la aplicacion.
	 * 
	 * @param servletContextEvent
	 *            contexto de la aplicacion
	 */
	public final void contextDestroyed(
			final ServletContextEvent servletContextEvent) {
		try {
			ProfilingUtils.cerrar();
			ProfilingUtils.setInactivo();
		} catch (Throwable t) {
			ProfilingUtils.cerrar();
			ProfilingUtils.setInactivo();
			t.printStackTrace();
			logger.error(t.getMessage());
		}
	}
}