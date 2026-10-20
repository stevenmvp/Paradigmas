package SistemaNotificaciones;

import java.util.List;

public class Main {

    public static void main (String[] args) {
        
        String mensaje = "Tarea de programacion entregada";

        
        Notificacion emailNotificacion = new EmailNotificacion("dallo@gmail.com");
        Notificacion smsNotificacion = new SmsNotificacion("3202068874");

        List<String> mensajes = List.of(mensaje,mensaje,mensaje);

        for (String mensajeRepetido : mensajes) {
            emailNotificacion.enviar(mensajeRepetido);
            smsNotificacion.enviar(mensajeRepetido);
        }
    }

}
