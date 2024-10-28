package rom.buulaen.mediator.counter;

import org.springframework.stereotype.Service;

@Service
public class HitCounterService {
    int hitCounter = 0;

    String countHit() {
        return "Odpowiedź nr: " + hitCounter++ + " z mediatora!";
    }
}
