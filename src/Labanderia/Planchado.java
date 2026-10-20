package modelo;
public class Planchado extends Servicio{
 public Planchado(String cliente,double precio){
    super(cliente,precio);

 }
 @Override
 public double calcularValor(){
    return precio+3000;

 }
}
