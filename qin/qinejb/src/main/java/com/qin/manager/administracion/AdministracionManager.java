package com.qin.manager.administracion;

import com.qin.entity.Alumno;
import com.qin.entity.Materia;
import com.qin.entity.Usuario;

public interface AdministracionManager {

	void insertMateria(Materia materia) throws Exception;

	void updateMateria(Materia materia) throws Exception;

	void deleteMateria(Materia materia) throws Exception;

	Alumno findAlumnoByUsuario(Usuario usuario) throws Exception;

}
