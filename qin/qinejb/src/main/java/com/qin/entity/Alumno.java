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

@SuppressWarnings("serial")
@Entity
@Table(name = "alumno", catalog = "qin")
public class Alumno extends Usuario {

	@Column(name = "padron", nullable = false)
	private String padron;

	@Column(nullable = true)
	@JoinTable(name = "alumno_materia", joinColumns = { @JoinColumn(name = "alumno_id") }, inverseJoinColumns = { @JoinColumn(name = "materia_id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Materia> materias;
	
	@Column(nullable = true)
	@JoinTable(name = "alumno_principal_grupo", joinColumns = { @JoinColumn(name = "alumno_id") }, inverseJoinColumns = { @JoinColumn(name = "grupo_id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Grupo> grupos;

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
	 * @param materias the materias to set
	 */
	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	/**
	 * @return the grupos
	 */
	public List<Grupo> getGrupos() {
		return grupos;
	}

	/**
	 * @param grupos the grupos to set
	 */
	public void setGrupos(List<Grupo> grupos) {
		this.grupos = grupos;
	}
}