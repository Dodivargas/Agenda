package controle;


import bancoDados.PessoaDAO;
import modelo.Pessoa;
import org.junit.Assert;
import org.junit.Test;
import java.sql.*;
import static org.mockito.Mockito.*;


public class PessoaControleTest {

    PessoaDAO daoFalso = mock(PessoaDAO.class);
    PessoaControle pessoaControle = new PessoaControle(daoFalso);


    @Test
    public void criaUsuario() throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setNome("pele");
        pessoa.setSenha("123");


        when(daoFalso.registraPessoa(pessoa)).thenReturn(pessoa);
        PessoaControle pessoaControle = new PessoaControle(daoFalso);


        Assert.assertEquals(pessoaControle.criaUsuario(pessoa),pessoa);

    }
}
