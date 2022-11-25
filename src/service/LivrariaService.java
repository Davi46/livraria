package service;

public class LivrariaService {
     private CarrinhoCompraService carrinhoCompraService;

     public LivrariaService() {
          this.carrinhoCompraService = carrinhoCompraService;
     }

     public void novaCompra(){
          carrinhoCompraService = new CarrinhoCompraService();
     }

     public void addItemCarrinho(int idProduto, int quantidade){
          try {
               carrinhoCompraService.addItemCarrinho(idProduto, quantidade);
          } catch (Exception e) {
               System.out.println(e.getMessage());
          }
     }

     public void finalizarCompra() throws Exception {
          carrinhoCompraService.checkout();
     }
}