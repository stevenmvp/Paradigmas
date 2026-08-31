package Eventos;

public class MainEventos {
	public static void main(String[] args) {
		Usuario usuario = new Usuario(1, "Ana López", "ana@correo.com",
				"123456789", "3001234567", "Calle 10", "28/08/2026");
		Evento evento = new Evento(1, "Conferencia de Java", "30/08/2026 10:00",
				"Auditorio principal", 100, 25000);
		Orden orden = new Orden(1, "28/08/2026");

		System.out.println("=== SOLICITAR EVENTO ===");
		System.out.println("Usuario: " + usuario.getNombre());
		System.out.println("Evento solicitado: " + evento.listarEvento());

		usuario.realizarOrden(orden);
		orden.solicitarEvento(evento);

		System.out.println("Evento agregado a la orden.");
		System.out.println("Total de la orden: " + orden.calcularTotal());
		System.out.println("Eventos en el historial: " + usuario.verHistorialDeOrden().size());
	}
}
