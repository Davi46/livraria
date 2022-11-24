package service;

import model.*;
import repository.EstoqueRepository;
import java.util.ArrayList;
import java.util.List;

public class EstoqueService {
    private static EstoqueRepository<AlbumMusica> estoqueAlbunsMusicas;
    private static EstoqueRepository<Brinquedo> estoqueBrinquedos;
    private static EstoqueRepository<Filme> estoqueFilmes;
    private static EstoqueRepository<Jogo> estoqueJogos;
    private static EstoqueRepository<Livro> estoqueLivros;

    private static List<Produto> estoqueGeral;

    public EstoqueService() {
        estoqueAlbunsMusicas = new EstoqueRepository();
        estoqueBrinquedos= new EstoqueRepository();
        estoqueFilmes = new EstoqueRepository();
        estoqueJogos = new EstoqueRepository();
        estoqueLivros= new EstoqueRepository();

        //Simulando uma carga do Banco de Dados
        carregarEstoque();
        carregarEstoqueGeral();
    }

    private void carregarEstoque() {
        List<String> diretores = new ArrayList<>();
        diretores.add("Roberto Sabtucci");
        List<Genero> generos = new ArrayList<>();
        generos.add(new Genero("Comedia"));
        List<String> produtores = new ArrayList<>();
        produtores.add("Caio Gullane");
        produtores.add("Fabiano Gullane");

        Filme filme1 = new Filme("Até que a sorte nos separe", 1, 50, TipoProduto.FILME, "Paris Filmes", diretores,generos, produtores);
        Filme filme2 = new Filme("Até que a sorte nos separe2", 3, 50, TipoProduto.FILME, "Paris Filmes", diretores,generos, produtores);

        Brinquedo carrinho = new Brinquedo("Carrinho", 2, 10, TipoProduto.BRINQUEDO, "Carrinho de controle remoto");
        Brinquedo boneca = new Brinquedo("Boneca", 4, 10, TipoProduto.BRINQUEDO, "Boneca de plastico");

        addProduto(filme1);
        addProduto(filme1);
        addProduto(filme1);
        addProduto(filme1);
        addProduto(filme2);
        addProduto(filme2);
        addProduto(filme2);
        addProduto(filme2);
        addProduto(carrinho);
        addProduto(carrinho);
        addProduto(carrinho);
        addProduto(carrinho);
        addProduto(boneca);
        addProduto(boneca);
        addProduto(boneca);
        addProduto(boneca);
        addProduto(boneca);
    }

    public static void carregarEstoqueGeral(){
        estoqueGeral = new ArrayList<>();
        estoqueAlbunsMusicas.getProdutos().forEach(p -> estoqueGeral.add(p));
        estoqueBrinquedos.getProdutos().forEach(p -> estoqueGeral.add(p));
        estoqueFilmes.getProdutos().forEach(p -> estoqueGeral.add(p));
        estoqueJogos.getProdutos().forEach(p -> estoqueGeral.add(p));
        estoqueLivros.getProdutos().forEach(p -> estoqueGeral.add(p));
    }

    public void addProduto(Produto produto){
        if (AlbumMusica.class.equals(produto.getClass())) {
            estoqueAlbunsMusicas.addProduto((AlbumMusica) produto);
        } else if (Brinquedo.class.equals(produto.getClass())) {
            estoqueBrinquedos.addProduto((Brinquedo) produto);
        }else if (Filme.class.equals(produto.getClass())) {
            estoqueFilmes.addProduto((Filme) produto);
        }else if (Jogo.class.equals(produto.getClass())) {
            estoqueJogos.addProduto((Jogo) produto);
        }else if (Livro.class.equals(produto.getClass())) {
            estoqueLivros.addProduto((Livro) produto);
        }
    }

