package TallerParadigmas2;

import java.util.Scanner;

public class DepositarDinero extends Dinero {

    double nuevoSaldo;

    public DepositarDinero(double saldo) {
        super(saldo);
    }


    public void depositar() {
        Scanner Depositar = new Scanner(System.in);
        System.out.println("Ingrese la cantidad a depositar: ");
        int cantidad = Depositar.nextInt();
        nuevoSaldo += cantidad;
        setSaldo(nuevoSaldo);
        System.out.println("Deposito exitoso. Su nuevo saldo es: " + getSaldo());
        Depositar.close();
    }


}
