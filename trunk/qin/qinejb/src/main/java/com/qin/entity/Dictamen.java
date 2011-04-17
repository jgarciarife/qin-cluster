package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "dictamen", catalog = "qin")
public class Dictamen extends ProductoAcademico {

	@Column(name = "nota", nullable = false)
	private Double nota;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "docente_id")
	private Docente docente;

	public Dictamen() {
	}

	/**
	 * @return the nota
	 */
	public Double getNota() {
		return nota;
	}

	/**
	 * @param nota
	 *            the nota to set
	 */
	public void setNota(Double nota) {
		this.nota = nota;
	}

	/**
	 * @return the docente
	 */
	public Docente getDocente() {
		return docente;
	}

	/**
	 * @param docente
	 *            the docente to set
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}
}