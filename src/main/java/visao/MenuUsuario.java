package visao;

import controle.UsuarioControle;
import exceptions.UsuarioJáExistenteException;
import database.AtividadeDAO;
import database.PessoaDAO;
import modelo.Atividade;
import modelo.Pessoa;
import validações.ValidaNomeUser;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuUsuario {

    public static void mostraMenuUsuario() throws SQLException {

        Atividade atividade = new Atividade();
        PessoaDAO pessoaDAO = new PessoaDAO();
        AtividadeDAO atividadeDAO = new AtividadeDAO();
        UsuarioControle menuUsuarioControle = new UsuarioControle(pessoaDAO);
        int opcaoUser = 999;
        Scanner s = new Scanner(System.in);
        while (opcaoUser != 0){
            opcaoUser = MenuUsuarioVisao.mostraMenuUsuario();
            try{
                switch (opcaoUser) {
                    case 1:
                        Pessoa pessoa;
                            pessoa = LeituraUsuario.verificaUsuario();
                            if (ValidaNomeUser.validaNomeUser(pessoa.getNome())){
                            menuUsuarioControle.criaUsuario(pessoa);
                            }else System.out.println("Nome de usuario invalido");
                        break;
                    case 2:
                        Pessoa pessoa2;
                        pessoa2 = LeituraUsuario.verificaUsuario();
                        menuUsuarioControle.verificaUsuario(pessoa2);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção Inválida tente novamente");
                        break;
                }
            }catch (Exception e){
                if(e instanceof UsuarioJáExistenteException){
                    System.out.println("Esse nome de usuario já está cadastrado");
                }
            }
        }
    }
}
