package Figuras;

public class MainFiguras {
    public static void main(String[] args) {
        Figura cuadrado = new Cuadrado(4);
        Figura rectangulo = new Rectangulo(5, 3);
        Figura triangulo = new Triangulo(6, 4, 5, 5);

        mostrarResultados("Cuadrado", cuadrado);
        mostrarResultados("Rectangulo", rectangulo);
        mostrarResultados("Triangulo", triangulo);
    }

    private static void mostrarResultados(String nombre, Figura figura) {
        System.out.println(nombre);
        System.out.println("Area: " + figura.area());
        System.out.println("Perimetro: " + figura.perimetro());
        System.out.println();
    }
}