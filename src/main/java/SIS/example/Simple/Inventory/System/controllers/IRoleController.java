package SIS.example.Simple.Inventory.System.controllers;

import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.RoleDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IRoleController {

    @PostMapping
    ResponseEntity<SerializedResponse> registerRole(@RequestBody RoleDTO roleDTO);
    @GetMapping
    ResponseEntity<SerializedResponse> readRoleById(@PathVariable Long roleId);
    @GetMapping
    ResponseEntity<SerializedResponse> readAll();
    @GetMapping
    ResponseEntity<SerializedResponse> getAllWorkersByRole(@PathVariable Long roleId);
    @PutMapping
    ResponseEntity<SerializedResponse> updateRole(@RequestBody RoleDTO roleDTO);
    @DeleteMapping
    ResponseEntity<SerializedResponse> deleteRole(@PathVariable Long roleId);
}