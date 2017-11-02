package bancoDados;

import modelo.Atividade;
import modelo.Pessoa;
import org.junit.Test;

import java.sql.*;

import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

public class AtividadeDAOTest {
    AtividadeDAO daoFalso = mock(AtividadeDAO.class);
    @Test
    public void criaAtividadeValida() throws SQLException {
        Pessoa pessoa = new Pessoa();
        Atividade atividade = new Atividade();
        when(daoFalso.criaAtividade(atividade,pessoa)).thenReturn(true);

        assertEquals(daoFalso.criaAtividade(atividade,pessoa),true);
    }
    @Test
    public void editarAtividadeValida() throws SQLException {
        Pessoa pessoa = new Pessoa();
        Atividade atividade = new Atividade();
        when(daoFalso.editarAtividade(atividade,atividade.getId())).thenReturn(true);

        assertEquals(daoFalso.editarAtividade(atividade,atividade.getId()),true);
    }
    @Test
    public void selecionaAtividadeValida() throws SQLException {
        Pessoa pessoa = new Pessoa();
        Atividade atividade = new Atividade();
        String horaInicio = "15:00";
        when(daoFalso.selecionaAtividade(horaInicio,pessoa)).thenReturn(atividade.getId());
        assertEquals(daoFalso.selecionaAtividade(horaInicio,pessoa),atividade.getId());
    }
}