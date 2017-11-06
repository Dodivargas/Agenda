package controle;

import exceptions.AtividadeNaoEncontradaException;
import bancoDados.AtividadeDAO;
import modelo.Atividade;
import modelo.Pessoa;
import java.sql.SQLException;
import java.util.List;


public class AtividadesConcluidasControle {

    private AtividadeDAO atividadeDAO;

    public AtividadesConcluidasControle(AtividadeDAO atividadeDAO) {
        this.atividadeDAO = atividadeDAO;

    }

    public void concluiAtividade(Pessoa pessoa, String horainicio) throws SQLException {
        try{
            Integer idAVerificar = atividadeDAO.selecionaAtividade(horainicio, pessoa);
            if (idAVerificar != 0){
                Atividade atividade = atividadeDAO.buscaAtividadeIndividualmente(idAVerificar);
                atividadeDAO.concluirAtividade(atividade, pessoa);
                atividadeDAO.removerAtividade(idAVerificar);
            }
        }catch (java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }

    public List<Atividade> listaAtividadesConcluidas(Pessoa pessoa) throws SQLException {
        pessoa.setAtividadesConcluidas(atividadeDAO.listaAtividadesConcluidas(pessoa));
        return pessoa.getAtividadesConcluidas();
    }

    public void limparAtividadesConcluidas(Pessoa pessoa) throws SQLException {
        atividadeDAO.limpaAtividadesConcluidas(pessoa);
    }
}
