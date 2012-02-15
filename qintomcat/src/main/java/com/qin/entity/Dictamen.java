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
import javax.persistence.UniqueConstraint;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "dictamen", catalog = "qintomcat", uniqueConstraints = @UniqueConstraint(columnNames = "resolucion_id"))
public class Dictamen extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resolucion_id")
	private Resolucion resolucion;

	@Column(name = "puntaje", nullable = false)
	private Double puntaje;

	@Column(name = "dictamen", nullable = false)
	private String dictamen;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "dictamen", fetch = FetchType.LAZY)
	private List<Correccion> correccions;

	public Dictamen() {
	}

	/**
	 * @return the resolucion
	 */
	public Resolucion getResolucion() {
		return resolucion;
	}

	/**
	 * @param resolucion
	 *            the resolucion to set
	 */
	public void setResolucion(Resolucion resolucion) {
		this.resolucion = resolucion;
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

	/**
	 * @return the dictamen
	 */
	public String getDictamen() {
		return dictamen;
	}

	/**
	 * @param dictamen
	 *            the dictamen to set
	 */
	public void setDictamen(String dictamen) {
		this.dictamen = dictamen;
	}

	/**
	 * @return the correccions
	 */
	public List<Correccion> getCorreccions() {
		return correccions;
	}

	/**
	 * @param correccions
	 *            the correccions to set
	 */
	public void setCorreccions(List<Correccion> correccions) {
		this.correccions = correccions;
	}
}