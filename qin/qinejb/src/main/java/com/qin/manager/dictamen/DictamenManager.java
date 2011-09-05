package com.qin.manager.dictamen;

import java.util.HashMap;
import java.util.List;

import com.qin.entity.Dictamen;

public interface DictamenManager {

	Dictamen findById(Long id) throws Exception;

	List<Dictamen> findAll() throws Exception;

	void insert(Dictamen tp) throws Exception;

	void update(Dictamen tp) throws Exception;
	
	HashMap<Integer, String> findAllTPNotaByMateria() throws Exception;
}
