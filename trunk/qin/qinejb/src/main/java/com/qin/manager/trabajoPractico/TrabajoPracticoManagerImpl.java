package com.qin.manager.trabajoPractico;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.itemProductoAcademico.ItemProductoAcademicoEAO;
import com.qin.eao.productoAcademico.ProductoAcademicoEAO;
import com.qin.entity.ItemProductoAcademico;
import com.qin.entity.ProductoAcademico;

@Stateless
public class TrabajoPracticoManagerImpl implements TrabajoPracticoManager {

	protected static Logger logger = LoggerFactory
			.getLogger(TrabajoPracticoManagerImpl.class);

	@EJB
	private ItemProductoAcademicoEAO itemProductoAcademicoEAO;
	
	@EJB
	private ProductoAcademicoEAO productoAcademicoEAO;

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
}