package bancoDados;

import controle.AtividadesControle;
import modelo.Atividade;
import modelo.Pessoa;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class AtividadeControleTest {
    AtividadeDAO daoFalso = mock(AtividadeDAO.class);

    @Test
    public void criaAtividade() throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        Atividade atividade = new Atividade();
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");

        when(daoFalso.criaAtividade(atividade,pessoa)).thenReturn(true);

        AtividadesControle atividadesControle = new AtividadesControle(daoFalso);

        assertEquals(true, atividadesControle.criaAtividade(pessoa, atividade));
    }
    @Test
    public void mostraAtividades() throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        Atividade atividade = new Atividade();
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");
        Atividade atividade2 = new Atividade();
        atividade2.setNome("futebol");
        atividade2.setHoraIncio("17:00");
        atividade2.setHoraFim("18:00");
        atividade2.setTipo("esporte");

        List<Atividade> atividades = new ArrayList<>();
        atividades.add(atividade);
        atividades.add(atividade2);


        when(daoFalso.listaAtividades(pessoa)).thenReturn(atividades);

        AtividadesControle atividadesControle = new AtividadesControle(daoFalso);

        atividadesControle.mostraTodasAtividades(pessoa);

        assertEquals(pessoa.getAtividades(),atividades);
    }

}
