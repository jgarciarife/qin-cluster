package com.qin.eao.grupo;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Grupo;

public interface GrupoEAO extends BaseEAO {

	Grupo findById(Long grupoId) throws Exception;

}
