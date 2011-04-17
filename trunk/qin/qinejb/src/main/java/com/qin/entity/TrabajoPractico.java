package com.qin.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "trabajo_practico", catalog = "qin")
public class TrabajoPractico extends ProductoAcademico {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dictamen_id")
	private Dictamen dictamen;
	
	public TrabajoPractico() {
	}

	/**
	 * @return the dictamen
	 */
	public Dictamen getDictamen() {
		return dictamen;
	}

	/**
	 * @param dictamen the dictamen to set
	 */
	public void setDictamen(Dictamen dictamen) {
		this.dictamen = dictamen;
	}
}