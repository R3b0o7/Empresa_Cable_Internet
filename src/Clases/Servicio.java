package Clases;
import java.util.*;
import java.util.Date;
import Enumeraciones.Estado;

/** Clase abstracta - superclase **/

public class Servicio {

    /** Parámetros **/

    protected Map<Integer, Float> tiempoTrabajado; //la clave corresponde al idTecnico y el valor al tiempo trabajado
    protected ArrayList <Articulo> materiales;
    protected String materialesAdicionalesDescripcion;
    protected double costoMaterialesAdicionales;
    protected boolean almuerzo;
    protected double combustible; //litros
    protected int idServicio;
    protected Enumeraciones.Estado estado;
    protected Date fecha;
    protected String horario;
    protected ArrayList <Tecnico> tecnicos;
    protected double MARGEN;
    protected Factura factura;
    protected double gastos;  //Por que tenemos un gastos?
    protected Cliente cliente;

    /** Constructor **/

    public Servicio(int idServicio, Date fecha, String horario, ArrayList<Tecnico> tecnicos, Cliente cliente) {

        this.materiales = new ArrayList<Articulo>();
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

    public int calcularTiempoTrabajado() {  //Esto esta calculado en calcularCostoBase, vale la pena tener 2 metodos?
        int tiempo = 30;
        int cantTecnicos = 0;
        for(Tecnico tecnico: this.tecnicos){
            cantTecnicos += 1;
        }
        return tiempo*cantTecnicos;
    }

    public double calcularPrecioBase(Compania compania) {
        //calculo costo del tiempo base del servicio
        double costoTiempo = 0.0d;
        for(Tecnico tecnico: this.tecnicos){
            costoTiempo += this.tiempoTrabajado.get(tecnico.getNroTécnico())*compania.getCostoTecnico(tecnico.getTipoTecnico());
        }
        //calculo costo de los materiales base
        double costoMateriales = 0.0d;
        for(Articulo articulo: this.materiales){
            costoMateriales += articulo.getCantidad()*articulo.getPrecio();
        }
        double precioBase = (costoTiempo+costoMateriales)+((costoTiempo+costoMateriales)*this.MARGEN);
        return precioBase;
    }

    public double calcularGastos(double combustible, double precioCombustible) {
        double gastoCombustible = combustible * precioCombustible; //Ingresar combustible utilizado y calcula el precio -> ESTO ES COSTO DE VIAJE?
        int gastoAlmuerzo = 0;
        if (almuerzo) {
            gastoAlmuerzo = 500;
        }
        //FALTA AGREGAR GASTO DE ARTICULOS ADICIONALES
        this.gastos = gastoCombustible + gastoAlmuerzo;
        return this.gastos;
    }

    public double calcularMargenReal(double combustible, Compania compania) {
        double margenReal = calcularPrecioBase(compania) - this.gastos;
        return margenReal;
    }

    public Factura generarFactura() {
        //Ver como generar un ID de factura automatico, y ver como hacer auto refencia a la instancia de este objeto

        //Factura factura = new Factura(1,Servicio,cliente);
        //Compania.getInstance().getFacturas().add(factura);

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

    /** Setters **/ //TODOS LOS QUE DICEN TO DO NO ME LOS DEJO CREAR AUTOMATICO -> Ver por qué
    public void setAlmuerzo(boolean value) {
        // TODO implementar
    }
    public void setCombustible(double value) {
        // TODO implementar
    }

    public void setMaterialesAdicionales(String value) {
        // TODO implementar
    }

    public void setCostoDeViaje(boolean value) {  //Asumo que lo que era setCostoDeViaje es el SetPrecioCombustible
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