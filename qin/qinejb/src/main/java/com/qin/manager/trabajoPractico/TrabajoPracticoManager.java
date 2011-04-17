package com.qin.manager.trabajoPractico;

import com.qin.entity.ItemProductoAcademico;
import com.qin.entity.ProductoAcademico;

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
}
