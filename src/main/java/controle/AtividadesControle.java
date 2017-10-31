package controle;

import Exceptions.AtividadeInvalidaException;
import Exceptions.AtividadeNaoEncontradaException;
import database.AtividadeDAO;
import modelo.Atividade;
import modelo.Pessoa;

import java.sql.SQLException;
import java.util.Scanner;

public class AtividadesControle {

    private AtividadeDAO atividadeDAO;

    public AtividadesControle(AtividadeDAO atividadeDAO) {
        this.atividadeDAO = atividadeDAO;
    }


    public void criaAtividade(Pessoa pessoa) throws SQLException {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Nome da atividade:");
            String nome = s.nextLine();
            System.out.println("Hora do inicio da atividade: ");
            String horainicio = s.nextLine();
            System.out.println("Hora do fim da atividade: ");
            String horafim = s.nextLine();
            System.out.println("Tipo da atividade: ");
            String tipo = s.nextLine();
            Atividade atividade = new Atividade(nome,horainicio,horafim,tipo);
            atividadeDAO.criaAtividade(atividade,pessoa);
        }catch (java.sql.SQLException e){
            throw new AtividadeInvalidaException(e);
        }
    }
    public void editaAtividade(Pessoa pessoa){
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite a hora inicial da atividade que deseja editar:");
            String horainicioeditar = s.nextLine();
            Integer idAVerificar = 0;
            idAVerificar = atividadeDAO.selecionaAtividade(horainicioeditar,pessoa);
            if (idAVerificar != 0) {
                System.out.println("Nome da atividade:");
                String nome = s.nextLine();
                System.out.println("Hora do inicio da atividade: ");
                String horainicio = s.nextLine();
                System.out.println("Hora do fim da atividade: ");
                String horafim = s.nextLine();
                System.out.println("Tipo da atividade: ");
                String tipo = s.nextLine();
                Atividade atividade = new Atividade(nome, horainicio, horafim, tipo);
                atividadeDAO.editarAtividade(atividade, idAVerificar);
            }
        }catch(java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }
    public void removeAtividade(Pessoa pessoa) throws SQLException {
        try{
            Scanner s = new Scanner(System.in);
            System.out.println("Digite a hora inicial da atividade que deseja remover:");
            String horainicioeditar = s.nextLine();
            Integer idARemover = 0;
            idARemover = atividadeDAO.selecionaAtividade(horainicioeditar,pessoa);
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
            for (int i = 0;i<pessoa.getAtividades().size();i++){
                System.out.println(pessoa.getAtividades().get(i));
            }
        }else System.out.println("\n\n Não existem atividades cadastradas para esse usuario!!!");
    }

    public void buscaAtividade(Pessoa pessoa) throws SQLException {
        try {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite a hora inicial da atividade que deseja ver:");
            String horainicio = s.nextLine();
            Integer idAVerificar = 0;
            idAVerificar = atividadeDAO.selecionaAtividade(horainicio,pessoa);
            atividadeDAO.buscaAtividadeIndividualmente(idAVerificar);
        }catch (java.sql.SQLException e){
            throw new AtividadeNaoEncontradaException(e);
        }
    }

}

