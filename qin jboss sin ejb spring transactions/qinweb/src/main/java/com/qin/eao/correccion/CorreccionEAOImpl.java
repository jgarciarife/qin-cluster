package com.qin.eao.correccion;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Correccion;

@Repository
public class CorreccionEAOImpl extends BaseEAOImpl implements CorreccionEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(CorreccionEAOImpl.class);

	public CorreccionEAOImpl() {
	}

	@Override
	public Correccion findById(Long correccionId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT correccion ");
		jpql.append("FROM Correccion correccion ");
		jpql.append("WHERE correccion.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("id", correccionId);
		return (Correccion) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Correccion> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT correccion ");
		jpql.append("FROM Correccion correccion ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		return query.list();
	}
}