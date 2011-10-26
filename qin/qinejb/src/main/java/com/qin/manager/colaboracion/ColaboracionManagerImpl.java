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
		Resolucion original = resolucionEAO
				.findByTrabajoPracticoIdAndCodigoResolucionCompartida(res
						.getTrabajoPractico().getId(), res
						.getCodigoResolucionCompartida());
		if (original != null) {
			if ((original.getRespuestas() != null)
					&& (original.getRespuestas().size() > 0)) {
				Respuesta resp = null;
				for (Respuesta r : original.getRespuestas()) {
					for (int i = 0; i < res.getRespuestas().size(); i++) {
						resp = res.getRespuestas().get(i);
						if ((resp != null)
								&& (r.getConsigna().getId().longValue() == resp
										.getConsigna().getId().longValue())) {
							r.setRespuesta(resp.getRespuesta());
							r.setResolucion(original);
							respuestaEAO.update(r);
							resp.setId(r.getId());
						}
					}
				}
			}
			for (Respuesta r : res.getRespuestas()) {
				if (r.getId() == null) {
					r.setResolucion(original);
					respuestaEAO.insert(r);
				}
			}
			updateResolucion(original);
			// -------------------------------------------------------------
			/*
			 * Map<Long, Respuesta> insertar = new HashMap<Long, Respuesta>();
			 * Map<Long, Respuesta> actualizar = new HashMap<Long, Respuesta>();
			 * Map<Long, Respuesta> borrar = new HashMap<Long, Respuesta>();
			 * Set<Long> nuevas = new HashSet<Long>(); for (Respuesta r :
			 * res.getRespuestas()) { if (r.getId() == null) {
			 * r.setResolucion(res); respuestaEAO.insert(r); }
			 * nuevas.add(r.getId()); } Set<Long> originales = new
			 * HashSet<Long>(); for (Respuesta r : original.getRespuestas()) {
			 * if (nuevas.contains(r.getId())) { actualizar.put(r.getId(), r); }
			 * else { borrar.put(r.getId(), r); } originales.add(r.getId()); }
			 * for (Respuesta r : res.getRespuestas()) { if
			 * (!originales.contains(r.getId())) { r.setResolucion(res);
			 * insertar.put(r.getId(), r); } } Respuesta r = null; for
			 * (Map.Entry<Long, Respuesta> entrada : insertar.entrySet()) { r =
			 * entrada.getValue(); r.setResolucion(original); if (r.getId() !=
			 * null) { respuestaEAO.update(r); } else { respuestaEAO.insert(r);
			 * } } for (Map.Entry<Long, Respuesta> entrada :
			 * actualizar.entrySet()) { r = entrada.getValue();
			 * r.setResolucion(original); if (r.getId() != null) {
			 * respuestaEAO.update(r); } else { respuestaEAO.insert(r); } } for
			 * (Map.Entry<Long, Respuesta> entrada : borrar.entrySet()) { r =
			 * entrada.getValue(); if (r.getId() != null) {
			 * respuestaEAO.delete(r); } } original = null; res = (Resolucion)
			 * resolucionEAO
			 * .findByTrabajoPracticoIdAndCodigoResolucionCompartida(
			 * res.getTrabajoPractico().getId(), res
			 * .getCodigoResolucionCompartida()); updateResolucion(res);
			 */
		} else {
			if (res.getRespuestas() != null) {
				for (Respuesta r : res.getRespuestas()) {
					r.setResolucion(res);
				}
			}
			insertResolucion(res);
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