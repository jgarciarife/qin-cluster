package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "alumno", catalog = "qin")
@DiscriminatorValue("alumno")
public class Alumno extends Usuario {

	@Column(name = "padron", nullable = false)
	private String padron;

	public Alumno() {
	}

	/**
	 * @return the padron
	 */
	public String getPadron() {
		return padron;
	}

	/**
	 * @param padron
	 *            the padron to set
	 */
	public void setPadron(String padron) {
		this.padron = padron;
	}
}