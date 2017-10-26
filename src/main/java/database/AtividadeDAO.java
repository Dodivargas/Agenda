package database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import modelo.Atividade;
import modelo.Pessoa;

import static java.lang.String.valueOf;

public class AtividadeDAO {

    private final Connection con;

    public AtividadeDAO() {
        this.con = ConectaMysql.getConnection();
    }

    public boolean criaAtividade(Atividade atividade , Pessoa pessoa) throws SQLException {

        String sql = "insert into atividades(pessoa_id,nome,horainicio,horafim,tipo)values(?,?,?,?,?)";

        try (PreparedStatement stm = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stm.setString(1, valueOf(pessoa.getId()));
            stm.setString(2, atividade.getNome());
            stm.setString(3, atividade.getHoraIncio());
            stm.setString(4, atividade.getHoraFim());
            stm.setString(5, atividade.getTipo());
            stm.execute();
            return true;
        }
    }

    public void removerAtividade(Integer id) throws SQLException {

        String sql = "DELETE FROM atividades WHERE atividade_id = ?";

        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1,id);
            stm.execute();
        }

    }

    public boolean editarAtividade(Atividade atividade, Integer id) throws SQLException {
        String sql = "UPDATE atividades SET nome = ?, horainicio = ?, horafim = ?,tipo = ? WHERE atividade_id = ?";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1,atividade.getNome());
            stm.setString(2,atividade.getHoraIncio());
            stm.setString(3,atividade.getHoraFim());
            stm.setString(4,atividade.getTipo());
            stm.setInt(5,id);
            stm.execute();
        }
    return true;
    }

    public int selecionaAtividade(String horaInicio) throws SQLException {
        String sql = "select atividade_id from atividades where horainicio = ?;";
        Integer PegaIdAretornar = 0;
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1,horaInicio);
            stm.execute();
            try(ResultSet rs = stm.getResultSet()){
                rs.next();
                PegaIdAretornar = rs.getInt("id");
            }
        }
        return PegaIdAretornar;
    }

    public List<Atividade> listaAtividades(Atividade atividade , Pessoa pessoa) throws SQLException {

        List<Atividade> atividades = new ArrayList<>();

        String sql = "select * from atividades";

        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.execute();
            try(ResultSet rs = stm.getResultSet()){
                while(rs.next()){
                    Integer id = rs.getInt("pessoa_id");
                    String nome = rs.getString("nome");
                    String horainicio = rs.getString("horainicio");
                    String horafim  = rs.getString("horafim");
                    String tipo = rs.getString("tipo");
                    Atividade atividade1 = new Atividade(nome,horainicio,horafim,tipo,id);
                    atividades.add(atividade1);
                }
            }
        }
        return atividades;
    }
}
