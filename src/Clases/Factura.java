package Clases;

public class Factura {

    /** Parámetros **/

    private int nroFactura;
    private Servicio servicio;
    private Cliente cliente;
    private double iva;

    /** Constructor **/

    public Factura(int nroFactura, Servicio servicio, Cliente cliente, double iva) {
        this.nroFactura = nroFactura;
        this.servicio = servicio;
        this.cliente = cliente;
        this.iva = iva;
    }

    /** Metodos de la clase **/

    public double calcularMonto() {
        // TODO implement here
        return 0.0d;
    }

}