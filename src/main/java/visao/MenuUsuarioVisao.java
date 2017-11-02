package visao;

import java.util.Scanner;

public class MenuUsuarioVisao {

    public static int mostraMenuUsuario(){
        Scanner s = new Scanner(System.in);
        System.out.println("\t\n\n###   AGENDA DE ATIVIDADES   ###\n");
        System.out.println("\t   =========================    ");
        System.out.println("\t|  1 - Criar usuario             |");
        System.out.println("\t|  2 - Entrar com user existente |");
        System.out.println("\t|  0 - Sair                      |");
        System.out.println("\t   =========================\n  ");
        int opcaoUser = (s.nextInt());
        return opcaoUser;
    }
}
