package visao;

import modelo.Atividade;

import java.util.Scanner;

public class LeituraAtividades {

    public static Atividade pegaAtividadeTeclado(){
        Scanner s = new Scanner(System.in);
        System.out.println("Nome da atividade:");
        String nome = s.nextLine();
        System.out.println("Hora do inicio da atividade hh/mm : ");
        String horainicio = s.nextLine();
        System.out.println("Hora do fim da atividade hh/mm : ");
        String horafim = s.nextLine();
        System.out.println("Tipo da atividade: ");
        String tipo = s.nextLine();
        Atividade atividade = new Atividade(nome,horainicio,horafim,tipo);
        return atividade;
    }

    public static String pegaHoraInicioAtividadeAEditar(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a hora inicial da atividade que deseja Editar hh/mm :");
        String horainicioeditar = s.nextLine();
        return horainicioeditar;
    }

    public static String pegaHoraInicioAtividadeARemover(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a hora inicial da atividade que deseja Remover hh/mm :");
        String horainicioeditar = s.nextLine();
        return horainicioeditar;
    }

    public static String pegaHoraInicioAtividadeAConcluir(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a hora inicial da atividade que deseja Concluir hh/mm :");
        String horainicioeditar = s.nextLine();
        return horainicioeditar;
    }

    public static String pegaHoraInicioAtividadeAMostrar(){
        Scanner s = new Scanner(System.in);
        System.out.println("Digite a hora inicial da atividade que deseja ver hh/mm :");
        String horaInicioAVer = s.nextLine();
        return horaInicioAVer;
    }





}
