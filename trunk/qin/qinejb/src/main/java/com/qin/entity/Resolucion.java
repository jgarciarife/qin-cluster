package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "resolucion", catalog = "qin")
public class Resolucion extends ItemProductoAcademico {
	
	@Column(name = "resolucion", nullable = true)
	private String resolucion;
	
	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "enunciado_id")
	private Enunciado enunciado;
	
	public Resolucion() {
	}

	/**
	 * @return the resolucion
	 */
	public String getResolucion() {
		return resolucion;
	}

	/**
	 * @param resolucion the resolucion to set
	 */
	public void setResolucion(String resolucion) {
		this.resolucion = resolucion;
	}

	/**
	 * @return the enunciado
	 */
	public Enunciado getEnunciado() {
		return enunciado;
	}

	/**
	 * @param enunciado the enunciado to set
	 */
	public void setEnunciado(Enunciado enunciado) {
		this.enunciado = enunciado;
	}
}