package com.qin.eao.correccion;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

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
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", correccionId);
		return (Correccion) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Correccion> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT correccion ");
		jpql.append("FROM Correccion correccion ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}