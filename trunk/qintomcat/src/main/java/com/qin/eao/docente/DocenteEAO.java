package com.qin.eao.docente;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Docente;

public interface DocenteEAO extends BaseEAO {

	Docente findById(Long docenteId) throws Exception;
	
	List<Docente> findAll() throws Exception;

}
