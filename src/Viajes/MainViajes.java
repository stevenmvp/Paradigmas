package Viajes;

import java.time.LocalDate;

public class MainViajes {
    public static void main(String[] args) {
        SistemaViajes sistema = new SistemaViajes();
        Usuario usuario = new Usuario("1001", "Ana Torres", "ana@correo.com", "3001234567");
        Destino destino = new Destino("D01", "Cartagena", "Colombia", 850000, "Playa", true);
        Hotel hotel = new Hotel("H01", "Hotel del Mar", destino, "Doble", 180000, 4);
        Tour tour = new Tour("A01", "Centro histórico", destino, 65000, "09:00", 2, "Luis", "Plaza Mayor");

        sistema.agregarUsuario(usuario);
        sistema.agregarDestino(destino);
        sistema.agregarHotel(hotel);
        sistema.agregarActividad(tour);
        usuario.registrarBusqueda("Cartagena");
        Reserva reserva = sistema.registrarReserva("R001", usuario, destino, hotel, tour, LocalDate.now());
        reserva.confirmarReserva();

        System.out.println("Reserva " + sistema.buscarReserva("R001").getEstado());
        System.out.println("Total por 3 noches: $" + reserva.calcularTotal(3));
    }
}