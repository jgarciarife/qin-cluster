package com.qin.eao.trabajoPractico;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Alumno;
import com.qin.entity.TrabajoPractico;

@Repository
public class TrabajoPracticoEAOImpl extends BaseEAOImpl implements
		TrabajoPracticoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(TrabajoPracticoEAOImpl.class);

	public TrabajoPracticoEAOImpl() {
	}

	@Override
	public TrabajoPractico findById(Long trabajoPracticoId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT trabajoPractico ");
		jpql.append("FROM TrabajoPractico trabajoPractico ");
		jpql.append("left join fetch trabajoPractico.materia left join fetch trabajoPractico.consignas ");
		jpql.append("WHERE trabajoPractico.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("id", trabajoPracticoId);
		TrabajoPractico singleResult = (TrabajoPractico) query.uniqueResult();
		return singleResult;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajoPractico> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT trabajoPractico ");
		jpql.append("FROM TrabajoPractico trabajoPractico ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setCacheable(true);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajoPractico> findByMateriaId(Long materiaId)
			throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT trabajoPractico ");
		jpql.append("FROM TrabajoPractico trabajoPractico ");
		jpql.append("WHERE trabajoPractico.materia.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("id", materiaId);
		return (List<TrabajoPractico>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajoPractico> findAllByAlumno(Alumno alumno)
			throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT grupo.resolucion.trabajoPractico ");
		jpql.append("FROM Grupo grupo, ");
		jpql.append("     GrupoAlumno grupoAlumno, ");
		jpql.append("WHERE grupo = grupoAlumno.grupo ");
		jpql.append("AND   grupoAlumno.alumno = :alumno ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("alumno", alumno);
		return (List<TrabajoPractico>) query.list();
	}
}