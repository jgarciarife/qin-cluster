package com.qin.eao.dictamen;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Dictamen;
@Repository
public class DictamenEAOImpl extends BaseEAOImpl implements DictamenEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(DictamenEAOImpl.class);

	public DictamenEAOImpl() {
	}

	@Override
	@Transactional
	public Dictamen findById(Long dictamenId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT dictamen ");
		jpql.append("FROM Dictamen dictamen ");
		jpql.append("join fetch dictamen.resolucion r ");
		jpql.append("join fetch r.respuestas ");
		jpql.append("join fetch r.trabajoPractico ");
		jpql.append("WHERE dictamen.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		query.setParameter("id", dictamenId);

		StringBuffer jpql2 = new StringBuffer();
		jpql2.append("SELECT dictamen ");
		jpql2.append("FROM Dictamen dictamen ");
		jpql2.append("join fetch dictamen.correccions c ");
		jpql2.append("join fetch c.respuesta ");
		jpql2.append("WHERE dictamen.id = :id ");
		Query query2 = sessionFactory.getCurrentSession().createQuery(jpql2.toString());
		query2.setParameter("id", dictamenId);
		Dictamen dic = (Dictamen) query.uniqueResult();
		Dictamen dic2 = (Dictamen) query2.uniqueResult();
		dic.setCorreccions(dic2.getCorreccions());
		return dic;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Dictamen> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT dictamen ");
		jpql.append("FROM Dictamen dictamen ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Object[]> findAllDictamenByMateriaGroupByNota(Long materiaId)
			throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT dictamen.puntaje, ");
		jpql.append("       COUNT(*) ");
		jpql.append("FROM Dictamen dictamen ");
		if (materiaId != null && materiaId.intValue() != -1) {
			jpql.append("WHERE dictamen.resolucion.trabajoPractico.materia.id = :materiaId ");
		}
		jpql.append("GROUP BY dictamen.puntaje ");
		jpql.append("ORDER BY dictamen.puntaje ASC ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		if (materiaId != null && materiaId.intValue() != -1) {
			query.setParameter("materiaId", materiaId);
		}
		return query.list();
	}

	@Override
	@Transactional
	public Dictamen findByResolucionId(Long resId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT dictamen ");
		jpql.append("FROM Dictamen dictamen ");
		jpql.append("join fetch dictamen.resolucion r ");
		jpql.append("join fetch r.respuestas ");
		jpql.append("join fetch r.trabajoPractico ");
		jpql.append("WHERE r.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(jpql.toString());
		query.setParameter("id", resId);
		Dictamen dic = (Dictamen) query.uniqueResult();

		StringBuffer jpql2 = new StringBuffer();
		jpql2.append("SELECT dictamen ");
		jpql2.append("FROM Dictamen dictamen ");
		jpql2.append("join fetch dictamen.correccions c ");
		jpql2.append("join fetch c.respuesta ");
		jpql2.append("WHERE dictamen.id = :id ");
		Query query2 = sessionFactory.getCurrentSession().createQuery(jpql2.toString());
		query2.setParameter("id", dic.getId());
		Dictamen dic2 = (Dictamen) query2.uniqueResult();
		dic.setCorreccions(dic2.getCorreccions());
		return dic;
	}
}
