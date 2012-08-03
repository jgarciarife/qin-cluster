package com.qin.eao.docente;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Docente;
@Repository
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
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		query.setParameter("id", docenteId);
		return (Docente) query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Docente> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT docente ");
		jpql.append("FROM Docente docente ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		return query.list();
	}
}