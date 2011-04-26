package com.qin.eao.enunciado;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Enunciado;

@Stateless
public class EnunciadoEAOImpl extends BaseEAOImpl implements EnunciadoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(EnunciadoEAOImpl.class);

	public EnunciadoEAOImpl() {
	}

	@Override
	public Enunciado findById(Long enunciadoId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT enunciado ");
		jpql.append("FROM Enunciado enunciado ");
		jpql.append("WHERE enunciado.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", enunciadoId);
		return (Enunciado) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Enunciado> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT enunciado ");
		jpql.append("FROM Enunciado enunciado ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}