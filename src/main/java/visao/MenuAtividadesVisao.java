package visao;

import java.util.Scanner;

public class MenuAtividadesVisao {

    public static int mostraMenuAtividades(){
        Scanner s = new Scanner(System.in);
        System.out.println("\t\n\n###   AGENDA DE ATIVIDADES   ###");
        System.out.println("\t      ========================="  );
        System.out.println("\t|     1 - Criar Atividade                      |");
        System.out.println("\t|     2 - Editar Atividade                     |");
        System.out.println("\t|     3 - Remover Atividade                    |");
        System.out.println("\t|     4 - Concluir Atividade                   |");
        System.out.println("\t|     5 - Buscar Atividade                     |");
        System.out.println("\t|     6 - Listar Atividades                    |");
        System.out.println("\t|     7 - Listar Atividades Concluidas         |");
        System.out.println("\t|     8 - Exclui todas atividades              |");
        System.out.println("\t|     9 - Exclui todas atividades Concluidas   |");
        System.out.println("\t|     0 - Sair                                 |");
        System.out.println("\t       =========================\n");
        System.out.print("\n");
        int opcaoAtividades = (s.nextInt());
        return opcaoAtividades;
    }
}
