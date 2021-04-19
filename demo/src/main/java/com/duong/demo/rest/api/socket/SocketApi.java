package com.duong.demo.rest.api.socket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@RestController
public class SocketApi {
    @MessageMapping("/get-file")
    @SendTo("/client/subscribe")
    public String getFile(String message) throws Exception {
        return ("Hello" + message);
    }
}
