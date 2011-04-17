package com.qin.eao.materia;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Materia;

public class MateriaEAOImpl extends BaseEAOImpl implements MateriaEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(MateriaEAOImpl.class);

	public MateriaEAOImpl() {
	}

	@Override
	public Materia findById(Long materiaId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT materia ");
		jpql.append("FROM Materia materia ");
		jpql.append("WHERE materia.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", materiaId);
		return (Materia) query.getSingleResult();
	}
}