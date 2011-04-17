package com.qin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "producto_academico", catalog = "qin")
@Inheritance(strategy = InheritanceType.JOINED)
public class ProductoAcademico extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_id")
	private Materia materia;

	@Column(nullable = true)
	@JoinTable(name = "producto_academico_item_producto_academico", joinColumns = { @JoinColumn(name = "producto_academico_id") }, inverseJoinColumns = { @JoinColumn(name = "item_producto_academico_id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ItemProductoAcademico> itemProductoAcademicos;

	protected ProductoAcademico() {
	}

	/**
	 * @return the materia
	 */
	public Materia getMateria() {
		return materia;
	}

	/**
	 * @param materia
	 *            the materia to set
	 */
	public void setMateria(Materia materia) {
		this.materia = materia;
	}

	/**
	 * @return the itemProductoAcademicos
	 */
	public List<ItemProductoAcademico> getItemProductoAcademicos() {
		return itemProductoAcademicos;
	}

	/**
	 * @param itemProductoAcademicos the itemProductoAcademicos to set
	 */
	public void setItemProductoAcademicos(
			List<ItemProductoAcademico> itemProductoAcademicos) {
		this.itemProductoAcademicos = itemProductoAcademicos;
	}
}