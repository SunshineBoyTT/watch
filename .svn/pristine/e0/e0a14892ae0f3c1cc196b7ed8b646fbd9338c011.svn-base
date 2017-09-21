package com.spring.base.websocket;

import org.springframework.web.socket.WebSocketSession;

public class UserSocketVo implements java.io.Serializable{

	
	private String sessionid; // 用户sessionid
	private WebSocketSession webSocketSession; // 用户对应的wsSession 默认仅缓存一个
	public String getSessionid() {
		return sessionid;
	}
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}
	public WebSocketSession getWebSocketSession() {
		return webSocketSession;
	}
	public void setWebSocketSession(WebSocketSession webSocketSession) {
		this.webSocketSession = webSocketSession;
	}
	@Override
	public String toString() {
		return "UserSocketVo [sessionid=" + sessionid + ", webSocketSession=" + webSocketSession + "]";
	}
	
}
