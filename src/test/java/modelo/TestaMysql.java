package modelo;

import database.ConectaMysql;
import org.junit.Test;

import java.awt.*;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import database.ConectaMysql;

import static org.junit.Assert.assertEquals;

class TestaMyslq{
    @Test
    public void TestaConexao(){

        Connection con = ConectaMysql.getConnection();

        String respostaEsperada = "Conectado com sucesso!";

        assertEquals(ConectaMysql.statusConection(), respostaEsperada);
    }
    @Test
    public void TestaFimConexao(){

        Connection con = ConectaMysql.getConnection();

        ConectaMysql.fechaConexao(con);

        String respostaEsperada = "conectou e foi fechado";

        assertEquals(ConectaMysql.statusConection(), respostaEsperada);
    }


}