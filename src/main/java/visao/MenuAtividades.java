package visao;

import Exceptions.AtividadeInvalidaException;
import Exceptions.AtividadeNaoEncontradaException;
import controle.AtividadesConcluidasControle;
import controle.AtividadesControle;
import database.AtividadeDAO;
import database.PessoaDAO;
import modelo.Pessoa;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuAtividades {


    public static void mostraMenuAtividades(Pessoa pessoa) throws SQLException {

        PessoaDAO pessoaDAO = new PessoaDAO();
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        AtividadesControle menuAtividadesControle = new AtividadesControle(atividadeDAO);
        AtividadesConcluidasControle atividadesConcluidasControle = new AtividadesConcluidasControle(atividadeDAO);
        int opcaoAtividades = 999;
        Scanner s = new Scanner(System.in);

        while (opcaoAtividades != 0){
            System.out.println("\t\n\n###   AGENDA DE ATIVIDADES   ###");
            System.out.println("\t      ========================="  );
            System.out.println("\t|     1 - Criar Atividade              |");
            System.out.println("\t|     2 - Editar Atividade             |");
            System.out.println("\t|     3 - Remover Atividade            |");
            System.out.println("\t|     4 - Concluir Atividade           |");
            System.out.println("\t|     5 - Listar Atividades            |");
            System.out.println("\t|     6 - Listar Atividades Concluidas |");
            System.out.println("\t|     7 - Buscar Atividade             |");
            System.out.println("\t|     0 - Sair                         |");
            System.out.println("\t       =========================\n");
            System.out.print("\n");
            opcaoAtividades = (s.nextInt());
            try {
                switch (opcaoAtividades) {
                    case 1:
                        menuAtividadesControle.criaAtividade(pessoa);
                        break;
                    case 2:
                        menuAtividadesControle.editaAtividade(pessoa);
                        break;
                    case 3:
                        menuAtividadesControle.removeAtividade(pessoa);
                        break;
                    case 4:
                        atividadesConcluidasControle.concluiAtividade(pessoa);
                        break;
                    case 5:
                        menuAtividadesControle.mostraTodasAtividades(pessoa);
                        break;
                    case 6:
                        atividadesConcluidasControle.listaAtividadesConcluidas(pessoa);
                        break;
                    case 7:
                        menuAtividadesControle.buscaAtividade(pessoa);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            } catch (Exception e) {
                if (e instanceof AtividadeNaoEncontradaException) {
                    System.out.println("A atividade não foi encontrada");
                }else if (e instanceof AtividadeInvalidaException){
                    System.out.println("A atividade não foi registrada");
                }
            }
        }
    }
}