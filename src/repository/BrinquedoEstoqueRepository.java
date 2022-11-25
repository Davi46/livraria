package repository;

import model.Brinquedo;
import model.TipoProduto;

public class BrinquedoEstoqueRepository extends EstoqueRepository<Brinquedo>{

    public BrinquedoEstoqueRepository(){
        carregarEstoqueBrinquedo();
    }

    public void carregarEstoqueBrinquedo(){
        Brinquedo carrinho = new Brinquedo("Carrinho", 2, 10, TipoProduto.BRINQUEDO, "Carrinho de controle remoto", false);
        Brinquedo boneca = new Brinquedo("Boneca", 4, 10, TipoProduto.BRINQUEDO, "Boneca de plastico", false);

        this.addProduto(carrinho);
        this.addProduto(carrinho);
        this.addProduto(carrinho);
        this.addProduto(carrinho);
        this.addProduto(boneca);
        this.addProduto(boneca);
        this.addProduto(boneca);
        this.addProduto(boneca);
        this.addProduto(boneca);
    }
}