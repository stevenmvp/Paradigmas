package SistemaBiblioteca;

public abstract class Material implements Operaciones {

    public String nombrelibro;
    public String TipoMaterial;
    public boolean prestado;

    public Material(String nombrelibro, String TipoMaterial) {
        this.nombrelibro = nombrelibro;
        this.TipoMaterial = TipoMaterial;
        this.prestado = false;
    
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombrelibro);
        System.out.println("Tipo de material: " + TipoMaterial);
    }

    @Override
    public void consultar() {
        mostrarInformacion();
        disponibilidad();
    }

    @Override
    public void disponibilidad() {
        System.out.println(prestado ? "Estado: prestado" : "Estado: disponible");
    }
    

}
