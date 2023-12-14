package SIS.example.Simple.Inventory.System.commons.domains.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDTO implements Serializable {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String password;
}