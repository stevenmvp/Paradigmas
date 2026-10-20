package SistemaBiblioteca;

public class Revista extends Material implements GestionPrestamo {

    private int fechaPrestamo = -1;
    private int fechaLimite = -1;
    private int fechaDevolucion = -1;
    private int restriccionHasta = -1;
    private long ultimaMulta;
    private Usuario usuarioPrestamo;

    public Revista(String nombre) {
        super(nombre, "Revista");
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
    }

    @Override
    public void prestar() {
        prestar(new SimularTiempo());
    }

    @Override
    public void prestar(SimularTiempo tiempo) {
        prestar(null, tiempo);
    }

    @Override
    public void prestar(Usuario usuario, SimularTiempo tiempo) {
        if (prestado) {
            System.out.println("La revista ya se encuentra prestada.");
            return;
        }
        if (usuario != null && !usuario.puedePrestar(tiempo)) {
            System.out.println("El usuario tiene restringido el servicio hasta: " + usuario.getRestriccionHasta());
            return;
        }
        this.usuarioPrestamo = usuario;
        this.fechaPrestamo = tiempo.getDiaActual();
        this.fechaLimite = tiempo.getDiaActual() + 7;
        this.fechaDevolucion = -1;
        this.restriccionHasta = -1;
        this.ultimaMulta = 0;
        this.prestado = true;
        System.out.println("Prestamo registrado. Fecha limite: " + fechaLimite);
    }

    @Override
    public void devolver() {
        devolver(new SimularTiempo());
    }

    @Override
    public void devolver(SimularTiempo tiempo) {
        devolver(usuarioPrestamo, tiempo);
    }

    @Override
    public void devolver(Usuario usuario, SimularTiempo tiempo) {
        if (!prestado) {
            System.out.println("La revista no se encuentra prestada.");
            return;
        }
        this.fechaDevolucion = tiempo.getDiaActual();
        long diasRetraso = Math.max(0, fechaDevolucion - fechaLimite);
        boolean aplicaMulta = diasRetraso > 5;
        long diasMulta = aplicaMulta ? diasRetraso - 5 : 0;
        this.ultimaMulta = diasMulta * 5000;
        this.restriccionHasta = aplicaMulta ? fechaDevolucion + 30 : -1;
        if (aplicaMulta && usuarioPrestamo != null) {
            usuarioPrestamo.restringirHasta(restriccionHasta);
        }
        this.prestado = false;
        System.out.println("Devolucion registrada.");
        multas();
        if (restriccionHasta >= 0) {
            System.out.println("Servicio de prestamo restringido hasta: " + restriccionHasta);
        }
        this.usuarioPrestamo = null;
    }

    @Override
    public void tiempodeprestamo() {
        if (fechaPrestamo < 0) {
            System.out.println("La revista aun no ha sido prestada.");
            return;
        }
        int finalPeriodo = fechaDevolucion < 0 ? fechaPrestamo : fechaDevolucion;
        System.out.println("Tiempo de prestamo: " + (finalPeriodo - fechaPrestamo) + " dias");
        System.out.println("Fecha limite: " + fechaLimite);
    }

    @Override
    public void multas() {
        System.out.println("Multa: $" + ultimaMulta);
    }

    public long calcularMulta(int diaActual) {
        if (prestado) {
            int diasRetraso = Math.max(0, diaActual - fechaLimite);
            return diasRetraso > 5 ? (diasRetraso - 5) * 5000 : 0;
        }
        return ultimaMulta;
    }

    public int calcularRestriccion(int diaActual) {
        if (prestado) {
            long multaActual = calcularMulta(diaActual);
            return multaActual > 0 ? diaActual + 30 : -1;
        }
        return restriccionHasta;
    }

    public int getRestriccionHasta() {
        return restriccionHasta;
    }

    public long getUltimaMulta() {
        return ultimaMulta;
    }
}
