package de.th_bingen.distsystems.microservices.datastorage.adapters.in.websocket;

import de.th_bingen.distsystems.microservices.datastorage.adapters.in.rest.UserDTO;
import de.th_bingen.distsystems.microservices.datastorage.ports.in.websocket.UpdateNotificationPort;
import de.th_bingen.distsystems.microservices.datastorage.services.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class WebSocketAdapter extends TextWebSocketHandler implements UpdateNotificationPort {

    private List<WebSocketSession> sessions = new ArrayList<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println("[WebSocketAdapter] Client connected");
        sessions.add(session);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println("[WebSocketAdapter] Client disconnected");
    }

    public void notify(String message) {
        for (WebSocketSession session : sessions) {
            try {
                session.sendMessage(new TextMessage(message));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
