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
	@JoinColumn(name = "alumno_id")
	private Alumno alumno;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "materia_id")
	private Materia materia;

	@Column(nullable = true)
	@JoinTable(name = "grupo_alumno", joinColumns = { @JoinColumn(name = "grupo_id") }, inverseJoinColumns = { @JoinColumn(name = "alumno_id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Alumno> intergrantes;

	public Grupo() {
	}

	/**
	 * @return the alumno
	 */
	public Alumno getAlumno() {
		return alumno;
	}

	/**
	 * @param alumno
	 *            the alumno to set
	 */
	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
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
	 * @return the intergrantes
	 */
	public List<Alumno> getIntergrantes() {
		return intergrantes;
	}

	/**
	 * @param intergrantes
	 *            the intergrantes to set
	 */
	public void setIntergrantes(List<Alumno> intergrantes) {
		this.intergrantes = intergrantes;
	}
}