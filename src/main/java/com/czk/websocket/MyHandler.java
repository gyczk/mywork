package com.czk.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.czk.service.impl.MyWorkConfig;
import com.czk.utils.UserUtils;

public class MyHandler extends TextWebSocketHandler {
	@Autowired
	MyWorkConfig myWorkConfig;
//	private WebSocketSession session;
	private static HashMap<Long, WebSocketSession> webSocketSet = new HashMap<Long, WebSocketSession>();

	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {

		System.out.println(message);
	}

	public void afterConnectionEstablished(WebSocketSession session) {
		Map<String, Object> map = session.getAttributes();
		long userID = (long) map.get("userID");
		webSocketSet.put(userID, session);
		try {
			session.sendMessage(new TextMessage(myWorkConfig.getUploadPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void sendMessage(String message) throws IOException {
		Long userID = UserUtils.getLoginUser().getUserId();
		WebSocketSession ws = webSocketSet.get(userID);
		if (ws != null) {
			ws.sendMessage(new TextMessage(message));
		}

	}
	
	
	public void sendMessageTOAllUsers(String message) throws IOException {
		for(Map.Entry<Long,WebSocketSession> temp : webSocketSet.entrySet()){
			WebSocketSession ws = temp.getValue();
			System.out.println(temp.getKey()+"---"+temp.getValue());
			if (ws != null) {
				ws.sendMessage(new TextMessage(message));
			}
		}
		

	}
}
