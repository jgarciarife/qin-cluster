package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "item_producto_academico", catalog = "qin")
@Inheritance(strategy = InheritanceType.JOINED)
public class ItemProductoAcademico extends BaseEntity {

	@Column(name = "puntos", nullable = true)
	private Double puntos;
	
	public ItemProductoAcademico() {
	}

	/**
	 * @return the puntos
	 */
	public Double getPuntos() {
		return puntos;
	}

	/**
	 * @param puntos the puntos to set
	 */
	public void setPuntos(Double puntos) {
		this.puntos = puntos;
	}
}