/**
 * 
 */
package com.qin.controller.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import org.codehaus.jettison.json.JSONObject;

/**
 * @author diego
 * 
 */
public class JsonControllerUtil {

	/**
	 * 
	 */
	private JsonControllerUtil() {
	}

	public static void sendChartToClient(HashMap<Integer, String> obj,
			HttpServletRequest request) throws Exception {
		JSONObject json = new JSONObject();
		StringBuffer buffer = new StringBuffer();
		Vector<Integer> v = new Vector<Integer>(obj.keySet());
		Collections.sort(v);
		Iterator<Integer> it = v.iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			json.put("label", key.toString());
			json.put("value", obj.get(key));
			if (!buffer.toString().equals("")) {
				buffer.append(",");
			}
			buffer.append(json.toString());
		}
		String msg = buffer.toString();
		request.setAttribute("tabla", msg);
		return;
	}

}
