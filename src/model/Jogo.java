package model;

public class Jogo extends Produto{
    private String distribuidora;
    private Genero genero;
    private String estudio;

    public Jogo(String nome, int id, double valor, TipoProduto tipoProduto, String distribuidora, Genero genero, String estudio, boolean isAdulto) {
        super(nome, id, valor, tipoProduto, isAdulto);
        this.distribuidora = distribuidora;
        this.genero = genero;
        this.estudio = estudio;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    @Override
    public String toString() {
        return "Jogo{" +
                "nome='" + this.getNome() + '\'' +
                ", id=" + this.getId() +
                ", valor=" + this.getValor() +
                ", tipoProduto=" + this.getTipoProduto() +
                ", isAdulto= " + this.isAdulto() +
                ", distribuidora='" + distribuidora + '\'' +
                ", genero='" + genero + '\'' +
                ", estudio='" + estudio + '\'' +
                '}';
    }
}
