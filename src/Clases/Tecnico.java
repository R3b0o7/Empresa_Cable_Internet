package Clases;
import Excepciones.GenericException;

import java.util.*;
import java.util.Date;

/** Clase heredada de Persona **/

public class Tecnico extends Persona {

    /** Parametros **/

    private int nroTécnico;
    private Enum TipoTecnico;
    private Agenda agenda;
    private String turno;

    /** Constructor

     Parametros heredados:

     @param dni
     @param nombreApellido
     @param dirección

     **/

    public Tecnico(int dni, String nombreApellido, String dirección,int nroTécnico, Enum TipoTecnico, String turno) {
        super(dni, nombreApellido, dirección);
        this.agenda = new Agenda();
        this.nroTécnico = nroTécnico;
        this.TipoTecnico = TipoTecnico;
        this.turno = turno;
    }


    /** Metodos **/

    public boolean poseeDisponibilidad(Date fecha, String horario, String tipoServicio) throws GenericException {
        // TODO implementa
        boolean res;
        if(tipoServicio == "REPARACION"){
            res = this.agenda.esDisponible(fecha, horario, 2);
        } else {
            res = this.agenda.esDisponible(fecha, horario, 3);
        }
        return res;
    }

    public void agendarServicio(Date fecha, String horario, int idServicio, String tipoServicio) throws GenericException {
        // TODO implementar

        //Valido si el turno está disponible
        if(tipoServicio == "REPARACION") {
            if (!this.agenda.esDisponible(fecha, horario, 2))
                throw new GenericException("El Tecnico no posee el turno disponible");
        } else {
            if (!this.agenda.esDisponible(fecha, horario, 3))
                throw new GenericException("El Tecnico no posee el turno disponible");
        }

        //agenda cierta cantidad de unidades de media hora de acuerdo al tipo de servicio
        if(tipoServicio == "REPARACION"){
            this.agenda.agendarServicio(idServicio, fecha, horario, 2);
        } else {
            this.agenda.agendarServicio(idServicio, fecha, horario, 3);
        }
    }

    /** Setters **/

    public void setTipoTecnico(Enum tipoTecnico) {
        TipoTecnico = tipoTecnico;
    }

    /** Getters **/

    public String getTurno() {
        return turno;
    }
}