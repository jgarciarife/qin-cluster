package com.qin.entity;

import javax.persistence.Column;

@SuppressWarnings("serial")
// @Entity
// @Table(name = "alumno", catalog = "qin")
public class Alumno extends Usuario {

	@Column(name = "padron", nullable = false)
	private String padron;

	public Alumno() {
	}

	/**
	 * @return the padron
	 */
	protected String getPadron() {
		return padron;
	}

	/**
	 * @param padron
	 *            the padron to set
	 */
	protected void setPadron(String padron) {
		this.padron = padron;
	}
}