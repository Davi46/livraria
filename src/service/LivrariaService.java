package service;

import model.Cliente;

public class LivrariaService {
     private ICarrinhoCompraService carrinhoCompraService;

     public LivrariaService() {
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

     public void addCliente(Cliente cliente){
          carrinhoCompraService.setCliente(cliente);
     }

     public void finalizarCompra() throws Exception {
          carrinhoCompraService.checkout();
     }
}