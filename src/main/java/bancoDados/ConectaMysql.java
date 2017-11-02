package bancoDados;
//Classes necessárias para uso de Banco de dados //

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

//Início da classe de conexão//

public class ConectaMysql {

    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String url = "jdbc:mysql://localhost:3306/agenda";
    private static final String user = "root";
    private static final String senha = "dodivargas";
    private static boolean status;

    public static Connection getConnection() {
        Connection connection = null;
        try {

            Class.forName(driver);

            connection = DriverManager.getConnection(url, user, senha);

            if (connection != null) {

                status = true;

            } else {

                status = false;

            }

            return connection;

        } catch (ClassNotFoundException | SQLException e) {

            throw new RuntimeException("Erro na conexão: ", e);

        }


    }

    public static void fechaConexao(Connection con) {

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        status = false;

    }

    public static void fechaConexao(Connection con, PreparedStatement stmt) {

        fechaConexao(con);
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        status = false;
    }

    public static void fechaConexao(Connection con, PreparedStatement stmt, ResultSet rs) {

        fechaConexao(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        status = false;
    }

    public static boolean statusConection() {

        return status;
    }
}