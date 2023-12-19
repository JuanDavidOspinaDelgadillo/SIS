package SIS.example.Simple.Inventory.System.controllers;

import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.WorkerDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface IWorkerController {

    @PostMapping
    ResponseEntity<SerializedResponse> registerWorker(@RequestBody WorkerDTO workerDTO);
    @GetMapping
    ResponseEntity<SerializedResponse> readWorker(@PathVariable Long workerId);
    @GetMapping
    ResponseEntity<SerializedResponse> readAllWorkers();
    @GetMapping
    ResponseEntity<SerializedResponse> getAllProductsRegisteredByWorker(@PathVariable Long workerId);
    @PutMapping
    ResponseEntity<SerializedResponse> updateWorker(@RequestBody WorkerDTO workerDTO);
    @DeleteMapping
    ResponseEntity<SerializedResponse> deleteWorker(@PathVariable Long workerId);
}