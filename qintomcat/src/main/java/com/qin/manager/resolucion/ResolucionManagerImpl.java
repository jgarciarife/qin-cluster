package com.qin.manager.resolucion;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.grupo.GrupoEAO;
import com.qin.eao.resolucion.ResolucionEAO;
import com.qin.entity.Alumno;
import com.qin.entity.Grupo;
import com.qin.entity.Materia;
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;

@Service
public class ResolucionManagerImpl implements ResolucionManager {

	protected static Logger logger = LoggerFactory
			.getLogger(ResolucionManagerImpl.class);

	@Autowired
	private ResolucionEAO resolucionEAO;

	@Autowired
	private GrupoEAO grupoEAO;

	public ResolucionManagerImpl() {
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Resolucion findById(Long id) throws Exception {
		return resolucionEAO.findById(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Resolucion> findByTrabajoPracticoId(Long tpId) throws Exception {
		return resolucionEAO.findByTPId(tpId);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Grupo> findByTrabajoPracticoIdWithGroup(Long tpId)
			throws Exception {
		return resolucionEAO.findByTPIdWithGrupo(tpId);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Resolucion> findAll() throws Exception {
		return resolucionEAO.findAll();
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Grupo> findAllWithGrupo() throws Exception {
		return resolucionEAO.findAllWithGrupo();
	}

	@Override
	@Transactional
	public void insert(Resolucion tp) throws Exception {
		resolucionEAO.insert(tp);
	}

	@Override
	@Transactional
	public void update(Resolucion tp) throws Exception {
		resolucionEAO.update(tp);
	}

	public void setResolucionEAO(ResolucionEAO resolucionEAO) {
		this.resolucionEAO = resolucionEAO;
	}

	public ResolucionEAO getResolucionEAO() {
		return resolucionEAO;
	}

	@Override
	@Transactional
	public Resolucion createResolucion(TrabajoPractico trabajoPractico,
			String codigoResolucionCompartida) throws Exception {
		Resolucion resolucion = new Resolucion();
		resolucion.setTrabajoPractico(trabajoPractico);
		resolucion.setCodigoResolucionCompartida(codigoResolucionCompartida);
		return resolucion;
	}

	@Override
	@Transactional
	public Grupo createGrupo(Resolucion resolucion, Materia materia)
			throws Exception {
		Grupo grupo = new Grupo();
		grupo.setResolucion(resolucion);
		grupo.setMateria(materia);
		return grupo;
	}

	// el codigo de resolucion compartida viene de afuera solo para probar
	// se debería generar dentro de este método
	@Override
	@Transactional
	public Resolucion joinResolucion(Resolucion verificacion,
			TrabajoPractico trabajoPractico, Alumno alumno,
			String codigoResolucionCompartida) throws Exception {
		Resolucion resolucion = resolucionEAO.findByTrabajoPracticoAndAlumno(
				trabajoPractico, alumno);
		if (resolucion == null) {
			resolucion = resolucionEAO
					.findByTrabajoPracticoIdAndCodigoResolucionCompartida(
							trabajoPractico.getId(), codigoResolucionCompartida);
			if (resolucion == null) {
				resolucion = createResolucion(trabajoPractico,
						codigoResolucionCompartida);
				insert(resolucion);
			}
			Grupo grupo = grupoEAO.findByResolucion(resolucion);
			if (grupo == null) {
				grupo = createGrupo(resolucion, trabajoPractico.getMateria());
				grupoEAO.insert(grupo);
			}
			if (grupo.getAlumnos() == null) {
				grupo.setAlumnos(new ArrayList<Alumno>());
			}
			grupo.getAlumnos().add(alumno);
			grupoEAO.update(grupo);
		}
		if ((verificacion != null) && (verificacion.getId() != null)) {
			if (resolucion.getId().longValue() != verificacion.getId()
					.longValue()) {
				throw new Exception(
						"Resolucion incorrecta; error en base de datos");
			}
		}
		return resolucion;
	}
}
