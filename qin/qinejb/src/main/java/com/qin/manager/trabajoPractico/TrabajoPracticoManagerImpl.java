package com.qin.manager.trabajoPractico;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.itemProductoAcademico.ItemProductoAcademicoEAO;
import com.qin.eao.productoAcademico.ProductoAcademicoEAO;
import com.qin.eao.trabajoPractico.TrabajoPracticoEAO;
import com.qin.entity.ItemProductoAcademico;
import com.qin.entity.ProductoAcademico;
import com.qin.entity.TrabajoPractico;

@Stateless
public class TrabajoPracticoManagerImpl implements TrabajoPracticoManager {

	protected static Logger logger = LoggerFactory
			.getLogger(TrabajoPracticoManagerImpl.class);

	@EJB
	private ItemProductoAcademicoEAO itemProductoAcademicoEAO;
	
	@EJB
	private ProductoAcademicoEAO productoAcademicoEAO;
	
	@EJB
	private TrabajoPracticoEAO trabajoPracticoEAO;

	public TrabajoPracticoManagerImpl() {
	}

	@Override
	public void insertItemProductoAcademico(
			ItemProductoAcademico itemProductoAcademico) throws Exception {
		itemProductoAcademicoEAO.insert(itemProductoAcademico);
	}

	@Override
	public void updateItemProductoAcademico(
			ItemProductoAcademico itemProductoAcademico) throws Exception {
		itemProductoAcademicoEAO.update(itemProductoAcademico);
	}

	@Override
	public void deleteItemProductoAcademico(
			ItemProductoAcademico itemProductoAcademico) throws Exception {
		itemProductoAcademicoEAO.delete(itemProductoAcademico);
	}

	@Override
	public void insertProductoAcademico(ProductoAcademico productoAcademico)
			throws Exception {
		productoAcademicoEAO.insert(productoAcademico);
	}
	 
	@Override
	public void updateProductoAcademico(ProductoAcademico productoAcademico)
			throws Exception {
		productoAcademicoEAO.update(productoAcademico);
	}

	@Override
	public void deleteProductoAcademico(ProductoAcademico productoAcademico)
			throws Exception {
		productoAcademicoEAO.delete(productoAcademico);
	}

	@Override
	public TrabajoPractico findById(Long id) throws Exception {
		TrabajoPractico trabajoPractico = getTrabajoPracticoEAO().findById(id);
		Hibernate.initialize(trabajoPractico.getMateria());
		Hibernate.initialize(trabajoPractico.getItemProductoAcademicos());
		return trabajoPractico;
	}

	public void setTrabajoPracticoEAO(TrabajoPracticoEAO trabajoPracticoEAO) {
		this.trabajoPracticoEAO = trabajoPracticoEAO;
	}

	public TrabajoPracticoEAO getTrabajoPracticoEAO() {
		return trabajoPracticoEAO;
	}

	@Override
	public List<TrabajoPractico> findByMateriaId(Long materiaId)
			throws Exception {
		return getTrabajoPracticoEAO().findByMateriaId(materiaId);
	}
	
	@Override
	public List<TrabajoPractico> findAll() throws Exception{
		return getTrabajoPracticoEAO().findAll();
	}
}