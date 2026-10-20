package Ejersicio4y5.ejersicio3;

public class main {

    public static void main(String[] args) {
        Dispositivo[] dispositivos = {new Ventilador(), new Bombilo()};

        for (Dispositivo dispositivo : dispositivos) {
            dispositivo.encender();
        }
    }

}
