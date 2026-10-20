package modelo;
public abstract class Servicio {
 private String cliente;
 protected double precio;
 public Servicio(String cliente,double precio){
this.cliente=cliente;this.precio=precio;

 }
 public String getCliente(){
    return cliente;}
 public double getPrecio()
 {
    return precio;
}
 public abstract double calcularValor();
}
