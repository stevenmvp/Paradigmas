package Viajes;

public interface IReservable {
    boolean verificarDisponibilidad();

    boolean reservarCupo();

    void liberarCupo();
}