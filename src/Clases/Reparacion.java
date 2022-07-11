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
        this.tiempoTrabajado = new HashMap<Integer, Float>();
        for(Tecnico tecnico: tecnicos){
            tiempoTrabajado.put(tecnico.getNroTécnico(), 0.5f);
        }
    }

    //Getters
    public ArrayList<Tecnico> getTecnicos(){
        return this.tecnicos;
    }

    @Override
    public String toString() {
        return "Reparacion{" +
                "idServicio=" + idServicio +
                ", fecha=" + fecha +
                ", horario='" + horario + '\'' +
                ", tecnicos=" + tecnicos +
                ", cliente=" + cliente +
                "} ";
    }
}