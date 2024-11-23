package rom.buulaen.mediator.db_connector;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import rom.buulaen.mediator.db_connector.model.ConnectionCounter;

import java.util.List;

@Service
@AllArgsConstructor
public class DbService {
    private final ConnectionCounterRepository connectionCounterRepository;

    public List<ConnectionCounter> getAllConnections() {
        return connectionCounterRepository.findAll();
    }

    public ConnectionCounter saveConnectionEvent() {
        ConnectionCounter connectionCounter = new ConnectionCounter();
        connectionCounter.setDescription("uderzenie z aplikcaji Baza");
        connectionCounter.setHitType("Z bazy");
        return connectionCounterRepository.save(connectionCounter);
    }
}
