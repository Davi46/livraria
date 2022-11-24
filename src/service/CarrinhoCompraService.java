package service;

import model.Caixa;
import model.Produto;
import model.TipoProduto;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoCompraService {
    private static Caixa caixa;
    private static EstoqueService estoqueService;
    private double valorCompra;
    private List<Produto> produtosComprados;

    public CarrinhoCompraService(Caixa caixa) {
        this.caixa = caixa;
        this.estoqueService = new EstoqueService();

        produtosComprados = new ArrayList<>();

        System.out.println("*--------------------ESTOQUE INICIAL--------------------*");
        estoqueService.listarEstoque();
        System.out.println("*--------------------------------------------------------------------*");
    }

    public void addItemCarrinho(int idProduto, int quantidade) throws Exception {
        for(int i =0; i < quantidade; i++){
            Produto produto = estoqueService.getProduto(idProduto);
            if(produto == null){
                throw new Exception("Item não contém no estoque. Favor escolher novo produto");
            }

            produtosComprados.add(produto);
            valorCompra += produto.getValor();
            estoqueService.removerProduto(produto);
        }
    }

    public void removerItemCarrinho(int idProduto, int quantidade){
        Produto produto = getProdutoCarrinho(idProduto);
        for(int i =0; i < quantidade; i++){
            produtosComprados.remove(produto);
            estoqueService.addProduto(produto);
        }
    }

    public Produto getProdutoCarrinho(int idProduto){
        for(Produto t : produtosComprados){
            if(t.getId() == idProduto){
                return t;
            }
        }
        return null;
    }

    public void checkout(){
        caixa.addEntrada(valorCompra);

        System.out.println("*--------------------RESUMO DA COMPRA--------------------*");
        System.out.println("Total de itens comprados:" + produtosComprados.size());
        System.out.println("*--------------------ITENS COMPRADOS--------------------*");
        produtosComprados.forEach(p -> System.out.println("Produto: " + p.getNome() + " - Valor: R$" + p.getValor()));
        System.out.println("VALOR TOTAL DA COMPRA: R$" + this.valorCompra);
        System.out.println("*--------------------------------------------------------------------*");

        System.out.println("*--------------------ESTOQUE FINAL--------------------*");
        estoqueService.listarEstoque();
        System.out.println("*--------------------------------------------------------------------*");
    }
}
