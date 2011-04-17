package com.qin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.qin.entity.base.BaseEntity;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuario", catalog = "qin", uniqueConstraints = @UniqueConstraint(columnNames = "nombre_usuario"))
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario extends BaseEntity {

	@Column(name = "apellido", nullable = false)
	private String apellido;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "nombre_usuario", nullable = false)
	private String nombreUsuario;

	@Column(name = "contrasenia_usuario", nullable = false)
	private String contraseniaUsuario;

	public Usuario() {
	}

	/**
	 * @return the apellido
	 */
	public String getApellido() {
		return apellido;
	}

	/**
	 * @param apellido
	 *            the apellido to set
	 */
	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	/**
	 * @return the nombreUsuario
	 */
	public String getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * @param nombreUsuario
	 *            the nombreUsuario to set
	 */
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * @return the contraseniaUsuario
	 */
	public String getContraseniaUsuario() {
		return contraseniaUsuario;
	}

	/**
	 * @param contraseniaUsuario
	 *            the contraseniaUsuario to set
	 */
	public void setContraseniaUsuario(String contraseniaUsuario) {
		this.contraseniaUsuario = contraseniaUsuario;
	}
}