package visao;

import modelo.Atividade;

import java.util.Scanner;

public class LeituraAtividades {

    public static Atividade pegaAtividadeTeclado(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nome da atividade:");
        String nome = s.nextLine();
        System.out.println("Hora do inicio da atividade: ");
        String horainicio = s.nextLine();
        System.out.println("Hora do fim da atividade: ");
        String horafim = s.nextLine();
        System.out.println("Tipo da atividade: ");
        String tipo = s.nextLine();
        Atividade atividade = new Atividade(nome,horainicio,horafim,tipo);
        return atividade;
    }
    public static String pegaHoraInicioAtividadeAEditar(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a hora inicial da atividade que deseja Editar:");
        String horainicioeditar = s.nextLine();
        return horainicioeditar;
    }
    public static String pegaHoraInicioAtividadeARemover(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a hora inicial da atividade que deseja Remover:");
        String horainicioeditar = s.nextLine();
        return horainicioeditar;
    }
    public static String pegaHoraInicioAtividadeAConcluir(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a hora inicial da atividade que deseja Concluir:");
        String horainicioeditar = s.nextLine();
        return horainicioeditar;
    }
    public static String pegaHoraInicioAtividadeAMostrar(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a hora inicial da atividade que deseja ver:");
        String horaInicioAVer = s.nextLine();
        return horaInicioAVer;
    }





}
