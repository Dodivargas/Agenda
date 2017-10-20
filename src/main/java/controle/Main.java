package controle;

import modelo.Atividade;
import modelo.Pessoa;

public class Main {

    public static void main(String[] args) {

        Pessoa pessoa = new Pessoa("pele");
        Atividade atividade = new Atividade("14:00","15:00","Lazer");
        Atividade atividade2 = new Atividade("11:00","12:00","Lazer");
        Atividade atividade3 = new Atividade("16:00","17:00","Lazer");


        pessoa.adicionaAtividadeDia(atividade);
        pessoa.adicionaAtividadeDia(atividade2);
        pessoa.adicionaAtividadeDia(atividade3);

        System.out.println(pessoa.getAtividades().toString());


    }
}
