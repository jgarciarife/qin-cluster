package com.qin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "resolucion", catalog = "qin")
public class Resolucion extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "trabajo_practico_id")
	private TrabajoPractico trabajoPractico;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "resolucion")
	private List<Respuesta> respuestas;

	public Resolucion() {
	}

	/**
	 * @return the trabajoPractico
	 */
	public TrabajoPractico getTrabajoPractico() {
		return trabajoPractico;
	}

	/**
	 * @param trabajoPractico the trabajoPractico to set
	 */
	public void setTrabajoPractico(TrabajoPractico trabajoPractico) {
		this.trabajoPractico = trabajoPractico;
	}

	/**
	 * @return the respuestas
	 */
	public List<Respuesta> getRespuestas() {
		return respuestas;
	}

	/**
	 * @param respuestas the respuestas to set
	 */
	public void setRespuestas(List<Respuesta> respuestas) {
		this.respuestas = respuestas;
	}
}