package com.qin.eao.trabajoPractico;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Alumno;
import com.qin.entity.TrabajoPractico;

public interface TrabajoPracticoEAO extends BaseEAO {

	TrabajoPractico findById(Long trabajoPracticoId) throws Exception;
	
	List<TrabajoPractico> findAll() throws Exception;
	
	List<TrabajoPractico> findByMateriaId(Long materiaId) throws Exception;

	List<TrabajoPractico> findAllByAlumno(Alumno alumno) throws Exception;
}