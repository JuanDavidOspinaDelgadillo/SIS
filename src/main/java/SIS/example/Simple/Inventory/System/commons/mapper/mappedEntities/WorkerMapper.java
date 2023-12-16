package SIS.example.Simple.Inventory.System.commons.mapper.mappedEntities;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.SISMappingException;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import SIS.example.Simple.Inventory.System.commons.domains.DTO.WorkerDTO;
import SIS.example.Simple.Inventory.System.commons.domains.entities.Worker;
import SIS.example.Simple.Inventory.System.commons.mapper.Mapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class WorkerMapper {
    public Worker mapWorkerDTOToWorkerEntity(WorkerDTO workerDTO){
        Worker worker = new Worker();
        try {
            worker = Mapper.modelMapper().map(workerDTO, Worker.class);
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new SISMappingException();
        }
        return worker;
    }
}
