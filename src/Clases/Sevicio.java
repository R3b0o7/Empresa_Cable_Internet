
import java.util.*;

/**
 * 
 */
public class Sevicio {

    /**
     * Default constructor
     */
    public Sevicio() {
    }

    /**
     * 
     */
    private int tiempoTrabajado;

    /**
     * 
     */
    private ArrayList <Material> materiales;

    /**
     * 
     */
    private String materialesAdicionales;

    /**
     * 
     */
    private boolean costoDeViaje;

    /**
     * 
     */
    private boolean almuerzo;

    /**
     * 
     */
    private double combustible;

    /**
     * 
     */
    private int idVisita;

    /**
     * 
     */
    private EnumeraciónEstado estado;

    /**
     * 
     */
    private Date fechaDia;

    /**
     * 
     */
    private ArrayList <Tecnico> tecnicos;

    /**
     * 
     */
    private double margen;

    /**
     * 
     */
    private Factura factura;

    /**
     * @param int 
     * @param int 
     * @return
     */
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