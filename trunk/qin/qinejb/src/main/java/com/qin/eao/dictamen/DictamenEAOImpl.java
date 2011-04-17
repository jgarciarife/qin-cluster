package com.qin.eao.dictamen;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Dictamen;

@Stateless
public class DictamenEAOImpl extends BaseEAOImpl implements DictamenEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(DictamenEAOImpl.class);

	public DictamenEAOImpl() {
	}

	@Override
	public Dictamen findById(Long dictamenId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT dictamen ");
		jpql.append("FROM Dictamen dictamen ");
		jpql.append("WHERE dictamen.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", dictamenId);
		return (Dictamen) query.getSingleResult();
	}
}