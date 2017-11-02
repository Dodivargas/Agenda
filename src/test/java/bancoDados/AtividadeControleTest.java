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

        assertEquals(atividadesControle.criaAtividade(pessoa, atividade),true );
    }
}
