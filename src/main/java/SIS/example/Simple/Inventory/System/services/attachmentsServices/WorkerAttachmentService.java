package SIS.example.Simple.Inventory.System.services.attachmentsServices;

import SIS.example.Simple.Inventory.System.commons.constants.encryption.EncryptionService;
import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISBadRequestException;
import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISInternalServerErrorException;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.WorkerDTO;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Product;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Worker;
import SIS.example.Simple.Inventory.System.commons.mapper.mappedEntities.WorkerMapper;
import SIS.example.Simple.Inventory.System.repositories.WorkerRepo;
import SIS.example.Simple.Inventory.System.services.IWorkerService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
@Component
@Service
public class WorkerAttachmentService implements IWorkerService {

    private final WorkerRepo workerRepo;
    private final WorkerMapper workerMapper;
    private final EncryptionService encryptionService;

    @Autowired
    public WorkerAttachmentService(WorkerRepo workerRepo, WorkerMapper workerMapper, EncryptionService encryptionService) {
        this.workerMapper = workerMapper;
        this.workerRepo = workerRepo;
        this.encryptionService = encryptionService;
    }

    @Override
    public ResponseEntity<SerializedResponse> registerWorker(WorkerDTO workerDTO) {
        try {
            Optional<Worker> workerExist = this.workerRepo.getWorkerById(workerDTO.getId());
            if (workerExist.isPresent()) {
                Worker worker = this.workerMapper.mapWorkerDTOToWorkerEntity(workerDTO);
                worker.setPassword(this.encryptionService.encrypt(worker.getPassword()));
                this.workerRepo.registerWorker(worker);
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
    public ResponseEntity<SerializedResponse> readWorker(Long workerId) {
        try {
            Optional<Worker> workerExist = this.workerRepo.getWorkerById(workerId);
            if (workerExist.isPresent()) {
                Worker worker = workerExist.get();
                worker.setPassword(this.encryptionService.decrypt(worker.getPassword()));
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(worker)
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
    public ResponseEntity<SerializedResponse> readAllWorkers() {
        try {
            List<Worker> workerList = this.workerRepo.getAll();
            if (!workerList.isEmpty()) {
                List<Worker> workersWithUnencryptedPasswordsList = new ArrayList<>();
                for (Worker worker : workerList) {
                    worker.setPassword(this.encryptionService.decrypt(worker.getPassword()));
                    workersWithUnencryptedPasswordsList.add(worker);
                }
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(workersWithUnencryptedPasswordsList)
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
    public ResponseEntity<SerializedResponse> getAllProductsRegisteredByWorker(Long workerId) {
        try {
            List<Product> productsList = this.workerRepo.getAllProductsRegisteredByWorkerId(workerId);
            if (!productsList.isEmpty()) {
                return ResponseEntity.status(HttpStatus.OK).body(SerializedResponse.builder()
                        .httpStatus(HttpStatus.OK)
                        .object(productsList)
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
    public ResponseEntity<SerializedResponse> updateWorker(WorkerDTO workerDTO) {
        try {
            Optional<Worker> workerExist = this.workerRepo.getWorkerById(workerDTO.getId());
            if (workerExist.isPresent()) {
                Worker worker = this.workerMapper.mapWorkerDTOToWorkerEntity(workerDTO);
                this.workerRepo.updateWorker(worker);
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
    public ResponseEntity<SerializedResponse> deleteWorker(Long workerId) {
        try {
            Optional<Worker> workerExist = this.workerRepo.getWorkerById(workerId);
            if (workerExist.isPresent()) {
                this.workerRepo.deleteWorkerById(workerId);
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