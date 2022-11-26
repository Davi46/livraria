package service;

import model.Cliente;
import model.Produto;

public interface ICarrinhoCompraService {
    void addItemCarrinho(int idProduto, int quantidade) throws Exception ;

    void removerItemCarrinho(int idProduto, int quantidade);

    Produto getProdutoCarrinho(int idProduto);

    void checkout() throws Exception ;

    void setCliente(Cliente cliente);
}