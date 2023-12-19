package SIS.example.Simple.Inventory.System.services.attachmentsServices;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISBadRequestException;
import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISInternalServerErrorException;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.RoleDTO;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Role;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Worker;
import SIS.example.Simple.Inventory.System.commons.mapper.mappedEntities.RoleMapper;
import SIS.example.Simple.Inventory.System.repositories.RoleRepo;
import SIS.example.Simple.Inventory.System.services.IRoleService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Log4j2
@Component
@Service
public class RoleAttachmentService implements IRoleService {

    private final RoleRepo roleRepo;
    private final RoleMapper roleMapper;

    @Autowired
    public RoleAttachmentService(RoleMapper roleMapper, RoleRepo roleRepo) {
        this.roleMapper = roleMapper;
        this.roleRepo = roleRepo;
    }
    @Override
    public ResponseEntity<SerializedResponse> registerRole(RoleDTO roleDTO) {
        try {
            Optional<Role> roleExist = this.roleRepo.getRoleByRoleId(roleDTO.getId());
            if (roleExist.isPresent()) {
                Role role = this.roleMapper.mapRoleDTOToRoleEntity(roleDTO);
                this.roleRepo.registerRole(role);
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(GeneralResponses.CORRECT_RESPONSE)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> readRoleById(Long roleId) {
        try {
            Optional<Role> roleExist = this.roleRepo.getRoleByRoleId(roleId);
            if (roleExist.isPresent()) {
                Role role = roleExist.get();
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(role)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> readAll() {
        try {
            List<Role> roleList = this.roleRepo.getAll();
            if (!roleList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(roleList)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> getAllWorkersByRole(Long roleId) {
        try {
            List<Worker> workerList = this.roleRepo.getAllWorkersByRoleId(roleId);
            if (!workerList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(workerList)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> updateRole(RoleDTO roleDTO) {
        try {
            Optional<Role> roleExist = this.roleRepo.getRoleByRoleId(roleDTO.getId());
            if (roleExist.isPresent()) {
                Role role = this.roleMapper.mapRoleDTOToRoleEntity(roleDTO);
                this.roleRepo.updateRole(role);
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(GeneralResponses.CORRECT_RESPONSE)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }

    @Override
    public ResponseEntity<SerializedResponse> deleteRole(Long roleId) {
        try {
            Optional<Role> roleExist = this.roleRepo.getRoleByRoleId(roleId);
            if (roleExist.isPresent()) {
                this.roleRepo.deleteByRoleId(roleId);
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(GeneralResponses.CORRECT_RESPONSE)
                        .build());
            } else {
                throw new SISBadRequestException();
            }
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISInternalServerErrorException();
        }
    }
}