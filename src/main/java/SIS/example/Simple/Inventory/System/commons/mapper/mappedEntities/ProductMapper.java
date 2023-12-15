package SIS.example.Simple.Inventory.System.commons.mapper.mappedEntities;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.SimpleInventorySystemMappingException;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.ProductDTO;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import SIS.example.Simple.Inventory.System.commons.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class ProductMapper {
    public Product mapProductDTOToProductEntity(ProductDTO productDTO){
        Product product = new Product();
        try {
            product = Mapper.modelMapper().map(productDTO, Product.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SimpleInventorySystemMappingException(GeneralResponses.CONFLICT_RESPONSE);
        }
        return product;
    }
}
