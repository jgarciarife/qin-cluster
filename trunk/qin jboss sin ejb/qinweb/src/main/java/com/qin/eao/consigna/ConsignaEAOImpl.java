package com.qin.eao.consigna;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Consigna;
@Repository
public class ConsignaEAOImpl extends BaseEAOImpl implements ConsignaEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(ConsignaEAOImpl.class);
	
	public ConsignaEAOImpl() {
	}

	@Override
	public Consigna findById(Long consignaId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT consigna ");
		jpql.append("FROM Consigna consigna ");
		jpql.append("WHERE consigna.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", consignaId);
		return (Consigna) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Consigna> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT consigna ");
		jpql.append("FROM Consigna consigna ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}