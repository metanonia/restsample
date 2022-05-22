package com.metanonia.restsample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SendDataService {
    @Autowired
    WebSocketHandler webSocketHandler;

    @Scheduled(fixedRate = 5000) // 5000ms = 5sec
    public void sendData() {
        webSocketHandler.sendAll("This is Test");
    }
}
