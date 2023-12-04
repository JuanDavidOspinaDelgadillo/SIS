package SIS.example.Simple.Inventory.System.commons.domains;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "worker")
@Data
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;


}
