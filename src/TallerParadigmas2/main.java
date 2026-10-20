package TallerParadigmas2;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner LeerNum = new Scanner(System.in);
        int ciclo=0;
        int opccion =0;


       

        do{
            
            System.out.println("==============*INICIANDO SISTEMA*==============");
            System.out.println("===============*CAJERO  COLPLATA*==============");
            System.out.println("===============================================");

            Dinero saldo = new Dinero(10000);

            do{
            ciclo=0;
            opccion=0;
                MostrarMenu verMenu = new MostrarMenu();
                verMenu.mostrarMenu();
                opccion=LeerNum.nextInt();

            switch(opccion){

                case 1:
                    DepositarDinero depositar = new DepositarDinero(saldo.getSaldo());
                    depositar.depositar();
                    break;

                case 2:
                    RetirarDinero ObRetirar = new RetirarDinero(saldo.getSaldo());
                    ObRetirar.retirar();
                    break;

                case 3:
                    ConsultarSaldo ConSaldo = new ConsultarSaldo(saldo.getSaldo());
                    ConSaldo.consultar();
                    break;

                case 4:
                    System.out.println("Gracias por usar el cajero");
                    break;

                default:
                    System.out.println("Opcion no valida");
            }

            


            }while(opccion!=4);

            
            System.out.println("Desea realizar otra operacion? (1=si, 2=no)");
            ciclo=LeerNum.nextInt();

        }while(ciclo==1);

        LeerNum.close();


    }

}
