package rom.buulaen.mediator.counter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/mediator-api")
@AllArgsConstructor
public class HitController {
    private HitCounterService hitCounterService;
    private SimpMessagingTemplate messagingTemplate;

    @GetMapping("/hit-counter")
    public ResponseEntity<String> getHitCounter() {
        Map<String, String> response = new HashMap<>();
        response.put("content", "strzał z Bazy");
        response.put("timestamp", String.valueOf(System.currentTimeMillis()));

        messagingTemplate.convertAndSend("/topic/messages", response);

        String result = hitCounterService.countHit();

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
