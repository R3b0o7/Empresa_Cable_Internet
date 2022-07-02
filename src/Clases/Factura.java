package Clases;

public class Factura {

    /** Parámetros **/

    private int nroFactura;
    private Servicio servicio;
    private Cliente cliente;
    private double IVA;

    /** Constructor **/

    public Factura(int nroFactura, Servicio servicio, Cliente cliente) {
        this.nroFactura = nroFactura;
        this.servicio = servicio;
        this.cliente = cliente;
        this.IVA = 0.21;
    }

    /** Metodos de la clase **/

    public double calcularMonto() {
        // TODO implement here
        return 0.0d;
    }

}