package service;

import model.Produto;
import model.TipoDesconto;
import model.TipoProduto;
import java.util.ArrayList;
import java.util.List;

public class DescontosServices {
    public static List<TipoDesconto> isValidaDesconto(List<Produto> produtos){
        List<TipoDesconto> descontosAptos = new ArrayList<>();
        boolean isAptoDescontoLivros = validaDescontoLivros(produtos);

        if(isAptoDescontoLivros){
            descontosAptos.add(TipoDesconto.LIVROS_MAIOR_2OO);
        }

        return descontosAptos;
    }

    public static boolean validaDescontoLivros(List<Produto> produtos) {
        double valorTotalLivros = 0;
        for (Produto p: produtos) {
            if(p.getTipoProduto() == TipoProduto.LIVRO){
                valorTotalLivros += p.getValor();
            }
        }

        return valorTotalLivros > 200;
    }

    public static double aplicaDesconto(TipoDesconto tipoDesconto, double valorTotal) throws Exception {
        switch (tipoDesconto){
            case LIVROS_MAIOR_2OO :
                return (15 * valorTotal)/100;
            default: throw new Exception("Desconto Inexistente");
        }
    }
}