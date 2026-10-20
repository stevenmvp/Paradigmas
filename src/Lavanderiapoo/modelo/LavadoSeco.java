package modelo;

public class LavadoSeco extends Servicio{
    
 public LavadoSeco(String cliente,double precio){
    super(cliente,precio);
}

@Override
 public double calcularValor(){
    return precio+15000;
}
}
