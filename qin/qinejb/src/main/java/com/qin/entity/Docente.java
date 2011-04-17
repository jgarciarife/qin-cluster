package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "docente", catalog = "qin")
//@DiscriminatorValue("docente")
public class Docente extends Usuario {

	@Column(name = "matricula", nullable = false)
	private String matricula; // ????????????????????????

	public Docente() {
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula
	 *            the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
}