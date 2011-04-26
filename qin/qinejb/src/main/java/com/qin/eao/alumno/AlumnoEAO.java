package com.qin.eao.alumno;

import java.util.List;

import com.qin.eao.base.BaseEAO;
import com.qin.entity.Alumno;

public interface AlumnoEAO extends BaseEAO {

	Alumno findById(Long alumnoId) throws Exception;
	
	List<Alumno> findAll() throws Exception;

}
