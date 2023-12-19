package SIS.example.Simple.Inventory.System.controllers.attachmentsControllers;

import SIS.example.Simple.Inventory.System.commons.constants.URLs.IWorkerEndPoints;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.WorkerDTO;
import SIS.example.Simple.Inventory.System.controllers.IWorkerController;
import SIS.example.Simple.Inventory.System.services.attachmentsServices.WorkerAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(IWorkerEndPoints.URL_BASE_WORKER)
public class WorkerAttachmentController implements IWorkerController {

    private final WorkerAttachmentService workerAttachmentService;

    @Autowired
    public WorkerAttachmentController(WorkerAttachmentService workerAttachmentService){
        this.workerAttachmentService = workerAttachmentService;
    }

    @Override
    @PostMapping(IWorkerEndPoints.URL_REGISTER_WORKER)
    public ResponseEntity<SerializedResponse> registerWorker(@RequestBody WorkerDTO workerDTO) {
        return this.workerAttachmentService.registerWorker(workerDTO);
    }

    @Override
    @GetMapping(IWorkerEndPoints.URL_READ_A_WORKER)
    public ResponseEntity<SerializedResponse> readWorker(@PathVariable Long workerId) {
        return this.workerAttachmentService.readWorker(workerId);
    }

    @Override
    @GetMapping(IWorkerEndPoints.URL_READ_ALL)
    public ResponseEntity<SerializedResponse> readAllWorkers() {
        return this.workerAttachmentService.readAllWorkers();
    }

    @Override
    @GetMapping(IWorkerEndPoints.URL_READ_ALL_PRODUCTS_BY_WORKER)
    public ResponseEntity<SerializedResponse> getAllProductsRegisteredByWorker(@PathVariable Long workerId) {
        return this.workerAttachmentService.getAllProductsRegisteredByWorker(workerId);
    }

    @Override
    @PutMapping(IWorkerEndPoints.URL_UPDATE_WORKER)
    public ResponseEntity<SerializedResponse> updateWorker(@RequestBody WorkerDTO workerDTO) {
        return this.workerAttachmentService.updateWorker(workerDTO);
    }

    @Override
    @DeleteMapping(IWorkerEndPoints.URL_DELETE_WORKER)
    public ResponseEntity<SerializedResponse> deleteWorker(@PathVariable Long workerId) {
        return this.workerAttachmentService.deleteWorker(workerId);
    }
}