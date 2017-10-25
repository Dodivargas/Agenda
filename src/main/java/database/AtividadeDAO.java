package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Atividade;
import modelo.Pessoa;

import static java.lang.String.valueOf;

public class AtividadeDAO {

    private final Connection con;

    public AtividadeDAO(Connection con) {
        this.con = con;
    }
    public void criaAtividade(Atividade atividade , Pessoa pessoa) throws SQLException {

        String sql = "insert into atividades(pessoa_id,nome,horainicio,horafim,tipo)values(?,?,?,?,?)";

        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, valueOf(pessoa.getId()));
            stm.setString(2, atividade.getNome());
            stm.setString(3, atividade.getHoraIncio());
            stm.setString(4, atividade.getHoraFim());
            stm.setString(5, atividade.getTipo());
            stm.execute();
        }


    }
    public void ListaAtividades(Atividade atividade , Pessoa pessoa) throws SQLException {

        String sql = "insert into atividades(pessoa_id,nome,horainicio,horafim,tipo)values(?,?,?,?,?)";

        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, valueOf(pessoa.getId()));
            stm.setString(2, atividade.getNome());
            stm.setString(3, atividade.getHoraIncio());
            stm.setString(4, atividade.getHoraFim());
            stm.setString(5, atividade.getTipo());
            stm.execute();
        }


    }

}
