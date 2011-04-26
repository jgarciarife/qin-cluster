package com.qin.eao.productoAcademico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.ProductoAcademico;

@Stateless
public class ProductoAcademicoEAOImpl extends BaseEAOImpl implements
		ProductoAcademicoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(ProductoAcademicoEAOImpl.class);

	public ProductoAcademicoEAOImpl() {
	}

	@Override
	public ProductoAcademico findById(Long productoAcademicoId)
			throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT productoAcademico ");
		jpql.append("FROM ProductoAcademico productoAcademico ");
		jpql.append("WHERE productoAcademico.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", productoAcademicoId);
		return (ProductoAcademico) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ProductoAcademico> findAll()
			throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT productoAcademico ");
		jpql.append("FROM ProductoAcademico productoAcademico ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}