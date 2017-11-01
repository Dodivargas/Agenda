package controle;

import Exceptions.UsuarioJáExistenteException;
import modelo.Pessoa;
import database.PessoaDAO;
import database.AtividadeDAO;
import visao.MenuAtividades;

import java.sql.SQLException;
import java.util.Scanner;


public class UsuarioControle {


    private PessoaDAO pessoaDAO;

    public UsuarioControle(PessoaDAO pessoaDAO) {
        this.pessoaDAO = pessoaDAO;
    }

    AtividadeDAO atividadeDAO = new AtividadeDAO();
    MenuAtividades menuAtividades = new MenuAtividades();
    Scanner s = new Scanner(System.in);

    public void criaUsuario() throws SQLException {
        try{System.out.println("Nome de usuario:");
            String user = s.nextLine();
            System.out.println("Senha: ");
            String senha = s.nextLine();
            Pessoa pessoa = new Pessoa(user,senha);
            pessoaDAO.registraPessoa(pessoa);
            menuAtividades.mostraMenuAtividades(pessoa);
        }catch (java.sql.SQLException e){
            throw new UsuarioJáExistenteException(e);
        }
    }
    public void verificaUsuario() throws SQLException {
        System.out.println("Digite seu user:");
        String user = s.nextLine();
        System.out.println("Digite sua senha:");
        String senha = s.nextLine();
        if(pessoaDAO.verificaPessoa(user,senha) != 0) {
            menuAtividades.mostraMenuAtividades(pessoaDAO.buscaPessoa(user));
        }else System.out.println("Senha ou user incorreto!!!!");
    }

}