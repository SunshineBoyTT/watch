/**    
* @{#} WSSessionLocalCache.java Create on 2016年4月12日 下午5:24:23    
* Copyright (c) 2015.    
*/
package com.spring.base.websocket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class WSSessionLocalCache_lost implements Serializable {

	private static final long serialVersionUID = 5748770732582192169L;
	private static Map<String, UserSocketVo> wsSessionCache = new ConcurrentHashMap<String, UserSocketVo>();

	public static boolean exists(String sessionId) {
		if (!wsSessionCache.containsKey(sessionId)) {
			return false;
		} else {
			return true;
		}
	}

	public static void put(String sessionId, UserSocketVo UserSocketVo) {
		wsSessionCache.put(sessionId, UserSocketVo);
	}

	public static UserSocketVo get(String sessionId) {
		return wsSessionCache.get(sessionId);
	}

	public static void remove(String sessionId) {
		wsSessionCache.remove(sessionId);
	}

	public static List<UserSocketVo> getAllSessions() {
		return new ArrayList<>(wsSessionCache.values());
	}
}
