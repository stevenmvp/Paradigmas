package veterinario.EjerciciosPoo;

public class elefante extends Animal{
    private Double peso;

    public elefante(int id, String nombre, int edad, String raza, Double peso, String sonidoAnimal) {
        super(id, nombre, edad, raza, sonidoAnimal);
        this.peso = peso;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    @Override
    public void move() {
        System.out.println("El elefante se mueve");
        System.out.println("con un peso de"+peso);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Peso: " + peso);
    }
}
