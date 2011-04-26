package com.qin.eao.enunciado;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Enunciado;

public interface EnunciadoEAO extends BaseEAO {

	Enunciado findById(Long enunciadoId) throws Exception;
	
	List<Enunciado> findAll() throws Exception;

}
