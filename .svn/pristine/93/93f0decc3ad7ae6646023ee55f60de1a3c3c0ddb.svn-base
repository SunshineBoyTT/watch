/**    
* @{#} ResponseBuilder.java Create on 2016年4月13日 上午11:26:40    
* Copyright (c) 2015.    
*/
package com.spring.base.websocket.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

/**
 * @author <a href="mailto:liwei.fly@gmail.com">author</a>
 * @version 1.0
 * @description
 */
public class JSONUtils {

	protected Map<String, Object> params = new HashMap<String, Object>();
	
	public JSONUtils setParams(String key, Object value) {
		this.params.put(key, value);
		return this;
	}
	
	public String buildJSON() throws JSONException {
		JSONObject jsonObject = new JSONObject();
		for (Map.Entry<String, Object> param : params.entrySet()) {
			if (param.getKey() != null && !"".equals(param.getKey()) && param.getValue() != null
					&& !"".equals(param.getValue())) {
				jsonObject.put(param.getKey(), param.getValue());
			}
		}
		return jsonObject.toString();
	}

	public Map<String, Object> parseJSON(String jsonBody) throws JSONException {

		Map<String, Object> params = new HashMap<String, Object>();
		JSONObject obj = new JSONObject(jsonBody);
		Iterator it = obj.keys();
		while (it.hasNext()) {
			Object o = it.next();
			if (o instanceof String) {
				String key = (String) o;
				params.put(key, obj.get(key));
			}
		}
		return params;
	}
}
