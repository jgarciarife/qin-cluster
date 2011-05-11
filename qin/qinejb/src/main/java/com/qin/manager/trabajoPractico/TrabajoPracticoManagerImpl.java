package com.qin.manager.trabajoPractico;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.trabajoPractico.TrabajoPracticoEAO;
import com.qin.entity.TrabajoPractico;

@Stateless
public class TrabajoPracticoManagerImpl implements TrabajoPracticoManager {

	protected static Logger logger = LoggerFactory
			.getLogger(TrabajoPracticoManagerImpl.class);

	@EJB
	private TrabajoPracticoEAO trabajoPracticoEAO;

	public TrabajoPracticoManagerImpl() {
	}

	@Override
	public TrabajoPractico findById(Long id) throws Exception {
		//TrabajoPractico trabajoPractico = getTrabajoPracticoEAO().findById(id);
		//Hibernate.initialize(trabajoPractico.getMateria());
		//Hibernate.initialize(trabajoPractico.getItemProductoAcademicos());
		//return trabajoPractico;
		return null;
	}

	public void setTrabajoPracticoEAO(TrabajoPracticoEAO trabajoPracticoEAO) {
		this.trabajoPracticoEAO = trabajoPracticoEAO;
	}

	public TrabajoPracticoEAO getTrabajoPracticoEAO() {
		return trabajoPracticoEAO;
	}

	@Override
	public List<TrabajoPractico> findByMateriaId(Long materiaId)
			throws Exception {
		return getTrabajoPracticoEAO().findByMateriaId(materiaId);
	}
	
	@Override
	public List<TrabajoPractico> findAll() throws Exception{
		return getTrabajoPracticoEAO().findAll();
	}
}