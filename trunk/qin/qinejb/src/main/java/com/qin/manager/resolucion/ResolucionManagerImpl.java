package com.qin.manager.resolucion;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.resolucion.ResolucionEAO;
import com.qin.entity.Resolucion;

@Stateless
public class ResolucionManagerImpl implements ResolucionManager {

	protected static Logger logger = LoggerFactory
			.getLogger(ResolucionManagerImpl.class);

	@EJB
	private ResolucionEAO resolucionEAO;

	public ResolucionManagerImpl() {
	}

	@Override
	public Resolucion findById(Long id) throws Exception {
		Resolucion resol = resolucionEAO.findById(id);
		return resol;
	}


	@Override
	public List<Resolucion> findByTrabajoPracticoId(Long tpId)
			throws Exception {
		return resolucionEAO.findByTPId(tpId);
	}
	
	@Override
	public List<Resolucion> findAll() throws Exception{
		return resolucionEAO.findAll();
	}

	@Override
	public void insert(Resolucion tp) throws Exception {
		resolucionEAO.insert(tp);
	}

	@Override
	public void update(Resolucion tp) throws Exception {
		resolucionEAO.update(tp);
	}

	public void setResolucionEAO(ResolucionEAO resolucionEAO) {
		this.resolucionEAO = resolucionEAO;
	}

	public ResolucionEAO getResolucionEAO() {
		return resolucionEAO;
	}
}