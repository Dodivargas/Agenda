package modelo;

import database.ConectaMysql;
import org.junit.Test;
import java.sql.Connection;
import static org.junit.Assert.assertEquals;

public class TestaMysql {


    @Test
    public void TestaConexao(){

        Connection con = ConectaMysql.getConnection();

        boolean respostaEsperada = true;

        assertEquals(ConectaMysql.statusConection(), respostaEsperada);
    }
    @Test
    public void TestaFimConexao(){

        Connection con = ConectaMysql.getConnection();

        ConectaMysql.fechaConexao(con);

        boolean respostaEsperada = false;

        assertEquals(ConectaMysql.statusConection(), respostaEsperada);
    }
}
