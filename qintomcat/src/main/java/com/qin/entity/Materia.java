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
@Table(name = "materia", catalog = "qintomcat", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"anio", "cuatrimestre", "carrera" }) })
public class Materia extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "docente_id")
	private Docente docente;

	@Column(name = "anio", nullable = false)
	private Long anio;

	@Column(name = "cuatrimestre", nullable = false)
	private Integer cuatrimestre;

	@Column(name = "carrera", nullable = false)
	private String carrera;

	@Column(name = "codigo", nullable = false)
	private String codigo;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	public Materia() {
	}

	/**
	 * @return the docente
	 */
	public Docente getDocente() {
		return docente;
	}

	/**
	 * @param docente
	 *            the docente to set
	 */
	public void setDocente(Docente docente) {
		this.docente = docente;
	}

	/**
	 * @return the anio
	 */
	public Long getAnio() {
		return anio;
	}

	/**
	 * @param anio
	 *            the anio to set
	 */
	public void setAnio(Long anio) {
		this.anio = anio;
	}

	/**
	 * @return the cuatrimestre
	 */
	public Integer getCuatrimestre() {
		return cuatrimestre;
	}

	/**
	 * @param cuatrimestre
	 *            the cuatrimestre to set
	 */
	public void setCuatrimestre(Integer cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	/**
	 * @return the carrera
	 */
	public String getCarrera() {
		return carrera;
	}

	/**
	 * @param carrera
	 *            the carrera to set
	 */
	public void setCarrera(String carrera) {
		this.carrera = carrera;
	}

	/**
	 * @return the codigo
	 */
	public String getCodigo() {
		return codigo;
	}

	/**
	 * @param codigo
	 *            the codigo to set
	 */
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre
	 *            the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}