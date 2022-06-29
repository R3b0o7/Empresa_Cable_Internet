package Clases;
import Enumeraciones.TipoTecnico;

import java.util.*;
import java.util.Date;

/** Clase heredada de Persona **/

public class Tecnico extends Persona {

    /** Parametros **/

    private int nroTecnico;
    private Enum tipoTecnico;
    private Agenda agenda;

    /** Constructor

     Parametros heredados:

     @param dni
     @param nombreApellido
     @param direccion

     **/

    public Tecnico(int dni, String nombreApellido, String direccion,int nroTecnico, int tipoTecnico, Agenda agenda) {
        super(dni, nombreApellido, direccion);
        this.agenda = agenda;
        this.nroTecnico = nroTecnico;
        switch (tipoTecnico) {
            case 1:
                this.tipoTecnico = TipoTecnico.Junior;
                break;
            case 2:
                this.tipoTecnico = TipoTecnico.Semisenior;
                break;
            case 3:
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

    public void setTipoTecnico(int tipoTecnico) {
        switch (tipoTecnico) {
            case 1:
                this.tipoTecnico = TipoTecnico.Junior;
                break;
            case 2:
                this.tipoTecnico = TipoTecnico.Semisenior;
                break;
            case 3:
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