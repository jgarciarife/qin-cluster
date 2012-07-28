package com.qin.eao.materia;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Materia;
@Repository
public class MateriaEAOImpl extends BaseEAOImpl implements MateriaEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(MateriaEAOImpl.class);

	public MateriaEAOImpl() {
	}

	@Override
	@Transactional
	public Materia findById(Long materiaId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT materia ");
		jpql.append("FROM Materia materia ");
		jpql.append("WHERE materia.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		query.setParameter("id", materiaId);
		return (Materia) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Materia> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT materia ");
		jpql.append("FROM Materia materia ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		query.setCacheable(true);
		return query.list();
	}
}