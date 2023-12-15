package SIS.example.Simple.Inventory.System.commons.mapper.mappedEntities;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.SimpleInventorySystemMappingException;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.RoleDTO;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Role;
import SIS.example.Simple.Inventory.System.commons.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class RoleMapper {
    public Role mapRoleDTOToRoleEntity(RoleDTO roleDTO){
        Role role = new Role();
        try {
            role = Mapper.modelMapper().map(roleDTO, Role.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SimpleInventorySystemMappingException(GeneralResponses.CONFLICT_RESPONSE);
        }
        return role;
    }
}