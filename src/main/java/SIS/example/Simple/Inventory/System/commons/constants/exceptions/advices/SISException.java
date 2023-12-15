package SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.SimpleInventorySystemGeneralException;
import SIS.example.Simple.Inventory.System.commons.constants.exceptions.SimpleInventorySystemMappingException;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SISException {
    @ExceptionHandler(SimpleInventorySystemGeneralException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<SerializedResponse> SimpleInventorySystemGeneralException(SimpleInventorySystemGeneralException simpleInventorySystemGeneralException){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(SerializedResponse.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .object(null)
                .build());
    }

    @ExceptionHandler(SimpleInventorySystemMappingException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<SerializedResponse> SISMappingException(SimpleInventorySystemMappingException simpleInventorySystemMappingException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(SerializedResponse.builder()
                .object(null)
                .httpStatus(HttpStatus.CONFLICT)
                .build());
    }
}