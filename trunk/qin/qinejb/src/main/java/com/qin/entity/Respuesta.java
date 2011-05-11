package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "respuesta", catalog = "qin")
public class Respuesta extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resolucion_id")
	private Resolucion resolucion;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "consigna_id")
	private Consigna consigna;

	@Column(name = "respuesta", nullable = false)
	private String respuesta;

	public Respuesta() {
	}

	/**
	 * @return the resolucion
	 */
	public Resolucion getResolucion() {
		return resolucion;
	}

	/**
	 * @param resolucion the resolucion to set
	 */
	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
	}

	/**
	 * @return the consigna
	 */
	public Consigna getConsigna() {
		return consigna;
	}

	/**
	 * @param consigna
	 *            the consigna to set
	 */
	public void setConsigna(Consigna consigna) {
		this.consigna = consigna;
	}

	/**
	 * @return the respuesta
	 */
	public String getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta
	 *            the respuesta to set
	 */
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
}