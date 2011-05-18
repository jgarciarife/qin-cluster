package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "correccion", catalog = "qin", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"dictamen_id", "respuesta_id" }) })
public class Correccion extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dictamen_id")
	private Dictamen dictamen;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "respuesta_id")
	private Respuesta respuesta;

	@Column(name = "correccion", nullable = false)
	private String correccion;

	@Column(name = "puntaje", nullable = false)
	private Double puntaje;

	public Correccion() {
	}

	/**
	 * @return the dictamen
	 */
	public Dictamen getDictamen() {
		return dictamen;
	}

	/**
	 * @param dictamen
	 *            the dictamen to set
	 */
	public void setDictamen(Dictamen dictamen) {
		this.dictamen = dictamen;
	}

	/**
	 * @return the respuesta
	 */
	public Respuesta getRespuesta() {
		return respuesta;
	}

	/**
	 * @param respuesta
	 *            the respuesta to set
	 */
	public void setRespuesta(Respuesta respuesta) {
		this.respuesta = respuesta;
	}

	/**
	 * @return the correccion
	 */
	public String getCorreccion() {
		return correccion;
	}

	/**
	 * @param correccion
	 *            the correccion to set
	 */
	public void setCorreccion(String correccion) {
		this.correccion = correccion;
	}

	/**
	 * @return the puntaje
	 */
	public Double getPuntaje() {
		return puntaje;
	}

	/**
	 * @param puntaje
	 *            the puntaje to set
	 */
	public void setPuntaje(Double puntaje) {
		this.puntaje = puntaje;
	}

}