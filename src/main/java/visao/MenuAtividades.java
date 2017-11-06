package visao;

import exceptions.AtividadeInvalidaException;
import exceptions.AtividadeNaoEncontradaException;
import controle.AtividadesConcluidasControle;
import controle.AtividadesControle;
import bancoDados.AtividadeDAO;
import bancoDados.PessoaDAO;
import modelo.Atividade;
import modelo.Pessoa;
import validações.ValidaHoraAtividade;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuAtividades {


    public static void mostraMenuAtividades(Pessoa pessoa) throws SQLException {

        PessoaDAO pessoaDAO = new PessoaDAO();
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        AtividadesControle atividadesControle = new AtividadesControle(atividadeDAO);
        AtividadesConcluidasControle atividadesConcluidasControle = new AtividadesConcluidasControle(atividadeDAO);
        int opcaoAtividades = 999;
        Scanner s = new Scanner(System.in);
        while (opcaoAtividades != 0){
            try {
                opcaoAtividades = MenuAtividadesVisao.mostraMenuAtividades();
                switch (opcaoAtividades) {
                    case 1:
                        Atividade atividade;
                        atividade = LeituraAtividades.pegaAtividadeTeclado();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(atividade.getHoraFim())
                                && ValidaHoraAtividade.ValidaHoraAtiviade(atividade.getHoraIncio())) {
                            atividadesControle.criaAtividade(pessoa, atividade);
                            System.out.println("Atividade adicionada!");
                        }else System.out.println("Horario digitado incorretamente!");
                        s.nextLine();
                        break;
                    case 2:
                        String horaInicioParaEditar = LeituraAtividades.pegaHoraInicioAtividadeAEditar();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(horaInicioParaEditar)) {
                            System.out.println("Digite abaixo a nova atividade!");
                            Atividade atividade2;
                            atividade2 = LeituraAtividades.pegaAtividadeTeclado();
                            atividadesControle.editaAtividade(pessoa, horaInicioParaEditar, atividade2);
                            System.out.println("atividade editada!");
                        }else System.out.println("Horario digitado incorretamente!");
                        s.nextLine();

                        break;
                    case 3:
                        String horaInicioParaRemover = LeituraAtividades.pegaHoraInicioAtividadeARemover();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(horaInicioParaRemover)){
                            atividadesControle.removeAtividade(pessoa,horaInicioParaRemover);
                            System.out.println("Atividade removida!");
                        }else System.out.println("Horario digitado incorretamente!");
                        s.nextLine();
                        break;
                    case 4:
                        String horaInicioParaConcluir = LeituraAtividades.pegaHoraInicioAtividadeAConcluir();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(horaInicioParaConcluir)) {
                            atividadesConcluidasControle.concluiAtividade(pessoa, horaInicioParaConcluir);
                            System.out.println("Atividade concluida!");
                        }else System.out.println("Horario digitado incorretamente!");
                        s.nextLine();
                        break;
                    case 5:
                        String horaInicioParaVer = LeituraAtividades.pegaHoraInicioAtividadeAMostrar();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(horaInicioParaVer)){
                            Atividade atividade2 ;
                            atividade2 = atividadesControle.buscaAtividade(pessoa,horaInicioParaVer);
                            System.out.println(atividade2.toString());
                        }else {
                            System.out.println("Horario digitado incorretamente!");
                        }
                        s.nextLine();
                        break;
                    case 6:
                        List<Atividade> atividades;
                        atividades = atividadesControle.mostraTodasAtividades(pessoa);
                        if (atividades.size() > 0){
                            for (int i = 0; i< atividades.size(); i++){
                                System.out.println(atividades.get(i));
                            }
                        }else{
                            System.out.println("\n\n Não existem atividades cadastradas para esse pessoa!!!");
                        }
                        s.nextLine();
                        break;
                    case 7:
                        List<Atividade> atividadesConcluidas = atividadesConcluidasControle.listaAtividadesConcluidas(pessoa);
                        if (pessoa.getAtividadesConcluidas().size() > 0){
                            for (int i = 0; i< atividadesConcluidas.size(); i++){
                                System.out.println(atividadesConcluidas.get(i));
                            }
                        }else System.out.println("\n\n Não existem atividades concluidas para esse pessoa!!!");
                        s.nextLine();
                        break;
                    case 8:
                        atividadesControle.limparAtividades(pessoa);
                        System.out.println("Todas atividades foram removidas");
                        s.nextLine();
                        break;
                    case 9:
                        atividadesConcluidasControle.limparAtividadesConcluidas(pessoa);
                        System.out.println("Todas atividades concluidas foram removidas");
                        s.nextLine();
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção Inválida!");
                        break;
                }
            } catch (Exception e) {
                if (e instanceof AtividadeNaoEncontradaException) {
                    System.out.println("A atividade não foi encontrada!");
                    s.nextLine();
                }
            }
        }
    }
}