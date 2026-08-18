package veterinario;

import java.util.Scanner;

public class VeterinariaMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== VETERINARIA ===");
            System.out.println("1. Registrar animal");
            System.out.println("2. Mostrar información de personal");
            System.out.println("3. Registrar cliente");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("ID del animal: ");
                    int idAnimal = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre del animal: ");
                    String nombreAnimal = scanner.nextLine();
                    System.out.print("Edad del animal: ");
                    int edadAnimal = scanner.nextInt();
                    scanner.nextLine();

                    Animal animal = new Animal(idAnimal, nombreAnimal, edadAnimal);
                    System.out.println("Animal registrado: " + animal.getNombre() + " (" + animal.getEdad() + " años)");
                    animal.move();
                    break;

                case 2:
                    Persona empleado = new Persona(10, "Ana", 28, "Veterinaria", "0999999999",
                            "ana@vet.com", "Quito", "1712345678");
                    empleado.mostrarInformacion();
                    empleado.actualizarContacto("0987654321", "ana.nueva@vet.com");
                    System.out.println("Nuevo contacto: " + empleado.getTelefono() + " / " + empleado.getEmail());
                    break;

                case 3:
                    Cliente cliente = new Cliente(20, "Luis", 35, "Cliente", "0981111111",
                            "luis@mail.com", "Guayaquil", "1711122233", "Perro", "Premium");
                    cliente.mostrarInformacion();
                    System.out.println("Cliente creado correctamente");
                    break;

                case 4:
                    System.out.println("Gracias por usar la veterinaria.");
                    break;

                default:
                    System.out.println("Opción inválida. Intente otra vez.");
                    break;
            }
        } while (opcion != 4);

        scanner.close();
    }
}
