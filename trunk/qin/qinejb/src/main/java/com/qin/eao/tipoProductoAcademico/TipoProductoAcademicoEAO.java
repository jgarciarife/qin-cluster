package com.qin.eao.tipoProductoAcademico;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.TipoProductoAcademico;

public interface TipoProductoAcademicoEAO extends BaseEAO {

	TipoProductoAcademico findById(Long tipoProductoAcademicoId)
			throws Exception;

}