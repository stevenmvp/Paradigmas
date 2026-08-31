package Figuras;

public class Cuadrado extends Figura {
    private final double lado;

    public Cuadrado(double lado) {
        validarPositivo(lado, "lado");
        this.lado = lado;
    }

    @Override
    public double area() {
        return lado * lado;
    }

    @Override
    public double perimetro() {
        return 4 * lado;
    }

    private void validarPositivo(double valor, String nombre) {
        if (valor <= 0) {
            throw new IllegalArgumentException(nombre + " debe ser mayor que cero");
        }
    }
}