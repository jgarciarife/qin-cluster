package com.qin.eao.alumno;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Alumno;

public interface AlumnoEAO extends BaseEAO {

	Alumno findById(Long alumnoId) throws Exception;

}
