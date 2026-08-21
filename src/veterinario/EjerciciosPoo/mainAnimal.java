package veterinario.EjerciciosPoo;
import java.util.Scanner;

public class mainAnimal {
    public static void main(String[] args) {
        Scanner scam = new Scanner(System.in);
        int opcion = 0;
        
        do {
            System.out.println("***************biblioteca de animales Menu****************");
            System.out.println("1. crear perro");
            System.out.println("2. crear gato");
            System.out.println("3. crear elefante y perro con peso");
            System.out.println("4. Salir");

            opcion = scam.nextInt();


            switch (opcion) {
                case 1:
                    Animal animal1 = new Animal(10, "Firulais", 4, "Samoyedo", "guau guau");
                    animal1.mostrarInformacion();
                    animal1.hacerSonido();

                    break;
                case 2:
                       Animal animal2 = new Animal(2, "Michicote", 2,"persa","Miau Miau");
                    animal2.mostrarInformacion();
                    animal2.hacerSonido();
                    break;
                case 3:
                    elefante animal3 = new elefante(3, "Elefante", 10,"Africano",10.2,"Barrito");
                    animal3.mostrarInformacion();
                    animal3.hacerSonido();

                    perro animal4 = new perro(4, "Perro", 5,"Labrador",5.1,"Guau Guau");
                    animal4.mostrarInformacion();
                    animal4.hacerSonido();
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 4);

        scam.close();
    }


}