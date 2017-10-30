package controle;

import database.AtividadeDAO;
import modelo.Atividade;
import modelo.Pessoa;

import java.sql.SQLException;
import java.util.Collections;
import java.util.Scanner;

public class MenuAtividadesControle {

    public void criaAtividade(Pessoa pessoa) throws SQLException {
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        Scanner s = new Scanner(System.in);

        System.out.println("Nome da atividade:");
        String nome = s.next();
        System.out.println("Hora do inicio da atividade: ");
        String horainicio = s.next();
        System.out.println("Hora do fim da atividade: ");
        String horafim = s.next();
        System.out.println("Tipo da atividade: ");
        String tipo = s.next();
        Atividade atividade = new Atividade(nome,horainicio,horafim,tipo);
        atividadeDAO.criaAtividade(atividade,pessoa);

    }
    public void editaAtividade(){
        try {
            Scanner s = new Scanner(System.in);
            AtividadeDAO atividadeDAO = new AtividadeDAO();
            System.out.println("Digite a hora inicial da atividade que deseja editar:");
            String horainicioeditar = s.next();
            Integer idAVerificar = 0;
            idAVerificar = atividadeDAO.selecionaAtividade(horainicioeditar);
            if (idAVerificar != 0) {
                System.out.println("Nome da atividade:");
                String nome = s.next();
                System.out.println("Hora do inicio da atividade: ");
                String horainicio = s.next();
                System.out.println("Hora do fim da atividade: ");
                String horafim = s.next();
                System.out.println("Tipo da atividade: ");
                String tipo = s.next();
                Atividade atividade = new Atividade(nome, horainicio, horafim, tipo);
                atividadeDAO.editarAtividade(atividade, idAVerificar);
            }
        }catch(java.sql.SQLException e){
            System.out.println("Não existe atividade nesse horario para editar");
        }
    }
    public void removeAtividade() throws SQLException {

        try{
            Scanner s = new Scanner(System.in);
            AtividadeDAO atividadeDAO = new AtividadeDAO();
            System.out.println("Digite a hora inicial da atividade que deseja remover:");
            String horainicioeditar = s.next();
            Integer idARemover = 0;
            idARemover = atividadeDAO.selecionaAtividade(horainicioeditar);
            if (idARemover != 0){
                atividadeDAO.removerAtividade(idARemover);
            }
        }catch (java.sql.SQLException e){
            System.out.println("Não existe atividade nesse horario para remover");
        }
    }
    public void mostraTodasAtividades(Pessoa pessoa) throws SQLException {
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        pessoa.setAtividades(atividadeDAO.listaAtividades(pessoa));
        if (pessoa.getAtividades().size() > 0){
            for (int i = 0;i<pessoa.getAtividades().size();i++){
                System.out.println(pessoa.getAtividades().get(i));
            }
        }else System.out.println("\n\n Não existem atividades cadastradas para esse usuario!!!");
    }

    public void buscaAtividade() throws SQLException {
        Scanner s = new Scanner(System.in);
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        System.out.println("Digite a hora inicial da atividade que deseja ver:");
        String horainicio = s.next();
        Integer idAVerificar = 0;
        idAVerificar = atividadeDAO.selecionaAtividade(horainicio);
        atividadeDAO.buscaAtividadeIndividualmente(idAVerificar);
    }

}