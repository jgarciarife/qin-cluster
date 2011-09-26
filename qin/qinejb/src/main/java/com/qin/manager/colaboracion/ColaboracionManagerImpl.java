package com.qin.manager.colaboracion;

import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qin.eao.grupo.GrupoEAO;
import com.qin.eao.materia.MateriaEAO;
import com.qin.eao.resolucion.ResolucionEAO;
import com.qin.eao.respuesta.RespuestaEAO;
import com.qin.entity.Grupo;
import com.qin.entity.Materia;
import com.qin.entity.Resolucion;
import com.qin.entity.Respuesta;
import com.qin.entity.TrabajoPractico;
import com.qin.manager.administracion.AdministracionManager;
import com.qin.manager.dictamen.DictamenManager;
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
	private RespuestaEAO respuestaEAO;

	@EJB
	private AdministracionManager administracionManager;

	@EJB
	private TrabajoPracticoManager trabajoPracticoManager;

	@EJB
	private DictamenManager dictamenManager;

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

	@Override
	public void saveResolucion(Resolucion res) throws Exception {
		if (res.getRespuestas() != null) {
			for (Respuesta r : res.getRespuestas()) {
				r.setResolucion(res);
			}
		}
		if (res.getId() == null) {
			insertResolucion(res);
		} else {
			updateResolucion(res);
		}
	}

	public void setResolucionEAO(ResolucionEAO resolucionEAO) {
		this.resolucionEAO = resolucionEAO;
	}

	public ResolucionEAO getResolucionEAO() {
		return resolucionEAO;
	}

	public void insertResolucion(Resolucion res) throws Exception {
		resolucionEAO.insert(res);
	}

	public void updateResolucion(Resolucion res) throws Exception {
		resolucionEAO.update(res);
	}

	@Override
	public Map<Integer, String> findAllTPNotaByMateria(Long materiaId)
			throws Exception {
		return dictamenManager.findAllTPNotaByMateria(materiaId);
	}
	
	@Override
	public String generateCodigoResolucionCompartida() throws Exception {
		return String.valueOf(Math.round(Math.random() * 1000));
	}
}