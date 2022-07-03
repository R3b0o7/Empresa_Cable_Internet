package Clases;
import Clases.Persona;
import Excepciones.GenericException;

import java.util.*;
import java.util.Date;

public class Cliente extends Persona {

    /** Parametros **/
    private Agenda agenda;

    /** Constructor

     Parametros heredados:

     @param dni
     @param nombreApellido
     @param dirección

     **/

    public Cliente(int dni, String nombreApellido, String dirección) {
        super(dni, nombreApellido, dirección);
        this.agenda = new Agenda();
    }

    /** Metodos **/

    public void agendarServicio(Date fecha, String horario, int idServicio, String tipoServicio) throws GenericException {
        // TODO implementar
        if (tipoServicio == "REPARACION") {
            if (!this.agenda.esDisponible(fecha, horario, 2))
                throw new GenericException("El Cliente posee otro turno agendado en ese horario");
        } else {
            if (!this.agenda.esDisponible(fecha, horario, 3))
                throw new GenericException("El Cliente posee otro turno agendado en ese horario");
        }

        if (tipoServicio == "REPARACION") {
            this.agenda.agendarServicio(idServicio, fecha, horario, 2);
        } else {
            this.agenda.agendarServicio(idServicio, fecha, horario, 3);
        }
    }

}