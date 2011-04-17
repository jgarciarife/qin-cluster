package com.qin.eao.trabajoPractico;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.TrabajoPractico;

public interface TrabajoPracticoEAO extends BaseEAO {

	TrabajoPractico findById(Long trabajoPracticoId) throws Exception;

}