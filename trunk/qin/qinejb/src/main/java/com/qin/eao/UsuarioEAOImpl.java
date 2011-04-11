package com.qin.eao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.entity.UsuarioEntity;

@Stateless
public class UsuarioEAOImpl implements UsuarioEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(UsuarioEAOImpl.class);

	@PersistenceContext(unitName = "qin")
	private EntityManager entityManager;

	private EntityManager getEntityManager() throws Exception {
		return entityManager;
	}

	@Override
	public void insert(UsuarioEntity usuario) throws Exception {
		EntityManager entityManager = getEntityManager();
		entityManager.persist(usuario);
	}

	@Override
	public void update(UsuarioEntity usuario) throws Exception {
		EntityManager entityManager = getEntityManager();
		entityManager.merge(usuario);
	}

	@Override
	public void delete(UsuarioEntity usuario) throws Exception {
		EntityManager entityManager = getEntityManager();
		entityManager.remove(usuario);
	}

	@Override
	public UsuarioEntity findById(UsuarioEntity usuario) throws Exception {
		EntityManager entityManager = getEntityManager();
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT usuario ");
		jpql.append("FROM UsuarioEntity usuario ");
		jpql.append("WHERE usuario.id = :id ");
		Query query = entityManager.createQuery(jpql.toString());
		query.setParameter("id", usuario.getId());
		return (UsuarioEntity) query.getSingleResult();
	}
}
