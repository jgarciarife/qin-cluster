package com.qin.manager.trabajoPractico;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.trabajoPractico.TrabajoPracticoEAO;
import com.qin.entity.Alumno;
import com.qin.entity.TrabajoPractico;
@Service
public class TrabajoPracticoManagerImpl implements TrabajoPracticoManager {

	protected static Logger logger = LoggerFactory
			.getLogger(TrabajoPracticoManagerImpl.class);

	@Autowired
	private TrabajoPracticoEAO trabajoPracticoEAO;

	public TrabajoPracticoManagerImpl() {
	}

	@Override
	@Transactional
	public TrabajoPractico findById(Long id) throws Exception {
		TrabajoPractico trabajoPractico = getTrabajoPracticoEAO().findById(id);
		return trabajoPractico;
	}

	public void setTrabajoPracticoEAO(TrabajoPracticoEAO trabajoPracticoEAO) {
		this.trabajoPracticoEAO = trabajoPracticoEAO;
	}

	public TrabajoPracticoEAO getTrabajoPracticoEAO() {
		return trabajoPracticoEAO;
	}

	@Override
	@Transactional
	public List<TrabajoPractico> findByMateriaId(Long materiaId)
			throws Exception {
		return getTrabajoPracticoEAO().findByMateriaId(materiaId);
	}
	
	@Override
	@Transactional
	public List<TrabajoPractico> findAll() throws Exception{
		return getTrabajoPracticoEAO().findAll();
	}

	@Override
	@Transactional
	public void insert(TrabajoPractico tp) throws Exception {
		getTrabajoPracticoEAO().insert(tp);
	}

	@Override
	@Transactional
	public void update(TrabajoPractico tp) throws Exception {
		getTrabajoPracticoEAO().update(tp);
	}
	
	@Override
	@Transactional
	public List<TrabajoPractico> findAllByAlumno(Alumno alumno) throws Exception {
		return getTrabajoPracticoEAO().findAllByAlumno(alumno);
	}
}