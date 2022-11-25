package repository;

import model.Filme;
import model.Genero;
import model.TipoProduto;
import java.util.ArrayList;
import java.util.List;

public class FilmeEstoqueRepository extends EstoqueRepository<Filme>{

    public FilmeEstoqueRepository(){
        carregarEstoqueFilmes();
    }

    private void carregarEstoqueFilmes() {
        List<String> diretores = new ArrayList<>();
        diretores.add("Roberto Sabtucci");
        List<Genero> generos = new ArrayList<>();
        generos.add(new Genero("Comedia"));
        List<String> produtores = new ArrayList<>();
        produtores.add("Caio Gullane");
        produtores.add("Fabiano Gullane");

        Filme filme1 = new Filme("Até que a sorte nos separe", 1, 50, TipoProduto.FILME, "Paris Filmes", diretores,generos, produtores, false);
        Filme filme2 = new Filme("Até que a sorte nos separe2", 3, 50, TipoProduto.FILME, "Paris Filmes", diretores,generos, produtores, false);

        addProduto(filme1);
        addProduto(filme1);
        addProduto(filme1);
        addProduto(filme1);
        addProduto(filme2);
        addProduto(filme2);
        addProduto(filme2);
        addProduto(filme2);
    }
}