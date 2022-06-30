package Clases;

import Enumeraciones.Articulos;

import java.util.*;

public class Compania {

    //Debe terer un inicializar sistema - por ahora es el inicializarBDD

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

    /** Inicialización de la Base de Datos - Programa Inicial **/

    public static void inicializarBDD(){

        /** Creación de Articulos **/

        Clases.Articulo artCable = new Articulo(Articulos.Cable,1000,250.90);
        Clases.Articulo artConector_coaxial_RG6 = new Articulo(Articulos.Conector_coaxial_RG6,2500,62.25);
        Clases.Articulo artDecodificador = new Articulo(Articulos.Decodificador,50,850);
        Clases.Articulo artDivisor = new Articulo(Articulos.Divisor,800,120.30);
        Clases.Articulo artModem = new Articulo(Articulos.Modem,50,1135.50);

        /** Creación de Stock y la lista de articulos en el stock **/

        Clases.Stock stock = new Stock();

        stock.agregarArticulo(artCable);
        stock.agregarArticulo(artConector_coaxial_RG6);
        stock.agregarArticulo(artDecodificador);
        stock.agregarArticulo(artDivisor);
        stock.agregarArticulo(artModem);
    }
}