package controle;

import bancoDados.AtividadeDAO;
import modelo.Atividade;
import modelo.Pessoa;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class AtividadesConcluidasControleTest {

    AtividadeDAO daoFalso = mock(AtividadeDAO.class);
    AtividadesConcluidasControle atividadesConcluidasControle = new AtividadesConcluidasControle(daoFalso);

    @Test
    public void mostraTodasAtividadesConcluidas () throws SQLException {
        Pessoa pessoa = new Pessoa();
        pessoa.setId(1);
        Atividade atividade = new Atividade();
        atividade.setNome("nadar");
        atividade.setHoraIncio("15:00");
        atividade.setHoraFim("16:00");
        atividade.setTipo("esporte");
        List<Atividade> atividadesConcluidas = new ArrayList<>();
        atividadesConcluidas.add(atividade);
        atividadesConcluidas.add(atividade);
        pessoa.setAtividades(atividadesConcluidas);

        when(daoFalso.listaAtividadesConcluidas(pessoa)).thenReturn(atividadesConcluidas);
        Assert.assertEquals( atividadesConcluidasControle.listaAtividadesConcluidas(pessoa),atividadesConcluidas);
    }


}
