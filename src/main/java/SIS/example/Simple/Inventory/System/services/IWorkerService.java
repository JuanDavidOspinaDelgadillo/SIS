package SIS.example.Simple.Inventory.System.services;

import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.WorkerDTO;
import org.springframework.http.ResponseEntity;

public interface IWorkerService {
    ResponseEntity<SerializedResponse> registerWorker(WorkerDTO workerDTO);
    ResponseEntity<SerializedResponse> readWorker(Long workerId);
    ResponseEntity<SerializedResponse> readAllWorkers();
    ResponseEntity<SerializedResponse> getAllProductsRegisteredByWorker(Long workerId);
    ResponseEntity<SerializedResponse> updateWorker(WorkerDTO workerDTO);
    ResponseEntity<SerializedResponse> deleteWorker(Long workerId);
}