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
import javax.persistence.UniqueConstraint;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "grupo", catalog = "qin", uniqueConstraints = @UniqueConstraint(columnNames = "resolucion_id"))
public class Grupo extends BaseEntity {

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "resolucion_id")
	private Resolucion resolucion;

	@Column(nullable = true)
	@JoinTable(name = "grupo_alumno", catalog = "qin", uniqueConstraints = { @UniqueConstraint(columnNames = {
			"grupo_id", "alumno_id" }) }, joinColumns = { @JoinColumn(name = "grupo_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "alumno_id", referencedColumnName = "id") })
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Alumno> alumnos;

	public Grupo() {
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
	 * @return the alumnos
	 */
	public List<Alumno> getAlumnos() {
		return alumnos;
	}

	/**
	 * @param alumnos
	 *            the alumnos to set
	 */
	public void setAlumnos(List<Alumno> alumnos) {
		this.alumnos = alumnos;
	}

	/**
	 * 
	 * @return String Los apellidos de lo mimbros del grupo separados por coma
	 */
	public String getAutores() {
		StringBuilder autores = new StringBuilder();
		if (alumnos != null) {
			for (Alumno al : alumnos) {
				autores.append(al.getApellido());
				if (!alumnos.get(alumnos.size() - 1).equals(al)) {
					autores.append(", ");
				}
			}
		}
		return autores.toString();
	}
}