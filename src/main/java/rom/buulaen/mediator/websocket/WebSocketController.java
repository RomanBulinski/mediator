package rom.buulaen.mediator.websocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebSocketController {

    @MessageMapping("/message")
    @SendTo("/topic/messages")
    public String processMessage(String message) {
        return message;
    }

}
