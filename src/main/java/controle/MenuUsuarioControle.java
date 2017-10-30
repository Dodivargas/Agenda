package controle;

import modelo.Atividade;
import modelo.Pessoa;
import database.PessoaDAO;
import database.AtividadeDAO;
import visao.MenuAtividades;

import java.sql.SQLException;
import java.util.Scanner;


public class MenuUsuarioControle {

    Atividade atividade = new Atividade();
    PessoaDAO pessoaDAO = new PessoaDAO();
    AtividadeDAO atividadeDAO = new AtividadeDAO();
    MenuAtividades menuAtividades = new MenuAtividades();
    Scanner s = new Scanner(System.in);

    public void criaUsuario() throws SQLException {
        System.out.println("Nome de usuario:");
        String user = s.next();
        System.out.println("Senha: ");
        String senha = s.next();
        Pessoa pessoa = new Pessoa(user,senha);
        pessoaDAO.registraPessoa(pessoa);
        menuAtividades.mostraMenuAtividades(pessoa);
    }
    public void verificaUsuario() throws SQLException {
        System.out.println("Digite seu user:");
        String user = s.next();
        System.out.println("Digite sua senha:");
        String senha = s.next();
        if(pessoaDAO.verificaPessoa(user,senha) != 0) {
            menuAtividades.mostraMenuAtividades(pessoaDAO.buscaPessoa(user));
        }else System.out.println("Senha ou user incorreto!!!!");
    }
}
