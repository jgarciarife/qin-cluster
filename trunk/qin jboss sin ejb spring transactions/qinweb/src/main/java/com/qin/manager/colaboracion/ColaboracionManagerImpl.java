package com.qin.manager.colaboracion;

import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.qin.eao.grupo.GrupoEAO;
import com.qin.eao.materia.MateriaEAO;
import com.qin.eao.resolucion.ResolucionEAO;
import com.qin.eao.respuesta.RespuestaEAO;
import com.qin.entity.Grupo;
import com.qin.entity.Materia;
import com.qin.entity.Resolucion;
import com.qin.entity.Respuesta;
import com.qin.entity.TrabajoPractico;
import com.qin.entity.Usuario;
import com.qin.manager.administracion.AdministracionManager;
import com.qin.manager.dictamen.DictamenManager;
import com.qin.manager.trabajoPractico.TrabajoPracticoManager;
@Service
public class ColaboracionManagerImpl implements ColaboracionManager {

	protected static Logger logger = LoggerFactory
			.getLogger(ColaboracionManagerImpl.class);

	@Autowired
	private GrupoEAO grupoEAO;

	@Autowired
	private MateriaEAO materiaEAO;

	@Autowired
	private ResolucionEAO resolucionEAO;

	@Autowired
	private RespuestaEAO respuestaEAO;

	@Autowired
	private AdministracionManager administracionManager;

	@Autowired
	private TrabajoPracticoManager trabajoPracticoManager;

	@Autowired
	private DictamenManager dictamenManager;

	public ColaboracionManagerImpl() {
	}

	@Override
	@Transactional
	public void insertGrupo(Grupo grupo) throws Exception {
		grupoEAO.insert(grupo);
	}

	@Override
	@Transactional
	public void updateGrupo(Grupo grupo) throws Exception {
		grupoEAO.update(grupo);
	}

	@Override
	@Transactional
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
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Materia> findAllMaterias() throws Exception {
		return materiaEAO.findAll();
	}

	@Override
	public void updateTP(TrabajoPractico tp) throws Exception {
		trabajoPracticoManager.update(tp);
	}

	@Override
	@Transactional
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

	@Transactional
	public void insertResolucion(Resolucion res) throws Exception {
		resolucionEAO.insert(res);
	}

	@Transactional
	public void updateResolucion(Resolucion res) throws Exception {
		resolucionEAO.update(res);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public Map<Integer, String> findAllTPNotaByMateria(Long materiaId)
			throws Exception {
		return dictamenManager.findAllTPNotaByMateria(materiaId);
	}

	@Override
	public String generateCodigoResolucionCompartida(Usuario usuario) throws Exception {
//		return String.valueOf(Math.round(Math.random() * 1000));
		return "000-" + usuario.getId();
	}
}