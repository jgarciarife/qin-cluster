package com.qin.manager.dictamen;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.qin.eao.dictamen.DictamenEAO;
import com.qin.entity.Dictamen;

@Stateless
public class DictamenManagerImpl implements DictamenManager {
	@EJB
	private DictamenEAO dictamenEAO;

	@Override
	public Dictamen findById(Long id) throws Exception {
		Dictamen dic = getDictamenEAO().findById(id);
		return dic;
	}

	public void setDictamenEAO(DictamenEAO dictamenEAO) {
		this.dictamenEAO = dictamenEAO;
	}

	public DictamenEAO getDictamenEAO() {
		return dictamenEAO;
	}

	@Override
	public List<Dictamen> findAll() throws Exception {
		return getDictamenEAO().findAll();
	}

	@Override
	public void insert(Dictamen tp) throws Exception {
		getDictamenEAO().insert(tp);
	}

	@Override
	public void update(Dictamen tp) throws Exception {
		getDictamenEAO().update(tp);
	}
}
