package database;

import controle.AtividadesControle;
import modelo.Atividade;
import modelo.Pessoa;
import org.junit.Test;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class AtividadeDAOTest {


    @Test
    public void configura() throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);

        Atividade atividade = new Atividade();
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");

        AtividadeDAO daoFalso = mock(AtividadeDAO.class);
        when(daoFalso.criaAtividade(atividade, pessoa)).thenReturn(true);

        assertTrue(daoFalso.criaAtividade(atividade, pessoa));
    }
    @Test
    public void retornaAtividades() throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);

        Atividade atividade = new Atividade();
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");

        List<Atividade> atividades = Arrays.asList(atividade);
        pessoa.setAtividades(atividades);

        AtividadeDAO daoFalso = mock(AtividadeDAO.class);
        when(daoFalso.listaAtividades(pessoa)).thenReturn(atividades);

        AtividadesControle atividadesControle = new AtividadesControle(daoFalso);

//        atividadesControle.buscaAtividade(pessoa);

        assertEquals(atividades, pessoa.getAtividades());
    }
}