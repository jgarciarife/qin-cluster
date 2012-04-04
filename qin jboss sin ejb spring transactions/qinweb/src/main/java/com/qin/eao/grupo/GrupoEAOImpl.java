package com.qin.eao.grupo;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Grupo;
import com.qin.entity.Resolucion;
@Repository
public class GrupoEAOImpl extends BaseEAOImpl implements GrupoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(GrupoEAOImpl.class);

	public GrupoEAOImpl() {
	}

	@Override
	@Transactional
	public Grupo findById(Long grupoId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT grupo ");
		jpql.append("FROM Grupo grupo ");
		jpql.append("WHERE grupo.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		query.setParameter("id", grupoId);
		return (Grupo) query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Grupo> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT grupo ");
		jpql.append("FROM Grupo grupo ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		return query.list();
	}

	@Override
	@Transactional
	public Grupo findByResolucion(Resolucion resolucion) throws Exception {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT grupo ");
			jpql.append("FROM Grupo grupo left join fetch grupo.alumnos a ");
			jpql.append("WHERE grupo.resolucion = :resolucion ");
			Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
			query.setParameter("resolucion", resolucion);
			return (Grupo) query.uniqueResult();
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}
}