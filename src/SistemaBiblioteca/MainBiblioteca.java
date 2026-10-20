package SistemaBiblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class MainBiblioteca {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Material> biblioteca = inicializarMateriales();
        Usuario usuario = new Usuario("juanchito");
        SimularTiempo tiempo = new SimularTiempo();

        int opcion = 0;
        while (opcion != 7) {
            System.out.println("\nSistema de Biblioteca");
            System.out.println("1. Consultar materiales");
            System.out.println("2. Consultar disponibilidad");
            System.out.println("3. Prestar material");
            System.out.println("4. Devolver material");
            System.out.println("5. Avanzar tiempo");
            System.out.println("6. Consultar multas");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarMateriales(biblioteca);
                    break;
                case 2:
                    Material materialDisponibilidad = seleccionarMaterial(scanner, biblioteca);
                    if (materialDisponibilidad != null) {
                        materialDisponibilidad.disponibilidad();
                    }
                    break;
                case 3:
                    GestionPrestamo materialPrestamo = seleccionarPrestamo(scanner, biblioteca);
                    if (materialPrestamo != null) {
                        materialPrestamo.prestar(usuario, tiempo);
                    }
                    break;
                case 4:
                    GestionPrestamo materialDevolucion = seleccionarPrestamo(scanner, biblioteca);
                    if (materialDevolucion != null) {
                        materialDevolucion.devolver(usuario, tiempo);
                    }
                    break;
                case 5:
                    System.out.print("Ingrese la cantidad de días a avanzar: ");
                    int dias = scanner.nextInt();
                    try {
                        tiempo.avanzarDias(dias);
                        System.out.println("Tiempo avanzado. Día actual: " + tiempo.getDiaActual());
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    consultarMultas(biblioteca, tiempo);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static List<Material> inicializarMateriales() {
        List<Material> materiales = new ArrayList<>();
        materiales.add(new Libros("Java para principiantes", "Libro", "Juan Perez", "Alfaomega"));
        materiales.add(new Libros("Programacion orientada a objetos", "Libro", "Ana Gomez", "McGraw Hill"));
        materiales.add(new Revista("Tecnologia hoy"));
        materiales.add(new Revista("Ciencia y futuro"));
        return materiales;
    }

    private static void mostrarMateriales(List<Material> materiales) {
        System.out.println("\nMateriales disponibles en la biblioteca:");
        for (int i = 0; i < materiales.size(); i++) {
            System.out.println("\n[" + (i + 1) + "]");
            materiales.get(i).consultar();
        }
    }

    private static Material seleccionarMaterial(Scanner scanner, List<Material> materiales) {
        mostrarMateriales(materiales);
        System.out.print("Seleccione el numero del material: ");
        int indice = scanner.nextInt() - 1;
        if (indice < 0 || indice >= materiales.size()) {
            System.out.println("Material invalido.");
            return null;
        }
        return materiales.get(indice);
    }

    private static GestionPrestamo seleccionarPrestamo(Scanner scanner, List<Material> materiales) {
        Material material = seleccionarMaterial(scanner, materiales);
        if (material == null) {
            return null;
        }
        if (!(material instanceof GestionPrestamo)) {
            System.out.println("Este material no esta habilitado para prestamos.");
            return null;
        }
        return (GestionPrestamo) material;
    }

    private static void consultarMultas(List<Material> materiales, SimularTiempo tiempo) {
        for (Material material : materiales) {
            if (material instanceof Libros) {
                Libros libro = (Libros) material;
                long multaActual = libro.calcularMulta(tiempo.getDiaActual());
                System.out.println("\n" + libro.nombrelibro + ":");
                System.out.println("Multa actual: $" + multaActual);
                if (multaActual > 0) {
                    System.out.println("Restriccion: " + (tiempo.getDiaActual() + 30));
                }
            } else if (material instanceof Revista) {
                Revista revista = (Revista) material;
                long multaActual = revista.calcularMulta(tiempo.getDiaActual());
                System.out.println("\n" + revista.nombrelibro + ":");
                System.out.println("Multa actual: $" + multaActual);
                if (multaActual > 0) {
                    System.out.println("Restriccion: " + (tiempo.getDiaActual() + 30));
                }
            }
        }
    }
}