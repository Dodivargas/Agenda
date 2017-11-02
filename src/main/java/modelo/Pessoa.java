package modelo;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private String nome;
    private String senha;
    private int id;
    private List<Atividade> atividades;
    private List<Atividade> atividadesConcluidas;

    public Pessoa(String nome, String senha, int id) {
        this.nome = nome;
        this.senha = senha;
        this.id = id;
        atividades = new ArrayList<Atividade>();
    }
    public Pessoa(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
        atividades = new ArrayList<Atividade>();
    }
    public Pessoa(){
        atividades = new ArrayList<Atividade>();
    }
    public List<Atividade> getAtividadesConcluidas() {
        return atividadesConcluidas;
    }
    public void setAtividadesConcluidas(List<Atividade> atividadesConcluidas) {
        this.atividadesConcluidas = atividadesConcluidas;
    }
    public List<Atividade> getAtividades() {
        return atividades;
    }
    public void setAtividades(List<Atividade> atividades) {
        this.atividades = atividades;
    }
    public String getSenha() {
        return senha;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}