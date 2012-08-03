package com.qin.eao.base;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.entity.base.BaseEntity;

@Repository
public class BaseEAOImpl implements BaseEAO {

	@Autowired
	protected SessionFactory sessionFactory;

	protected BaseEAOImpl() {
	}

	@Override
	public void insert(BaseEntity entity) throws Exception {
		sessionFactory.getCurrentSession().persist(entity);
	}

	@Override
	public void update(BaseEntity entity) throws Exception {
		entity = (BaseEntity) sessionFactory.getCurrentSession().merge(entity);
	}

	@Override
	public void delete(BaseEntity entity) throws Exception {
		sessionFactory.getCurrentSession().delete(entity);
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
