package com.fatuma.dojoandNinjasAssignment.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WsConfig implements WebSocketMessageBrokerConfigurer{
	//we adding  a new Stop and point to our websocket configuration
	// addEndpoint which is the pathwebsocket 

	@Override
	public void registerStompEndpoints(StompEndpointRegistry registry) {
		registry.addEndpoint("/javatechie").withSockJS();
	}
	
	// this is the point where we want to enable the simple broke or application destination prefixes
	@Override
	public void configureMessageBroker(MessageBrokerRegistry registry) {
		// takes a destination prefixes 
		registry.enableSimpleBroker("/topic");
		registry.setApplicationDestinationPrefixes("/app");
	}
}
