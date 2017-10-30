package visao;

import controle.MenuAtividadesControle;
import database.AtividadeDAO;
import database.PessoaDAO;
import modelo.Pessoa;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuAtividades {


    public static void mostraMenuAtividades(Pessoa pessoa) throws SQLException {

        PessoaDAO pessoaDAO = new PessoaDAO();
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        MenuAtividadesControle menuAtividadesControle = new MenuAtividadesControle();
        int opcaoAtividades = 999;
        Scanner s = new Scanner(System.in);

<<<<<<< HEAD:src/main/java/Visão/Menu.java
        do {

            System.out.println("\n\n###   AGENDA DE ATIVIDADES   ###");
            System.out.println("\n                      =========================    ");
            System.out.println("                  |  1 - Criar usuario              |");
            System.out.println("                  |  2 - Entrar com user existente  |");
            System.out.println("                        =========================\n  ");
            opcao = (s.nextInt());
            switch (opcao) {
                case 1:
                    break;
                case 2:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }while (opcao != 0);
    }


    public static void menuAtividades(){
        int opcao = 0;
        Scanner s = new Scanner(System.in);
        do {
            System.out.println("\n\n###   AGENDA DE ATIVIDADES   ###");
=======
        while (opcaoAtividades != 0){
            System.out.println("              \n\n###   AGENDA DE ATIVIDADES   ###");
>>>>>>> 8387873385f63fb9cca39487df6c9e3e3f8a245b:src/main/java/visao/MenuAtividades.java
            System.out.println("\n                     ========================="  );
            System.out.println("                  |     1 - Criar Atividade      |");
            System.out.println("                  |     2 - Editar Atividade     |");
            System.out.println("                  |     3 - Remover Atividade    |");
            System.out.println("                  |     4 - Listar Atividades    |");
            System.out.println("                  |     5 - Buscar Atividade     |");
            System.out.println("                  |     0 - Sair                 |");
            System.out.println("                       =========================\n");
            System.out.print("\n");
            opcaoAtividades = (s.nextInt());
            switch (opcaoAtividades) {
                case 1:
                    menuAtividadesControle.criaAtividade(pessoa);
                    break;
                case 2:
                    menuAtividadesControle.editaAtividade();
                    break;
                case 3:
                    menuAtividadesControle.removeAtividade();
                    break;
                case 4:
                    menuAtividadesControle.mostraTodasAtividades(pessoa);
                    break;
                case 5:
                    menuAtividadesControle.buscaAtividade();
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        }
    }
}
