package bancoDados;


import modelo.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PessoaDAOTest {
    PessoaDAO daoFalso = mock(PessoaDAO.class);

    @Test
    public void registraPessoa() throws SQLException {
        Pessoa pessoa = new Pessoa();
        when(daoFalso.registraPessoa(pessoa)).thenReturn(pessoa);

        assertEquals(daoFalso.registraPessoa(pessoa),pessoa);
    }
    @Test
    public void buscaPessoa(){
        Pessoa pessoa = new Pessoa();
        when(daoFalso.buscaPessoa(pessoa.getNome())).thenReturn(pessoa);
        Assert.assertEquals(daoFalso.buscaPessoa(pessoa.getNome()),pessoa);
    }
    @Test
    public void verificaPessoa(){
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        when(daoFalso.verificaPessoa(pessoa.getNome(),pessoa.getSenha())).thenReturn(pessoa.getId());
        Assert.assertEquals(pessoa.getId(),daoFalso.verificaPessoa(pessoa.getNome(),pessoa.getSenha()));

    }
}
