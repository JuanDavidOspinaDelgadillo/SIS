package SIS.example.Simple.Inventory.System.commons.constants.exceptions;

import SIS.example.Simple.Inventory.System.commons.constants.exceptions.advices.*;
import SIS.example.Simple.Inventory.System.commons.constants.response.SerializedResponse;
import SIS.example.Simple.Inventory.System.commons.constants.response.generalResponses.GeneralResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class SISException {

    @ExceptionHandler(SISAccessForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public ResponseEntity<SerializedResponse> SISAccessForbiddenException(SISAccessForbiddenException sisAccessForbiddenException){
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(SerializedResponse.builder()
                .httpStatus(HttpStatus.FORBIDDEN)
                .object(GeneralResponses.ACCESS_FORBIDDEN_RESPONSE)
                .build());
    }

    @ExceptionHandler(SISBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<SerializedResponse> SISBadRequestException(SISBadRequestException sisBadRequestException){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(SerializedResponse.builder()
                .httpStatus(HttpStatus.BAD_REQUEST)
                .object(GeneralResponses.BAD_REQUEST_RESPONSE)
                .build());
    }

    @ExceptionHandler(SISInternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<SerializedResponse> SISInternalServerErrorException(SISInternalServerErrorException sisInternalServerErrorException){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(SerializedResponse.builder()
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .object(GeneralResponses.INTERNAL_SERVER_ERROR_RESPONSE)
                .build());
    }

    @ExceptionHandler(SISMappingException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<SerializedResponse> SISMappingException(SISMappingException simpleInventorySystemMappingException){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(SerializedResponse.builder()
                .object(GeneralResponses.CONFLICT_RESPONSE)
                .httpStatus(HttpStatus.CONFLICT)
                .build());
    }

    @ExceptionHandler(SISUrlNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<SerializedResponse> SISUrlNotFound(SISUrlNotFoundException sisUrlNotFoundException){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(SerializedResponse.builder()
                .httpStatus(HttpStatus.NOT_FOUND)
                .object(GeneralResponses.URL_NOT_FOUND)
                .build());
    }

    @ExceptionHandler(SISWrongMethodException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity<SerializedResponse> SISWrongMethodException(SISWrongMethodException sisWrongMethodException){
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(SerializedResponse.builder()
                .httpStatus(HttpStatus.METHOD_NOT_ALLOWED)
                .object(GeneralResponses.WRONG_METHOD_RESPONSE)
                .build());
    }

}