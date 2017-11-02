package controle;

import exceptions.UsuarioJáExistenteException;
import modelo.Pessoa;
import bancoDados.PessoaDAO;
import bancoDados.AtividadeDAO;
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

    public void criaUsuario(Pessoa pessoa) throws SQLException {
        try{
            pessoaDAO.registraPessoa(pessoa);
            menuAtividades.mostraMenuAtividades(pessoa);
        }catch (java.sql.SQLException e){
            throw new UsuarioJáExistenteException(e);
        }
    }
    public void verificaUsuario(Pessoa pessoa) throws SQLException {
        if(pessoaDAO.verificaPessoa(pessoa.getNome(),pessoa.getSenha()) != 0) {
            menuAtividades.mostraMenuAtividades(pessoaDAO.buscaPessoa(pessoa.getNome()));
        }else System.out.println("Senha ou user incorreto!!!!");
    }

}