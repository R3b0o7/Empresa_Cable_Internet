package Clases;

import java.util.ArrayList;
import java.util.Date;

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
        this.tiempoTrabajado = 0.5d;
    }

}