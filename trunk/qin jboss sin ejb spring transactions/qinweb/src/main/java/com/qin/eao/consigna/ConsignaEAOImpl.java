package com.qin.eao.consigna;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Consigna;

@Repository
public class ConsignaEAOImpl extends BaseEAOImpl implements ConsignaEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(ConsignaEAOImpl.class);

	public ConsignaEAOImpl() {
	}

	@Override
	@Transactional
	public Consigna findById(Long consignaId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT consigna ");
		jpql.append("FROM Consigna consigna ");
		jpql.append("WHERE consigna.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("id", consignaId);
		return (Consigna) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Consigna> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT consigna ");
		jpql.append("FROM Consigna consigna ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		return query.list();
	}
}