package TallerParadigmas2;

public interface MetodoPago {

        void realizarPago();

        default void pagoProcessado() {
            System.out.println("El pago ha sido procesado correctamente.");
        }
}
