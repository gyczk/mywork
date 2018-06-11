package com.czk.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.czk.service.impl.MyWorkConfig;
import com.czk.utils.UserUtils;

public class MyHandler extends TextWebSocketHandler {
	@Autowired
	MyWorkConfig myWorkConfig;
//	private WebSocketSession session;
	private static ConcurrentHashMap<Long, WebSocketSession> webSocketSet = new ConcurrentHashMap<Long, WebSocketSession>();
	
	public ConcurrentHashMap<Long, WebSocketSession> getWebSocketSet(){
		return  webSocketSet;
	}
	@Override
	public void handleTextMessage(WebSocketSession session, TextMessage message) {
		if(session!=null&&session.isOpen()){
			System.out.println(message);
		}
		
	}

	public void afterConnectionEstablished(WebSocketSession session) {
		if(session!=null){
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
		
	}

	public void sendMessage(String message) throws IOException {
		Long userID = UserUtils.getLoginUser().getUserId();
		WebSocketSession ws = webSocketSet.get(userID);
		if (ws != null&&ws.isOpen()) {
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
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		webSocketSet.remove(getUserId(session));
		// TODO Auto-generated method stub
//		session.sendMessage(new TextMessage("连接关闭"));
		/*webSocketSet.get(UserUtils.getLoginUser().getUserId()).close();
		webSocketSet.remove(UserUtils.getLoginUser().getUserId());*/
//		session.close();
	}
	
	@Override
	public void handleTransportError(WebSocketSession session, Throwable exception)   {
		 if (session.isOpen()) {
	            try {
					session.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	     webSocketSet.remove(getUserId(session));
	}
	
	private Long getUserId(WebSocketSession session) {
        try {
            Long clientId = (Long) session.getAttributes().get("userID");
            return clientId;
        } catch (Exception e) {
            return null;
        }
    }
	
}
