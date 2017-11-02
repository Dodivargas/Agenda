package bancoDados;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
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
            return true;
        }
    }
    public Integer selecionaAtividade(String horaInicio, Pessoa pessoa) throws SQLException {
        String sql = "select atividade_id from atividades where horainicio = ? and pessoa_id = ?";
        Integer pegaIdAretornar = 0;
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setString(1,horaInicio);
            stm.setInt(2, pessoa.getId());
            stm.execute();
            try(ResultSet rs = stm.getResultSet()){
                rs.next();
                pegaIdAretornar = rs.getInt("atividade_id");
            }
        }
        return pegaIdAretornar;
    }
    public List<Atividade> listaAtividades(Pessoa pessoa) throws SQLException {

        List<Atividade> atividades = new ArrayList<>();
        String sql = "select * from atividades where pessoa_id = ?";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, pessoa.getId());
            stm.execute();
            try(ResultSet rs = stm.getResultSet()){
                while(rs.next()){
                    String nome = rs.getString("nome");
                    String horainicio = rs.getString("horainicio");
                    String horafim  = rs.getString("horafim");
                    String tipo = rs.getString("tipo");
                    Atividade atividade1 = new Atividade(nome,horainicio,horafim,tipo);
                    atividades.add(atividade1);
                }
            }
        }
        Collections.sort(atividades);
        return atividades;
    }
    public Atividade buscaAtividadeIndividualmente(Integer idABuscar) throws SQLException{
        String sql = "select nome,horainicio,horafim,tipo from atividades where atividade_id = ?";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, idABuscar);
            stm.execute();
            try (ResultSet rs = stm.getResultSet()) {
                rs.next();
                String nome = rs.getString("nome");
                String horainicio = rs.getString("horainicio");
                String horafim  = rs.getString("horafim");
                String tipo = rs.getString("tipo");
                Atividade atividade = new Atividade(nome,horainicio,horafim,tipo);
                return atividade;
            }
        }
    }

    public boolean concluirAtividade(Atividade atividade , Pessoa pessoa) throws SQLException {
        String sql = "insert into atividadesConcluidas(pessoa_id,nome,horainicio,horafim,tipo)values(?,?,?,?,?)";
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
    public List<Atividade> listaAtividadesConcluidas(Pessoa pessoa) throws SQLException {

        List<Atividade> atividades = new ArrayList<>();
        String sql = "select * from atividadesConcluidas where pessoa_id = ?";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, pessoa.getId());
            stm.execute();
            try(ResultSet rs = stm.getResultSet()){
                while(rs.next()){
                    String nome = rs.getString("nome");
                    String horainicio = rs.getString("horainicio");
                    String horafim  = rs.getString("horafim");
                    String tipo = rs.getString("tipo");
                    Atividade atividade1 = new Atividade(nome,horainicio,horafim,tipo);
                    atividades.add(atividade1);
                }
            }
        }
        Collections.sort(atividades);
        return atividades;
    }
    public boolean limpaAtividades(Pessoa pessoa) throws SQLException {
        String sql = "DELETE FROM atividades WHERE pessoa_id = ?";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, pessoa.getId());
            stm.execute();
            return true;
        }
    }

    public boolean limpaAtividadesConcluidas(Pessoa pessoa) throws SQLException {
        String sql = "DELETE FROM atividadesConcluidas WHERE pessoa_id = ?";
        try (PreparedStatement stm = con.prepareStatement(sql)) {
            stm.setInt(1, pessoa.getId());
            stm.execute();
            return true;
        }
    }
}
