package com.qin.eao.resolucion;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Resolucion;

@Stateless
public class ResolucionEAOImpl extends BaseEAOImpl implements ResolucionEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(ResolucionEAOImpl.class);

	public ResolucionEAOImpl() {
	}

	@Override
	public Resolucion findById(Long resolucionId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT resolucion ");
		jpql.append("FROM Resolucion resolucion ");
		jpql.append("WHERE resolucion.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", resolucionId);
		return (Resolucion) query.getSingleResult();
	}
}