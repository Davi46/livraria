package model;

import java.util.List;

public class Filme extends Produto {
    private String estudio;
    private List<String> diretores;
    private List<Genero> generos;
    private List<String> produtores;

    public Filme(String nome, int id, double valor, TipoProduto tipoProduto, String estudio, List<String> diretores, List<Genero> generos, List<String> produtores) {
        super(nome, id, valor, tipoProduto);
        this.estudio = estudio;
        this.diretores = diretores;
        this.generos = generos;
        this.produtores = produtores;
    }

    public String getEstudio() {
        return estudio;
    }

    public void setEstudio(String estudio) {
        this.estudio = estudio;
    }

    public List<String> getDiretores() {
        return diretores;
    }

    public void setDiretores(List<String> diretores) {
        this.diretores = diretores;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<String> getProdutores() {
        return produtores;
    }

    public void setProdutores(List<String> produtores) {
        this.produtores = produtores;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "nome='" + this.getNome() + '\'' +
                ", id=" + this.getId() +
                ", valor=" + this.getValor() +
                ", tipoProduto=" + this.getTipoProduto() +
                ", estudio='" + estudio + '\'' +
                ", diretores=" + diretores +
                ", generos=" + generos +
                ", produtores=" + produtores +
                '}';
    }
}