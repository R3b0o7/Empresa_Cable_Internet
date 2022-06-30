package Clases;

import Enumeraciones.Articulos;

import java.util.*;

public class Compania {

    //Debe terer un inicializar sistea

    private ArrayList<Reparacion> reparaciones;
    private ArrayList<Instalacion> instalaciones;
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

    public ArrayList<Instalacion> getInstalaciones() {
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

    public static void inicializarBDD(){
        Clases.Articulo artCable = new Articulo(Articulos.Cable,0,250.90);
        Clases.Stock stock = new Stock();
        stock.agregarArticulo(artCable);
    }
}