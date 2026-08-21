package coche;

public class main { 
    public static void main() {
        carro carro1 = new carro("Chevrolet", "2021", "Azul", "4");
        
        
        System.out.println("Marca del carro: " + carro1.getMarca());
        System.out.println("Modelo del carro: " + carro1.getModelo());
        System.out.println("Color del carro: " + carro1.getColor());
        System.out.println("Cantidad de llantas del carro: " + carro1.getCantidadLLantas());
        System.out.println(carro1.facturar());
        System.out.println();

        moto moto1 = new moto("Honda", "2022", "Rojo", "2");
        System.out.println("Marca de la moto: " + moto1.getMarca());
        System.out.println("Modelo de la moto: " + moto1.getModelo());
        System.out.println("Color de la moto: " + moto1.getColor());
        System.out.println("Cantidad de llantas de la moto: " + moto1.getCantidadLLantas());
         System.out.println(moto1.facturar());
        System.out.println();


        System.out.println("Modelo actual de la moto: " + moto1.getModelo());
        moto1.setModelo("2026");
        System.out.println("Modelo actualizado de la moto: " + moto1.getModelo());  

        System.out.println("Actualizacion de datos");
        System.out.println(moto1.facturar());
    }

}
