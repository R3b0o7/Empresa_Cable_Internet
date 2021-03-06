package Interfaz;

import Clases.*;
import Enumeraciones.Articulos;
import Enumeraciones.TipoTecnico;
import Excepciones.GenericException;

import javax.swing.*;
import java.util.*;

public class ControllerAdministrador extends Usuario{

    static Scanner sc = new Scanner(System.in);
    private Compania compania;
    private static ControllerAdministrador controladorAdministrador;

    private ControllerAdministrador(){
        this.compania = Compania.getInstance();
    }

    public static ControllerAdministrador getInstance(){
        if(controladorAdministrador == null){
            controladorAdministrador = new ControllerAdministrador();
        }
        return controladorAdministrador;
    }

    public DefaultListModel<String> listModelTecnico(){
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        int i = 0;
        for(Tecnico tec: compania.getTecnicos()){
            listModel.add(i,+tec.getNroTécnico()
                                + " - Nombre: " + tec.getNombreApellido()
                                + " - Seniority: " + tec.getTipoTecnico()
                                + " - Estado: " + tec.getEstado()
            );
            i++;
        }
        return listModel;
    }

    public DefaultListModel<String> listModelArticulo(){
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        int i = 0;
        for(Articulo art: compania.getStock().getStockArticulos()){
            listModel.add(i,i+1+"." + art.getArticulo() + ": " + art.getCantidad() + " articulos");
            i++;
        }
        return listModel;
    }

    public void darDeBajaTecnico(int id){
        for (Tecnico tec : compania.getTecnicos()){
            if (tec.getNroTécnico() == id && tec.getEstado() == true){
                compania.getTecnico(id).setEstado(false);
                System.out.println("El Técnico Nro " + id + " fué dado de baja de manera exitosa.");
                JOptionPane.showMessageDialog(null, "El Técnico Nro "+ id + " fué dado de baja de manera exitosa.");
                System.out.println();
            }
        }
    }

    public void darDeAltaTecnico(int dni, String nombre, String direccion, TipoTecnico tipoTecnico,String turno){
        compania.guardarTecnico(new Tecnico(dni, nombre, direccion, tipoTecnico, turno ));
    }

    public String[] listadoArticulosToCombo(){
        String[] listado = new String[20];
        int i = 0;
        for(Articulo art: compania.getStock().getStockArticulos()){
            listado[i] = art.getArticulo().toString();
            i++;
        }
        return listado;
    }

    public void altaDeStock(Enumeraciones.Articulos articulo, int cantidad){
        for(Articulo art: compania.getStock().getStockArticulos()){
            if(art.getArticulo().equals(articulo)){
                art.agregarCantidadArticulos(cantidad);
            }
        }
    }

    public void bajaDeStock(Enumeraciones.Articulos articulo, int cantidad) throws GenericException{
        for (Articulo art : compania.getStock().getStockArticulos()) {
            if (art.getArticulo().equals(articulo)) {
                if(art.getCantidad() >= cantidad) {
                    art.agregarCantidadArticulos(cantidad * -1);
                } else {
                    throw new GenericException("El valor ingresado supera el stock existente.");
                }
            }
        }
    }

