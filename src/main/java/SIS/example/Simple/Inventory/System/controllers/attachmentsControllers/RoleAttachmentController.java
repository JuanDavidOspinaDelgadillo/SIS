package SIS.example.Simple.Inventory.System.controllers.attachmentsControllers;

import SIS.example.Simple.Inventory.System.commons.constants.URLs.IRoleEndPoints;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.RoleDTO;
import SIS.example.Simple.Inventory.System.controllers.IRoleController;
import SIS.example.Simple.Inventory.System.services.attachmentsServices.RoleAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IRoleEndPoints.URL_BASE_ROLE)
public class RoleAttachmentController implements IRoleController {

    private final RoleAttachmentService roleAttachmentService;

    @Autowired
    public RoleAttachmentController(RoleAttachmentService roleAttachmentService){
        this.roleAttachmentService = roleAttachmentService;
    }

    @Override
    @PostMapping(IRoleEndPoints.URL_REGISTER_ROLE)
    public ResponseEntity<SerializedResponse> registerRole(@RequestBody RoleDTO roleDTO) {
        return this.roleAttachmentService.registerRole(roleDTO);
    }

    @Override
    @GetMapping(IRoleEndPoints.URL_READ_A_ROLE)
    public ResponseEntity<SerializedResponse> readRoleById(@PathVariable Long roleId) {
        return this.roleAttachmentService.readRoleById(roleId);
    }

    @Override
    @GetMapping(IRoleEndPoints.URL_READ_ALL)
    public ResponseEntity<SerializedResponse> readAll() {
        return this.roleAttachmentService.readAll();
    }

    @Override
    @GetMapping(IRoleEndPoints.URL_READ_ALL_WORKERS_BY_ROLE)
    public ResponseEntity<SerializedResponse> getAllWorkersByRole(@PathVariable Long roleId) {
        return this.roleAttachmentService.getAllWorkersByRole(roleId);
    }

    @Override
    @PutMapping(IRoleEndPoints.URL_UPDATE_ROLE)
    public ResponseEntity<SerializedResponse> updateRole(@RequestBody RoleDTO roleDTO) {
        return this.roleAttachmentService.updateRole(roleDTO);
    }

    @Override
    @DeleteMapping(IRoleEndPoints.URL_DELETE_ROLE)
    public ResponseEntity<SerializedResponse> deleteRole(@PathVariable Long roleId) {
        return this.roleAttachmentService.deleteRole(roleId);
    }
}