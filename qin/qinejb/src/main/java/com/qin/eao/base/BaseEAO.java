package com.qin.eao.base;

import com.qin.entity.base.BaseEntity;

public interface BaseEAO {

	void insert(BaseEntity entity) throws Exception;

	void update(BaseEntity entity) throws Exception;

	void delete(BaseEntity entity) throws Exception;
}
