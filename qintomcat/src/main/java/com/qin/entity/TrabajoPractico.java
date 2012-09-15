package com.qin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "trabajo_practico", catalog = "qintomcat")
public class TrabajoPractico extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_id")
	private Materia materia;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajoPractico", fetch = FetchType.LAZY)
	private List<Consigna> consignas;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "trabajoPractico", fetch = FetchType.LAZY)
	private List<Resolucion> resolucions;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	public TrabajoPractico() {
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
	 * @return the consignas
	 */
	public List<Consigna> getConsignas() {
		return consignas;
	}

	/**
	 * @param consignas
	 *            the consignas to set
	 */
	public void setConsignas(List<Consigna> consignas) {
		this.consignas = consignas;
	}

	/**
	 * @return the resolucions
	 */
	public List<Resolucion> getResolucions() {
		return resolucions;
	}

	/**
	 * @param resolucions
	 *            the resolucions to set
	 */
	public void setResolucions(List<Resolucion> resolucions) {
		this.resolucions = resolucions;
	}

	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo
	 *            the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
}