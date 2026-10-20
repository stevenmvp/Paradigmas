package SistemaNotificaciones;

public class EmailNotificacion implements Notificacion {

    private String email;

    public EmailNotificacion(String email) {
        this.email = email;
    }

    @Override
    public void enviar(String mensaje) {
        System.out.println("Enviando notificación por correo electrónico a " + email + ": " + mensaje);
    }

}
