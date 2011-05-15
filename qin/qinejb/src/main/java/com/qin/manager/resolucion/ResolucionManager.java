package com.qin.manager.resolucion;

import java.util.List;

import com.qin.entity.Resolucion;

public interface ResolucionManager {

	Resolucion findById(Long id) throws Exception;

	List<Resolucion> findByTrabajoPracticoId(Long tpid) throws Exception;

	List<Resolucion> findAll() throws Exception;
	
	void insert(Resolucion res) throws Exception;
	
	void update(Resolucion res) throws Exception;
}
