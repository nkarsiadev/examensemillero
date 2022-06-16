package pichincha.com.maaseichaq.Excepciones.Excepcion;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
    }

    public BadRequestException(String message) {
        super(message);
    }
}
