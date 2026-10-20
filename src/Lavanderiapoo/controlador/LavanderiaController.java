package controlador;
import java.util.ArrayList;
import java.util.List;
import modelo.Servicio;
import excepciones.ServicioException;

public class LavanderiaController{
 private List<Servicio> servicios;

 public LavanderiaController(){
    servicios=new ArrayList<>();
}

 public void registrarServicio(Servicio servicio)throws ServicioException{
  if(servicio==null){
    throw new ServicioException("Servicio invalido");

  }
  servicios.add(servicio);
 }

 @SuppressWarnings("unchecked")
 public void cargarServicios(){
  List lista=new ArrayList();
  servicios=lista;
 }

 public List<Servicio> getServicios() {
    for (Servicio servicio : servicios) {
        System.out.println("Cliente: " + servicio.getCliente());
        System.out.println("Total: " + servicio.calcularValor());
    }
    return servicios;
 }

}
