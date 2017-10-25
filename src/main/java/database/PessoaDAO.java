package database;

import modelo.Pessoa;

import java.sql.*;

public class PessoaDAO {

    private final Connection con;

    public PessoaDAO(Connection con) {
        this.con = con;
    }

    public void registraPessoa(Pessoa pessoa) throws SQLException{
        String sql = "insert into pessoas(nome)values(?)";
        try(PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
            stm.setString(1, pessoa.getNome());
            stm.execute();

            ResultSet rs = stm.getGeneratedKeys();
            rs.next();
            int idGerado = rs.getInt(1);
            System.out.println(idGerado);
            pessoa.setId(idGerado);
        }



    }
}
