package Visão;

import modelo.Atividade;
import modelo.Pessoa;

import java.util.Scanner;

public class Menu {


    public static void menuUsuario(){


        int opcao = 0;
        Scanner s = new Scanner(System.in);

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
            System.out.println("\n                     ========================="  );
            System.out.println("                  |     1 - Criar Atividade      |");
            System.out.println("                  |     2 - Editar Atividade     |");
            System.out.println("                  |     3 - Remover Atividade    |");
            System.out.println("                  |     4 - Listar Atividades    |");
            System.out.println("                  |     5 - Buscar Atividade     |");
            System.out.println("                  |     0 - Sair                 |");
            System.out.println("                       =========================\n");
            System.out.print("\n");
            opcao = (s.nextInt());
            switch (opcao) {
                case 1:

                    break;
                case 2:

                    break;
                case 5:

                    break;
                case 0:

                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }
}

    
    
