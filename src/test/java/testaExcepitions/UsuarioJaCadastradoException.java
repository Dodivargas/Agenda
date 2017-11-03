package testaExcepitions;

import bancoDados.PessoaDAO;
import controle.PessoaControle;
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
        when(daoFalsoPessoa.verificaPessoa(pessoa.getNome(),pessoa.getSenha())).thenThrow(exceptions.UsuarioJáExistenteException.class);
        try {
            pessoaControle.verificaUsuario(pessoa);
        }catch (exceptions.UsuarioJáExistenteException e){
            assertTrue(true);
        }
    }
}
