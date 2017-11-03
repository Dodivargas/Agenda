package controle;

import bancoDados.AtividadeDAO;
import bancoDados.PessoaDAO;
import controle.AtividadesControle;
import exceptions.AtividadeNaoEncontradaException;
import modelo.Atividade;
import modelo.Pessoa;
import org.junit.Assert;
import org.junit.Test;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

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
