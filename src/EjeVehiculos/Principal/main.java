package EjeVehiculos.Principal;

import EjeVehiculos.Vehiculos.*;

import java.util.Scanner;
import EjeVehiculos.MetodosVehiculo.*;

public class main {
        public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
        int option=0;
        Carro carro = null;
        moto moto = null;

        



        do{
             System.out.println("Bienvenido al sistema de vehículos");
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear un carro");
            System.out.println("2. Crear una moto");
            System.out.println("3. Mostrar información de un vehículos guardados");
            System.out.println("0. Salir");
             option = leer.nextInt();

             switch (option) {
                case 1:
                    System.out.println("Creacion De Carro:");
                    System.out.println("Ingrese la marca del carro:");
                    String marcaCarro = leer.next();
                    System.out.println("Ingrese el modelo del carro:");
                    String modeloCarro = leer.next();
                    System.out.println("Ingrese el precio base del carro:");
                    Double precioBaseCarro = leer.nextDouble();
                    System.out.println("Ingrese el número de puertas del carro:");
                    int numeroPuertas = leer.nextInt();


                    carro = new Carro(marcaCarro, modeloCarro, precioBaseCarro, numeroPuertas);
                    System.out.println("Carro creado exitosamente.");
                    break;
                case 2:
                    System.out.println("Creacion De Moto:");
                    System.out.println("Ingrese la marca de la moto:");
                    String marcaMoto = leer.next();
                    System.out.println("Ingrese el modelo de la moto:");
                    String modeloMoto = leer.next();
                    System.out.println("Ingrese el precio base de la moto:");
                    Double precioBaseMoto = leer.nextDouble();
                    System.out.println("Ingrese el cilindraje de la moto:");
                    int cilindraje = leer.nextInt();
                    System.out.println("Ingrese si la moto es deportiva (si/no):");
                    String deportiva = leer.next();


                    moto = new moto(marcaMoto, modeloMoto, precioBaseMoto, cilindraje, deportiva);
                    System.out.println("Moto creada exitosamente.");
                    break;
                case 3:
                    System.out.println("Mostrar información de vehículos guardados:");
                    if (carro != null) {
                        carro.mostrarInformacion();
                        MetodosCarro metodosCarro = new MetodosCarro();
                        metodosCarro.arrancar();
                        metodosCarro.apagar();

                    }
                    if (moto != null) {
                        moto.mostrarInformacion();
                        metodosMoto metodosMoto = new metodosMoto();
                        metodosMoto.arrancar();
                        metodosMoto.apagar();
                    }


                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
                    break;
             }

        }while (option != 0);
       

        



    }

}
