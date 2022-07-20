package Clases;

import Enumeraciones.TipoServicio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/** Clase heredada de Servicio **/

public class Reparacion extends Servicio {

    /**
     * Constructor
     * Parametros heredados:
     *
     * @param idServicio
     * @param fecha
     * @param horario
     * @param tecnicos
     * @param cliente
     **/

    public Reparacion(int idServicio, Date fecha, String horario, ArrayList<Tecnico> tecnicos, Cliente cliente) {
        super(idServicio, fecha, horario, tecnicos, cliente);
        this.tipoServicio = TipoServicio.Reparación;
        this.tiempoTrabajado = new HashMap<Integer, Double>();
        for(Tecnico tecnico: tecnicos){
            tiempoTrabajado.put(tecnico.getNroTécnico(), 0.5);
        }
    }

    //Getters
    public ArrayList<Tecnico> getTecnicos(){
        return this.tecnicos;
    }

    @Override
    public String toString() {
        String tecnicosStr = "";
        for(Tecnico tec: this.tecnicos){
            tecnicosStr += "id-"+ tec.getNroTécnico()+" ";
        }
        return "Reparación - " +
                "idServicio=" + idServicio +
                " - Fecha=" + fecha +
                " - Horario='" + horario + '\'' +
                " - Tecnicos=" + tecnicosStr +
                " - Estado=" + estado +
                " - Cliente=" + cliente.getNombreApellido() +
                "} ";
    }

    public String toStringDetalle() {
        String tecnicosStr = "";
        for (Tecnico tec : this.tecnicos) {
            tecnicosStr += "id-" + tec.getNroTécnico() + " ";
        }
        String articulosStr = "";
        for (Articulo art : this.materiales) {
            articulosStr += art.getArticulo()+"("+art.getCantidad()+")"+" ";
        }
        return "Reparacion - " +
                "idServicio=" + idServicio +
                " - tecnicos=" + tecnicosStr +
                " - cliente=" + cliente +
                " - Estado=" + estado +
                " - Materiales=" + articulosStr +
                " - Costo Materiales adicionales= $" + costoMaterialesAdicionales +
                " - Almuerzo=" + almuerzo +
                " - Combustible= " + combustible +
                " - Costo Real= $" + costoReal +
                " - Bonificacion= "+ bonificacion*100 + "%" +
                " - Precio Real= $"+ precioFinal +
                " - Gastos= $" + gastos +
                " - tiempoTrabajado=" + tiempoTrabajado +
                "} ";
    }
}