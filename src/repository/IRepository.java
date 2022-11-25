package repository;

import model.Produto;
import java.util.List;

public interface IRepository <T extends Produto> {
    List<T> getProdutos() ;

    T getProduto(int id);

    void addProduto(T produto);

    public boolean deleteProduto(T produto);

    public void alterarProduto(T produto);
}