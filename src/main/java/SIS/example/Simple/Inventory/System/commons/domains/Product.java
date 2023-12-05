package SIS.example.Simple.Inventory.System.commons.domains;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "register_date")
    private LocalDate registerDate;

    @ManyToOne
    private Category category;
}