package com.qin.entity;

import javax.persistence.Column;

@SuppressWarnings("serial")
// @Entity
// @Table(name = "docente", catalog = "qin")
public class Docente extends Usuario {

	@Column(name = "matricula", nullable = false)
	private String matricula; // ????????????????????????

	public Docente() {
	}

	/**
	 * @return the matricula
	 */
	protected String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula
	 *            the matricula to set
	 */
	protected void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}