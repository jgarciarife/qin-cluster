package com.qin.eao.correccion;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Correccion;

public interface CorreccionEAO extends BaseEAO {

	Correccion findById(Long alumnoId) throws Exception;
	
	List<Correccion> findAll() throws Exception;

}
