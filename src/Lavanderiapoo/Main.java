import modelo.LavadoNormal;
import controlador.LavanderiaController;

public class Main{
 public static void main(String[] args){



  /*************
   *  
 LavanderiaController controlador=new LavanderiaController();
  controlador.getServicios().add(new LavadoNormal("Cliente",20000)); no existe getse
 }

   * ******** */
 LavanderiaController controlador = new LavanderiaController();
 LavadoNormal servicio = new LavadoNormal("Cliente", 20000);


 try {
  controlador.registrarServicio(servicio);
 } catch (Exception e) {
  System.out.println("Error al registrar servicio: " + e.getMessage());
  return;
 }

System.out.println("Cliente: " + servicio.getCliente());
System.out.println("Total: " + servicio.calcularValor());

/**
 * 
 *  controlador.getServicios(); luego de creado el get servicio, debe funcionar y traer el resultado
 */

 System.out.println(controlador.getServicios());
 }
}
