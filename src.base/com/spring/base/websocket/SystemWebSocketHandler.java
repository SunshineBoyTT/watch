package com.spring.base.websocket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;


public class SystemWebSocketHandler implements WebSocketHandler {

	private static final Logger logger;

	static {
		logger = LoggerFactory.getLogger(SystemWebSocketHandler.class);
	}

	// @Autowired
	// private WebSocketService webSocketService;

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus arg1) throws Exception {
		// TODO Auto-generated method stub
		logger.debug("websocket connection closed......");
		WSSessionLocalCache.remove(session);
		System.err.println("Close:"+session.toString());
	}

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		// TODO Auto-generated method stub

		System.err.println("websocketSession" + session.toString());
		logger.debug("connect to the websocket success......");
		// sessions.add(session);
		if (!WSSessionLocalCache.exists(session)) {
			WSSessionLocalCache.add(session);
		}
	}

	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> attributes = session.getAttributes();
		Object payload = message.getPayload();
		System.out.println("-------------ccc:" + message.getPayload());
		logger.info("定时消息");
		String payloadMessage[] = (payload + "").split(",");
		// Global.postionId = payloadMessage[0];
		// Global.employeeId = payloadMessage[1];
		// 用户建立连接成功后主动推送用户的sessionid给客户端
		UserSocketVo userSocketVo = (UserSocketVo) attributes.get("websocket_username"); // 获取用户

		JSONUtils json = new JSONUtils().setParams("uid", userSocketVo.getSessionid()).setParams("code", 0);
		TextMessage returnMessage = new TextMessage(json.buildJSON());
		userSocketVo.getWebSocketSession().sendMessage(returnMessage);
		// if(message instanceof TextMessage){
		// TextMessage receiveMessage = (TextMessage)message;
		// System.out.println(receiveMessage.getPayload());
		// }
	}

	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
		// TODO Auto-generated method stub

		UserSocketVo userSocketVo = (UserSocketVo) session.getAttributes().get("websocket_username");
		WSSessionLocalCache.remove(session);
		logger.debug(" error:" + exception.getMessage());
		try {
			if (session.isOpen() && !(exception instanceof IOException)) {
				session.close();
			}
		} catch (Exception e) {
			logger.debug(e.getMessage());
		}
		logger.debug("websocket connection closed......");

	}

	@Override
	public boolean supportsPartialMessages() {
		// TODO Auto-generated method stub
		return false;
	}

}
