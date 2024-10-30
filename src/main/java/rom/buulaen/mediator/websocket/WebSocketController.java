package rom.buulaen.mediator.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class WebSocketController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Map<String, String> processMessage(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Received message: " + message + " - Processed!");
        return response;}


    }
