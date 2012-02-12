package ar.com.ospim.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class UsuarioDaoImpl implements BaseDao {

	@Autowired
	private SessionFactory sessionFactory;

	public UsuarioDaoImpl() {
	}

	@Transactional
	public void persist(Object entity) {
		this.sessionFactory.getCurrentSession().persist(entity);
	}

	@Transactional
	public void persist(Object[] entities) {
		for (int i = 0; i < entities.length; i++) {
			persist(entities[i]);
		}
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> find(Class<T> entityClass) {
		Session currentSession = sessionFactory.getCurrentSession();
		Criteria createCriteria = currentSession.createCriteria(entityClass);
		return createCriteria.list();
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> T load(Class<T> entityClass, Serializable id) {
		final T entity = (T) sessionFactory.getCurrentSession().load(
				entityClass, id);
		return entity;
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public <T> List<T> find(String hql) {
		final List<T> entities = sessionFactory.getCurrentSession().find(hql);
		return entities;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
