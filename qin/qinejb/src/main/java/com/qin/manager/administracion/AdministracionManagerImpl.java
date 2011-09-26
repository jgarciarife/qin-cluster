package com.qin.manager.administracion;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.alumno.AlumnoEAO;
import com.qin.eao.materia.MateriaEAO;
import com.qin.entity.Alumno;
import com.qin.entity.Materia;
import com.qin.entity.Usuario;

@Stateless
public class AdministracionManagerImpl implements AdministracionManager {

	protected static Logger logger = LoggerFactory
			.getLogger(AdministracionManagerImpl.class);

	@EJB
	private MateriaEAO materiaEAO;
	
	@EJB
	private AlumnoEAO alumnoEAO;

	public AdministracionManagerImpl() {
	}

	@Override
	public void insertMateria(Materia materia) throws Exception {
		materiaEAO.insert(materia);
	}

	@Override
	public void updateMateria(Materia materia) throws Exception {
		materiaEAO.update(materia);
	}

	@Override
	public void deleteMateria(Materia materia) throws Exception {
		materiaEAO.delete(materia);
	}
	
	@Override
	public Alumno findAlumnoByUsuario(Usuario usuario) throws Exception {
		return alumnoEAO.findById(usuario.getId());
	}
}