package com.qin.eao.base;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.qin.entity.base.BaseEntity;

@Repository
public class BaseEAOImpl implements BaseEAO {

	@PersistenceContext(unitName = "qin")
	private EntityManager entityManager;

	protected BaseEAOImpl() {
	}

	/**
	 * @return the entityManager
	 */
	protected EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	protected void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void insert(BaseEntity entity) throws Exception {
		getEntityManager().persist(entity);
	}

	@Override
	public void update(BaseEntity entity) throws Exception {
		entity = getEntityManager().merge(entity);
	}

	@Override
	public void delete(BaseEntity entity) throws Exception {
		getEntityManager().remove(entity);
	}
}
