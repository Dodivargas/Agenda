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

        while (opcaoAtividades != 0){
            System.out.println("\t\n\n###   AGENDA DE ATIVIDADES   ###");
            System.out.println("\t  ========================="  );
            System.out.println("\t|     1 - Criar Atividade      |");
            System.out.println("\t|     2 - Editar Atividade     |");
            System.out.println("\t|     3 - Remover Atividade    |");
            System.out.println("\t|     4 - Listar Atividades    |");
            System.out.println("\t|     5 - Buscar Atividade     |");
            System.out.println("\t|     0 - Sair                 |");
            System.out.println("\t   =========================\n");
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
                case 6:

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