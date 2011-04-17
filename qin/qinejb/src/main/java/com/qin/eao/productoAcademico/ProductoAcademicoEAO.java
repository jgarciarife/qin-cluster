package com.qin.eao.productoAcademico;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.ProductoAcademico;

public interface ProductoAcademicoEAO extends BaseEAO {

	ProductoAcademico findById(Long productoAcademicoId) throws Exception;

}