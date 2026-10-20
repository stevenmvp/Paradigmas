package SistemaNotificaciones;

public class SmsNotificacion implements Notificacion {

    private String numero;

    public SmsNotificacion(String numero) {
        this.numero = numero;
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando notificación por SMS a " + numero + ": " + mensaje);
    }

}
