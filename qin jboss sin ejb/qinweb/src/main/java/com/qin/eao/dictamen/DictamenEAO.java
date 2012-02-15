package com.qin.eao.dictamen;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Dictamen;

public interface DictamenEAO extends BaseEAO {

	Dictamen findById(Long dictamenId) throws Exception;

	List<Dictamen> findAll() throws Exception;

	List<Object[]> findAllDictamenByMateriaGroupByNota(Long materiaId)
			throws Exception;

	Dictamen findByResolucionId(Long id) throws Exception;

}
