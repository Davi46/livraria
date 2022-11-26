package service;

import model.Produto;

import java.util.List;

public interface ICaixaService {
    void realizarCompra(List<Produto> produtos) throws Exception;
}
