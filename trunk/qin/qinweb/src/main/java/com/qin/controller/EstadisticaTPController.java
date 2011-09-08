package com.qin.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qin.entity.Materia;
import com.qin.manager.colaboracion.ColaboracionManager;

@Controller
public class EstadisticaTPController {
	protected static Logger logger = LoggerFactory
			.getLogger(EstadisticaTPController.class);

	@Autowired
	private ColaboracionManager colaboracionManager;

	@ModelAttribute("materias")
	public List<Materia> popularMaterias() throws Exception {
		return getColaboracionManager().findAllMaterias();
	}

	@RequestMapping(value = "/estadistica_tp.html")
	public String altaTP(Model model) throws Exception {
		return "tp.estadistica";
	}

	@RequestMapping(value = "/ver_estadistica.html")
	protected String buscarTPs(Long materiaId, Model model) throws Exception {
		// HashMap<Integer, String> obj = colaboracionManager
		// .findAllTPNotaByMateria(materiaId);
		// JsonControllerUtil.sendChartToClient(obj, request);
		model.addAttribute("materiaId", materiaId);
		return "tp.ver_estadistica_tp_en_materia";
	}

	@RequestMapping(value = "/actualizar_estadistica.html", method = RequestMethod.GET)
	protected @ResponseBody
	Grafico actualizarGraficoTPs(Long materiaId) throws Exception {
		HashMap<Integer, String> itemsMap = colaboracionManager
				.findAllTPNotaByMateria(materiaId);
		Grafico grafico = new Grafico();
		List<ItemGrafico> itemsGrafico = mapear(itemsMap);
		grafico.setData(itemsGrafico);
		return grafico;
	}

	private List<ItemGrafico> mapear(HashMap<Integer, String> itemsMap) {
		List<ItemGrafico> items = new ArrayList<ItemGrafico>();
		if (itemsMap != null) {
			for (Integer materia : itemsMap.keySet()) {
				String value = itemsMap.get(materia);
				ItemGrafico item = new ItemGrafico(materia, value);
				items.add(item);
			}
		}

		Collections.sort(items, new Comparator<ItemGrafico>() {
			public int compare(ItemGrafico arg0, ItemGrafico arg1) {
				return arg0.getLabel().compareTo(arg1.getLabel());
			}
		});
		return items;
	}

	public void setColaboracionManager(ColaboracionManager colaboracionManager) {
		this.colaboracionManager = colaboracionManager;
	}

	public ColaboracionManager getColaboracionManager() {
		return colaboracionManager;
	}

	public class Grafico {
		private ChartInfo chart = new ChartInfo();
		private List<ItemGrafico> data;

		public void setData(List<ItemGrafico> data) {
			this.data = data;
		}

		public List<ItemGrafico> getData() {
			return data;
		}

		public void setChart(ChartInfo chart) {
			this.chart = chart;
		}

		public ChartInfo getChart() {
			return chart;
		}

	}

	public class ChartInfo {
		private String caption = "Cantidad de trabajos prácticos de la materia elegida, por nota";
		private String xAxisName = "Nota";
		private String yAxisName = "Cantidad de trabajos prácticos de la materia elegida";
		private String numberPrefix = "Cant. TPs: ";

		public void setCaption(String caption) {
			this.caption = caption;
		}

		public String getCaption() {
			return caption;
		}

		public void setxAxisName(String xAxisName) {
			this.xAxisName = xAxisName;
		}

		public String getxAxisName() {
			return xAxisName;
		}

		public void setyAxisName(String yAxisName) {
			this.yAxisName = yAxisName;
		}

		public String getyAxisName() {
			return yAxisName;
		}

		public void setNumberPrefix(String numberPrefix) {
			this.numberPrefix = numberPrefix;
		}

		public String getNumberPrefix() {
			return numberPrefix;
		}
	}

	public class ItemGrafico {
		private String label;
		private String value;

		public ItemGrafico(Integer materia, String value) {
			this.label = materia.toString();
			this.value = value;
		}

		public void setLabel(String label) {
			this.label = label;
		}

		public String getLabel() {
			return label;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		private EstadisticaTPController getOuterType() {
			return EstadisticaTPController.this;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((label == null) ? 0 : label.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ItemGrafico other = (ItemGrafico) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			return true;
		}
	}
}
