package repository;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepository <T extends Produto>{
    private List<T> produtos;

    public EstoqueRepository() {
        this.produtos = new ArrayList<>();
    }

    public void setProdutos(List<T> produtos) {
        this.produtos = produtos;
    }

    public List<T> getProdutos() {
        return produtos;
    }

    public T getProduto(int id){
        for(T t : produtos){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public void addProduto(T produto){
        produtos.add(produto);
    }

    public boolean deleteProduto(T produto){
        return produtos.remove(produto);
    }
}