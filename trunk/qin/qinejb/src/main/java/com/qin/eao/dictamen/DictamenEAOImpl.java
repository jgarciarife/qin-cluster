package com.qin.eao.dictamen;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Dictamen;

@Stateless
public class DictamenEAOImpl extends BaseEAOImpl implements DictamenEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(DictamenEAOImpl.class);

	public DictamenEAOImpl() {
	}

	@Override
	public Dictamen findById(Long dictamenId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT dictamen ");
		jpql.append("FROM Dictamen dictamen ");
		jpql.append("WHERE dictamen.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", dictamenId);
		Dictamen dic = (Dictamen) query.getSingleResult();
		/*
		 * Hibernate.initialize(dic.getCorreccions());
		 * Hibernate.initialize(dic.getResolucion());
		 * Hibernate.initialize(dic.getResolucion().getRespuestas());
		 * Hibernate.initialize(dic.getResolucion().getTrabajoPractico());
		 */
		return dic;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dictamen> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT dictamen ");
		jpql.append("FROM Dictamen dictamen ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> findAllDictamenByMateriaGroupByNota() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT dictamen.puntaje, ");
		jpql.append("       COUNT(*) ");
		jpql.append("FROM Dictamen dictamen ");
		jpql
				.append("WHERE dictamen.resolucion.trabajoPractico.materia.id = 1 ");
		jpql.append("GROUP BY dictamen.puntaje ");
		jpql.append("ORDER BY dictamen.puntaje ASC ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}