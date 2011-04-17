package com.qin.eao.base;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.qin.entity.base.BaseEntity;

@Stateless
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
		getEntityManager().merge(entity);
	}

	@Override
	public void delete(BaseEntity entity) throws Exception {
		getEntityManager().remove(entity);
	}
}
