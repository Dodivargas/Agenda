package modelo;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        atividadesEsperadas.add(new Atividade("coco","05:00", "16:00", "lazer"));
        atividadesEsperadas.add(new Atividade("futebol","09:00", "19:00", "lazer"));
        atividadesEsperadas.add(new Atividade("futebol","10:00", "12:00", "lazer"));
        atividadesEsperadas.add(new Atividade("futebol","10:00", "12:00", "lazer"));

        Collections.sort(atividades);

        assertEquals(atividades, atividadesEsperadas);
    }

}