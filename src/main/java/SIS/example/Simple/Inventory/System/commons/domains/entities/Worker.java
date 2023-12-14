package SIS.example.Simple.Inventory.System.commons.domains.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder(builderMethodName = "BuilderInstance")
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "worker")
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "worker_id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private Role role;

    @JsonIgnore
    @JsonManagedReference
    @OneToMany(mappedBy = "worker", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Product> products;
}