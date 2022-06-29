package Clases;
import Enumeraciones.TipoTecnico;

import java.util.*;
import java.util.Date;

/** Clase heredada de Persona **/

public class Tecnico extends Persona {

    /** Parametros **/

    private int nroTecnico;
    private Enumeraciones.TipoTecnico tipoTecnico;
    private Agenda agenda;

    /** Constructor

     Parametros heredados:

     @param dni
     @param nombreApellido
     @param direccion

     **/

    public Tecnico(int dni, String nombreApellido, String direccion,int nroTecnico, Enumeraciones.TipoTecnico tipoTecnico, Agenda agenda) {
        super(dni, nombreApellido, direccion);
        this.agenda = agenda;
        this.nroTecnico = nroTecnico;
        switch (tipoTecnico) {
            case Junior:
                this.tipoTecnico = TipoTecnico.Junior;
                break;
            case Semi_senior:
                this.tipoTecnico = TipoTecnico.Semi_senior;
                break;
            case Senior:
                this.tipoTecnico = TipoTecnico.Senior;
                break;
        }
    }


    public int getNroTecnico() {
        return nroTecnico;
    }

    public void setNroTecnico(int nroTecnico) {
        this.nroTecnico = nroTecnico;
    }

    public String getTipoTecnico() {
        return tipoTecnico.toString();
    }

    public void setTipoTecnico(Enumeraciones.TipoTecnico tipoTecnico) {
        switch (tipoTecnico) {
            case Junior:
                this.tipoTecnico = TipoTecnico.Junior;
                break;
            case Semi_senior:
                this.tipoTecnico = TipoTecnico.Semi_senior;
                break;
            case Senior:
                this.tipoTecnico = TipoTecnico.Senior;
                break;
        }
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }

    /** Metodos **/


    public void agendarServicio(Date fecha, int value1, int value2) {
        // TODO implement here
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


}