    public void modificarPrecioArticulo(Articulos articulo, Double precio){
        for (Articulo art : compania.getStock().getStockArticulos()) {
            if (art.getArticulo().equals(articulo)) {
                art.setPrecio(precio);
            }
        }
    }
//
//    public void menuInicial() {
//
//        //Genero los objetos base
//        this.compania = Clases.Compania.getInstance();
//
//        //ejecución menu principal
//        boolean run = true;
//        while (run) {
//            this.imprimirMenuInicial();
//
//            int opcion = ingresarEntero();
//
//            switch(opcion) {
//                case 1:
//                    this.abmTecnico();
//                    break;
//                case 2:
//                    this.abmArticulo();
//                    break;
//                case 3:
//                    this.configurarParametros();
//                    break;
//                case 0:
//                    run = false;
//                    break;
//                default:
//                    System.out.println("Opcion invalida");
//                    System.out.println();
//                    break;
//            }
//        }
//    }
//
//    public void imprimirMenuInicial() {
//        String[] menu = {"EMPRESA DE CABLE"};
//        imprimirEncabezado(menu);
//        System.out.println("1. ABM de tecnicos");
//        System.out.println("2. ABM de artículos");
//        System.out.println("3. Configurar parámetros");
//        System.out.println("0. Salir");
//        System.out.print("Elija una opción: ");
//    }
//
//    public void imprimirEncabezado(String[] menu) {
//        System.out.println("");
//        System.out.println("");
//        for(int i = 0; i < menu.length; i++ ) {
//            System.out.print(menu[i]);
//            if(i == menu.length-1) {
//                break;
//            }
//            System.out.print(" > ");
//        }
//        System.out.print("\n");
//        System.out.println("---------------------------------");
//    }
//
//    public void abmTecnico(){
//        //ejecución menu del ABM
//
//        boolean run = true;
//
//        String[] menu = {"EMPRESA DE CABLE", "ABM DE TÉCNICOS"};
//        this.imprimirEncabezado(menu);
//
//        while (run) {
//            System.out.println("1. Alta de técnico");
//            System.out.println("2. Baja de técnico");
//            System.out.println("3. Modificación de técnico");
//            System.out.println("0. Volver");
//            System.out.print("Elija una opción: ");
//            System.out.println();
//            int opcion = ingresarEntero();
//            switch(opcion) {
//                case 1: //Alta de técnico
//
//                    System.out.println();
//                    System.out.println("ALTA DE TÉCNICO");
//                    System.out.println("---------------------------------");
//                    Tecnico tecnico;
//
//                    // Ingresar primero el DNI para corroborar si existe el técnico a asociar.
//                    System.out.println("Ingrese DNI del Técnico: ");
//                    int dni = ingresarEntero();
//                    // Validar si existe el técnico antes de crearlo
//                    if (this.compania.getTecnicoDNI(dni) != null) {
//                        System.out.println("El Técnico ya existe.");
//                        return;
//                    }
//
//                    // Ingresar el resto de los datos del técnico
//                    System.out.println("Ingrese nombre del Técnico: ");
//                    String nombre = sc.nextLine();
//                    System.out.println("Ingrese direccion del Técnico: ");
//                    String direccion = sc.nextLine();
//
//                    //Selecciona turno validando que solo puedan ser las opciones mostradas
//                    String turno = "";
//                    boolean run2 = true;
//                    while (run2){
//                        System.out.println("Ingrese el turno del Técnico: ");
//                        System.out.println("1.Mañana");
//                        System.out.println("2.Tarde");
//                        System.out.print("Elija una opción: ");
//                        int opcion2 = ingresarEntero();
//                        switch (opcion2) {
//                            case 1:
//                                turno = "Mañana";
//                                run2 = false;
//                                break;
//                            case 2:
//                                turno = "Tarde";
//                                run2 = false;
//                                break;
//                            default:
//                                System.out.println("Opcion invalida");
//                                System.out.println();
//                                break;
//                        }
//                    }
//
//                    //Selecciona el tipo de técnico validando que solo puedan ser las opciones mostradas
//                    TipoTecnico tipoTecnico = seleccionarTipoTecnico();
//
//                    //Se muestran los datos ingresados antes de confirmar la creación
//                    System.out.println();
//                    System.out.println("Se creará el siguiente Técnico:");
//                    System.out.println("DNI: " + dni);
//                    System.out.println("Nombre: " + nombre);
//                    System.out.println("Direccion: " + direccion);
//                    System.out.println("Tipo de Técnico: " + tipoTecnico);
//                    System.out.println("Turno: " + turno);
//                    System.out.println("¿Confirma el alta? y/n :");
//                    //Confirmación de guardado
//                    String confirma = sc.nextLine();
//                    if (confirma.equals("y")) {
//                        tecnico = new Tecnico(dni, nombre, direccion, tipoTecnico, turno);
//                        compania.guardarTecnico(tecnico);
//                        System.out.println("El Técnico se guardó correctamente con el número " + tecnico.getNroTécnico());
//                        System.out.println();
//                    } else {
//                        System.out.println("Se canceló la operación");
//                        System.out.println();
//                    }
//                    break;
//
//                case 2: //Baja de técnico -> pasa el atributo del técnico estado = false
//                    //Muestra los técnicos activos de la compañia para dar de baja
//                    System.out.println();
//                    System.out.println("BAJA DE TÉCNICO");
//                    System.out.println("---------------------------------");
//                    System.out.println("Técnicos activos de la compania: ");
//                    for (Tecnico tec : compania.getTecnicos()) {
//                        if (tec.getEstado()) { //Muesta solo los tecnicos que no fueron dados de baja -> estado = true
//                            System.out.println("Técnico Nro " + tec.getNroTécnico() + " ; DNI: " + tec.getDni());
//                        }
//                    }
//                    System.out.println("---------------------------------");
//                    System.out.println();
//
//                    //Selecciona un técnico recorre los tecnicos de la compañia y cuando lo encuentra le cambia el estado
//                    System.out.println("Seleccione el numero de técncio que desa dar de baja: ");
//                    int nroTecnico = ingresarEntero();
//                    for (Tecnico tec2 : compania.getTecnicos()){
//                        if (tec2.getNroTécnico() == nroTecnico && tec2.getEstado() == true){
//                            compania.getTecnico(nroTecnico).setEstado(false);
//                            System.out.println("El Técnico Nro " + nroTecnico + " fué dado de baja de manera exitosa.");
//                            System.out.println();
//                        }
//                    }
//                    //VER COMO MOSTRAR UN MENSAJE QUE EL TECNICO SELECCIONADO NO ES UN TECNICO DISPONIBLE PARA DAR DE BAJA
//                    break;
//
//                case 3://Modificación de técnico
//                    //Muestra los técnicos activos de la compañia para modificar.
//                    System.out.println();
//                    System.out.println("MODIFICAR TÉCNICO");
//                    System.out.println("---------------------------------");
//                    System.out.println("Técnicos activos de la compania: ");
//                    for (Tecnico tec : compania.getTecnicos()) {
//                        if (tec.getEstado()) { //Muesta solo los tecnicos que no fueron dados de baja -> estado = true
//                            System.out.println("Técnico Nro " + tec.getNroTécnico() + "; DNI: " + tec.getDni() + "; Tipo: " + tec.getTipoTecnico());
//                        }
//                    }
//                    System.out.println("---------------------------------");
//                    System.out.println();
//
//                    //Selecciona un técnico recorre los tecnicos de la compañia
//                    System.out.println("Seleccione el numero de técncio que desa modificar: ");
//                    int nroTecnicoModificar = ingresarEntero();
//                    for (Tecnico tecModificar : compania.getTecnicos()){
//                        if (tecModificar.getNroTécnico() == nroTecnicoModificar && tecModificar.getEstado() == true){
//                            System.out.println("Opciones para modificar:");
//                            System.out.println("1. Cambiar dirección");
//                            System.out.println("2. Cambiar tipo de técnico");
//                            System.out.println("0. Volver");
//                            System.out.print("Elija una opción: ");
//                            boolean run4 = true;
//                            int opcion4 = ingresarEntero();
//                            while (run4){
//                                switch (opcion4){
//                                    case 1:
//                                        System.out.println("Ingresar la nueva dirección: ");
//                                        String nuevaDireccion = sc.nextLine();
//                                        tecModificar.setDirección(nuevaDireccion);
//                                        System.out.println("La modificación fue realizada con exito");
//                                        System.out.println();
//                                        run4 = false;
//                                        break;
//                                    case 2:
//                                        TipoTecnico tipoTecnico2 = seleccionarTipoTecnico();
//                                        tecModificar.setTipoTecnico(tipoTecnico2);
//                                        System.out.println("La modificación fue realizada con exito");
//                                        System.out.println();
//                                        run4 = false;
//                                        break;
//                                    case 0 :
//                                        run4 = false;
//                                        break;
//                                    default:
//                                        System.out.println("Opcion invalida");
//                                        break;
//                                 }
//                            }
//                        }
//                    }
//                    break;
//                case 0:
//                    run = false;
//                    break;
//                default:
//                    System.out.println("Opcion invalida");
//                    break;
//            }
//        }
//    }
//
//    public void abmArticulo(){
//
//        boolean run = true;
//
//        String[] menu = {"EMPRESA DE CABLE", "ABM DE ARTÍCULO"};
//        this.imprimirEncabezado(menu);
//
//        while (run) {
//            System.out.println("1. Alta de artículo");
//            System.out.println("2. Baja de artículo");
//            System.out.println("3. Modificación de artículo");
//            System.out.println("0. Volver");
//            System.out.print("Elija una opción: ");
//            System.out.println();
//            int opcion = ingresarEntero();
//            switch (opcion) {
//                case 1: //Alta de artículo -> Alta de Stock
//                    System.out.println("ALTA DE ARTICULOS EN EL STOCK");
//                    System.out.println("La lista de existencias actual es:\n" +
//                            "1. " + compania.getStock().getStockArticulos().get(0).getArticulo() + ": " + compania.getStock().getStockArticulos().get(0).getCantidad() + " articulos\n" +
//                            "2. " + compania.getStock().getStockArticulos().get(1).getArticulo() + ": " + compania.getStock().getStockArticulos().get(1).getCantidad() + " articulos\n" +
//                            "3. " + compania.getStock().getStockArticulos().get(2).getArticulo() + ": " + compania.getStock().getStockArticulos().get(2).getCantidad() + " articulos\n" +
//                            "4. " + compania.getStock().getStockArticulos().get(3).getArticulo() + ": " + compania.getStock().getStockArticulos().get(3).getCantidad() + " articulos\n" +
//                            "5. " + compania.getStock().getStockArticulos().get(4).getArticulo() + ": " + compania.getStock().getStockArticulos().get(4).getCantidad() + " articulos\n");
//
//                    boolean run1 = true;
//                    while(run1){
//                        System.out.println("Seleccionar producto:");
//                        int opcion1 = ingresarEntero();
//                        switch (opcion1){
//                            case 1:
//                                System.out.println("Ingrese la cantidad de articulos de Cable a agregar:");
//                                int nuevoCantidad = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(0).agregarCantidadArticulos(nuevoCantidad);
//                                System.out.println("La cantidad agregada de articulos es de " + nuevoCantidad + ", con un total de "
//                                        + compania.getStock().getStockArticulos().get(0).getCantidad() + " articulos en existencias de Cable");
//                                System.out.println();
//                                run1 = false;
//                                break;
//                            case 2:
//                                System.out.println("Ingrese la cantidad de articulos de Conector coaxial RG6 a agregar:");
//                                int nuevoCantidad2 = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(1).agregarCantidadArticulos(nuevoCantidad2);
//                                System.out.println("La cantidad agregada de articulos es de " + nuevoCantidad2 + ", con un total de "
//                                        + compania.getStock().getStockArticulos().get(1).getCantidad() + " articulos en existencias de Conector coaxial RG6");
//                                System.out.println();
//                                run1 = false;
//                                break;
//                            case 3:
//                                System.out.println("Ingrese la cantidad de articulos de Decodificador a agregar:");
//                                int nuevoCantidad3 = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(2).agregarCantidadArticulos(nuevoCantidad3);
//                                System.out.println("La cantidad agregada de articulos es de " + nuevoCantidad3 + ", con un total de "
//                                        + compania.getStock().getStockArticulos().get(2).getCantidad() + " articulos en existencias de Decodificador");
//                                System.out.println();
//                                run1 = false;
//                                break;
//                            case 4:
//                                System.out.println("Ingrese la cantidad de articulos de Divisor a agregar:");
//                                int nuevoCantidad4 = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(3).agregarCantidadArticulos(nuevoCantidad4);
//                                System.out.println("La cantidad agregada de articulos es de " + nuevoCantidad4 + ", con un total de "
//                                        + compania.getStock().getStockArticulos().get(3).getCantidad() + " articulos en existencias de Divisor");
//                                System.out.println();
//                                run1 = false;
//                                break;
//                            case 5:
//                                System.out.println("Ingrese la cantidad de articulos de Modem a agregar:");
//                                int nuevoCantidad5 = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(4).agregarCantidadArticulos(nuevoCantidad5);
//                                System.out.println("La cantidad agregada de articulos es de " + nuevoCantidad5 + ", con un total de "
//                                        + compania.getStock().getStockArticulos().get(4).getCantidad() + " articulos en existencias de Modem");
//                                System.out.println();
//                                run1 = false;
//                                break;
//                        }
//                    }
//                    break;
//                case 2: //Baja de artículo -> Baja de Stock
//                    System.out.println("BAJA DE ARTICULOS EN EL STOCK");
//                    System.out.println("La lista de existencias actual es:\n" +
//                            "1. " + compania.getStock().getStockArticulos().get(0).getArticulo() + ": " + compania.getStock().getStockArticulos().get(0).getCantidad() + " articulos\n" +
//                            "2. " + compania.getStock().getStockArticulos().get(1).getArticulo() + ": " + compania.getStock().getStockArticulos().get(1).getCantidad() + " articulos\n" +
//                            "3. " + compania.getStock().getStockArticulos().get(2).getArticulo() + ": " + compania.getStock().getStockArticulos().get(2).getCantidad() + " articulos\n" +
//                            "4. " + compania.getStock().getStockArticulos().get(3).getArticulo() + ": " + compania.getStock().getStockArticulos().get(3).getCantidad() + " articulos\n" +
//                            "5. " + compania.getStock().getStockArticulos().get(4).getArticulo() + ": " + compania.getStock().getStockArticulos().get(4).getCantidad() + " articulos\n");
//
//                    boolean run2 = true;
//                    while(run2){
//                        System.out.println("Seleccionar producto:");
//                        int opcion2 = ingresarEntero();
//                        switch (opcion2){
//                            case 1:
//                                System.out.println("Ingrese la cantidad de articulos de Cable a dar de baja:");
//                                int nuevoCantidad = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(0).agregarCantidadArticulos(-nuevoCantidad);
//                                if (compania.getStock().getStockArticulos().get(0).getCantidad() < 0){
//                                    System.out.println("La cantidad a dar de baja es superior a la cantidad de existencias del articulo");
//                                    compania.getStock().getStockArticulos().get(0).agregarCantidadArticulos(nuevoCantidad);
//                                    run2 = false;
//                                    break;
//                                }
//                                System.out.println("La cantidad dada de baja de articulos es de " + nuevoCantidad + " ,con un total de "
//                                        + compania.getStock().getStockArticulos().get(0).getCantidad() + " articulos en existencias de Cable");
//                                System.out.println();
//                                run2 = false;
//                                break;
//                            case 2:
//                                System.out.println("Ingrese la cantidad de articulos de Conector coaxial RG6 a dar de baja:");
//                                int nuevoCantidad2 = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(1).agregarCantidadArticulos(-nuevoCantidad2);
//                                if (compania.getStock().getStockArticulos().get(1).getCantidad() < 0){
//                                    System.out.println("La cantidad a dar de baja es superior a la cantidad de existencias del articulo");
//                                    compania.getStock().getStockArticulos().get(1).agregarCantidadArticulos(nuevoCantidad2);
//                                    run2 = false;
//                                    break;
//                                }
//                                System.out.println("La cantidad dada de baja de articulos es de " + nuevoCantidad2 + " ,con un total de "
//                                        + compania.getStock().getStockArticulos().get(1).getCantidad() + " articulos en existencias de Conector coaxial RG6");
//                                System.out.println();
//                                run2 = false;
//                                break;
//                            case 3:
//                                System.out.println("Ingrese la cantidad de articulos de Decodificador a dar de baja:");
//                                int nuevoCantidad3 = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(2).agregarCantidadArticulos(-nuevoCantidad3);
//                                if (compania.getStock().getStockArticulos().get(2).getCantidad() < 0){
//                                    System.out.println("La cantidad a dar de baja es superior a la cantidad de existencias del articulo");
//                                    compania.getStock().getStockArticulos().get(2).agregarCantidadArticulos(nuevoCantidad3);
//                                    run2 = false;
//                                    break;
//                                }
//                                System.out.println("La cantidad dada de baja de articulos es de " + nuevoCantidad3 + " ,con un total de "
//                                        + compania.getStock().getStockArticulos().get(2).getCantidad() + " articulos en existencias de Decodificador");
//                                System.out.println();
//                                run2 = false;
//                                break;
//                            case 4:
//                                System.out.println("Ingrese la cantidad de articulos de Divisor a dar de baja:");
//                                int nuevoCantidad4 = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(3).agregarCantidadArticulos(-nuevoCantidad4);
//                                if (compania.getStock().getStockArticulos().get(3).getCantidad() < 0){
//                                    System.out.println("La cantidad a dar de baja es superior a la cantidad de existencias del articulo");
//                                    compania.getStock().getStockArticulos().get(3).agregarCantidadArticulos(nuevoCantidad4);
//                                    run2 = false;
//                                    break;
//                                }
//                                System.out.println("La cantidad dada de baja de articulos es de " + nuevoCantidad4 + " ,con un total de "
//                                        + compania.getStock().getStockArticulos().get(3).getCantidad() + " articulos en existencias de Divisor");
//                                System.out.println();
//                                run2 = false;
//                                break;
//                            case 5:
//                                System.out.println("Ingrese la cantidad de articulos de Modem a dar de baja:");
//                                int nuevoCantidad5 = ingresarEntero();
//                                compania.getStock().getStockArticulos().get(4).agregarCantidadArticulos(-nuevoCantidad5);
//                                if (compania.getStock().getStockArticulos().get(4).getCantidad() < 0){
//                                    System.out.println("La cantidad a dar de baja es superior a la cantidad de existencias del articulo");
//                                    compania.getStock().getStockArticulos().get(4).agregarCantidadArticulos(nuevoCantidad5);
//                                    run2 = false;
//                                    break;
//                                }
//                                System.out.println("La cantidad dada de baja de articulos es de " + nuevoCantidad5 + " ,con un total de "
//                                        + compania.getStock().getStockArticulos().get(4).getCantidad() + " articulos en existencias de Modem");
//                                System.out.println();
//                                run2 = false;
//                                break;
//                        }
//                    }
//                    break;
//                case 3: //Modificación de artículo -> cambio de preico
//                    System.out.println("MODIFICAR PRECIO");
//                    System.out.println("La lista de precio actual es:\n" +
//                            "1. " + compania.getStock().getStockArticulos().get(0).getArticulo() + ": " + compania.getStock().getStockArticulos().get(0).getPrecio() + "$\n" +
//                            "2. " + compania.getStock().getStockArticulos().get(1).getArticulo() + ": " + compania.getStock().getStockArticulos().get(1).getPrecio() + "$\n" +
//                            "3. " + compania.getStock().getStockArticulos().get(2).getArticulo() + ": " + compania.getStock().getStockArticulos().get(2).getPrecio() + "$\n" +
//                            "4. " + compania.getStock().getStockArticulos().get(3).getArticulo() + ": " + compania.getStock().getStockArticulos().get(3).getPrecio() + "$\n" +
//                            "5. " + compania.getStock().getStockArticulos().get(4).getArticulo() + ": " + compania.getStock().getStockArticulos().get(4).getPrecio() + "$\n");
//
//                    boolean run3 = true;
//                    while (run3) {
//                        System.out.println("Seleccionar producto:");
//                        int opcion2 = ingresarEntero();
//                        switch (opcion2) {
//                            case 1:
//                                System.out.println("Ingrese el nuevo precio para el Cable:");
//                                double nuevoPrecio = ingresarDouble();
//                                compania.getStock().getStockArticulos().get(0).setPrecio(nuevoPrecio);
//                                System.out.println("El precio del cable fue actualizado correctamente a " + nuevoPrecio + "$");
//                                System.out.println();
//                                run3 = false;
//                                break;
//                            case 2:
//                                System.out.println("Ingrese el nuevo precio para el Conector coaxial RG6:");
//                                double nuevoPrecio2 = ingresarDouble();
//                                compania.getStock().getStockArticulos().get(1).setPrecio(nuevoPrecio2);
//                                System.out.println("El precio del Conector coaxial RG6 fue actualizado correctamente a " + nuevoPrecio2 + "$");
//                                System.out.println();
//                                run3 = false;
//                                break;
//                            case 3:
//                                System.out.println("Ingrese el nuevo precio para el Decodificador:");
//                                double nuevoPrecio3 = ingresarDouble();
//                                compania.getStock().getStockArticulos().get(2).setPrecio(nuevoPrecio3);
//                                System.out.println("El precio del Decodificador fue actualizado correctamente a " + nuevoPrecio3 + "$");
//                                System.out.println();
//                                run3 = false;
//                                break;
//                            case 4:
//                                System.out.println("Ingrese el nuevo precio para el Divisor:");
//                                double nuevoPrecio4 = ingresarDouble();
//                                compania.getStock().getStockArticulos().get(3).setPrecio(nuevoPrecio4);
//                                System.out.println("El precio del Divisor fue actualizado correctamente a " + nuevoPrecio4 + "$");
//                                System.out.println();
//                                run3 = false;
//                                break;
//                            case 5:
//                                System.out.println("Ingrese el nuevo precio para el Modem:");
//                                double nuevoPrecio5 = ingresarDouble();
//                                compania.getStock().getStockArticulos().get(4).setPrecio(nuevoPrecio5);
//                                System.out.println("El precio del Modem fue actualizado correctamente a " + nuevoPrecio5 + "$");
//                                System.out.println();
//                                run3 = false;
//                                break;
//                            default:
//                                System.out.println("Opcion invalida");
//                                System.out.println();
//                                break;
//                        }
//                    }
//                    break;
//                case 0: //Volver
//                    run = false;
//                    break;
//                default: //Para numeros invalidos
//                    System.out.println("Opcion invalida");
//                    System.out.println();
//                    break;
//            }
//        }
//    }
//
//    public void configurarParametros() { // Modificar Costo Tecnico Segun Seniority - Costo Combustible - Costo de Viaje
//        //ejecución menu de la configuración de parametros
//        Scanner sc = new Scanner(System.in);
//        boolean run = true;
//
//        String[] menu = {"EMPRESA DE CABLE", "CONFIGURAR PARÁMETROS"};
//        this.imprimirEncabezado(menu);
//
//        while(run) {
//            System.out.println("Parametro a modificar:");
//            System.out.println("1. Precio por Tipo Técnico");
//            System.out.println("2. Costo Combustible");
//            System.out.println("3. Costo base de Viaje");
//            System.out.println("0. Volver");
//            System.out.print("Elija una opción: ");
//
//            int opcion = ingresarEntero();
//            switch (opcion){
//                case 1: //Cambia el precio por tipo de tecnico (seniority)
//                    System.out.println();
//                    boolean run2 = true;
//                    while (run2){
//                        System.out.println("Tipo de Técnico a modificar:");
//                        System.out.println("1. Junior");
//                        System.out.println("2. Semi senior");
//                        System.out.println("3. Senior");
//                        System.out.println("0. Volver");
//                        System.out.print("Elija una opción: ");
//                        int opcion2 = ingresarEntero();
//                        switch (opcion2){
//                            case 1: //Cambia precio de Junior
//                                System.out.println("El costo actual por hora del técnico Junior es " +
//                                        compania.getMaestroCostoTecnicos().get(TipoTecnico.Junior) + "$");
//                                System.out.println("Ingresar nuevo valor por hora para el técnico Junior:");
//                                double costoJunior = ingresarDouble();
//                                compania.getMaestroCostoTecnicos().put(TipoTecnico.Junior,costoJunior);
//                                System.out.println("El costo actual por hora del técnico Junior fue actualizado correctamente a " +
//                                        compania.getMaestroCostoTecnicos().get(TipoTecnico.Junior) + "$");
//                                run2 = false;
//                                break;
//                            case 2: //Cambia precio de Semi senior
//                                System.out.println("El costo actual por hora del técnico Semi senior es " +
//                                        compania.getMaestroCostoTecnicos().get(TipoTecnico.Semi_senior) + "$");
//                                System.out.println("Ingresar nuevo valor por hora para el técnico Semi senior:");
//                                double costoJSemi_senior = ingresarDouble();
//                                compania.getMaestroCostoTecnicos().put(TipoTecnico.Semi_senior,costoJSemi_senior);
//                                System.out.println("El costo actual por hora del técnico Semi senior fue actualizado correctamente a " +
//                                        compania.getMaestroCostoTecnicos().get(TipoTecnico.Semi_senior) + "$");
//                                run2 = false;
//                                break;
//                            case 3: //Cambia precio de Senior
//                                System.out.println("El costo actual por hora del técnico Senior es " +
//                                        compania.getMaestroCostoTecnicos().get(TipoTecnico.Senior) + "$");
//                                System.out.println("Ingresar nuevo valor por hora para el técnico Senior:");
//                                double costoSenior = ingresarDouble();
//                                compania.getMaestroCostoTecnicos().put(TipoTecnico.Senior,costoSenior);
//                                System.out.println("El costo actual por hora del técnico Senior fue actualizado correctamente a " +
//                                        compania.getMaestroCostoTecnicos().get(TipoTecnico.Senior) + "$");
//                                run2 = false;
//                                break;
//                            case 0: //Vuelve
//                                run2 = false;
//                                break;
//                            default: //Para numeros invalidos
//                                System.out.println("Opcion invalida");
//                                System.out.println();
//                                break;
//                        }
//                    }
//                    break;
//                case 2: //Cambia el precio del combustible
//                    System.out.println("El costo actual del combustible es " + compania.getPrecioCombustible() + "$/litro");
//                    System.out.println("Ingresar nuevo valor del combustible");
//                    double nuevoPrecioCombustible = ingresarDouble();
//                    compania.setPrecioCombustible(nuevoPrecioCombustible);
//                    System.out.println("El precio del combustible fue actualizado correctamente a "
//                            + nuevoPrecioCombustible + "$/litro");
//                    break;
//                case 3: //Cambia el costo base del viaje
//                    System.out.println("El costo base actual del viaje es " + compania.getCostoDeViaje() + "$");
//                    System.out.println("Ingresar nuevo costo base de viaje");
//                    double nuevoCostoViaje = ingresarDouble();
//                    compania.setCostoDeViaje(nuevoCostoViaje);
//                    System.out.println("El costo base del viaje fue actualizado correctamente a " + nuevoCostoViaje + "$");
//                    break;
//                case 0:
//                    run = false;
//                    break;
//                default:
//                    System.out.println("Opcion invalida");
//                    System.out.println();
//                    break;
//            }
//        }
//    }
//
//    public TipoTecnico seleccionarTipoTecnico(){
//        TipoTecnico tipoTecnico = TipoTecnico.Junior;
//        boolean run = true;
//        while (run){
//            System.out.println("Tipo Técnico: ");
//            System.out.println("1. Junior");
//            System.out.println("2. Semi senior");
//            System.out.println("3. Senior");
//            System.out.print("Elija una opción: ");
//            int opcion3 = ingresarEntero();
//            switch (opcion3) {
//                case 1:
//                    tipoTecnico = TipoTecnico.Junior;
//                    run = false;
//                    break;
//                case 2:
//                    tipoTecnico = TipoTecnico.Semi_senior;
//                    run = false;
//                    break;
//                case 3:
//                    tipoTecnico = TipoTecnico.Senior;
//                    run = false;
//                    break;
//                default:
//                    System.out.println("Opcion invalida");
//                    System.out.println();
//                    break;
//            }
//        }
//        return tipoTecnico;
//    }
//
//    public static int ingresarEntero() {
//        boolean repetir;
//        int n = 100;
//        do {
//            repetir = false;
//            try {
//                n = sc.nextInt();
//                return n;
//            }
//            catch (InputMismatchException exception) {
//                System.out.println("ERROR. El valor no corresponde a un Entero. Volver a ingresar: ");
//                repetir = true;
//            }
//            finally {
//                sc.nextLine();
//            }
//        } while (repetir);
//        return n;
//    }
//
//    public static double ingresarDouble() {
//        boolean repetir;
//        double n = 100.0;
//        do {
//            repetir = false;
//            try {
//                n = sc.nextDouble();
//                return n;
//            }
//            catch (InputMismatchException exception) {
//                System.out.println("ERROR. El valor no corresponde a un Número con Decimales. Volver a ingresar: ");
//                repetir = true;
//            }
//            finally {
//                sc.nextLine();
//            }
//        } while (repetir);
//        return n;
//    }

}
