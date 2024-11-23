package rom.buulaen.mediator.db_connector;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rom.buulaen.mediator.db_connector.model.ConnectionCounter;

@Repository
public interface ConnectionCounterRepository extends JpaRepository<ConnectionCounter, Long> {


}
