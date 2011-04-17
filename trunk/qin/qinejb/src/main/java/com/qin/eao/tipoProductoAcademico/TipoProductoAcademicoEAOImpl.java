package com.qin.eao.tipoProductoAcademico;

import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.TipoProductoAcademico;

public class TipoProductoAcademicoEAOImpl extends BaseEAOImpl implements
		TipoProductoAcademicoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(TipoProductoAcademicoEAOImpl.class);

	public TipoProductoAcademicoEAOImpl() {
	}

	@Override
	public TipoProductoAcademico findById(Long tipoProductoAcademicoId)
			throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT tipoProductoAcademico ");
		jpql.append("FROM TipoProductoAcademico tipoProductoAcademico ");
		jpql.append("WHERE tipoProductoAcademico.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", tipoProductoAcademicoId);
		return (TipoProductoAcademico) query.getSingleResult();
	}
}