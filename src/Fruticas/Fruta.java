package Fruticas;

public abstract class Fruta {
    
    int cantidad;
    int precio;

    public Fruta(int cantidad, int precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    public abstract void mostrarSabor();

    //Metodo Funcional
    public void lavar(){
        System.out.println("Se esta lavando la fruta");
    }

    public abstract int precioFruta(int cantidad);
}
