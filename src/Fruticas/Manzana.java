package Fruticas;

public class Manzana extends Fruta {

    public Manzana(int cantidad, int precio) {
        super(cantidad, precio);
    }
    @Override
    public void mostrarSabor(){
        System.out.println("El sabor de la manzana es dulce");
    }
    @Override
    public int precioFruta(int cantidad) {
        return cantidad * 2500;
    }


}
