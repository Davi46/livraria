package model;

public class Brinquedo extends Produto{
    private String tipo;

    public Brinquedo(String nome, int id, double valor, TipoProduto tipoProduto, String tipo) {
        super(nome, id, valor, tipoProduto);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Brinquedo{" +
                "nome='" + this.getNome() + '\'' +
                ", id=" + this.getId() +
                ", valor=" + this.getValor() +
                ", tipoProduto=" + this.getTipoProduto() +
                ", tipo='" + tipo + '\'' +
                '}';
    }


}