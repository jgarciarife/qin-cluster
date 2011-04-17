package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "enunciado", catalog = "qin")
public class Enunciado extends ItemProductoAcademico {
	
	@Column(name = "enunciado", nullable = true)
	private String enunciado;
	
	public Enunciado() {
	}

	/**
	 * @return the enunciado
	 */
	public String getEnunciado() {
		return enunciado;
	}

	/**
	 * @param enunciado the enunciado to set
	 */
	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}
}