package rom.buulaen.mediator.db_connector.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "connection_counter")
public class ConnectionCounter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;
    private String hitType;

}
