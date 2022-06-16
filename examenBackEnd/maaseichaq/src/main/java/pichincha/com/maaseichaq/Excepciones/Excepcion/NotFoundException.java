package pichincha.com.maaseichaq.Excepciones.Excepcion;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
    }

    public NotFoundException(String message) {
        super(message);
    }
}
