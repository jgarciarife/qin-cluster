/*
 * rights reserved.
 */
package org.terracotta;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.terracotta.api.TerracottaClient;

public class ColorCacheToolkitMap {
	private static Map<String, String> miMap = null;

	private final static Map<String, Color> colorMap = new HashMap<String, Color>();
	static {
		colorMap.put("red", Color.red);
		colorMap.put("blue", Color.blue);
		colorMap.put("green", Color.green);
		colorMap.put("white", Color.white);
		colorMap.put("black", Color.black);
		colorMap.put("lightGray", Color.lightGray);
		colorMap.put("gray", Color.gray);
		colorMap.put("darkGray", Color.darkGray);
		colorMap.put("pink", Color.pink);
		colorMap.put("orange", Color.orange);
		colorMap.put("yellow", Color.yellow);
		colorMap.put("magenta", Color.magenta);
		colorMap.put("cyan", Color.cyan);

		miMap = new TerracottaClient("localhost:9510").getToolkit().getMap(
				"myStaticMap");
	}

	private static final ColorDatabase colorDatabase = new ColorDatabase();

	public ColorCacheToolkitMap() {
		/**/
	}

	public Color getColor(String name) {
		String elem = getClusterizedMap().get(name);
		if (elem == null) {
			Color color = colorDatabase.getColor(name);
			if (color == null) {
				return null;
			}
			getClusterizedMap().put(name, name);
			elem = name;
		}
		return getColorByName(elem);
	}

	/**
	 * Hacer esta vuelta no tiene sentido! Solo hago esto porque chillo al
	 * tratar de clusterizar un map<String, Color>, entonces, en vez de hacer
	 * eso, guardo el toString y despues creo el objeto aca... es solo con el
	 * fin de probar si el map<String, String> se clusteriza correctamente
	 * 
	 * @param elem
	 * @return
	 */
	private Color getColorByName(String elem) {
		return colorMap.get(elem.toLowerCase());
	}

	public String[] getColorNames() {
		Iterator<String> keys = getClusterizedMap().keySet().iterator();
		List<String> list = new ArrayList<String>();
		while (keys.hasNext()) {
			String name = keys.next();
			list.add(getClusterizedMap().get(name));
		}
		return list.toArray(new String[list.size()]);
	}

	public long getTTL() {
		return 0;
	}

	public long getTTI() {
		return 0;
	}

	public int getSize() {
		return getClusterizedMap().size();
	}

	private Map<String, String> getClusterizedMap() {
		// Si hago esto tarda mas, en cambio si me guardo una referencia static
		// al mapa anda joya. obviamente que necesita mucho test
		// ClusteringToolkit toolkit = new TerracottaClient("localhost:9510")
		// .getToolkit();
		// ClusteredMap<String, String> myClusteredMap =
		// toolkit.getMap("myMap");
		// return myClusteredMap;
		return miMap;
	}
}
