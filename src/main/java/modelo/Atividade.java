package modelo;

public class Atividade implements Comparable{


    private Integer id = 0;
    private String nome;
    private String horaIncio;
    private String horaFim;
    private String tipo;
    private Integer hora;




    public Atividade(String nome, String horaIncio, String horaFim, String tipo, Integer id) {
        this.nome = nome;
        this.horaIncio = horaIncio;
        this.horaFim = horaFim;
        this.tipo = tipo;
        this.id = id;
    }

    public Atividade(String nome, String horaIncio, String horaFim, String tipo) {
        this.horaIncio = horaIncio;
        this.horaFim = horaFim;
        this.tipo = tipo;
        String aux = horaIncio.substring(0,2);
        this.nome = nome;
    }

    public Atividade(){

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHoraIncio() {
        return horaIncio;
    }

    public void setHoraIncio(String horaIncio) {
        this.horaIncio = horaIncio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Integer getHora() {
        String aux = horaIncio.substring(0,2);
        hora = Integer.parseInt(aux);
        return hora;
    }

    @Override
    public String toString(){
        String s = "Atividade: " + getNome() +  " hora do inicio: " + getHoraIncio() + " hora do fim: " +getHoraFim()+ " tipo de atividade: " +getTipo() + "\n";
        return s;
    }

    @Override
    public int compareTo(Object o) {
        Atividade atividade = (Atividade) o;
        if (this.getHora() < atividade.getHora()){
            return -1;
        }else if (this.getHora() > atividade.getHora()){
            return 1;
        }else return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Atividade atividade = (Atividade) o;

        if (getHoraIncio() != null ? !getHoraIncio().equals(atividade.getHoraIncio()) : atividade.getHoraIncio() != null)
            return false;
        if (getHoraFim() != null ? !getHoraFim().equals(atividade.getHoraFim()) : atividade.getHoraFim() != null)
            return false;
        if (getTipo() != null ? !getTipo().equals(atividade.getTipo()) : atividade.getTipo() != null) return false;
        return getHora() != null ? getHora().equals(atividade.getHora()) : atividade.getHora() == null;
    }

    @Override
    public int hashCode() {
        int result = getHoraIncio() != null ? getHoraIncio().hashCode() : 0;
        result = 31 * result + (getHoraFim() != null ? getHoraFim().hashCode() : 0);
        result = 31 * result + (getTipo() != null ? getTipo().hashCode() : 0);
        result = 31 * result + (getHora() != null ? getHora().hashCode() : 0);
        return result;
    }


}
