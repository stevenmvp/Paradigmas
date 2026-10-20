package TallerParadigmas2;

import java.util.Scanner;

public class RetirarDinero extends Dinero{

    public RetirarDinero(double saldo) {
        super(saldo);
    }
    
    public void retirar(){

        System.out.println("Ingrese la cantidad a retirar: ");
        Scanner Retirar = new Scanner(System.in);
        int cantidad = Retirar.nextInt();
        if(cantidad <= getSaldo()){
            setSaldo(getSaldo()-cantidad);
            System.out.println("su retiro fue exitoso. por un valor de "+cantidad+". su nuevo saldo es: "+getSaldo());
        } else {
            System.out.println("Fondos insuficientes. ingrese un valor menor al mencionado");
        }

        Retirar.close();

    }
}
