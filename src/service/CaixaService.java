package service;

import model.Caixa;
import model.Produto;
import model.TipoDesconto;
import java.util.List;

public class CaixaService implements  ICaixaService{
    private static Caixa caixa;

    public CaixaService(){
        this.caixa = new Caixa();
    }

    @Override
    public void realizarCompra(List<Produto> produtos) throws Exception {
        double valorCompra= calcularValorTotal(produtos);
        double valorDesconto = verificaEAplicaDescontos(produtos, valorCompra);
        caixa.addEntrada((valorCompra - valorDesconto));
        imprimirCompra(produtos, valorCompra, valorDesconto);
    }

    private double calcularValorTotal(List<Produto> produtos){
        double valorTotal = 0;
        for (Produto p: produtos) {
            valorTotal += p.getValor();
        }

        return valorTotal;
    }

    private double verificaEAplicaDescontos(List<Produto> produtos, double valorTotal) throws Exception {
        List<TipoDesconto> contemDescontos = DescontosServices.isValidaDesconto(produtos);
        
        double valorDesconto = 0;
        if(contemDescontos.size() >= 1){
            for (TipoDesconto l: contemDescontos) {
                valorDesconto += DescontosServices.aplicaDesconto(l, valorTotal);
            }
        }

        return valorDesconto;
    }

    private void imprimirCompra(List<Produto> produtosComprados, double valorCompra, double valorDesconto) {
        System.out.println("*--------------------RESUMO DA COMPRA--------------------*");
        System.out.println("Total de itens comprados:" + produtosComprados.size());
        System.out.println("*--------------------ITENS COMPRADOS--------------------*");
        produtosComprados.forEach(p -> System.out.println("Produto: " + p.getNome() + " - Valor: R$" + p.getValor()));
        System.out.println("VALOR TOTAL DA COMPRA: R$" + valorCompra);
        System.out.println("VALOR DE DESCONTO: R$" + valorDesconto);
        System.out.println("VALOR A PAGAR: R$" + (valorCompra - valorDesconto));
        System.out.println("*--------------------------------------------------------------------*");
    }
}