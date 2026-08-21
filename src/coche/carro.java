package coche;

public class carro extends vehiculo {
     private String CantidadLLantas;
    
    public carro(String marca, String modelo, String color, String CantidadLLantas) {
        super(marca, modelo, color);
        this.CantidadLLantas = CantidadLLantas;
    }

    public String getCantidadLLantas() {
        return CantidadLLantas;
    }
    public void setCantidadLLantas(String CantidadLLantas) {
        this.CantidadLLantas = CantidadLLantas;
    }
    @Override
    public String facturar(){
        super.facturaInfo();
        return  "su factura es de 4llantas * 300.000=" + (4 * 300000);
    }
    
}
