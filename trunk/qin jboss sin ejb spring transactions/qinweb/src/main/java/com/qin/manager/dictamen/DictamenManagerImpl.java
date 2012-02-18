package com.qin.manager.dictamen;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qin.eao.dictamen.DictamenEAO;
import com.qin.entity.Dictamen;
@Service
public class DictamenManagerImpl implements DictamenManager {
	@Autowired
	private DictamenEAO dictamenEAO;

	@Override
	public Dictamen findById(Long id) throws Exception {
		Dictamen dic = getDictamenEAO().findById(id);
		return dic;
	}
	
	@Override
	public Dictamen findByResolucionId(Long id) throws Exception {
		Dictamen dic = getDictamenEAO().findByResolucionId(id);
		return dic;
	}

	public void setDictamenEAO(DictamenEAO dictamenEAO) {
		this.dictamenEAO = dictamenEAO;
	}

	public DictamenEAO getDictamenEAO() {
		return dictamenEAO;
	}

	@Override
	public List<Dictamen> findAll() throws Exception {
		return getDictamenEAO().findAll();
	}

	@Override
	public void insert(Dictamen tp) throws Exception {
		getDictamenEAO().insert(tp);
	}

	@Override
	public void update(Dictamen tp) throws Exception {
		getDictamenEAO().update(tp);
	}

	@Override
	public Map<Integer, String> findAllTPNotaByMateria(Long materiaId)
			throws Exception {
		List<Object[]> resultado = getDictamenEAO()
				.findAllDictamenByMateriaGroupByNota(materiaId);
		if ((resultado == null)
				|| ((resultado != null) && (resultado.isEmpty()))) {
			return new HashMap<Integer, String>();
		}
		Map<Integer, String> retorno = new HashMap<Integer, String>();
		Double nota = null;
		Long cantidad = null;
		Integer key = null;
		Long cantidadOriginal = null;
		for (Object[] registro : resultado) {
			if (registro != null) {
				nota = (Double) registro[0];
				cantidad = (Long) registro[1];
				if (nota != null) {
					key = Long.valueOf(Math.round(nota)).intValue();
					if (retorno.containsKey(key)) {
						cantidadOriginal = new Long(retorno.get(key));
					} else {
						cantidadOriginal = new Long(0);
					}
					retorno.put(key, new Long(cantidadOriginal.longValue()
							+ cantidad.longValue()).toString());
				}
			}
		}
		return retorno;
	}
}
