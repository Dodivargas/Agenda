package exceptions;

public class UsuarioJaExistenteException extends IllegalStateException {

    public UsuarioJaExistenteException(Exception e) {
        super(e);
    }
}
