import modelo.LavadoNormal;
import controlador.LavanderiaController;

public class Main{
 public static void main(String[] args){
  LavanderiaController controlador=new LavanderiaController();
  controlador.getServicios().add(new LavadoNormal("Cliente",20000));
 }
}
