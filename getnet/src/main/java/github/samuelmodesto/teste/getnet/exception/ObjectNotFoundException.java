package github.samuelmodesto.teste.getnet.exception;

public class ObjectNotFoundException extends RuntimeException{
    public ObjectNotFoundException(String mensagem) {
        super(mensagem);
    }
}
