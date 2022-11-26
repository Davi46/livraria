package service;

import model.Caixa;
import model.Cliente;
import model.Produto;
import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompraService implements  ICarrinhoCompraService{
    private static ICaixaService caixaService;
    private static EstoqueService estoqueService;
    private List<Produto> produtosComprados;

    private Cliente cliente;

    @Override
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CarrinhoCompraService() {
        this.estoqueService = new EstoqueService();
        this.caixaService = new CaixaService();
        produtosComprados = new ArrayList<>();

        System.out.println("*--------------------ESTOQUE INICIAL--------------------*");
        estoqueService.listarEstoque();
        System.out.println("*--------------------------------------------------------------------*");
    }

    @Override
    public void addItemCarrinho(int idProduto, int quantidade) throws Exception {
        Produto produto = estoqueService.getProduto(idProduto);

        if(produto == null){
            throw new Exception("Item não contém no estoque. Favor escolher novo produto");
        }

        ClienteValidacaoService.validaProdutoAdulto(produto, this.cliente);

        for(int i =0; i < quantidade; i++){
            produtosComprados.add(produto);
            estoqueService.removerProduto(produto);
        }
    }

    @Override
    public void removerItemCarrinho(int idProduto, int quantidade){
        Produto produto = getProdutoCarrinho(idProduto);
        for(int i =0; i < quantidade; i++){
            produtosComprados.remove(produto);
            estoqueService.addProduto(produto);
        }
    }

    @Override
    public Produto getProdutoCarrinho(int idProduto){
        for(Produto t : produtosComprados){
            if(t.getId() == idProduto){
                return t;
            }
        }
        return null;
    }

    @Override
    public void checkout() throws Exception {
        caixaService.realizarCompra(this.produtosComprados);
    }
}