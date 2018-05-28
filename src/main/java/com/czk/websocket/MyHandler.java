package com.czk.websocket;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import com.czk.service.impl.MyWorkConfig;
import com.czk.utils.UserUtils;

public class MyHandler extends TextWebSocketHandler {
	@Autowired
	MyWorkConfig myWorkConfig;
	private WebSocketSession session;
	private static HashMap<Long, WebSocketSession> webSocketSet = new HashMap<Long, WebSocketSession>();
	 @Override
	    public void handleTextMessage(WebSocketSession session, TextMessage message) {
		 
	        System.out.println(message);
	    }
	 
	 public void afterConnectionEstablished(WebSocketSession session){
		 this.session = session;
		/* Long userID = UserUtils.getLoginUser().getUserId();
		 webSocketSet.put(userID, session);*/
		 try {
			 
		
			session.sendMessage(new TextMessage(myWorkConfig.getUploadPath()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 } 
	 
	 
	 
	 public void sendMessage(String message) throws IOException {
		 /*Long userID = UserUtils.getLoginUser().getUserId();
		 WebSocketSession session = webSocketSet.get(userID);*/
		 if(session!=null){
			session.sendMessage(new TextMessage(message));
		 }
	       
	    }
}
