package com.selfProject.get_it_offline.config;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Handle incoming message and broadcast it to the relevant chat room
        // For example, you could parse the message and send it to other connected clients
    }
}
