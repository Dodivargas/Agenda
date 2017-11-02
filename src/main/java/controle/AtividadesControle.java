package controle;

import exceptions.AtividadeInvalidaException;
import exceptions.AtividadeNaoEncontradaException;
import bancoDados.AtividadeDAO;
import modelo.Atividade;
import modelo.Pessoa;

import java.sql.SQLException;

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
            Integer idAVerificar = 0;
            idAVerificar = atividadeDAO.selecionaAtividade(horainicioeditar, pessoa);
            if (idAVerificar != 0) {
                atividadeDAO.editarAtividade(atividade, idAVerificar);
            }
        }catch(java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }

    public void removeAtividade(Pessoa pessoa, String horaInicioParaRemover) throws SQLException {
        try{
            Integer idARemover = 0;
            idARemover = atividadeDAO.selecionaAtividade(horaInicioParaRemover, pessoa);
            if (idARemover != 0){
                atividadeDAO.removerAtividade(idARemover);
            }

        }catch (java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }

    public void mostraTodasAtividades(Pessoa pessoa) throws SQLException {
        pessoa.setAtividades(atividadeDAO.listaAtividades(pessoa));
        if (pessoa.getAtividades().size() > 0){
            for (int i = 0; i< pessoa.getAtividades().size(); i++){
                System.out.println(pessoa.getAtividades().get(i));
            }
        }else System.out.println("\n\n Não existem atividades cadastradas para esse pessoa!!!");
    }

    public void buscaAtividade(Pessoa pessoa, String horaInicialAVer) throws SQLException {
        try {
            Atividade atividade;
            Integer idAVerificar = 0;
            idAVerificar = atividadeDAO.selecionaAtividade(horaInicialAVer, pessoa);
            atividade = atividadeDAO.buscaAtividadeIndividualmente(idAVerificar);
            System.out.println(atividade.toString());
        }catch (java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }
    public void limparAtividades(Pessoa pessoa) throws SQLException {
        atividadeDAO.limpaAtividades(pessoa);
    }

}

