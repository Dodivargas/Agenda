package controle;

import Exceptions.AtividadeNaoEncontradaException;
import database.AtividadeDAO;
import modelo.Atividade;
import modelo.Pessoa;

import java.sql.SQLException;
import java.util.Scanner;

public class AtividadesConcluidasControle {
    private AtividadeDAO atividadeDAO;

    public AtividadesConcluidasControle(AtividadeDAO atividadeDAO) {
        this.atividadeDAO = atividadeDAO;
    }

    public void concluiAtividade(Pessoa pessoa) throws SQLException {
        try{
            Scanner s = new Scanner(System.in);
            System.out.println("Digite a hora inicial da atividade a concluir:");
            String horainicio = s.nextLine();
            Integer idAVerificar = 0;
            idAVerificar = atividadeDAO.selecionaAtividade(horainicio,pessoa);
            Atividade atividade = new Atividade();
            atividade = atividadeDAO.retornaAtividade(idAVerificar);
            atividadeDAO.concluirAtividade(atividade,pessoa);
            atividadeDAO.removerAtividade(idAVerificar);
        }catch (java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }

    }

    public void listaAtividadesConcluidas(Pessoa pessoa) throws SQLException {
        pessoa.setAtividadesConcluidas(atividadeDAO.listaAtividadesConcluidas(pessoa));
        if (pessoa.getAtividadesConcluidas().size() > 0){
            for (int i = 0;i<pessoa.getAtividadesConcluidas().size();i++){
                System.out.println(pessoa.getAtividadesConcluidas().get(i));
            }
        }else System.out.println("\n\n Não existem atividades concluidas para esse usuario!!!");
    }

}
