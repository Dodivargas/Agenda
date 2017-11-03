package controle;

import bancoDados.AtividadeDAO;
import controle.AtividadesControle;
import exceptions.AtividadeNaoEncontradaException;
import modelo.Atividade;
import modelo.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class AtividadeControleTest {
    AtividadeDAO daoFalso = mock(AtividadeDAO.class);

    AtividadesControle atividadesControle = new AtividadesControle(daoFalso);

    @Test
    public void criaAtividade() throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        Atividade atividade = new Atividade();
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");

        when(daoFalso.criaAtividade(atividade, pessoa)).thenReturn(true);

        assertEquals(atividadesControle.criaAtividade(pessoa, atividade), true);
    }

    @Test
    public void mostraTodasAtividades() throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        Atividade atividade = new Atividade();
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");
        List<Atividade> atividades = new ArrayList<>();
        atividades.add(atividade);
        atividades.add(atividade);
        pessoa.setAtividades(atividades);

        when(daoFalso.listaAtividades(pessoa)).thenReturn(atividades);

        Assert.assertEquals(atividadesControle.mostraTodasAtividades(pessoa),atividades);
    }

    @Test
    public void buscaAtividade() throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        Atividade atividade = new Atividade();
        atividade.setId(1);
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");

        when(daoFalso.selecionaAtividade("15:00",pessoa)).thenReturn(1);
        when(daoFalso.buscaAtividadeIndividualmente(1)).thenReturn(atividade);

        Assert.assertEquals(atividadesControle.buscaAtividade(pessoa,"15:00"),atividade);
    }



}