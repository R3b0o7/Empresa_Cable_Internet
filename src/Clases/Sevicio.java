import java.util.*;
import Clases.Estado;

/** Clase abstracta **/

public class Sevicio {

    private int tiempoTrabajado;
    private ArrayList <Material> materiales;
    private String materialesAdicionales;
    private boolean costoDeViaje;
    private boolean almuerzo;
    private double combustible;
    private int idVisita;
    private Enumeración Estado;
    private Date fechaDia;
    private ArrayList <Tecnico> tecnicos;
    private double margen;
    private Factura factura;

    public Sevicio(int tiempoTrabajado, ArrayList<Material> materiales, String materialesAdicionales,
                   boolean costoDeViaje, boolean almuerzo, double combustible, int idVisita, Enumeración estado,
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

    public int calcularTiempoTrabajado(void int, void int) {
        // TODO implement here
        return 0;
    }

    /**
     * @param Tecnico 
     * @return
     */
    public void asignarTecnico(void Tecnico) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getMaterialesAdicionales() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getEstado() {
        // TODO implement here
        return "";
    }

    /**
     * @param value
     */
    public void setMaterialesAdicionales(String value) {
        // TODO implement here
    }

    /**
     * @param value
     */
    public void setCostoDeViaje(boolean value) {
        // TODO implement here
    }

    /**
     * @param value
     */
    public void setAlmuerzo(boolean value) {
        // TODO implement here
    }

    /**
     * @param value
     */
    public void setCombustible(double value) {
        // TODO implement here
    }

    /**
     * @return
     */
    public double calcularCosto() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public double calcularGastos() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public double calcularMargenReal() {
        // TODO implement here
        return 0.0d;
    }

    /**
     * @return
     */
    public Factura generarFactura() {
        // TODO implement here
        return null;
    }

}