    public boolean removerProduto(Produto produto){
        boolean contemItem = false;
        if (AlbumMusica.class.equals(produto.getClass())) {
            contemItem = estoqueAlbunsMusicas.deleteProduto((AlbumMusica) produto);
        } else if (Brinquedo.class.equals(produto.getClass())) {
            contemItem = estoqueBrinquedos.deleteProduto((Brinquedo) produto);
        }else if (Filme.class.equals(produto.getClass())) {
            contemItem = estoqueFilmes.deleteProduto((Filme) produto);
        }else if (Jogo.class.equals(produto.getClass())) {
            contemItem = estoqueJogos.deleteProduto((Jogo) produto);
        }else if (Livro.class.equals(produto.getClass())) {
            contemItem = estoqueLivros.deleteProduto((Livro) produto);
        }

        return contemItem;
    }

    public Produto getProduto(int id){
        carregarEstoqueGeral();
        for(Produto t : estoqueGeral){
            if(t.getId() == id){
                return t;
            }
        }
        return null;
    }

    public static List<Produto> getEstoqueGeral() {
        carregarEstoqueGeral();
        return estoqueGeral;
    }

    public int getQtdItensPorTipo(TipoProduto tipoProduto){
        List<Produto> produtosPorTipo = new ArrayList<>();
        for (Produto produto: estoqueGeral) {
            if(produto.getTipoProduto() == tipoProduto){
                produtosPorTipo.add(produto);
            }
        }

       return produtosPorTipo.size();
    }

    public static List<Produto> getItensPorTipo(TipoProduto tipoProduto){
        carregarEstoqueGeral();
        List<Produto> produtosPorTipo = new ArrayList<>();
        for (Produto produto: estoqueGeral) {
            if(produto.getTipoProduto() == tipoProduto){
                produtosPorTipo.add(produto);
            }
        }

        return produtosPorTipo;
    }

    public static void listarEstoque(){
        System.out.println("*--------------------LISTA DE PRODUTOS DO ESTOQUE--------------------*");
        EstoqueService.getEstoqueGeral().forEach(p -> System.out.println(p.toString()));
        System.out.println("*--------------------------------------------------------------------*");

        System.out.println("*------------------------------FILMES--------------------------------*");
        System.out.println("Total de Filmes no Estoque:" + getItensPorTipo(TipoProduto.FILME).size());

        System.out.println("*--------------------------LISTA DE FILMES---------------------------*");
        getItensPorTipo(TipoProduto.FILME).forEach(p -> System.out.println(p.toString()));
        System.out.println("*--------------------------------------------------------------------*");

        System.out.println("*------------------------------BRINQUEDOS----------------------------*");
        System.out.println("Total de Brinquedos no Estoque:" + getItensPorTipo(TipoProduto.BRINQUEDO).size());

        System.out.println("*--------------------------LISTA DE BRINQUEDOS-----------------------*");
        getItensPorTipo(TipoProduto.BRINQUEDO).forEach(p -> System.out.println(p.toString()));
        System.out.println("*--------------------------------------------------------------------*");

        System.out.println("*---------------------------ALBUNS DE MÚSICA--------------------------*");
        System.out.println("Total de Albuns de Música no Estoque:" + getItensPorTipo(TipoProduto.ALBUM_MUSICA).size());

        System.out.println("*----------------------LISTA DE ALBUNS DE MÚSICA----------------------*");
        getItensPorTipo(TipoProduto.ALBUM_MUSICA).forEach(p -> System.out.println(p.toString()));
        System.out.println("*--------------------------------------------------------------------*");

        System.out.println("*---------------------------JOGOS------------------------------------*");
        System.out.println("Total de Albuns de Música no Estoque:" + getItensPorTipo(TipoProduto.ALBUM_MUSICA).size());

        System.out.println("*----------------------LISTA DE JOGOS--------------------------------*");
        getItensPorTipo(TipoProduto.JOGO).forEach(p -> System.out.println(p.toString()));
        System.out.println("*--------------------------------------------------------------------*");

        System.out.println("*------------------------------LIVROS--------------------------------*");
        System.out.println("Total de Filmes no Estoque:" + getItensPorTipo(TipoProduto.FILME).size());

        System.out.println("*--------------------------LISTA DE LIVROS---------------------------*");
        getItensPorTipo(TipoProduto.LIVRO).forEach(p -> System.out.println(p.toString()));
        System.out.println("*--------------------------------------------------------------------*");
    }
}