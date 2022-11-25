package repository;

import model.Livro;

public class LivroEstoqueRepository extends EstoqueRepository<Livro>{
    public LivroEstoqueRepository(){
        carregarEstoqueLivro();
    }

    public void carregarEstoqueLivro(){
        ///TODO Criar estoque
    }
}
