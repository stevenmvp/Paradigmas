package modelo;
public class LavadoNormal extends Servicio{
 public LavadoNormal(String cliente,double precio){
    super(cliente,precio);
}
 @Override
 public double calcularValor(){
    return precio+5000;
}
}
