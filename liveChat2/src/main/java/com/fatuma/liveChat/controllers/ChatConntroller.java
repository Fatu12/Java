package com.fatuma.liveChat.controllers;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fatuma.liveChat.models.ChatMessage;


@Controller
public class ChatConntroller {

	@MessageMapping("/chat.register")
	@SendTo("/topic/public")
	// add new user when a new user connects to our chat application so we need to add and hit that endpoint and inform all the 
	// users that we have a new has joined a chat 
	public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
		// add username in web socket session
		headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
		return chatMessage;
	}
	// dispatch the message tgat would be send by any user 
	@MessageMapping("/chat.send")
	@SendTo("/topic/public")
	// The WebSocket. send() method enqueues the specified data to be transmitted to the server over the WebSocket connection, 
	//increasing the value of bufferedAmount by the number of bytes needed to contain the data
	public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
		return chatMessage;
	}

}