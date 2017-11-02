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
                        Atividade atividade = new Atividade();
                        atividade = LeituraAtividades.pegaAtividadeTeclado();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(atividade.getHoraFim())
                                && ValidaHoraAtividade.ValidaHoraAtiviade(atividade.getHoraIncio())) {
                            atividadesControle.criaAtividade(pessoa, atividade);
                        }else System.out.println("Horario digitado incorretamente!");
                        break;
                    case 2:
                        String horaInicioParaEditar = LeituraAtividades.pegaHoraInicioAtividadeAEditar();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(horaInicioParaEditar)) {
                            Atividade atividade2 = new Atividade();
                            atividade2 = LeituraAtividades.pegaAtividadeTeclado();
                            atividadesControle.editaAtividade(pessoa, horaInicioParaEditar, atividade2);
                        }else System.out.println("Horario digitado incorretamente!");
                        break;
                    case 3:
                        String horaInicioParaRemover = LeituraAtividades.pegaHoraInicioAtividadeARemover();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(horaInicioParaRemover)){
                            atividadesControle.removeAtividade(pessoa,horaInicioParaRemover);
                        }else System.out.println("Horario digitado incorretamente!");
                        break;
                    case 4:
                        String horaInicioParaConcluir = LeituraAtividades.pegaHoraInicioAtividadeAConcluir();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(horaInicioParaConcluir)) {
                            atividadesConcluidasControle.concluiAtividade(pessoa, horaInicioParaConcluir);
                        }else System.out.println("Horario digitado incorretamente!");
                        break;
                    case 5:
                        String horaInicioParaVer = LeituraAtividades.pegaHoraInicioAtividadeAMostrar();
                        if (ValidaHoraAtividade.ValidaHoraAtiviade(horaInicioParaVer)){
                            atividadesControle.buscaAtividade(pessoa,horaInicioParaVer);
                            s.nextLine();
                        }else System.out.println("Horario digitado incorretamente!");
                        s.nextLine();
                        break;
                    case 6:
                        atividadesControle.mostraTodasAtividades(pessoa);
                        s.nextLine();
                        break;
                    case 7:
                        atividadesConcluidasControle.listaAtividadesConcluidas(pessoa);
                        s.nextLine();
                        break;
                    case 8:
                        atividadesControle.limparAtividades(pessoa);
                        break;
                    case 9:
                        atividadesConcluidasControle.limparAtividadesConcluidas(pessoa);
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
                    System.out.println("A atividade não foi encontrada");
                }else if (e instanceof AtividadeInvalidaException){
                    System.out.println("A atividade não foi registrada");
                }else if (e instanceof AtividadeInvalidaException){
                    System.out.println("Não existem atividades para mostrar");
                }
            }
        }
    }
}