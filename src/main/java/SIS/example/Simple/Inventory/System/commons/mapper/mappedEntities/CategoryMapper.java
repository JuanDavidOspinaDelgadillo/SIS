package SIS.example.Simple.Inventory.System.commons.mapper.mappedEntities;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.SimpleInventorySystemMappingException;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.CategoryDTO;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Category;
import SIS.example.Simple.Inventory.System.commons.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class CategoryMapper {
    public Category mapCategoryDTOToCategoryEntity(CategoryDTO categoryDTO) {
        Category category = new Category();
        try {
            category = Mapper.modelMapper().map(categoryDTO, Category.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SimpleInventorySystemMappingException(GeneralResponses.CONFLICT_RESPONSE);
        }
        return category;
    }
}