package com.qin.eao.itemProductoAcademico;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.ItemProductoAcademico;

public interface ItemProductoAcademicoEAO extends BaseEAO {

	ItemProductoAcademico findById(Long itemProductoAcademicoId)
			throws Exception;

}
