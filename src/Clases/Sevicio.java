package Clases;
import java.util.*; // Este importa todo ya...
import java.util.ArrayList;
import java.util.Date;

/** Clase abstracta - superclase **/

public class Sevicio {
    /** Parámetros **/

    private int tiempoTrabajado;
    private ArrayList <Material> materiales;
    private String materialesAdicionales; // tiene que estar en la lista de articulos?
    private boolean costoDeViaje;
    private boolean almuerzo;
    private double combustible;
    private int idVisita;
    private Enum Estado;
    private Date fechaDia;
    private ArrayList <Tecnico> tecnicos;
    private double margen;
    private Factura factura;

    /** Constructor **/

    public Sevicio(int tiempoTrabajado, ArrayList<Material> materiales, String materialesAdicionales,
                   boolean costoDeViaje, boolean almuerzo, double combustible, int idVisita, Enum estado,
                   Date fechaDia, ArrayList<Tecnico> tecnicos, double margen, Factura factura) {

        this.tiempoTrabajado = tiempoTrabajado;
        this.materiales = materiales;
        this.materialesAdicionales = materialesAdicionales;
        this.costoDeViaje = costoDeViaje;
        this.almuerzo = almuerzo;
        this.combustible = combustible;
        this.idVisita = idVisita;
        Estado = estado;
        this.fechaDia = fechaDia;
        this.tecnicos = tecnicos;
        this.margen = margen;
        this.factura = factura;
    }

    /** Metodos de la clase **/

    public void asignarTecnico(Tecnico) {
        // TODO implementar
        return null;
    }

    public int calcularTiempoTrabajado(void int, void int) {
        // TODO implementar
        return 0;
    }

    public double calcularCosto() {
        // TODO implementar
        return 0.0d;
    }

    public double calcularGastos() {
        // TODO implementar
        return 0.0d;
    }

    public double calcularMargenReal() {
        // TODO implementar
        return 0.0d;
    }

    public Factura generarFactura() {
        // TODO implementar
        return null;
    }

    /** Getters **/
    public String getMaterialesAdicionales() {
        return materialesAdicionales;
    }

    public Enum getEstado() {
        return Estado;
    }

    /** Setters **/
    public void setAlmuerzo(boolean value) {
        // TODO implementar
    }
    public void setCombustible(double value) {
        // TODO implementar
    }

    public void setMaterialesAdicionales(String value) {
        // TODO implementar
    }

    public void setCostoDeViaje(boolean value) {
        // TODO implementar
    }

    public void setEstado(Enum estado) {
        Estado = estado;
    }

}