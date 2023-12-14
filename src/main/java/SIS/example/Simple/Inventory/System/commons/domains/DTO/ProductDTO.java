package SIS.example.Simple.Inventory.System.commons.domains.DTO;

import SIS.example.Simple.Inventory.System.commons.domains.entities.Category;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO implements Serializable {
    private Long id;
    private String product;
    private LocalDate registerDate;
    private Long categoryId;
    private Long workerId;
}
