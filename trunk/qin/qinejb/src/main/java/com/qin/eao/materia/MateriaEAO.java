package com.qin.eao.materia;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Materia;

public interface MateriaEAO extends BaseEAO {

	Materia findById(Long materiaId) throws Exception;

}