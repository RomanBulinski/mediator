package rom.buulaen.mediator.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@EnableScheduling
@RestController
public class WebSocketController {

    int counter = 0;
    private SimpMessagingTemplate messagingTemplate;

    public WebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

//    @Scheduled(fixedRate = 5000)
//    public void sendPeriodicUpdates() {
//        Map<String, String> response = new HashMap<>();
//        response.put("content", STR."Scheduled update: \{counter++}");
//        response.put("timestamp", String.valueOf(System.currentTimeMillis()));
//        // Send the updated message to all subscribers of /topic/messages
//        System.out.println(counter);
//        messagingTemplate.convertAndSend("/topic/messages", response);
//    }

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public Map<String, String> processMessage(String message) {
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        response.put("message", "Received message: " + message + counter++);
        return response;
    }

}
