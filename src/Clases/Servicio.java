package Clases;
import java.util.*;
import java.util.Date;
import Enumeraciones.Estado;

/** Clase abstracta - superclase **/

public class Servicio {

    /** Parámetros **/

    protected double tiempoTrabajado;
    protected ArrayList <Articulo> materiales;
    protected String materialesAdicionalesDescripcion; // no tendría que estar en la lista de articulos?
    protected boolean costoDeViaje;
    protected boolean almuerzo;
    protected double combustible;
    protected int idServicio;
    protected Enumeraciones.Estado estado;
    protected Date fecha;
    protected String horario;
    protected ArrayList <Tecnico> tecnicos;
    protected double MARGEN;
    protected Factura factura;
    protected double gastos;
    protected Cliente cliente;

    /** Constructor **/

    public Servicio(int idServicio, Date fecha, String horario, ArrayList<Tecnico> tecnicos, Cliente cliente) {

        this.materiales = new ArrayList<Articulo>();
        this.costoDeViaje = false;
        this.almuerzo = false;
        this.combustible = 0.0d;
        this.idServicio = idServicio;
        this.estado = Estado.Programado;
        this.fecha = fecha;
        this.horario = horario;
        this.tecnicos = tecnicos;
        this.MARGEN = 0.30d;
        this.cliente = cliente;
    }

    /** Metodos de la clase **/

    public void asignarTecnicos(ArrayList<Tecnico> tecnicos) {
        // TODO implementar
        this.tecnicos = tecnicos;
    }

    public int calcularTiempoTrabajado() {
        // TODO implementar
        return 0;
    }

    public double calcularCostoBase() {
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
        return materialesAdicionalesDescripcion;
    }

    public Enum getEstado() {
        return estado;
    }

    public int getIdServicio() {
        return idServicio;
    }

    public Cliente getCliente(){ return this.cliente;};

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