package testaExcepitions;

import bancoDados.PessoaDAO;
import controle.PessoaControle;
import exceptions.UsuarioJaExistenteException;
import modelo.Pessoa;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UsuarioJaCadastradoException {
    PessoaDAO daoFalsoPessoa = mock(PessoaDAO.class);


    @Test
    public void testaUsuarioNaoEncontradoException() throws SQLException {
        PessoaControle pessoaControle = new PessoaControle(daoFalsoPessoa);
        Pessoa pessoa = new Pessoa();
        pessoa.setId(61);
        when(daoFalsoPessoa.verificaPessoa(pessoa.getNome(),pessoa.getSenha())).thenThrow(UsuarioJaExistenteException.class);
        try {
            pessoaControle.verificaUsuario(pessoa);
        }catch (UsuarioJaExistenteException e){
            assertTrue(true);
        }
    }
}
