package com.qin.eao.trabajoPractico;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.TrabajoPractico;

public class TrabajoPracticoEAOImpl extends BaseEAOImpl implements
		TrabajoPracticoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(TrabajoPracticoEAOImpl.class);

	public TrabajoPracticoEAOImpl() {
	}

	@Override
	public TrabajoPractico findById(Long trabajoPracticoId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT trabajoPractico ");
		jpql.append("FROM TrabajoPractico trabajoPractico ");
		jpql.append("WHERE trabajoPractico.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", trabajoPracticoId);
		return (TrabajoPractico) query.getSingleResult();
	}
}