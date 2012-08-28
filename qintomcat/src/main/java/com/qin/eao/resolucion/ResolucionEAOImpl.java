package com.qin.eao.resolucion;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Alumno;
import com.qin.entity.Grupo;
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;

@Repository
public class ResolucionEAOImpl extends BaseEAOImpl implements ResolucionEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(ResolucionEAOImpl.class);

	public ResolucionEAOImpl() {
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> findByTPIdWithGrupo(Long tpid) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT distinct grupo ");
		jpql.append("FROM Grupo grupo ");
		jpql.append(" join fetch grupo.resolucion r "
				+ " join fetch r.trabajoPractico tp"
				+ " join fetch grupo.alumnos al ");
		jpql.append("WHERE grupo.resolucion.trabajoPractico.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("id", tpid);
		return (List<Grupo>) query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Grupo> findAllWithGrupo() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT distinct grupo ");
		jpql.append("FROM Grupo grupo ");
		jpql.append(" join fetch grupo.resolucion r "
				+ " join fetch r.trabajoPractico tp"
				+ " join fetch grupo.alumnos al");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		return query.list();
	}

	@Override
	public Resolucion findById(Long resolucionId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT resolucion FROM Resolucion resolucion  left outer join fetch resolucion.respuestas r "
				+ "left outer join fetch r.consigna c ");
		jpql.append("left outer join fetch c.trabajoPractico ");
		jpql.append("WHERE resolucion.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("id", resolucionId);
		Resolucion res = (Resolucion) query.uniqueResult();
		if (res != null) {
			if (res.getTrabajoPractico() != null) {
				res.getTrabajoPractico().getTitulo();
			}
		}
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resolucion> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT resolucion ");
		jpql.append("FROM Resolucion resolucion ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resolucion> findByTPId(Long tpid) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT resolucion ");
		jpql.append("FROM Resolucion resolucion ");
		jpql.append("WHERE resolucion.trabajoPractico.id = :id ");
		Query query = sessionFactory.getCurrentSession().createQuery(
				jpql.toString());
		query.setParameter("id", tpid);
		return (List<Resolucion>) query.list();
	}

	@Override
	public Resolucion findByTrabajoPracticoIdAndCodigoResolucionCompartida(
			Long trabajoPracticoId, String codigoResolucionCompartida)
			throws Exception {
		try {
			if ((codigoResolucionCompartida != null)
					&& (!codigoResolucionCompartida.trim().equals(""))) {
				StringBuffer jpql = new StringBuffer();
				jpql.append("SELECT resolucion ");
				jpql.append("FROM Resolucion resolucion left join fetch resolucion.respuestas rtas left join fetch rtas.consigna c ");
				jpql.append("WHERE resolucion.trabajoPractico.id = :trabajoPracticoId ");
				jpql.append("AND   resolucion.codigoResolucionCompartida = :codigoResolucionCompartida ");
				Query query = sessionFactory.getCurrentSession().createQuery(
						jpql.toString());
				query.setParameter("trabajoPracticoId", trabajoPracticoId);
				query.setParameter("codigoResolucionCompartida",
						codigoResolucionCompartida);
				Resolucion res = (Resolucion) query.uniqueResult();
				if (res == null){
					return null;
				}			
				Resolucion resComppleta = findById(res.getId());
				if (resComppleta != null) {
					if (resComppleta.getTrabajoPractico() != null) {
						resComppleta.getTrabajoPractico().getTitulo();
					}
				}
				return resComppleta;
			} else {
				return null;
			}
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public Resolucion findByTrabajoPracticoAndAlumno(
			TrabajoPractico trabajoPractico, Alumno alumno) throws Exception {
		try {
			StringBuffer jpql = new StringBuffer();
			jpql.append("SELECT grupo.resolucion ");
			jpql.append("FROM Grupo grupo ");
			jpql.append("         JOIN grupo.alumnos alu ");
			jpql.append("WHERE grupo.resolucion.trabajoPractico = :trabajoPractico ");
			jpql.append("AND   alu = :alumno ");
			Query query = sessionFactory.getCurrentSession().createQuery(
					jpql.toString());
			query.setParameter("trabajoPractico", trabajoPractico);
			query.setParameter("alumno", alumno);
			Resolucion res = (Resolucion) query.uniqueResult();
			if (res == null){
				return null;
			}
			Resolucion resComppleta = findById(res.getId());
			if (resComppleta != null) {
				if (resComppleta.getTrabajoPractico() != null) {
					resComppleta.getTrabajoPractico().getTitulo();
				}
			}
			return resComppleta;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}
}