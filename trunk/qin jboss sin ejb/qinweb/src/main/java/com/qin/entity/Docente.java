package com.qin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "docente", catalog = "qin", uniqueConstraints = @UniqueConstraint(columnNames = "matricula"))
public class Docente extends Usuario {

	@Column(name = "matricula", nullable = false)
	private String matricula; // ????????????????????????

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "docente", fetch = FetchType.LAZY)
	private List<Materia> materias;

	public Docente() {
	}

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula
	 *            the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the materias
	 */
	public List<Materia> getMaterias() {
		return materias;
	}

	/**
	 * @param materias
	 *            the materias to set
	 */
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	@Override
	public boolean isEvaluador() {
		return true;
	}
}