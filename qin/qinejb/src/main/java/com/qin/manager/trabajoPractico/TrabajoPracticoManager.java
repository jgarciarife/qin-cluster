package com.qin.manager.trabajoPractico;

import java.util.List;

import com.qin.entity.TrabajoPractico;

public interface TrabajoPracticoManager {

	TrabajoPractico findById(Long id) throws Exception;

	List<TrabajoPractico> findByMateriaId(Long materiaId) throws Exception;

	List<TrabajoPractico> findAll() throws Exception;
	
	void insert(TrabajoPractico tp) throws Exception;
	
	void update(TrabajoPractico tp) throws Exception;
}
