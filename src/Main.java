import model.*;
import service.EstoqueService;
import service.LivrariaService;

import java.util.ArrayList;
import java.util.List;

public class Main {





    public static void main(String[] args) throws Exception {
        /*carregarProdutos();
        EstoqueService.listarEstoque();*/


        LivrariaService livrariaService = new LivrariaService();
        livrariaService.novaCompra();
        livrariaService.addItemCarrinho(1, 2);
        livrariaService.addItemCarrinho(3, 1);
        livrariaService.addItemCarrinho(2, 1);
        livrariaService.addItemCarrinho(4, 2);

        livrariaService.finalizarCompra();
    }
}