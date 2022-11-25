package model;

import java.util.List;

public class Livro extends Produto{
    private List<Genero> generos;
    private String escritor;
    private String editora;

    public Livro(String nome, int id, double valor, TipoProduto tipoProduto, List<Genero> generos, String escritor, String editora, boolean isAdulto) {
        super(nome, id, valor, tipoProduto, isAdulto);
        this.generos = generos;
        this.escritor = escritor;
        this.editora = editora;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public String getEscritor() {
        return escritor;
    }

    public void setEscritor(String escritor) {
        this.escritor = escritor;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + this.getNome() + '\'' +
                ", id=" + this.getId() +
                ", valor=" + this.getValor() +
                ", tipoProduto=" + this.getTipoProduto() +
                ", isAdulto= " + this.isAdulto() +
                ", generos=" + generos +
                ", escritor='" + escritor + '\'' +
                ", editora='" + editora + '\'' +
                '}';
    }
}