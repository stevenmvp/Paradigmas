package veterinario.EjerciciosPoo;

public class perro extends Animal{
    private Double peso;

    public perro(int id, String nombre, int edad, String raza, Double peso, String sonidoAnimal) {
        super(id, nombre, edad, raza, sonidoAnimal);
        this.peso = peso;
    }
    public Double getPeso() {
        return peso;
    }
    public void setPeso(Double peso) {
        this.peso = peso;
    }
    @Override
    public void move() {
        System.out.println("El perro se mueve");
        System.out.println("con un peso de"+peso);
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Peso: " + peso);
    }
}
