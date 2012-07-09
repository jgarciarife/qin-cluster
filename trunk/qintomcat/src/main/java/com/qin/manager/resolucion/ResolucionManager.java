package com.qin.manager.resolucion;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qin.entity.Alumno;
import com.qin.entity.Grupo;
import com.qin.entity.Materia;
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;

@Service
public interface ResolucionManager {

	Resolucion findById(Long id) throws Exception;

	List<Resolucion> findByTrabajoPracticoId(Long tpid) throws Exception;

	List<Resolucion> findAll() throws Exception;

	void insert(Resolucion res) throws Exception;

	void update(Resolucion res) throws Exception;

	Resolucion joinResolucion(Resolucion verificacion,
			TrabajoPractico trabajoPractico, Alumno alumno,
			String codigoResolucionCompartida) throws Exception;

	Resolucion createResolucion(TrabajoPractico trabajoPractico,
			String codigoResolucionCompartida) throws Exception;

	Grupo createGrupo(Resolucion resolucion, Materia materia) throws Exception;

	public List<Grupo> findByTrabajoPracticoIdWithGroup(Long tpId)
			throws Exception;

	public List<Grupo> findAllWithGrupo() throws Exception;
}