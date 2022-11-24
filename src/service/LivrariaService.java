package service;


import model.Caixa;
import model.Produto;
import model.TipoProduto;

public class LivrariaService {
     private CarrinhoCompraService carrinhoCompraService;
     private Caixa caixa;

     public LivrariaService() {
          this.caixa = new Caixa();
          this.carrinhoCompraService = carrinhoCompraService;
     }

     public void novaCompra(){
          carrinhoCompraService = new CarrinhoCompraService(caixa);
     }

     public void addItemCarrinho(int idProduto, int quantidade){
          try {
               carrinhoCompraService.addItemCarrinho(idProduto, quantidade);
          } catch (Exception e) {
               System.out.println(e.getMessage());
          }
     }

     public void finalizarCompra(){
          carrinhoCompraService.checkout();
     }
}