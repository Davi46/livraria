package model;

import java.util.List;

public class AlbumMusica extends Produto{
    private List<String> musicasBandas;
    private List<Genero> generos;
    private List<String> selos;

    public AlbumMusica(String nome, int id, double valor, TipoProduto tipoProduto, List<String> musicasBandas, List<Genero> generos, List<String> selos, boolean isAdulto) {
        super(nome, id, valor, tipoProduto, isAdulto);
        this.musicasBandas = musicasBandas;
        this.generos = generos;
        this.selos = selos;
    }

    public List<String> getMusicasBandas() {
        return musicasBandas;
    }

    public void setMusicasBandas(List<String> musicasBandas) {
        this.musicasBandas = musicasBandas;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<String> getSelos() {
        return selos;
    }

    public void setSelos(List<String> selos) {
        this.selos = selos;
    }

    @Override
    public String toString() {
        return "AlbumMusica{" +
                "nome='" + this.getNome() + '\'' +
                ", id=" + this.getId() +
                ", valor=" + this.getValor() +
                ", tipoProduto=" + this.getTipoProduto() +
                ", isAdulto= " + this.isAdulto() +
                ", musicasBandas=" + musicasBandas +
                ", generos=" + generos +
                ", selos=" + selos +
                '}';
    }
}
