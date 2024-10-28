package rom.buulaen.mediator.counter;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mediator-api")
@AllArgsConstructor
public class ApiController {
    private HitCounterService hitCounterService;

    @GetMapping("/hit-counter")
    public ResponseEntity<String> getHitCounter() {
        return new ResponseEntity<>(hitCounterService.countHit(), HttpStatus.OK);
    }
}
