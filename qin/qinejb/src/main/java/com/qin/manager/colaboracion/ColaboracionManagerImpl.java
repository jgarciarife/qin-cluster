package com.qin.manager.colaboracion;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.grupo.GrupoEAO;
import com.qin.eao.materia.MateriaEAO;
import com.qin.eao.resolucion.ResolucionEAO;
import com.qin.entity.Grupo;
import com.qin.entity.Materia;
import com.qin.entity.Resolucion;
import com.qin.entity.TrabajoPractico;
import com.qin.manager.administracion.AdministracionManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;

@Stateless
public class ColaboracionManagerImpl implements ColaboracionManager {

	protected static Logger logger = LoggerFactory
			.getLogger(ColaboracionManagerImpl.class);

	@EJB
	private GrupoEAO grupoEAO;

	@EJB
	private MateriaEAO materiaEAO;
	
	@EJB
	private ResolucionEAO resolucionEAO;

	@EJB
	private AdministracionManager administracionManager;

	@EJB
	private TrabajoPracticoManager trabajoPracticoManager;
	

	public ColaboracionManagerImpl() {
	}

	@Override
	public void insertGrupo(Grupo grupo) throws Exception {
		grupoEAO.insert(grupo);
	}

	@Override
	public void updateGrupo(Grupo grupo) throws Exception {
		grupoEAO.update(grupo);
	}

	@Override
	public void deleteGrupo(Grupo grupo) throws Exception {
		grupoEAO.delete(grupo);
	}

	@Override
	public void insertTP(TrabajoPractico tp) throws Exception {
		trabajoPracticoManager.insert(tp);
	}

	public void setAdministracionManager(
			AdministracionManager administracionManager) {
		this.administracionManager = administracionManager;
	}

	public AdministracionManager getAdministracionManager() {
		return administracionManager;
	}

	public void setTrabajoPracticoManager(
			TrabajoPracticoManager trabajoPracticoManager) {
		this.trabajoPracticoManager = trabajoPracticoManager;
	}

	public TrabajoPracticoManager getTrabajoPracticoManager() {
		return trabajoPracticoManager;
	}

	@Override
	public List<Materia> findAllMaterias() throws Exception {
		return materiaEAO.findAll();
	}

	@Override
	public void updateTP(TrabajoPractico tp) throws Exception {
		trabajoPracticoManager.update(tp);
	}

	public void setResolucionEAO(ResolucionEAO resolucionEAO) {
		this.resolucionEAO = resolucionEAO;
	}

	public ResolucionEAO getResolucionEAO() {
		return resolucionEAO;
	}

	@Override
	public void insertResolucion(Resolucion res) throws Exception {
		resolucionEAO.insert(res);
		
	}

	@Override
	public void updateResolucion(Resolucion res) throws Exception {
		resolucionEAO.update(res);
	}
}