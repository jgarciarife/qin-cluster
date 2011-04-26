package com.qin.eao.itemProductoAcademico;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.base.BaseEAOImpl;
import com.qin.entity.ItemProductoAcademico;

@Stateless
public class ItemProductoAcademicoEAOImpl extends BaseEAOImpl implements
		ItemProductoAcademicoEAO {

	protected static Logger logger = LoggerFactory
			.getLogger(ItemProductoAcademicoEAOImpl.class);

	public ItemProductoAcademicoEAOImpl() {
	}

	@Override
	public ItemProductoAcademico findById(Long itemProductoAcademicoId)
			throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT itemProductoAcademico ");
		jpql.append("FROM ItemProductoAcademico itemProductoAcademico ");
		jpql.append("WHERE itemProductoAcademico.id = :id ");
		Query query = getEntityManager().createQuery(jpql.toString());
		query.setParameter("id", itemProductoAcademicoId);
		return (ItemProductoAcademico) query.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ItemProductoAcademico> findAll()
			throws Exception {
		StringBuffer jpql = new StringBuffer();
		jpql.append("SELECT itemProductoAcademico ");
		jpql.append("FROM ItemProductoAcademico itemProductoAcademico ");
		Query query = getEntityManager().createQuery(jpql.toString());
		return query.getResultList();
	}
}