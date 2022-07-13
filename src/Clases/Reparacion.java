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
                " - fecha=" + fecha +
                " - horario='" + horario + '\'' +
                " - tecnicos=" + tecnicosStr +
                " - Estado=" + estado +
                " - cliente=" + cliente +
                "} ";
    }

    public String toStringDetalle() {
        String tecnicosStr = "";
        for(Tecnico tec: this.tecnicos){
            tecnicosStr += "id-"+ tec.getNroTécnico()+" ";
        }
        String articulosStr = "";
        for(Articulo art: this.materiales){
            articulosStr += art.getArticulo()+" ";
        }
        return "Reparacion - " +
                "idServicio=" + idServicio +
                " - tecnicos=" + tecnicosStr +
                " - cliente=" + cliente +
                " - Estado=" + estado +
                " - Materiales=" + articulosStr +
                " - Costo Materiales adicionales=" + costoMaterialesAdicionales +
                " - Almuerzo=" + almuerzo +
                " - Costo Real=" + costoReal +
                " - Gastos=" + gastos +
                " - tiempoTrabajado=" + tiempoTrabajado +
                "} ";
    }
}