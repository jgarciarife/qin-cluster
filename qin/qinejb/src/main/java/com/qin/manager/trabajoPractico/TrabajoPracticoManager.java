package com.qin.manager.trabajoPractico;

import java.util.List;

import com.qin.entity.ItemProductoAcademico;
import com.qin.entity.ProductoAcademico;
import com.qin.entity.TrabajoPractico;

public interface TrabajoPracticoManager {

	void insertItemProductoAcademico(ItemProductoAcademico itemProductoAcademico)
			throws Exception;

	void updateItemProductoAcademico(ItemProductoAcademico itemProductoAcademico)
			throws Exception;

	void deleteItemProductoAcademico(ItemProductoAcademico itemProductoAcademico)
			throws Exception;

	void insertProductoAcademico(ProductoAcademico productoAcademico)
			throws Exception;

	void updateProductoAcademico(ProductoAcademico productoAcademico)
			throws Exception;

	void deleteProductoAcademico(ProductoAcademico productoAcademico)
			throws Exception;

	TrabajoPractico findById(Long id) throws Exception;

	List<TrabajoPractico> findByMateriaId(Long materiaId) throws Exception;

	List<TrabajoPractico> findAll() throws Exception;
}
