package SIS.example.Simple.Inventory.System.commons.domains.DTO;

import SIS.example.Simple.Inventory.System.commons.domains.entities.Worker;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDTO implements Serializable {
    private Long id;
    private String name;

}