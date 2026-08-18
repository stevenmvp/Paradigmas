package veterinario;

public class Cliente extends Persona {
    private String tipoMascota;
    private String categoria;

    public Cliente() {
        super();
    }

    public Cliente(int id, String nombre, int edad, String cargo, String telefono, String email,
                   String direccion, String cedula, String tipoMascota, String categoria) {
        super(id, nombre, edad, cargo, telefono, email, direccion, cedula);
        this.tipoMascota = tipoMascota;
        this.categoria = categoria;
    }

    public String getTipoMascota() {
        return tipoMascota;
    }

    public void setTipoMascota(String tipoMascota) {
        this.tipoMascota = tipoMascota;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Tipo de mascota: " + tipoMascota + ", Categoría: " + categoria);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + getId() +
                ", nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", cargo='" + getCargo() + '\'' +
                ", telefono='" + getTelefono() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", direccion='" + getDireccion() + '\'' +
                ", cedula='" + getCedula() + '\'' +
                ", tipoMascota='" + tipoMascota + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
