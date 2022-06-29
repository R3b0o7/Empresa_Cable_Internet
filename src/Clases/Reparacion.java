package Clases;

import Clases.Sevicio;
import java.util.*;
import java.util.ArrayList;
import java.util.Date;

/** Clase heredada de Servicio **/

public class Reparacion extends Sevicio {

    /** Constructor

     Parametros heredados:

     @param tiempoTrabajado
     @param materiales
     @param materialesAdicionales
     @param costoDeViaje
     @param almuerzo
     @param combustible
     @param idVisita
     @param estado
     @param fechaDia
     @param tecnicos
     @param margen
     @param factura

     **/

    public Reparacion(int tiempoTrabajado, ArrayList<Material> materiales, String materialesAdicionales,
                      boolean costoDeViaje, boolean almuerzo, double combustible, int idVisita, Enum estado,
                      Date fechaDia, ArrayList<Tecnico> tecnicos, double margen, Factura factura) {

        super(tiempoTrabajado, materiales, materialesAdicionales, costoDeViaje, almuerzo, combustible,
                idVisita, estado, fechaDia, tecnicos, margen, factura);
    }

    /** Metodos **/

    @Override
    public void asignarTecnico() {
        super.asignarTecnico();
    }

    @Override
    public int calcularTiempoTrabajado() {
        return super.calcularTiempoTrabajado();
    }

    @Override
    public double calcularCosto() {
        return super.calcularCosto();
    }

    @Override
    public double calcularGastos() {
        return super.calcularGastos();
    }

    @Override
    public double calcularMargenReal() {
        return super.calcularMargenReal();
    }

    @Override
    public Factura generarFactura() {
        return super.generarFactura();
    }

    /** Getters **/

    @Override
    public String getMaterialesAdicionales() {
        return super.getMaterialesAdicionales();
    }

    @Override
    public Enum getEstado() {
        return super.getEstado();
    }

    /** Setters **/

    @Override
    public void setAlmuerzo(boolean value) {
        super.setAlmuerzo(value);
    }

    @Override
    public void setCombustible(double value) {
        super.setCombustible(value);
    }

    @Override
    public void setMaterialesAdicionales(String value) {
        super.setMaterialesAdicionales(value);
    }

    @Override
    public void setCostoDeViaje(boolean value) {
        super.setCostoDeViaje(value);
    }

    @Override
    public void setEstado(Enum estado) {
        super.setEstado(estado);
    }
}