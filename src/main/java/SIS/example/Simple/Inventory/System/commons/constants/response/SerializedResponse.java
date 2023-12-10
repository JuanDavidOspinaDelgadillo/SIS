package SIS.example.Simple.Inventory.System.commons.constants.response;

import lombok.Builder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Builder
public class SerializedResponse implements Serializable {
    public Object object;
    public HttpStatus httpStatus;
}
