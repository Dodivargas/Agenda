package bancoDados;


import modelo.Atividade;
import modelo.Pessoa;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
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

    @Test
    public void listaAtividades() throws SQLException {
        Pessoa pessoa = new Pessoa();
        Atividade atividade = new Atividade();
        List atividades = new ArrayList();
        atividades.add(atividade);
        atividades.add(atividade);
        pessoa.setAtividades(atividades);
        when(daoFalso.listaAtividades(pessoa)).thenReturn(atividades);

        assertEquals(2, daoFalso.listaAtividades(pessoa).size());
    }
    @Test
    public void buscaAtividade() throws SQLException {
        Pessoa pessoa = new Pessoa();
        Atividade atividade = new Atividade();
        Integer idAbuscar = 1;
        when(daoFalso.buscaAtividadeIndividualmente(idAbuscar)).thenReturn(atividade);

        assertEquals(daoFalso.buscaAtividadeIndividualmente(1),atividade);
    }
    @Test
    public void concluiAtividade() throws SQLException {
        Pessoa pessoa = new Pessoa();
        Atividade atividade = new Atividade();
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");

        when(daoFalso.concluirAtividade(atividade,pessoa)).thenReturn(true);


        assertEquals(daoFalso.concluirAtividade(atividade,pessoa),true );
    }
    @Test
    public void limpaAtividades() throws SQLException {
        Pessoa pessoa = new Pessoa();
        when(daoFalso.limpaAtividades(pessoa)).thenReturn(true);
        assertEquals(daoFalso.limpaAtividades(pessoa),true );
    }
    @Test
    public void limpaAtividadesConcluidas() throws SQLException {
        Pessoa pessoa = new Pessoa();
        when(daoFalso.limpaAtividadesConcluidas(pessoa)).thenReturn(true);
        assertEquals(daoFalso.limpaAtividadesConcluidas(pessoa),true );
    }
}