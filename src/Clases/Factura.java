package Clases;

public class Factura {

    /** Parámetros **/

    private static int generador = 0; //Generador de numero de factura
    private int nroFactura;
    private Servicio servicio;
    private Cliente cliente;
    private double IVA;
    private double monto; //NUEVO  -> Agregar al diagrama

    /** Constructor **/

    public Factura(Servicio servicio, Cliente cliente) {
        Factura.generador++;
        this.nroFactura = generador;
        this.servicio = servicio;
        this.cliente = cliente;
        this.IVA = 0.21;
        this.calcularMonto();
    }

    /** Metodos de la clase **/

    private double calcularMonto() {
        // TODO implement here
        this.monto = this.servicio.getPrecioFinal() + (this.servicio.getPrecioFinal()*this.IVA);
        return this.monto;
    }

    public String imprimirFactura(){
        return "N°"+this.nroFactura +"\n"
                +"Materiales utilizados: "+this.servicio.listarMaterialesUtilizados()+"\n"
                +"Materiales adicionales: "+this.servicio.getMaterialesAdicionales()+"\n"
                +"Tiempo trabajado total: "+this.servicio.getTiempoTrabajado()+"\n"
                +"Costo del servicio: "+this.servicio.getPrecioFinal()+"\n"
                +"IVA: "+this.servicio.getPrecioFinal()*this.IVA+"\n"
                +"Precio final: "+this.monto;
    }

    @Override
    public String toString() {  //NUEVO -> Agregar al diagrama
        return "N° Factura = " + nroFactura
                + " - Costo Real = " + this.servicio.getCostoReal()
                + " - Precio final = "+ this.servicio.getPrecioFinal()
                + " - Margen real = "+ this.servicio.calcularMargenReal()*100+ "%";
    }

}