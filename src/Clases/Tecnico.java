package Clases;
import java.util.*;
import java.util.Date;

/** Clase heredada de Persona **/

public class Tecnico extends Persona {

    /** Parametros **/

    private int nroTécnico;
    private Enum TipoTecnico;
    private Agenda agenda;

    /** Constructor

     Parametros heredados:

     @param dni
     @param nombreApellido
     @param dirección

     **/

    public Tecnico(int dni, String nombreApellido, String dirección,int nroTécnico, Enum TipoTecnico, Agenda agenda) {
        super(dni, nombreApellido, dirección);
        this.agenda = agenda;
        this.nroTécnico = nroTécnico;
        this.TipoTecnico = TipoTecnico;
    }


    /** Metodos **/

    public Tecnico Técnico() {
        // TODO implementar
        return null;
    }

    public boolean poseeDisponibilidad() {
        // TODO implementar
        return false;
    }

    public void agendarServicio() {
        // TODO implementar
    }

    /** Metodos heredados **/

    @Override
    public void login() {
        super.login();
    }

    /** Setters **/

    public void setTipoTecnico(Enum tipoTecnico) {
        TipoTecnico = tipoTecnico;
    }

}