package com.qin.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@SuppressWarnings("serial")
@Entity
@Table(name = "alumno", catalog = "qin", uniqueConstraints = @UniqueConstraint(columnNames = "padron"))
public class Alumno extends Usuario {

	@Column(name = "padron", nullable = false)
	private String padron;

	@Column(nullable = true)
	@JoinTable(name = "alumno_materia", catalog = "qin", uniqueConstraints = { @UniqueConstraint(columnNames = {
			"alumno_id", "materia_id" }) }, joinColumns = { @JoinColumn(name = "alumno_id") }, inverseJoinColumns = { @JoinColumn(name = "materia_id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Materia> materias;

	public Alumno() {
	}

	/**
	 * @return the padron
	 */
	public String getPadron() {
		return padron;
	}

	/**
	 * @param padron
	 *            the padron to set
	 */
	public void setPadron(String padron) {
		this.padron = padron;
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
		return false;
	}
}