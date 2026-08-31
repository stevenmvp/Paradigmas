package Figuras;

public class Triangulo extends Figura {
    private final double base;
    private final double altura;
    private final double lado1;
    private final double lado2;

    public Triangulo(double base, double altura, double lado1, double lado2) {
        validarPositivo(base, "base");
        validarPositivo(altura, "altura");
        validarPositivo(lado1, "lado1");
        validarPositivo(lado2, "lado2");

        if (lado1 + lado2 <= base || lado1 + base <= lado2 || lado2 + base <= lado1) {
            throw new IllegalArgumentException("Los lados no forman un triangulo valido");
        }

        this.base = base;
        this.altura = altura;
        this.lado1 = lado1;
        this.lado2 = lado2;
    }

    @Override
    public double area() {
        return (base * altura) / 2;
    }

    @Override
    public double perimetro() {
        return base + lado1 + lado2;
    }

    private void validarPositivo(double valor, String nombre) {
        if (valor <= 0) {
            throw new IllegalArgumentException(nombre + " debe ser mayor que cero");
        }
    }
}