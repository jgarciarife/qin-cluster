package com.qin.eao.dictamen;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Dictamen;

public interface DictamenEAO extends BaseEAO {

	Dictamen findById(Long dictamenId) throws Exception;

}
