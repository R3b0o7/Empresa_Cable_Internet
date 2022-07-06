package Clases;

import Enumeraciones.Articulos;
import Enumeraciones.Estado;
import Enumeraciones.TipoTecnico;

import java.util.*;

public class Compania {

    /** La Compania es instanciada en el controlador, ya que esta contiene la BDD del sistema **/

    private static Compania compania;
    private ArrayList<Reparacion> reparaciones;
    private ArrayList<Instalacion> instalaciones;
    private ArrayList<Cliente> clientes;
    private Map<String, String> usuarios;
    private Map<String, String> password;
    private ArrayList<PerfilAdminSistema> usuariosAdmiSistema;
    private ArrayList<PerfilCallCenter> usuariosCallCenter;
    private ArrayList<PerfilTecnico> usuariosTecnicos;
    private ArrayList<PerfilAdministrativo> usuariosAdministrativo;
    private ArrayList<Factura> facturas;
    private ArrayList<Tecnico> tecnicos;
    private Stock stock;
    private int ultimoServicio;
    private Map<TipoTecnico, Double> maestroCostoTecnicos;

    /** Constructor privado por ser Singleton  **/
    private Compania(){
        this.reparaciones = new ArrayList<Reparacion>();
        this.instalaciones = new ArrayList<Instalacion>();
        this.clientes = new ArrayList<Cliente>();
        this.usuarios = new HashMap<String, String>();
        this.password = new HashMap<String, String>();
        this.usuariosAdmiSistema = new ArrayList<PerfilAdminSistema>();
        this.usuariosAdministrativo = new ArrayList<PerfilAdministrativo>();
        this.usuariosTecnicos = new ArrayList<PerfilTecnico>();
        this.usuariosCallCenter = new ArrayList<PerfilCallCenter>();
        this.facturas = new ArrayList<Factura>();
        this.tecnicos = new ArrayList<Tecnico>();
        this.stock = new Stock();
        this.ultimoServicio = 0;
        this.maestroCostoTecnicos = new HashMap<TipoTecnico, Double>();
        this.maestroCostoTecnicos.put(TipoTecnico.Junior, 100.0);
        this.maestroCostoTecnicos.put(TipoTecnico.Semi_senior, 200.0);
        this.maestroCostoTecnicos.put(TipoTecnico.Senior, 300.0);

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

    public int getUltimoServicio() {
        return ultimoServicio;
    }

    public void incrementarUltimoServicio(){
        this.ultimoServicio++;
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

    public Reparacion getReparacionPorCliente(int dni){
        for(Reparacion reparacion: this.getReparaciones()){
            if(reparacion.getCliente().getDni() == dni && (reparacion.getEstado() == Estado.En_curso || reparacion.getEstado() == Estado.Programado)){
                return reparacion;
            }
        }
        return null;
    }

    public Instalacion getInstalacionPorCliente(int dni){
        for(Instalacion instalacion: this.instalaciones){
            if(instalacion.getCliente().getDni() == dni && (instalacion.getEstado() == Estado.En_curso || instalacion.getEstado() == Estado.Programado)){
                return instalacion;
            }
        }
        return null;
    }

    public Cliente getCliente(int dni){
        for(Cliente cliente: this.clientes){
            if(cliente.getDni() == dni){
                return cliente;
            }
        }
        return null;
    }

    public double getCostoTecnico(TipoTecnico tipo){
        return this.maestroCostoTecnicos.get(tipo);
    }

    public String getContraseña(String usuario) {return this.password.get(usuario);};

    public String getPerfil(String usuario) {return this.usuarios.get(usuario);};

    /** Metodos **/

    public void guardarReparacion(Reparacion reparacion){
        this.reparaciones.add(reparacion);
    }

    public void guardarInstalacion(Instalacion instalacion){
        this.instalaciones.add(instalacion);
    }

    public void guardarCliente(Cliente cliente) { this.clientes.add(cliente);};

    /** Inicialización de la Base de Datos - Programa Inicial **/

    private void inicializarBDD(){

        /** Listado de Usuarios  **/
        this.usuarios.put("usrCallCenter", "callCenter");
        this.usuarios.put("usrAdministrador", "administrador");
        this.usuarios.put("usrAdministrativo", "administrativo");
        this.usuarios.put("usrTecnico", "tecnico");

        this.password.put("usrCallCenter", "admin");
        this.password.put("usrAdministrador", "admin");
        this.password.put("usrAdministrativo", "admin");
        this.password.put("usrTecnico", "admin");

        /** Creación de Articulos  **/
        // Los mismos tienen una cantidad por defecto para simplificar el caso, pero podría ser 0

        Articulo artCable = new Articulo(Articulos.Cable,1000,250.90);
        Articulo artConector_coaxial_RG6 = new Articulo(Articulos.Conector_coaxial_RG6,2500,62.25);
        Articulo artDecodificador = new Articulo(Articulos.Decodificador,50,1850);
        Articulo artDivisor = new Articulo(Articulos.Divisor,800,120.30);
        Articulo artModem = new Articulo(Articulos.Modem,50,2135.50);

        /** Creación de Stock y la lista de articulos en el stock  **/

        //Stock stock = new Stock();

        this.stock.agregarArticulo(artCable);
        this.stock.agregarArticulo(artConector_coaxial_RG6);
        this.stock.agregarArticulo(artDecodificador);
        this.stock.agregarArticulo(artDivisor);
        this.stock.agregarArticulo(artModem);

        //Tecnicos
        Clases.Tecnico tecnico1 = new Tecnico(123, "Gonzalo", "salta", 1, TipoTecnico.Junior, "Tarde");
        Clases.Tecnico tecnico2 = new Tecnico(1234, "Juan", "salta", 2, TipoTecnico.Semi_senior , "Mañana");
        Clases.Tecnico tecnico3 = new Tecnico(12345, "Pedro", "salta", 3, TipoTecnico.Senior, "Mañana");
        this.tecnicos.add(tecnico1);
        this.tecnicos.add(tecnico2);
        this.tecnicos.add(tecnico3);

        Clases.Cliente cliente1 = new Cliente(123, "gonzalo", "salta");
        Clases.Cliente cliente2 = new Cliente(12345, "Juan", "salta");
        this.clientes.add(cliente1);
        this.clientes.add(cliente2);

    }

}