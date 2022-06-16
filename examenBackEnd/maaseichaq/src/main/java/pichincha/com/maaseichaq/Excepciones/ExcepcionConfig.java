package pichincha.com.maaseichaq.Excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import pichincha.com.maaseichaq.Excepciones.Excepcion.BadRequestException;
import pichincha.com.maaseichaq.Excepciones.Excepcion.NotFoundException;

@ControllerAdvice(annotations = RestController.class)
public class ExcepcionConfig {
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<?> notFoundException(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> badRequestException(Exception e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
