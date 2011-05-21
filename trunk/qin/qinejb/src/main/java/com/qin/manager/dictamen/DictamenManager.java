package com.qin.manager.dictamen;

import java.util.List;

import com.qin.entity.Dictamen;

public interface DictamenManager {

	public Dictamen findById(Long id) throws Exception;

	public List<Dictamen> findAll() throws Exception;

	public void insert(Dictamen tp) throws Exception;

	public void update(Dictamen tp) throws Exception;
}
