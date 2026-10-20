package Ejersicio4y5.ejersicio4;


public class main {

    public static void main(String[] args) {
        suma sum = new suma();
        resta res = new resta();

        double a = 10;
        double b = 5;

        System.out.println("Suma: " + sum.calcular(a, b));
        System.out.println("Resta: " + res.calcular(a, b));
    }

}
