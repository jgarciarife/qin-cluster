package com.qin.eao.grupo;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Grupo;

public class GrupoEAOImpl extends BaseEAOImpl implements GrupoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(GrupoEAOImpl.class);

	public GrupoEAOImpl() {
	}

	@Override
	public Grupo findById(Long grupoId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT grupo ");
		jpql.append("FROM Grupo grupo ");
		jpql.append("WHERE grupo.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", grupoId);
		return (Grupo) query.getSingleResult();
	}
}