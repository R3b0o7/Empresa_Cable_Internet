package Clases;
import java.util.*;
import java.util.Date;
import Enumeraciones.Estado;
import Enumeraciones.TipoServicio;

/** Clase abstracta - superclase **/

public class Servicio {

    /** Parámetros **/

    protected Enumeraciones.TipoServicio tipoServicio;
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
    protected double costoReal; //es el costo calculado cuando se finaliza el servicio
    protected double gastos;  //Por que tenemos un gastos?
    protected double precioFinal;
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
        this.MARGEN = 1.30d;
        this.cliente = cliente;

    }

    /** Metodos de la clase **/

    public void asignarTecnicos(ArrayList<Tecnico> tecnicos) {
        // TODO implementar
        this.tecnicos = tecnicos;
    }

    public double calcularCostoTiempoTrabajado(Compania compania) {  //Esto esta calculado en calcularCostoBase, vale la pena tener 2 metodos? LO UNIFICO
        //calculo costo del tiempo trabajado
        double costoTiempo = 0.0d;
        for(Tecnico tecnico: this.tecnicos){
            costoTiempo += this.tiempoTrabajado.get(tecnico.getNroTécnico()) * compania.getCostoTecnico(tecnico.getTipoTecnico());
        }
        return costoTiempo;
    }

    public double calcularPrecioBase(Compania compania) {
        //calculo costo del tiempo base del servicio
        double costoTiempo = this.calcularCostoTiempoTrabajado(compania);
        //calculo costo de los materiales base
        double costoMateriales = 0.0d;
        for(Articulo articulo: this.materiales){
            costoMateriales += articulo.getCantidad()*articulo.getPrecio();
        }
        double precioBase = (costoTiempo+costoMateriales)+((costoTiempo+costoMateriales)*this.MARGEN);
        return precioBase;
    }

    public double calcularGastos(double precioCombustible) {
        double gastoCombustible = this.combustible * precioCombustible; //Ingresar combustible utilizado y calcula el precio -> ESTO ES COSTO DE VIAJE?
        int gastoAlmuerzo = 0;
        if (almuerzo) {
            gastoAlmuerzo = 500;
        }
        this.gastos = gastoCombustible + gastoAlmuerzo + this.costoMaterialesAdicionales;
        return this.gastos;
    }

    public double calcularCostoReal(Compania compania){
        //calculo costo del tiempo base del servicio
        double costoTiempo = this.calcularCostoTiempoTrabajado(compania);
        //calculo costo de los materiales base
        double costoMateriales = 0.0d;
        for(Articulo articulo: this.materiales){
            costoMateriales += articulo.getCantidad()*articulo.getPrecio();
        }
        double costoReal =
                costoTiempo
                +costoMateriales
                +this.costoMaterialesAdicionales
                +compania.getCostoDeViaje();
        //seteo el atributo
        this.costoReal = costoReal;
        return costoReal;
    }

   public double calcularPrecioFinal(){
        this.precioFinal = (this.costoReal*this.MARGEN) - this.gastos;
        return precioFinal;
   }

    public double calcularMargenReal() {
        double margenReal = (this.precioFinal-this.costoReal)/this.costoReal;
        return margenReal;
    }

    public Factura generarFactura() {
        //Ver como generar un ID de factura automatico, y ver como hacer auto refencia a la instancia de este objeto

        //Factura factura = new Factura(1,Servicio,cliente);
        //Compania.getInstance().getFacturas().add(factura);

        // TODO implementar
        return null;
    }

    public void finalizarServicio(Compania compania){
        this.estado = Estado.Finalizada;
        this.calcularCostoReal(compania);
        this.calcularGastos(compania.getPrecioCombustible());
        this.calcularPrecioFinal();
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

    public TipoServicio getTipoServicio(){return this.tipoServicio;};

    /** Setters **/ //TODOS LOS QUE DICEN TO DO NO ME LOS DEJO CREAR AUTOMATICO -> Ver por qué
    public void setAlmuerzo(boolean value) {
        this.almuerzo = value;
    }
    public void setCombustible(double value) {
        this.combustible = value;
    }

    public void setPrecioFinal(double value){
        this.precioFinal = value;
    }

    public void setMaterialesAdicionales(String value) {
        // TODO implementar
    }

    public void setCostoMaterialesAdicionales(double costo) {
        this.costoMaterialesAdicionales = costo;
    }

    public void setEstado(Enumeraciones.Estado estado) {
        this.estado = estado;
    }

}