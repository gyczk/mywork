package com.czk.websocket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyHandler extends TextWebSocketHandler {
	private static ConcurrentHashMap<String, MyHandler> webSocketSet = new ConcurrentHashMap<String, MyHandler>();
	private WebSocketSession session;
	 @Override
	    public void handleTextMessage(WebSocketSession session, TextMessage message) {
		 this.session = session;
		 webSocketSet.put("mysocket", this);
	        System.out.println(message);
	    }
	 
	 public void afterConnectionEstablished(WebSocketSession session){
		 try {
			 
		
			session.sendMessage(new TextMessage("nimabi"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 } 
	 
	 
	 
	 public void sendMessage(String message) throws IOException {
		 if(session!=null){
			 this.session.sendMessage(new TextMessage(message));
		 }
	       
	    }
}
