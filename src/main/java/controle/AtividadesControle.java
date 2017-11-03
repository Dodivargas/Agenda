package controle;

import exceptions.AtividadeInvalidaException;
import exceptions.AtividadeNaoEncontradaException;
import bancoDados.AtividadeDAO;
import modelo.Atividade;
import modelo.Pessoa;

import java.sql.SQLException;
import java.util.List;

public class AtividadesControle {

    private AtividadeDAO atividadeDAO;

    public AtividadesControle(AtividadeDAO atividadeDAO) {
        this.atividadeDAO = atividadeDAO;
    }


    public boolean criaAtividade(Pessoa pessoa, Atividade atividade) throws SQLException {
        try {
            atividadeDAO.criaAtividade(atividade, pessoa);
            return true;
        }catch (java.sql.SQLException e){
            throw new AtividadeInvalidaException(e);
        }
    }

    public void editaAtividade(Pessoa pessoa, String horainicioeditar, Atividade atividade){
        try {
            Integer idAVerificar = atividadeDAO.selecionaAtividade(horainicioeditar, pessoa);
            if (idAVerificar != 0) {
                atividadeDAO.editarAtividade(atividade, idAVerificar);
            }
        }catch(java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }

    public void removeAtividade(Pessoa pessoa, String horaInicioParaRemover) throws SQLException {
        try{
            Integer idARemover = atividadeDAO.selecionaAtividade(horaInicioParaRemover, pessoa);
            if (idARemover != 0){
                atividadeDAO.removerAtividade(idARemover);
            }
        }catch (java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }

    public List<Atividade> mostraTodasAtividades(Pessoa pessoa) throws SQLException {
        pessoa.setAtividades(atividadeDAO.listaAtividades(pessoa));
        return pessoa.getAtividades();
    }
    public Atividade buscaAtividade(Pessoa pessoa, String horaInicialAVer) throws SQLException {
        try {
            Integer idAVerificar = atividadeDAO.selecionaAtividade(horaInicialAVer, pessoa);
            return atividadeDAO.buscaAtividadeIndividualmente(idAVerificar);
        }catch (java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }
    public void limparAtividades(Pessoa pessoa) throws SQLException {
        atividadeDAO.limpaAtividades(pessoa);
    }

}

