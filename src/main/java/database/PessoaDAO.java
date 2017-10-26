package database;

import modelo.Pessoa;

import java.sql.*;

public class PessoaDAO {

    private final Connection con;

    public PessoaDAO() {
        this.con = ConectaMysql.getConnection();
    }

    public void registraPessoa(Pessoa pessoa) throws SQLException {
        String sql = "insert into pessoas(nome)values(?)";
        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, pessoa.getNome());
            stm.execute();
            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int idGerado = rs.getInt(1);
            pessoa.setId(idGerado);
        }
    }
    public boolean verificaPessoa(String nome) throws SQLException {
        String sql = "select * from pessoas";
        boolean aux = false;
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            try (ResultSet rs = stm.getResultSet()) {
                while (rs.next()) {
                    String nome1 = rs.getString("nome");
                    if (nome.equals(nome1)) {
                        aux = true;
                    }else aux = false;
                }
            }
        }
        return aux;
    }
}
