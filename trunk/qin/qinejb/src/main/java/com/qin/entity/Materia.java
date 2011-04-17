package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "materia", catalog = "qin")
public class Materia extends BaseEntity {

	@Column(name = "anio", nullable = false)
	public Long anio;
	
	@Column(name = "cuatrimestre", nullable = false)
	public Integer cuatrimestre;
	
	@Column(name = "carrera", nullable = false)
	public String carrera;
	
	@Column(name = "codigo", nullable = false)
	public String codigo;
	
	@Column(name = "nombre", nullable = false)
	public String nombre;
	
	public Materia() {
	}

	/**
	 * @return the anio
	 */
	public Long getAnio() {
		return anio;
	}

	/**
	 * @param anio the anio to set
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
	 * @param cuatrimestre the cuatrimestre to set
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
	 * @param carrera the carrera to set
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
	 * @param codigo the codigo to set
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
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}