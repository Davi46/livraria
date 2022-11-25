package repository;

import model.Genero;
import model.Livro;
import model.TipoProduto;
import java.util.ArrayList;
import java.util.List;

public class LivroEstoqueRepository extends EstoqueRepository<Livro> {
    public LivroEstoqueRepository() {
        carregarEstoqueLivro();
    }

    public void carregarEstoqueLivro() {
        List<Genero> generos = new ArrayList<>();
        generos.add(new Genero("Tecnologia"));

        Livro livro = new Livro("Clean Code", 5, 250, TipoProduto.LIVRO, generos, "Robert Cecil Martin", "Alta Books", true);
        this.addProduto(livro);
    }
}