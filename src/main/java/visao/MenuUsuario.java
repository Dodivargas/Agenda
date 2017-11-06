package visao;

import controle.PessoaControle;
import exceptions.UsuarioJaExistenteException;
import bancoDados.PessoaDAO;
import modelo.Pessoa;
import validações.ValidaNomeUser;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuUsuario {

    public static void mostraMenuUsuario() throws SQLException {

        PessoaDAO pessoaDAO = new PessoaDAO();
        PessoaControle menuPessoaControle = new PessoaControle(pessoaDAO);
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
                            menuPessoaControle.criaUsuario(pessoa);
                            MenuAtividades.mostraMenuAtividades(pessoa);
                        }else System.out.println("Nome de usuario invalido");
                        break;
                    case 2:
                        Pessoa pessoa2;
                        pessoa2 = LeituraUsuario.verificaUsuario();
                        menuPessoaControle.verificaUsuario(pessoa2);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opção Inválida tente novamente");
                        break;
                }
            }catch (Exception e){
                if(e instanceof UsuarioJaExistenteException){
                    System.out.println("Esse nome de usuario já está cadastrado");
                }
            }
        }
    }
}
