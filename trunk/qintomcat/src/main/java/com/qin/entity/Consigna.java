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
@Table(name = "consigna", catalog = "qintomcat", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"id", "trabajo_practico_id" }) })
public class Consigna extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trabajo_practico_id")
	private TrabajoPractico trabajoPractico;

	@Column(name = "orden", nullable = false)
	private Integer orden;

	@Column(name = "consigna", nullable = false)
	private String consigna;

	@Column(name = "puntaje", nullable = false)
	private Double puntaje;

	public Consigna() {
	}

	/**
	 * @return the trabajoPractico
	 */
	public TrabajoPractico getTrabajoPractico() {
		return trabajoPractico;
	}

	/**
	 * @param trabajoPractico
	 *            the trabajoPractico to set
	 */
	public void setTrabajoPractico(TrabajoPractico trabajoPractico) {
		this.trabajoPractico = trabajoPractico;
	}

	/**
	 * @return the orden
	 */
	public Integer getOrden() {
		return orden;
	}

	/**
	 * @param orden
	 *            the orden to set
	 */
	public void setOrden(Integer orden) {
		this.orden = orden;
	}

	/**
	 * @return the consigna
	 */
	public String getConsigna() {
		return consigna;
	}

	/**
	 * @param consigna
	 *            the consigna to set
	 */
	public void setConsigna(String consigna) {
		this.consigna = consigna;
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