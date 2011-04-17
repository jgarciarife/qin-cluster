package com.qin.eao.resolucion;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Resolucion;

public interface ResolucionEAO extends BaseEAO {

	Resolucion findById(Long resolucionId) throws Exception;

}