package modelo;
public class LavadoSeco extends Servicio{
 public LavadoSeco(String cliente,double precio){
    super(cliente,precio);
}
 public double calcularvalor(){
    return precio+15000;
}
}
