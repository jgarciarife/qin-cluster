package com.qin.eao.resolucion;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Resolucion;

public interface ResolucionEAO extends BaseEAO {

	Resolucion findById(Long resolucionId) throws Exception;

	List<Resolucion> findAll() throws Exception;
}