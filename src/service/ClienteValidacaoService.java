package service;

import model.Cliente;
import model.Produto;

public class ClienteValidacaoService {
    public static boolean validaCliente(Cliente cliente){
        boolean isValid = true;
        if(cliente.getNome().isBlank() ||
            cliente.getCpf().isBlank() ||
            cliente.getRg().isBlank() ||
            cliente.getDataNascimento().toString().isBlank()
        ){
            isValid = false;
        }
        return isValid;
    }

    public static boolean validaMair18Anos(Cliente cliente){
        return cliente.getIdade()>=18;
    }

    public static void validaProdutoAdulto(Produto produto, Cliente cliente) throws Exception {
        if(produto.isAdulto()){
            if(cliente == null){
                throw new Exception("Para esse tipo de produto é necessário ter um cliente associado ao carrinho");
            }

            boolean clienteIsValid = validaCliente(cliente);

            if(!clienteIsValid){
                throw new Exception("Os dados do cliente não estão corretos");
            }

            boolean clienteMaior18Anos = validaMair18Anos(cliente);

            if(!clienteMaior18Anos){
                throw new Exception("O cliente não pode adquirir esse produto, pois sua idade é menor que a permitida para adquirir o produto.");
            }
        }
    }
}