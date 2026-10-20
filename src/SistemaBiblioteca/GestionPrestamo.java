package SistemaBiblioteca;

public interface GestionPrestamo extends Operaciones {


    void prestar();

    void devolver();

    void prestar(SimularTiempo tiempo);

    void prestar(Usuario usuario, SimularTiempo tiempo);


    void devolver(SimularTiempo tiempo);

    void devolver(Usuario usuario, SimularTiempo tiempo);

    void tiempodeprestamo();


    void multas();

}
