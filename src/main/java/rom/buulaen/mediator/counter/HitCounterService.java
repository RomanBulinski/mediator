package rom.buulaen.mediator.counter;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.buulaen.mediator.db_connector.ConnectionCounterRepository;
import rom.buulaen.mediator.db_connector.model.ConnectionCounter;

@Service
@AllArgsConstructor
public class HitCounterService {

    private final ConnectionCounterRepository connectionCounterRepository;

    String countHit() {
        ConnectionCounter connectionCounter = new ConnectionCounter();
        connectionCounter.setDescription("uderzenie z aplikcaji Baza");
        connectionCounter.setHitType("Z bazy");
        return connectionCounterRepository.save(connectionCounter).toString();
    }
}
