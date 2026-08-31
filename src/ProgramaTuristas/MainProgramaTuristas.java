package ProgramaTuristas;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

import Viajes.Actividad;
import Viajes.Destino;
import Viajes.Excursion;
import Viajes.EstadoReserva;
import Viajes.Hotel;
import Viajes.Museo;
import Viajes.Parque;
import Viajes.Reserva;
import Viajes.Restaurante;
import Viajes.Rol;
import Viajes.SistemaViajes;
import Viajes.Tour;
import Viajes.Usuario;

public class MainProgramaTuristas {
    private static final Scanner scanner = new Scanner(System.in);
    private static final SistemaViajes sistema = new SistemaViajes();
    private static final PersistenciaJson persistencia = new PersistenciaJson();

    public static void main(String[] args) {
        persistencia.cargar(sistema);
        crearDatosIniciales();
        Usuario usuario = iniciarSesion();
        if (usuario != null) {
            if (usuario.getRol() == Rol.ADMINISTRADOR) menuAdministrador();
            else menuCliente(usuario);
        }
        persistencia.guardar(sistema);
        scanner.close();
        System.out.println("Programa finalizado.");
    }

    private static void crearDatosIniciales() {
        if (!sistema.getUsuarios().isEmpty()) return;
        sistema.agregarUsuario(new Usuario("admin", "Administrador", "admin@viajes.com", "0000000000", "admin123", Rol.ADMINISTRADOR));
        sistema.agregarUsuario(new Usuario("1001", "Cliente Demo", "cliente@viajes.com", "3000000000", "cliente123", Rol.CLIENTE));
        Destino cartagena = new Destino("D01", "Cartagena", "Colombia", 850000, "Playa", true);
        Destino medellin = new Destino("D02", "Medellin", "Colombia", 620000, "Cultural", true);
        sistema.agregarDestino(cartagena);
        sistema.agregarDestino(medellin);
        sistema.agregarHotel(new Hotel("H01", "Hotel del Mar", cartagena, "Doble", 180000, 5));
        sistema.agregarHotel(new Hotel("H02", "Hotel Central", medellin, "Sencilla", 140000, 4));
        sistema.agregarActividad(new Tour("A01", "Centro historico", cartagena, 65000, "09:00", 10, "Luis", "Plaza Mayor"));
        sistema.agregarActividad(new Museo("A02", "Museo de Antioquia", medellin, 30000, "10:00", 20, "Arte", "Coleccion principal"));
        sistema.conectarDestinos(cartagena, medellin);
        persistencia.guardar(sistema);
        System.out.println("Se creo el catalogo inicial en la carpeta datos/.");
    }

    private static Usuario iniciarSesion() {
        for (int intento = 1; intento <= 3; intento++) {
            System.out.println("\n========== INICIO DE SESION ==========");
            String documento = leerTexto("Documento: ");
            String contrasena = leerTexto("Contrasena: ");
            Usuario usuario = sistema.getUsuarios().stream()
                    .filter(item -> item.getDocumento().equals(documento) && item.autenticar(contrasena))
                    .findFirst().orElse(null);
            if (usuario != null) {
                System.out.println("Bienvenido, " + usuario.getNombre() + ".");
                return usuario;
            }
            System.out.println("Credenciales incorrectas. Intento " + intento + " de 3.");
        }
        return null;
    }

