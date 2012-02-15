package com.qin.eao.respuesta;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Respuesta;
@Repository
public class RespuestaEAOImpl extends BaseEAOImpl implements RespuestaEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(RespuestaEAOImpl.class);
	
	public RespuestaEAOImpl() {
	}

	@Override
	public Respuesta findById(Long respuestaId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT respuesta ");
		jpql.append("FROM Respuesta respuesta ");
		jpql.append("WHERE respuesta.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", respuestaId);
		return (Respuesta) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Respuesta> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT respuesta ");
		jpql.append("FROM Respuesta respuesta ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}