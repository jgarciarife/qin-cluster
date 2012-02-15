package com.qin.eao.resolucion;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Alumno;
import com.qin.entity.Grupo;
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;

public interface ResolucionEAO extends BaseEAO {

	Resolucion findById(Long resolucionId) throws Exception;

	List<Resolucion> findAll() throws Exception;

	List<Resolucion> findByTPId(Long tpId) throws Exception;

	Resolucion findByTrabajoPracticoIdAndCodigoResolucionCompartida(
			Long trabajoPracticoId, String codigoResolucionCompartida)
			throws Exception;

	Resolucion findByTrabajoPracticoAndAlumno(TrabajoPractico trabajoPractico,
			Alumno alumno) throws Exception;

	public List<Grupo> findByTPIdWithGrupo(Long tpid) throws Exception;

	public List<Grupo> findAllWithGrupo() throws Exception;

}