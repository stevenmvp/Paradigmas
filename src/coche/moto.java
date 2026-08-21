package coche;

public class moto extends vehiculo {
    private String CantidadLLantas;
    
    public moto(String marca, String modelo, String color, String CantidadLLantas) {
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
        return "su factura es de 2llantas * 300.000 es=" + (2 * 300000);
    }
}
