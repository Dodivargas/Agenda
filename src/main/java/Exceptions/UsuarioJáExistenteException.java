package Exceptions;

public class UsuarioJáExistenteException extends IllegalStateException {

    public UsuarioJáExistenteException(Exception e) {
        super(e);
    }
}
