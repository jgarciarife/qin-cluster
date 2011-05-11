package com.qin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "grupo", catalog = "qin")
public class Grupo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "alumno_principal_id")
	private Alumno alumnoPrincipal;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_id")
	private Materia materia;

	@Column(nullable = true)
	@JoinTable(name = "grupo_alumno", joinColumns = { @JoinColumn(name = "grupo_id") }, inverseJoinColumns = { @JoinColumn(name = "alumno_id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Alumno> alumnos;

	public Grupo() {
	}

	/**
	 * @return the alumnoPrincipal
	 */
	public Alumno getAlumnoPrincipal() {
		return alumnoPrincipal;
	}

	/**
	 * @param alumno
	 *            the alumnoPrincipal to set
	 */
	public void setAlumnoPrincipal(Alumno alumnoPrincipal) {
		this.alumnoPrincipal = alumnoPrincipal;
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
	 * @return the alumnos
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	/**
	 * @param alumnos the alumnos to set
	 */
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}
}