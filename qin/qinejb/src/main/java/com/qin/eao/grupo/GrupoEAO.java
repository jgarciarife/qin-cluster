package com.qin.eao.grupo;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Grupo;

public interface GrupoEAO extends BaseEAO {

	Grupo findById(Long grupoId) throws Exception;
	
	List<Grupo> findAll() throws Exception;

}
