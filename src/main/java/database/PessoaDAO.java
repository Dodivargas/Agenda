package database;

import modelo.Pessoa;

import java.sql.*;

public class PessoaDAO {

    private final Connection con;

    public PessoaDAO() {
        this.con = ConectaMysql.getConnection();
    }

    public void registraPessoa(Pessoa pessoa) throws SQLException {
        String sql = "insert into pessoas(nome,senha)values(?,?)";
        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, pessoa.getNome());
            stm.setString(2, pessoa.getSenha());
            stm.execute();
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int idGerado = rs.getInt(1);
            pessoa.setId(idGerado);
        }
    }
<<<<<<< HEAD
    public boolean verificaPessoa(String nome,String senha) throws SQLException {
        String sql = "select * from pessoas";
        boolean aux = false;
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            try (ResultSet rs = stm.getResultSet()) {
                while (rs.next()) {
                    String senha1 = rs.getString("senha");
                    String nome1 = rs.getString("nome");
                    if (nome.equals(nome1) || senha.equals(senha1)) {
                        aux = true;
                    }else aux = false;
=======

    public Pessoa buscaPessoa(String user){
        Pessoa pessoa = new Pessoa();
        try {
            PreparedStatement stm = con.prepareStatement("select nome,senha,pessoa_id from pessoas where nome = ?");
            stm.setString(1,user);
            stm.execute();
            ResultSet rs = stm.executeQuery();
            rs.next();
                pessoa.setNome(rs.getString("nome"));
                pessoa.setId(rs.getInt("pessoa_id"));
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return pessoa;
    }

    public Integer verificaPessoa(String nome, String senha){
        Integer id = 0;
        try {
            PreparedStatement stm = con.prepareStatement("select * from pessoas");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String nomeBanco = rs.getString("nome");
                String senhaBanco = rs.getString("senha");
                if (nome.equals(nomeBanco) && senha.equals(senhaBanco)) {
                    id = rs.getInt("pessoa_id");
>>>>>>> 8387873385f63fb9cca39487df6c9e3e3f8a245b
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }
}
