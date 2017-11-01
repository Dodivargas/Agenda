package exceptions;

public class AtividadeNaoEncontradaException extends IllegalStateException {

    public AtividadeNaoEncontradaException(Exception e) {
        super(e);
    }

}
