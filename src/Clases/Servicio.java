package Clases;
import java.util.*;
import java.util.Date;
import Enumeraciones.Estado;

/** Clase abstracta - superclase **/

public class Servicio {

    /** Parámetros **/

    private int tiempoTrabajado;
    private ArrayList <Articulo> materiales;
    private String materialesAdicionales; // no tendría que estar en la lista de articulos?
    private boolean costoDeViaje;
    private boolean almuerzo;
    private double combustible;
    private int idServicio;
    private Enumeraciones.Estado estado;
    private Date fechaDia;
    private ArrayList <Tecnico> tecnicos;
    private double margen;
    private Factura factura;
    private double gastos;
    /** Constructor **/

    public Servicio(int tiempoTrabajado, ArrayList<Articulo> materiales, String materialesAdicionales,
                    boolean costoDeViaje, boolean almuerzo, double combustible, int idServicio, Enumeraciones.Estado estado,
                    Date fechaDia, ArrayList<Tecnico> tecnicos, double margen, Factura factura) {

        this.tiempoTrabajado = tiempoTrabajado;
        this.materiales = materiales;
        this.materialesAdicionales = materialesAdicionales;
        this.costoDeViaje = costoDeViaje;
        this.almuerzo = almuerzo;
        this.combustible = combustible;
        this.idServicio = idServicio;
        this.estado = estado;
        this.fechaDia = fechaDia;
        this.tecnicos = tecnicos;
        this.margen = margen;
        this.factura = factura;
    }

    /** Metodos de la clase **/

    public void asignarTecnico() {
        // TODO implementar

    }

    public int calcularTiempoTrabajado() {
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
        return estado;
    }

    public int getIdServicio() {
        return idServicio;
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

    public void setEstado(Enumeraciones.Estado estado) {
        switch (estado){
            case En_curso:
                this.estado = Estado.En_curso;
                break;
            case Cancelada:
                this.estado = Estado.Cancelada;
                break;
            case Finalizada:
                this.estado = Estado.Finalizada;
                break;
            case Programado:
                this.estado = Estado.Programado;
                break;
        }
    }

}