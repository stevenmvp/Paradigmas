package veterinario.EjerciciosPoo;

public class estudiante extends Persona{
    String carrera;
    String semestre;

    public estudiante(int id, String nombre, int edad, String cargo, String telefono, String email,
                      String direccion, String cedula, String carrera, String semestre) {
        super(id, nombre, edad, cargo, telefono, email, direccion, cedula);
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
    public String getSemestre() {
        return semestre;    
    }
    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Carrera: " + carrera + ", Semestre: " + semestre);
    }

}
