/**    
* @{#} WSSessionLocalCache.java Create on 2016年4月12日 下午5:24:23    
* Copyright (c) 2015.    
*/
package com.spring.base.websocket;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.WebSocketSession;


public class WSSessionLocalCache implements Serializable {

	private static final long serialVersionUID = 5748770732582192169L;
	private static final List<WebSocketSession> wsSessionCache=new Vector<>();

	public static boolean exists(WebSocketSession session) {
		if (!wsSessionCache.contains(session)) {
			return false;
		} else {
			return true;
		}
	}

	public static void add(WebSocketSession session) {
		wsSessionCache.add(session);
	}


	public static void remove(WebSocketSession session) {
		wsSessionCache.remove(session);
	}

	public static List<WebSocketSession> getAllSessions() {
		return wsSessionCache;
	}
}
