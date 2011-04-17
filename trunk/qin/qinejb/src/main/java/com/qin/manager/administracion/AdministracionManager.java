package com.qin.manager.administracion;

import com.qin.entity.Materia;

public interface AdministracionManager {

	void insertMateria(Materia materia) throws Exception;

	void updateMateria(Materia materia) throws Exception;

	void deleteMateria(Materia materia) throws Exception;

}
