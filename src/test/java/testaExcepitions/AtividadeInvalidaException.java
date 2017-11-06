package testaExcepitions;

import bancoDados.AtividadeDAO;
import controle.AtividadesControle;
import modelo.Atividade;
import modelo.Pessoa;
import org.junit.Test;
import java.sql.SQLException;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AtividadeInvalidaException{

    AtividadeDAO daoFalso = mock(AtividadeDAO.class);

    @Test
    public void aitividadeNaoEncontradaException() throws SQLException {

        AtividadesControle atividadesControle = new AtividadesControle(daoFalso);
        Pessoa pessoa = new Pessoa();
        Atividade atividade = new Atividade();
        pessoa.setId(61);
        pessoa.setNome("douglas");
        String horaParaRemover = "15:00";

        when(daoFalso.criaAtividade(atividade,pessoa)).thenThrow(exceptions.AtividadeInvalidaException.class);

        try {
            atividadesControle.criaAtividade(pessoa,atividade);
        }catch (exceptions.AtividadeInvalidaException e){
            assertTrue(true);
        }
    }
}
