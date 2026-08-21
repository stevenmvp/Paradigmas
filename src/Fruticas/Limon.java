package Fruticas;

public class Limon extends Fruta {

    public Limon(int cantidad, int precio) {
        super(cantidad, precio);
    }

    @Override
    public void mostrarSabor(){
        System.out.println("El sabor del limon es acido");
    }

    @Override
    public int precioFruta(int cantidad){
        return cantidad * 1500;
    }

}
