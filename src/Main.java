import model.*;
import service.LivrariaService;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exceptio { 
        
        LivrariaService livrariaService = new LivrariaService();
        livrariaService.novaCompra();
        livrariaService.addCliente(new Cliente("Davi Almeida", "MG 12369863", "65366545455", LocalDate.of(1997,3,20)));

        livrariaService.addItemCarrinho(1, 2);
        livrariaService.addItemCarrinho(3, 1);
        livrariaService.addItemCarrinho(2, 1);
        livrariaService.addItemCarrinho(4, 2);
        livrariaService.addItemCarrinho(5, 1);

        livrariaService.finalizarCompra();
    }
}
