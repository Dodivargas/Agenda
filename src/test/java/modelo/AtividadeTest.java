package modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import modelo.Pessoa;

import javax.smartcardio.ATR;

import static org.junit.Assert.*;

public class AtividadeTest {

    @Test
    public void shouldSortAtividade() {

        List<Atividade> atividades = new ArrayList<>();
        atividades.add(new Atividade("futebol","10:00", "12:00", "lazer"));
        atividades.add(new Atividade("futebol","09:00", "19:00", "lazer"));
        atividades.add(new Atividade("futebol","10:00", "12:00", "lazer"));
        atividades.add(new Atividade("futebol","02:00", "12:00", "lazer"));
        atividades.add(new Atividade("futebol","05:00", "16:00", "lazer"));

        List<Atividade> atividadesEsperadas = new ArrayList<>();
        atividadesEsperadas.add(new Atividade("futebol","02:00", "12:00", "lazer"));
        atividadesEsperadas.add(new Atividade("futebol","05:00", "16:00", "lazer"));
        atividadesEsperadas.add(new Atividade("futebol","09:00", "19:00", "lazer"));
        atividadesEsperadas.add(new Atividade("futebol","10:00", "12:00", "lazer"));
        atividadesEsperadas.add(new Atividade("futebol","10:00", "12:00", "lazer"));

        Collections.sort(atividades);

        assertEquals(atividades, atividadesEsperadas);
    }
    @Test
    public void adicionaAtividade(){

        Pessoa pessoa = new Pessoa();


        Atividade a = new Atividade("mortalpratras","11:00","12:00","Lazer");
        Atividade b = new Atividade("videogame","16:00","17:00","Lazer");

        pessoa.adicionaAtividadeDia(a);
        pessoa.adicionaAtividadeDia(b);

        List<Atividade> atividadesEsperadas = new ArrayList<>();

        atividadesEsperadas.add(new Atividade("mortalpratras","11:00","12:00","Lazer"));
        atividadesEsperadas.add(new Atividade("videogame","16:00","17:00","Lazer"));

        assertEquals(pessoa.getAtividades(), atividadesEsperadas);

    }


    @Test
    public void removeAtividade(){
        Pessoa pessoa = new Pessoa();

        Atividade a = new Atividade("futebol","14:00","15:00","Lazer");
        Atividade b = new Atividade("videogame","16:00","17:00","Lazer");
        Atividade c = new Atividade("mortalpratras","11:00","12:00","Lazer");

        pessoa.adicionaAtividadeDia(a);
        pessoa.adicionaAtividadeDia(b);
        pessoa.adicionaAtividadeDia(c);
        pessoa.removeAtividadeDia("futebol");

        List<Atividade> atividadesEsperadas = new ArrayList<>();

        atividadesEsperadas.add(new Atividade("mortalpratras","11:00","12:00","Lazer"));
        atividadesEsperadas.add(new Atividade("videogame","16:00","17:00","Lazer"));


        assertEquals(pessoa.getAtividades(), atividadesEsperadas);

    }
    @Test
    public void editaAtividade(){
        Pessoa pessoa = new Pessoa();

        Atividade a = new Atividade("futebol","14:00","15:00","Lazer");
        Atividade b = new Atividade("videogame","16:00","17:00","Lazer");
        Atividade c = new Atividade("mortalpratras","11:00","12:00","Lazer");

        pessoa.adicionaAtividadeDia(a);
        pessoa.adicionaAtividadeDia(b);
        pessoa.adicionaAtividadeDia(c);

        Atividade n = new Atividade("natação","15:00","16:00","Lazer");

        pessoa.editaAtividade("futebol",n);


        List<Atividade> atividadesEsperadas = new ArrayList<>();

        atividadesEsperadas.add(new Atividade("mortalpratras","11:00","12:00","Lazer"));
        atividadesEsperadas.add(new Atividade("natação","15:00","16:00","Lazer"));
        atividadesEsperadas.add(new Atividade("videogame","16:00","17:00","Lazer"));


        assertEquals(pessoa.getAtividades(), atividadesEsperadas);
    }
}