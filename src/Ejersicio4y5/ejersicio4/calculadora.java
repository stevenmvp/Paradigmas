package Ejersicio4y5.ejersicio4;

public class calculadora implements Operacion {

    private double valor;

    @Override
    public double calcular(double a, double b) {
        return a + b;
    }

    @Override
    public double getValor() {
        return valor;
    }

    @Override
    public void setValor(double valor) {
        this.valor = valor;
    }

}
