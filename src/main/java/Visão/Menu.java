package Visão;

import modelo.Atividade;
import modelo.Pessoa;
import database.PessoaDAO;
import database.AtividadeDAO;
import database.ConectaMysql;
import java.*;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {


    public static void menuUsuario() throws SQLException {


        Atividade atividade = new Atividade();
        PessoaDAO pessoaDAO = new PessoaDAO();
        AtividadeDAO atividadeDAO = new AtividadeDAO();

        int opcaoUser = 999;
        Scanner s = new Scanner(System.in);

        while (opcaoUser != 0){

            System.out.println("                 \n\n###   AGENDA DE ATIVIDADES   ###");
            System.out.println("              \n       =========================    ");
            System.out.println("                  |  1 - Criar usuario             |");
            System.out.println("                  |  2 - Entrar com user existente |");
            System.out.println("                       =========================\n  ");
            opcaoUser = (s.nextInt());
            switch (opcaoUser) {
                case 1:

                    System.out.println("Nome de usuario:");
                    String user = s.next();
                    System.out.println("Senha: ");
                    String senha = s.next();

                    Pessoa pessoa = new Pessoa(user,senha);
                    pessoaDAO.registraPessoa(pessoa);

                    menuAtividades(pessoa);

                    break;
                case 2:
                    System.out.println("Digite seu user:");
                    user = s.next();
                    System.out.println("Digite sua senha:");
                    senha = s.next();
                    if(pessoaDAO.verificaPessoa(user,senha) != 0) {
                        menuAtividades(pessoaDAO.buscaPessoa(user));
                    }else System.out.println("Senha ou user incorreto!!!!");
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Opção Inválida tente novamente");
                    break;
            }
        }
    }

    public static void menuAtividades(Pessoa pessoa){
        int opcaoAtividades = 999;
        Scanner s = new Scanner(System.in);

        while (opcaoAtividades != 0){
            System.out.println("              \n\n###   AGENDA DE ATIVIDADES   ###");
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

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

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

    
    
