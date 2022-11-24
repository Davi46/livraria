package model;

public class Caixa {
    private static Double valor;

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Caixa() {
        this.valor = Double.valueOf(0);
    }

    public void addEntrada(Double valorComprado){
        this.valor += valorComprado;
    }

    @Override
    public String toString() {
        return "Caixa{" +
                "valor=" + valor +
                '}';
    }
}