package com.qin.eao.docente;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Docente;

public class DocenteEAOImpl extends BaseEAOImpl implements DocenteEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(DocenteEAOImpl.class);

	public DocenteEAOImpl() {
	}

	@Override
	public Docente findById(Long docenteId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT docente ");
		jpql.append("FROM Docente docente ");
		jpql.append("WHERE docente.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", docenteId);
		return (Docente) query.getSingleResult();
	}
}