    private static void menuCliente(Usuario usuario) {
        int opcion;
        do {
            System.out.println("\n========== MENU CLIENTE ==========");
            System.out.println("1. Ver catalogo");
            System.out.println("2. Buscar destinos por precio");
            System.out.println("3. Ver mis reservas");
            System.out.println("4. Crear reserva");
            System.out.println("5. Cancelar una de mis reservas");
            System.out.println("6. Ver conexiones entre destinos");
            System.out.println("0. Cerrar sesion");
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1: verCatalogo(); break;
                case 2: buscarPorPrecio(usuario); break;
                case 3: verMisReservas(usuario); break;
                case 4: crearReserva(usuario); break;
                case 5: cancelarReserva(usuario); break;
                case 6: System.out.println(sistema.getConexiones()); break;
                case 0: break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void menuAdministrador() {
        int opcion;
        do {
            System.out.println("\n========== MENU ADMINISTRADOR ==========");
            System.out.println("1. Ver catalogo completo");
            System.out.println("2. Crear usuario cliente");
            System.out.println("3. Crear destino");
            System.out.println("4. Crear hotel");
            System.out.println("5. Crear actividad");
            System.out.println("6. Eliminar destino, hotel o actividad");
            System.out.println("7. Ver todas las reservas");
            System.out.println("8. Conectar destinos");
            System.out.println("9. Atender cola de espera");
            System.out.println("0. Cerrar sesion");
            opcion = leerEntero("Seleccione una opcion: ");
            switch (opcion) {
                case 1: verCatalogo(); break;
                case 2: registrarCliente(); break;
                case 3: registrarDestino(); break;
                case 4: registrarHotel(); break;
                case 5: registrarActividad(); break;
                case 6: eliminarElemento(); break;
                case 7: verTodasLasReservas(); break;
                case 8: conectarDestinos(); break;
                case 9: gestionarEspera(); break;
                case 0: break;
                default: System.out.println("Opcion invalida.");
            }
        } while (opcion != 0);
    }

    private static void registrarCliente() {
        String documento = leerTexto("Documento: ");
        if (buscarUsuario(documento) != null) { System.out.println("Documento ya registrado."); return; }
        sistema.agregarUsuario(new Usuario(documento, leerTexto("Nombre: "), leerTexto("Correo: "),
                leerTexto("Telefono: "), leerTexto("Contrasena: "), Rol.CLIENTE));
        guardarYConfirmar("Cliente registrado.");
    }

    private static void registrarDestino() {
        sistema.agregarDestino(new Destino(leerTexto("Codigo: "), leerTexto("Ciudad: "), leerTexto("Pais: "),
                leerDoublePositivo("Precio aproximado: "), leerTexto("Tipo: "), leerBooleano("Disponible (s/n): ")));
        guardarYConfirmar("Destino registrado.");
    }

    private static void registrarHotel() {
        if (sistema.getDestinos().isEmpty()) { System.out.println("No hay destinos."); return; }
        Destino destino = seleccionarDestino();
        sistema.agregarHotel(new Hotel(leerTexto("Codigo: "), leerTexto("Nombre: "), destino,
                leerTexto("Tipo de habitacion: "), leerDoublePositivo("Precio por noche: "), leerEnteroPositivo("Habitaciones: ")));
        guardarYConfirmar("Hotel registrado.");
    }

    private static void registrarActividad() {
        if (sistema.getDestinos().isEmpty()) { System.out.println("No hay destinos."); return; }
        Destino destino = seleccionarDestino();
        String id = leerTexto("Codigo: "), nombre = leerTexto("Nombre: "), horario = leerTexto("Horario: ");
        double precio = leerDoublePositivo("Precio: ");
        int cupos = leerEnteroPositivo("Cupos: ");
        System.out.println("1 Tour | 2 Restaurante | 3 Museo | 4 Parque | 5 Excursion");
        int tipo = leerEntero("Tipo: ");
        Actividad actividad;
        switch (tipo) {
            case 1: actividad = new Tour(id, nombre, destino, precio, horario, cupos, leerTexto("Guia: "), leerTexto("Punto de encuentro: ")); break;
            case 2: actividad = new Restaurante(id, nombre, destino, precio, horario, cupos, leerTexto("Comida: "), leerBooleano("Vestimenta formal (s/n): ")); break;
            case 3: actividad = new Museo(id, nombre, destino, precio, horario, cupos, leerTexto("Tematica: "), leerTexto("Exposicion: ")); break;
            case 4: actividad = new Parque(id, nombre, destino, precio, horario, cupos, leerBooleano("Es natural (s/n): ")); break;
            case 5: actividad = new Excursion(id, nombre, destino, precio, horario, cupos, leerTexto("Dificultad: "), leerTexto("Equipo: ")); break;
            default: System.out.println("Tipo invalido."); return;
        }
        sistema.agregarActividad(actividad);
        guardarYConfirmar("Actividad registrada.");
    }

    private static void eliminarElemento() {
        System.out.println("1 Destino | 2 Hotel | 3 Actividad");
        int tipo = leerEntero("Tipo: ");
        String codigo = leerTexto("Codigo: ");
        boolean eliminado = tipo == 1 ? sistema.eliminarDestino(codigo) : tipo == 2 ? sistema.eliminarHotel(codigo) : sistema.eliminarActividad(codigo);
        if (eliminado) guardarYConfirmar("Elemento eliminado."); else System.out.println("No se encontro el elemento.");
    }

    private static void verCatalogo() {
        System.out.println("\nDESTINOS"); sistema.getDestinos().forEach(System.out::println);
        System.out.println("HOTELES"); sistema.getHoteles().forEach(System.out::println);
        System.out.println("ACTIVIDADES"); sistema.getActividades().forEach(a -> System.out.println(a + " | cupos: " + a.getCuposDisponibles()));
    }

    private static void buscarPorPrecio(Usuario usuario) {
        double maximo = leerDoublePositivo("Precio maximo: ");
        usuario.registrarBusqueda("Destinos hasta " + maximo);
        List<Destino> resultados = sistema.buscarDestinosPorPrecio(maximo);
        if (resultados.isEmpty()) System.out.println("No hay resultados."); else resultados.forEach(System.out::println);
    }

    private static void crearReserva(Usuario usuario) {
        Destino destino = seleccionarDestino();
        Hotel hotel = seleccionarHotel(destino);
        Actividad actividad = seleccionarActividad(destino);
        if (hotel == null && actividad == null) { System.out.println("Seleccione un hotel o actividad."); return; }
        if ((hotel != null && !hotel.verificarDisponibilidad()) || (actividad != null && !actividad.verificarDisponibilidad())) {
            if (actividad != null) { actividad.solicitarCupo(usuario); System.out.println("Actividad agotada: usuario agregado a la cola."); }
            else System.out.println("No hay disponibilidad.");
            return;
        }
        Reserva reserva = sistema.registrarReserva(leerTexto("Codigo de reserva: "), usuario, destino, hotel, actividad, leerFecha());
        try { reserva.confirmarReserva(); guardarYConfirmar("Reserva confirmada. Total: $" + reserva.calcularTotal(leerEnteroPositivo("Noches: "))); }
        catch (IllegalStateException error) { System.out.println(error.getMessage()); }
    }

    private static void verMisReservas(Usuario usuario) {
        sistema.getReservas().stream().filter(r -> r.getUsuario() == usuario)
                .forEach(r -> System.out.println(r.getCodigoReserva() + " | " + r.getDestino().getCiudad() + " | " + r.getEstado()));
    }

    private static void cancelarReserva(Usuario usuario) {
        Reserva reserva = sistema.buscarReserva(leerTexto("Codigo de reserva: "));
        if (reserva == null || reserva.getUsuario() != usuario) { System.out.println("Reserva no encontrada en su cuenta."); return; }
        if (reserva.getEstado() == EstadoReserva.CONFIRMADA) { reserva.cancelarReserva(); guardarYConfirmar("Reserva cancelada."); }
        else System.out.println("La reserva no esta confirmada.");
    }

    private static void verTodasLasReservas() { sistema.getReservas().forEach(r -> System.out.println(r.getCodigoReserva() + " | " + r.getUsuario().getNombre() + " | " + r.getEstado())); }
    private static void conectarDestinos() { Destino a = seleccionarDestino(), b = seleccionarDestino(); sistema.conectarDestinos(a, b); guardarYConfirmar("Conexion creada."); }
    private static void gestionarEspera() { Actividad a = seleccionarActividadGeneral(); Usuario u = a.atenderListaEspera(); System.out.println(u == null ? "No hay usuarios esperando o cupos disponibles." : "Cupo asignado a " + u.getNombre()); guardarYConfirmar("Cola actualizada."); }

    private static Destino seleccionarDestino() { List<Destino> lista = sistema.getDestinos(); for (int i = 0; i < lista.size(); i++) System.out.println((i + 1) + ". " + lista.get(i)); return lista.get(indiceValido("Destino: ", lista.size())); }
    private static Hotel seleccionarHotel(Destino d) { List<Hotel> lista = sistema.getHoteles().stream().filter(h -> h.getDestino() == d).toList(); for (int i = 0; i < lista.size(); i++) System.out.println((i + 1) + ". " + lista.get(i)); if (lista.isEmpty()) return null; int n = leerEntero("Hotel (0 ninguno): "); return n == 0 ? null : lista.get(indiceValido(n, lista.size())); }
    private static Actividad seleccionarActividad(Destino d) { List<Actividad> lista = sistema.getActividades().stream().filter(a -> a.getDestino() == d).toList(); for (int i = 0; i < lista.size(); i++) System.out.println((i + 1) + ". " + lista.get(i)); if (lista.isEmpty()) return null; int n = leerEntero("Actividad (0 ninguna): "); return n == 0 ? null : lista.get(indiceValido(n, lista.size())); }
    private static Actividad seleccionarActividadGeneral() { List<Actividad> lista = sistema.getActividades(); for (int i = 0; i < lista.size(); i++) System.out.println((i + 1) + ". " + lista.get(i)); return lista.get(indiceValido("Actividad: ", lista.size())); }
    private static Usuario buscarUsuario(String documento) { return sistema.getUsuarios().stream().filter(u -> u.getDocumento().equals(documento)).findFirst().orElse(null); }
    private static int indiceValido(String mensaje, int cantidad) { return indiceValido(leerEntero(mensaje), cantidad); }
    private static int indiceValido(int n, int cantidad) { while (n < 1 || n > cantidad) n = leerEntero("Ingrese una opcion entre 1 y " + cantidad + ": "); return n - 1; }
    private static void guardarYConfirmar(String mensaje) { persistencia.guardar(sistema); System.out.println(mensaje); }
    private static int leerEntero(String m) { while (true) try { return Integer.parseInt(leerTexto(m)); } catch (NumberFormatException e) { System.out.println("Ingrese un entero valido."); } }
    private static int leerEnteroPositivo(String m) { int n; do { n = leerEntero(m); } while (n <= 0); return n; }
    private static double leerDoublePositivo(String m) { while (true) try { double n = Double.parseDouble(leerTexto(m)); if (n > 0) return n; } catch (NumberFormatException e) { } }
    private static boolean leerBooleano(String m) { return leerTexto(m).equalsIgnoreCase("s"); }
    private static LocalDate leerFecha() { while (true) try { return LocalDate.parse(leerTexto("Fecha (AAAA-MM-DD): ")); } catch (DateTimeParseException e) { System.out.println("Formato invalido."); } }
    private static String leerTexto(String m) { String s; do { System.out.print(m); s = scanner.nextLine().trim(); } while (s.isEmpty()); return s; }
}
