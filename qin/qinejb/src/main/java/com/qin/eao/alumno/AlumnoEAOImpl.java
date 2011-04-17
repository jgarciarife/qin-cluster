package com.qin.eao.alumno;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Alumno;

@Stateless
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
}