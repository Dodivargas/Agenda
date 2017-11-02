package visao;

import modelo.Pessoa;

import java.util.Scanner;

public class LeituraUsuario {


    public static Pessoa verificaUsuario(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite seu user:");
        String user = s.nextLine();
        System.out.println("Digite sua senha:");
        String senha = s.nextLine();
        Pessoa pessoa = new Pessoa(user,senha);
        return pessoa;
    }
}
