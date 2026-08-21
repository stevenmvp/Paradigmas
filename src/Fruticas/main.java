package Fruticas;

public class main {

    public static void main(String[] args) {

        Fruta fruta1 = new Manzana(3, 2300);
        Fruta fruta2 = new Limon(5, 4000);

        fruta1.mostrarSabor();
        fruta2.mostrarSabor();
        fruta1.lavar();
        fruta2.lavar();

        System.out.println("El precio de la manzana es: " + fruta1.precioFruta(2000));
        System.out.println("El precio del limon es: " + fruta2.precioFruta(3000));
    }
}
