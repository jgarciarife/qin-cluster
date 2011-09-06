package com.qin.manager.dictamen;

import java.util.HashMap;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.qin.eao.dictamen.DictamenEAO;
import com.qin.entity.Dictamen;

@Stateless
public class DictamenManagerImpl implements DictamenManager {
	@EJB
	private DictamenEAO dictamenEAO;

	@Override
	public Dictamen findById(Long id) throws Exception {
		Dictamen dic = getDictamenEAO().findById(id);
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
	public HashMap<Integer, String> findAllTPNotaByMateria(Long materiaId) throws Exception {
		List<Object[]> resultado = getDictamenEAO()
				.findAllDictamenByMateriaGroupByNota(materiaId);
		if ((resultado == null)
				|| ((resultado != null) && (resultado.isEmpty()))) {
			return new HashMap<Integer, String>();
		}
		HashMap<Integer, String> retorno = new HashMap<Integer, String>();
		Double nota = null;
		Long cantidad = null;
		Integer key = null;
		Long cantidadOriginal = null;
		for (Object[] registro : resultado) {
			if (registro != null) {
				nota = (Double) registro[0];
				cantidad = (Long) registro[1];
				if (nota != null) {
					if ((9.5 < nota.floatValue()) && (nota.floatValue() <= 10)) {
						key = new Integer(10);
					} else if ((8.5 < nota.floatValue())
							&& (nota.floatValue() <= 9.5)) {
						key = new Integer(9);
					} else if ((7.5 < nota.floatValue())
							&& (nota.floatValue() <= 8.5)) {
						key = new Integer(8);
					} else if ((6.5 < nota.floatValue())
							&& (nota.floatValue() <= 7.5)) {
						key = new Integer(7);
					} else if ((5.5 < nota.floatValue())
							&& (nota.floatValue() <= 6.5)) {
						key = new Integer(6);
					} else if ((4.5 < nota.floatValue())
							&& (nota.floatValue() <= 5.5)) {
						key = new Integer(5);
					} else if ((3.5 < nota.floatValue())
							&& (nota.floatValue() <= 4.5)) {
						key = new Integer(4);
					} else if ((2.5 < nota.floatValue())
							&& (nota.floatValue() <= 3.5)) {
						key = new Integer(3);
					} else if ((1.5 < nota.floatValue())
							&& (nota.floatValue() <= 2.5)) {
						key = new Integer(2);
					} else if ((0.5 < nota.floatValue())
							&& (nota.floatValue() <= 1.5)) {
						key = new Integer(1);
					} else if ((0 <= nota.floatValue())
							&& (nota.floatValue() <= 0.5)) {
						key = new Integer(0);
					}
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
