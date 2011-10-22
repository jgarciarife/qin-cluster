package com.qin.manager.dictamen;

import java.util.List;
import java.util.Map;

import com.qin.entity.Dictamen;

public interface DictamenManager {

	Dictamen findById(Long id) throws Exception;

	List<Dictamen> findAll() throws Exception;

	void insert(Dictamen tp) throws Exception;

	void update(Dictamen tp) throws Exception;

	Map<Integer, String> findAllTPNotaByMateria(Long materiaId)
			throws Exception;

	public Dictamen findByResolucionId(Long id) throws Exception;
}
