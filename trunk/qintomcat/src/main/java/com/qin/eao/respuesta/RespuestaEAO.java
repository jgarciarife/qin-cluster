package com.qin.eao.respuesta;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Respuesta;

public interface RespuestaEAO extends BaseEAO {

	Respuesta findById(Long alumnoId) throws Exception;
	
	List<Respuesta> findAll() throws Exception;

}
