package visao;

import controle.MenuUsuarioControle;
import database.AtividadeDAO;
import database.PessoaDAO;
import modelo.Atividade;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuUsuario {

    public static void mostraMenuUsuario() throws SQLException {

        Atividade atividade = new Atividade();
        PessoaDAO pessoaDAO = new PessoaDAO();
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        MenuUsuarioControle menuUsuarioControle = new MenuUsuarioControle();
        int opcaoUser = 999;
        Scanner s = new Scanner(System.in);

        while (opcaoUser != 0){

            System.out.println("\t\n\n###   AGENDA DE ATIVIDADES   ###\n");
            System.out.println("\t   =========================    ");
            System.out.println("\t|  1 - Criar usuario             |");
            System.out.println("\t|  2 - Entrar com user existente |");
            System.out.println("\t|  0 - Sair                      |");
            System.out.println("\t   =========================\n  ");
            opcaoUser = (s.nextInt());
            switch (opcaoUser) {
                case 1:
                    menuUsuarioControle.criaUsuario();
                    break;
                case 2:
                    menuUsuarioControle.verificaUsuario();
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção Inválida tente novamente");
                    break;
            }
        }
    }
}
