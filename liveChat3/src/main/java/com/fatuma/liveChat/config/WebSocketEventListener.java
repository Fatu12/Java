package com.fatuma.liveChat.config;

//import org.springframework.stereotype.Component;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.event.EventListener;
//import org.springframework.messaging.simp.SimpMessageSendingOperations;
//import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
//import org.springframework.web.socket.messaging.SessionConnectedEvent;
//import org.springframework.web.socket.messaging.SessionDisconnectEvent;
//
//import com.fatuma.liveChat.models.ChatMessage;
//
//
////Define the WebSocker Listener class. This class listens to events such as a new user joining the chat or an user l
////eaving the chat
//@Component
//public class WebSocketEventListener {
//
//    @Autowired
//    private SimpMessageSendingOperations messagingTemplate;
//
//    @EventListener
//    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
//        System.out.println("Received a new web socket connection");
//    }
//
//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//    	// wrap the event get message
//
//    	StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//       if(username != null) {
//
//           ChatMessage chatMessage = new ChatMessage();
//           
//            chatMessage.setType("Leave");
//            
//          chatMessage.setSender(username);
//
//           messagingTemplate.convertAndSend("/topic/public", chatMessage);
//       }
//    }
//}
//

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.fatuma.liveChat.models.ChatMessage;

@Component
public class WebSocketEventListener {
	// we need to infrom the others or like all the user of my application that a specific user has left the chat 

    private static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);

    @Autowired
    private SimpMessageSendingOperations messagingTemplate;

    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        logger.info("Received a new web socket connection");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
            logger.info("User Disconnected : " + username);

            ChatMessage chatMessage = new ChatMessage();
            chatMessage.setType(ChatMessage.MessageType.LEAVE);
            chatMessage.setSender(username);
            // where everyone or every user of my chat application will be listenig on 
            // where we need to send our chat message 

            messagingTemplate.convertAndSend("/topic/public", chatMessage);
        }
    }
}

