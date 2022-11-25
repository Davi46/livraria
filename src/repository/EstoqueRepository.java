package repository;

import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class EstoqueRepository <T extends Produto> implements  IRepository<T>{
    private List<T> produtos;

    public EstoqueRepository() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public List<T> getProdutos() {
        return produtos;
    }

    @Override
    public T getProduto(int id){
        for(T t : produtos){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    @Override
    public void addProduto(T produto){
        produtos.add(produto);
    }

    @Override
    public boolean deleteProduto(T produto){
        return produtos.remove(produto);
    }

    @Override
    public void alterarProduto(T produto) {
        for(T t : produtos){
            if(t.getId() == produto.getId()){
                deleteProduto(t);
                addProduto(produto);
            }
        }
    }
}