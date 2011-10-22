package com.qin.eao.resolucion;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.Alumno;
import com.qin.entity.Grupo;
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;

@Stateless
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
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", tpid);
		return (List<Grupo>) query.getResultList();
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
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}

	@Override
	public Resolucion findById(Long resolucionId) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT resolucion FROM Resolucion resolucion  left outer join fetch resolucion.respuestas r " +
				"left outer join fetch r.consigna c ");
		jpql.append("left outer join fetch c.trabajoPractico ");
		jpql.append("WHERE resolucion.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", resolucionId);
		Resolucion res = (Resolucion) query.getSingleResult();
		return res;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resolucion> findAll() throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT resolucion ");
		jpql.append("FROM Resolucion resolucion ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Resolucion> findByTPId(Long tpid) throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT resolucion ");
		jpql.append("FROM Resolucion resolucion ");
		jpql.append("WHERE resolucion.trabajoPractico.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", tpid);
		return (List<Resolucion>) query.getResultList();
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
				jpql.append("FROM Resolucion resolucion ");
				jpql.append("WHERE resolucion.trabajoPractico.id = :trabajoPracticoId ");
				jpql.append("AND   resolucion.codigoResolucionCompartida = :codigoResolucionCompartida ");
				Query query = getEntityManager().createQuery(jpql.toString());
				query.setParameter("trabajoPracticoId", trabajoPracticoId);
				query.setParameter("codigoResolucionCompartida",
						codigoResolucionCompartida);
				Resolucion res = (Resolucion) query.getSingleResult();
				Resolucion resComppleta = findById(res.getId());
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
			Query query = getEntityManager().createQuery(jpql.toString());
			query.setParameter("trabajoPractico", trabajoPractico);
			query.setParameter("alumno", alumno);
			Resolucion res = (Resolucion) query.getSingleResult();
			Resolucion resComppleta = findById(res.getId());
			return resComppleta;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}
}