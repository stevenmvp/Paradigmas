package TallerParadigmas2;

public class ConsultarSaldo extends Dinero {


    public ConsultarSaldo(double saldo) {
        super(saldo);
    }

    public void consultar() {
        System.out.println("Su saldo actual es: " + getSaldo());
    }
}
