package com.qin.eao.consigna;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Consigna;

public interface ConsignaEAO extends BaseEAO {

	Consigna findById(Long alumnoId) throws Exception;
	
	List<Consigna> findAll() throws Exception;

}
