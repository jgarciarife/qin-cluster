package com.qin.eao.alumno;

import java.util.List;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Alumno;
@Repository
public class AlumnoEAOImpl extends BaseEAOImpl implements AlumnoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(AlumnoEAOImpl.class);
	
	public AlumnoEAOImpl() {
	}

	@Override
	public Alumno findById(Long alumnoId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT alumno ");
		jpql.append("FROM Alumno alumno ");
		jpql.append("WHERE alumno.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", alumnoId);
		return (Alumno) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Alumno> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT alumno ");
		jpql.append("FROM Alumno alumno ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}