package Clases;

import java.util.*;

public class Compañia {

    private ArrayList<Reparacion> reparaciones;
    private ArrayList<Instalación> instalaciones;
    private ArrayList<Cliente> clientes;
    private ArrayList<PerfilAdminSistema> usuariosAdmiSistema;
    private ArrayList<PerfilCallCenter> usuariosCallCenter;
    private ArrayList<PerfilTecnico> usuariosTecnicos;
    private ArrayList<PerfilAdministrativo> usuariosAdministrativo;
    private ArrayList<Factura> facturas;
    private ArrayList<Tecnico> tecnico;
    private Stock stock;

    /** Getters **/

    public ArrayList<Reparacion> getReparaciones() {
        return reparaciones;
    }

    public ArrayList<Instalación> getInstalaciones() {
        return instalaciones;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<PerfilAdminSistema> getUsuariosAdmiSistema() {
        return usuariosAdmiSistema;
    }

    public ArrayList<PerfilCallCenter> getUsuariosCallCenter() {
        return usuariosCallCenter;
    }

    public ArrayList<PerfilTecnico> getUsuariosTecnicos() {
        return usuariosTecnicos;
    }

    public ArrayList<PerfilAdministrativo> getUsuariosAdministrativo() {
        return usuariosAdministrativo;
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public ArrayList<Tecnico> getTecnico() {
        return tecnico;
    }

    public Stock getStock() {
        return stock;
    }
}