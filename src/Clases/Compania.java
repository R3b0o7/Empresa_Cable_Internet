package Clases;

import Enumeraciones.Articulos;
import Enumeraciones.TipoTecnico;

import java.util.*;

public class Compania {

    /** La Compania es instanciada en el controlador, ya que esta contiene la BDD del sistema **/

    private static Compania compania;
    private ArrayList<Reparacion> reparaciones;
    private ArrayList<Instalacion> instalaciones;
    private ArrayList<Cliente> clientes;
    private ArrayList<PerfilAdminSistema> usuariosAdmiSistema;
    private ArrayList<PerfilCallCenter> usuariosCallCenter;
    private ArrayList<PerfilTecnico> usuariosTecnicos;
    private ArrayList<PerfilAdministrativo> usuariosAdministrativo;
    private ArrayList<Factura> facturas;
    private ArrayList<Tecnico> tecnicos;
    private Stock stock;

    /** Constructor privado por ser Singleton  **/
    private Compania(){
        this.reparaciones = new ArrayList<Reparacion>();
        this.instalaciones = new ArrayList<Instalacion>();
        this.clientes = new ArrayList<Cliente>();
        this.usuariosAdmiSistema = new ArrayList<PerfilAdminSistema>();
        this.usuariosAdministrativo = new ArrayList<PerfilAdministrativo>();
        this.usuariosTecnicos = new ArrayList<PerfilTecnico>();
        this.usuariosCallCenter = new ArrayList<PerfilCallCenter>();
        this.facturas = new ArrayList<Factura>();
        this.tecnicos = new ArrayList<Tecnico>();
        this.stock = new Stock();

        //inicializo la BDD
        this.inicializarBDD();

    }

    //Metodo para el Singleton. Reemplaza al constructor
    public static Compania getInstance() {
        if(compania == null) {
            compania = new Compania();
        }
        return compania;
    }

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

    public ArrayList<Tecnico> getTecnicos() {
        return tecnicos;
    }

    public Stock getStock() {
        return stock;
    }

    public Reparacion getReparacion(int idServicio){
        for(Reparacion reparacion: this.getReparaciones()){
            if(reparacion.getIdServicio() == idServicio){
                return reparacion;
            }
        }
        return null;
    }

    public Instalacion getInstalacion(int idServicio){
        for(Instalacion instalacion: this.instalaciones){
            if(instalacion.getIdServicio() == idServicio){
                return instalacion;
            }
        }
        return null;
    }

    /** Inicialización de la Base de Datos - Programa Inicial **/

    private void inicializarBDD(){

        /** Creación de Articulos  **/
        // Los mismos tienen una cantidad por defecto para simplificar el caso, pero podría ser 0

        Articulo artCable = new Articulo(Articulos.Cable,1000,250.90);
        Articulo artConector_coaxial_RG6 = new Articulo(Articulos.Conector_coaxial_RG6,2500,62.25);
        Articulo artDecodificador = new Articulo(Articulos.Decodificador,50,850);
        Articulo artDivisor = new Articulo(Articulos.Divisor,800,120.30);
        Articulo artModem = new Articulo(Articulos.Modem,50,1135.50);

        /** Creación de Stock y la lista de articulos en el stock  **/

        //Stock stock = new Stock();

        this.stock.agregarArticulo(artCable);
        this.stock.agregarArticulo(artConector_coaxial_RG6);
        this.stock.agregarArticulo(artDecodificador);
        this.stock.agregarArticulo(artDivisor);
        this.stock.agregarArticulo(artModem);

        //Tecnicos
        Clases.Tecnico tecnico1 = new Tecnico(123, "Gonzalo", "salta", 1, TipoTecnico.Semi_senior, "Tarde");
        this.tecnicos.add(tecnico1);
    }

}