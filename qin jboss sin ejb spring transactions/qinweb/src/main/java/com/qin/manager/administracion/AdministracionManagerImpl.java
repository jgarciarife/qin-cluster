package com.qin.manager.administracion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.alumno.AlumnoEAO;
import com.qin.eao.materia.MateriaEAO;
import com.qin.entity.Alumno;
import com.qin.entity.Materia;
import com.qin.entity.Usuario;
@Service
public class AdministracionManagerImpl implements AdministracionManager {

	protected static Logger logger = LoggerFactory
			.getLogger(AdministracionManagerImpl.class);

	@Autowired
	private MateriaEAO materiaEAO;
	
	@Autowired
	private AlumnoEAO alumnoEAO;

	public AdministracionManagerImpl() {
	}

	@Override
	@Transactional
	public void insertMateria(Materia materia) throws Exception {
		materiaEAO.insert(materia);
	}

	@Override
	@Transactional
	public void updateMateria(Materia materia) throws Exception {
		materiaEAO.update(materia);
	}

	@Override
	@Transactional
	public void deleteMateria(Materia materia) throws Exception {
		materiaEAO.delete(materia);
	}
	
	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Alumno findAlumnoByUsuario(Usuario usuario) throws Exception {
		return alumnoEAO.findById(usuario.getId());
	}
}