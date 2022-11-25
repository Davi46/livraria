package model;

public class Produto {
    private String nome;
    private int id;
    private double valor;

    private boolean isAdulto;

    public Produto(String nome, int id, double valor, TipoProduto tipoProduto, boolean isAdulto) {
        this.nome = nome;
        this.id = id;
        this.valor = valor;
        this.tipoProduto = tipoProduto;
        this.isAdulto = isAdulto;
    }

    private TipoProduto tipoProduto;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getValor() {
        return valor;
    }

    public boolean isAdulto() {
        return isAdulto;
    }

    public void setAdulto(boolean adulto) {
        isAdulto = adulto;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", id=" + id +
                ", valor=" + valor +
                ", tipoProduto=" + tipoProduto +
                ", isAdulto= " + this.isAdulto() +
                ", isAdulto=" + isAdulto +
                '}';
    }
}