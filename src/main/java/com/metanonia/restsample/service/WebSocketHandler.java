package com.metanonia.restsample.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {
    private static Set<WebSocketSession> sessions = new ConcurrentHashMap().newKeySet();
    JSONArray jsonArray = new JSONArray();

    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        sessions.add(session);
        log.info("client{} connect", session.getRemoteAddress());
    }

    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        log.info("client{} handle message:{}", session.getRemoteAddress(), message.getPayload());
        try {
            WebSocketMessage msg = new TextMessage("Received : " + message.getPayload());
            session.sendMessage(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
        log.info("client{} connect closed reason {}", session.getRemoteAddress(), status.getReason());
    }


    public void sendMessage(String sessionId, TextMessage msg) {
        for (WebSocketSession webSocketSession : sessions) {
            if (sessionId.matches(webSocketSession.getId())) {
                try {
                    webSocketSession.sendMessage(msg);
                    log.info("sendMessage " + sessionId + " " + msg.getPayload());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
