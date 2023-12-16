package SIS.example.Simple.Inventory.System.services;

import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.RoleDTO;
import org.springframework.http.ResponseEntity;

public interface IRoleService {
    ResponseEntity<SerializedResponse> registerRole(RoleDTO roleDTO);
    ResponseEntity<SerializedResponse> readRoleById(Long roleId);
    ResponseEntity<SerializedResponse> readAll();
    ResponseEntity<SerializedResponse> getAllWorkersByRole(Long roleId);
    ResponseEntity<SerializedResponse> updateRole(RoleDTO roleDTO);
    ResponseEntity<SerializedResponse> deleteRole(Long roleId);
}