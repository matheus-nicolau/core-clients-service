package github.matheus_nicolau.core_clients.exceptions;

public class ClientNotFindException extends RuntimeException{
    public ClientNotFindException(String message) {
        super(message);
    }
}
