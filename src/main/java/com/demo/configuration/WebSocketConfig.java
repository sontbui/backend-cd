package com.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.demo.controllers.ChatHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	  private final ChatHandler chatHandler;

	    public WebSocketConfig(ChatHandler chatHandler) {
	        this.chatHandler = chatHandler;
	    }

	    @Override
	    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
	        registry.addHandler(chatHandler, "/ws-chat").setAllowedOrigins("*");
	    }
}
