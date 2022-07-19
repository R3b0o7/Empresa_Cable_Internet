package Controladores;

import Clases.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerTecnico extends Usuario {

    static Scanner sc = new Scanner(System.in);
    private Compania compania = Clases.Compania.getInstance();
    private static ControllerTecnico controladorTecnico;

    public static ControllerTecnico getInstance(){
        if(controladorTecnico == null){
            controladorTecnico = new ControllerTecnico();
        }
        return controladorTecnico;
    }

    public void menuInicial() {
        // TODO Auto-generated method stub

        //Genero los objetos base


        //ejecución menu principal
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            this.imprimirMenuInicial();
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    //this.serviciosAsignados();
                    break;
                case "2":
                    //this.cargarDatosServicio();
                    break;
                case "0":
                    run = false;
                    break;
                default:
                    System.out.println("No se ingreso una opcion correcta");
            }
        }
    }

    public void imprimirMenuInicial() {
        String[] menu = {"EMPRESA DE CABLE"};
        imprimirEncabezado(menu);
        System.out.println("1. Listar servicios asignados");
        System.out.println("2. Finalizar servicio");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
    }

    public void imprimirEncabezado(String[] menu) {
        System.out.println("\n");
        System.out.println("\n");
        for (int i = 0; i < menu.length; i++) {
            System.out.print(menu[i]);
            if (i == menu.length - 1) {
                break;
            }
            System.out.print(" > ");
        }
        System.out.print("\n");
        System.out.println("##################################");
    }

    public ArrayList<String> serviciosAsignados(String nroTecnico) {
        ArrayList<String> servicios = new ArrayList<>();
        this.compania = Clases.Compania.getInstance();
        System.out.println("REPARACIONES: ");
        if (this.compania.getReparaciones().size() == 0) {
            System.out.println("No existen reparaciones");
        } else {
            for (Reparacion reparacion : this.compania.getReparaciones()) {
                System.out.println("Ingrese su numero de tecnico: "+nroTecnico);
                //int nroTecnico = ingresarEntero();
                Reparacion rep = reparacion;
                for (Tecnico tecnicoReparacion : reparacion.getTecnicos()) {
                    try {
                        if (tecnicoReparacion.getNroTécnico() == Integer.valueOf(nroTecnico)) {
                            System.out.println("ID Reparacion: " + reparacion.getIdServicio() +
                                    " - Fecha: " + reparacion.getFecha() +
                                    " - Horario: " + reparacion.getHora() +
                                    "\nTecnicos: " + reparacion.getTecnicos() +
                                    " - Cliente: " + reparacion.getCliente().getNombreApellido() +
                                    " - DNI cliente: " + reparacion.getCliente().getDni() +
                                    " - TECNICO: " + Integer.valueOf(nroTecnico));
                            servicios.add(rep.toString());
//                            servicios.add("ID Servicio: ");
//                            servicios.add(String.valueOf(reparacion.getIdServicio()));
//                            servicios.add("Tipo Servicio: ");
//                            servicios.add(String.valueOf(reparacion.getTipoServicio()));
//                            servicios.add("Cliente: ");
//                            servicios.add(String.valueOf(reparacion.getCliente().getNombreApellido()));
//                            servicios.add("Tecnico/s: ");
//                            for (int k = 0 ; k < reparacion.getTecnicos().size() ; k++){
//                                servicios.add("ID: ");
//                                servicios.add(String.valueOf(reparacion.getTecnicos().get(k).getNroTécnico()));
//                                servicios.add("Nombre: ");
//                                servicios.add(String.valueOf(reparacion.getTecnicos().get(k).getNombreApellido()));
//                                servicios.add("Tipo: ");
//                                servicios.add(String.valueOf(reparacion.getTecnicos().get(k).getTipoTecnico()));
//                                servicios.add("Turno: ");
//                                servicios.add(String.valueOf(reparacion.getTecnicos().get(k).getTurno()));
//                            }
//                            servicios.add("Fecha: ");
//                            servicios.add(String.valueOf(reparacion.getFecha()));
//                            servicios.add("Hora servicio: ");
//                            servicios.add(String.valueOf(reparacion.getHora()));
//                            servicios.add("Materiales Adicionales: ");
//                            servicios.add(String.valueOf(reparacion.getMaterialesAdicionales()));
//                            servicios.add("Tiempo Trabajado: ");
//                            servicios.add(String.valueOf(reparacion.getTiempoTrabajado()));
//                            servicios.add("Estado: ");
//                            servicios.add(String.valueOf(reparacion.getEstado()));
//                            servicios.add("Precio Final: ");
//                            servicios.add(String.valueOf(reparacion.getPrecioFinal()));
//                            servicios.add("Costo Real: ");
//                            servicios.add(String.valueOf(reparacion.getCostoReal()));
                        } else {
                            System.out.println("No existen Reparaciones asignadas");
                        }
                    } catch (NumberFormatException exception) {
                        JOptionPane.showMessageDialog(null,"Numero de tecnico invalido");
                    }
                }
            }
        }
        System.out.println("\n");
        System.out.println("INSTALACIONES: ");
        if (this.compania.getInstalaciones().size() == 0) {
            System.out.println("No existen instalaciones");
        } else {
            for (Instalacion instalacion : this.compania.getInstalaciones()) {
                System.out.println("Ingrese su numero de tecnico: ");
                //int nroTecnico = ingresarEntero();
                Instalacion inst = instalacion;
                for (Tecnico tecnicoInstalacion : instalacion.getTecnicos()) {
                    try {
                        if (tecnicoInstalacion.getNroTécnico() == Integer.valueOf(nroTecnico)) {
                            System.out.println("ID Instalacion: " + instalacion.getIdServicio() +
                                    " - Fecha: " + instalacion.getFecha() +
                                    " - Horario: " + instalacion.getHora() +
                                    "\nTecnicos: " + instalacion.getTecnicos() +
                                    " - Cliente: " + instalacion.getCliente().getNombreApellido() +
                                    " - DNI cliente: " + instalacion.getCliente().getDni());
                            servicios.add(inst.toString());
//                            servicios.add(String.valueOf(instalacion.getIdServicio()));
//                            servicios.add("Tipo Servicio: ");
//                            servicios.add(String.valueOf(instalacion.getTipoServicio()));
//                            servicios.add("Cliente: ");
//                            servicios.add(String.valueOf(instalacion.getCliente().getNombreApellido()));
//                            servicios.add("Tecnico/s: ");
//                            for (int k = 0 ; k < instalacion.getTecnicos().size() ; k++){
//                                servicios.add("ID: ");
//                                servicios.add(String.valueOf(instalacion.getTecnicos().get(k).getNroTécnico()));
//                                servicios.add("Nombre: ");
//                                servicios.add(String.valueOf(instalacion.getTecnicos().get(k).getNombreApellido()));
//                                servicios.add("Tipo: ");
//                                servicios.add(String.valueOf(instalacion.getTecnicos().get(k).getTipoTecnico()));
//                                servicios.add("Turno: ");
//                                servicios.add(String.valueOf(instalacion.getTecnicos().get(k).getTurno()));
//                            }
//                            servicios.add("Fecha: ");
//                            servicios.add(String.valueOf(instalacion.getFecha()));
//                            servicios.add("Hora servicio: ");
//                            servicios.add(String.valueOf(instalacion.getHora()));
//                            servicios.add("Materiales Adicionales: ");
//                            servicios.add(String.valueOf(instalacion.getMaterialesAdicionales()));
//                            servicios.add("Tiempo Trabajado: ");
//                            servicios.add(String.valueOf(instalacion.getTiempoTrabajado()));
//                            servicios.add("Estado: ");
//                            servicios.add(String.valueOf(instalacion.getEstado()));
//                            servicios.add("Precio Final: ");
//                            servicios.add(String.valueOf(instalacion.getPrecioFinal()));
//                            servicios.add("Costo Real: ");
//                            servicios.add(String.valueOf(instalacion.getCostoReal()));
                        } else {
                            System.out.println("No existen Instalaciones asignadas");
                        }
                    } catch (NumberFormatException exception) {}
                }
            }
        }
        return servicios;
    }

    public void cargarDatosServicio(String tipo, Integer nroTecnico, int nroServicio, ArrayList<String> materiales, ArrayList<String> materialesAdic, String almuerzo, String combustible, String tiempoTrabajado) {
        //boolean run = true;
        //while (run) {
            System.out.println("Desea cargar datos de 1-REPARACIONES / 2-INSTALACIONES / 0-SALIR: ");
            //int res = ingresarEntero();
                switch (tipo) {
                    /*case 0:
                        System.out.println("Saliendo");
                        run = false;
                        break;*/
                    case "Reparacion":
                        //Cargar datos REPARACIONES
                        for (Reparacion reparacion : this.compania.getReparaciones()) {
                            System.out.println("Ingrese su numero de tecnico: ");
                            //int nroTecnico = ingresarEntero();
                            for (Tecnico tecnico : reparacion.getTecnicos()) {
                                if (tecnico.getNroTécnico() == nroTecnico) {
                                    //serviciosAsignados();
                                    //System.out.println("Ingrese el numero de Reparacion a cargar datos: ");
                                    if (reparacion.getIdServicio() == nroServicio) {

                                        //Ingresa materiales usados
                                        for (int k = 0 ; k < materiales.size() ; k+=2) {
                                            /*System.out.println("Utilizó " + articulo.getArticulo() + " (Y/N): ");
                                            String opcion = sc.nextLine();
                                            if (opcion.equals("Y")) {
                                                System.out.println("Que cantidad?: ");
                                                //int cantidad = ingresarEntero();
                                                reparacion.addMaterial(articulo, cantidad);
                                                this.compania.getStock().getArticulo(articulo.getArticulo()).agregarCantidadArticulos(-cantidad);
                                            }*/
                                            for (Articulo articulo : this.compania.getStock().getStockArticulos()) {
                                                if (String.valueOf(articulo.getArticulo()).equals(materiales.get(k))){
                                                    reparacion.addMaterial(articulo,Integer.valueOf(materiales.get(k+1)));
                                                }
                                            }
                                        }

                                        //Ingresa materiales adicionales
                                        /* while (true) {
                                            System.out.println("Ingrese el nombre del material adicional (vacio para no ingresar mas): ");
                                            String material = sc.nextLine();
                                            if (!material.equals("")) {
                                                reparacion.setMaterialesAdicionales(material);
                                                System.out.println("Ingrese el costo del " + material + ": ");
                                                double costo = ingresarDouble();
                                                reparacion.setCostoMaterialesAdicionales(costo);
                                                sc.nextLine();
                                            } else {
                                                System.out.println("No se ingresan materiales adicionales");
                                                break;
                                            }
                                        }*/
                                        for (int k = 0 ; k < materialesAdic.size() ; k+=2) {
                                            double costo = Double.valueOf(materialesAdic.get(k+1));
                                            reparacion.setCostoMaterialesAdicionales(costo);
                                            reparacion.setMaterialesAdicionales(materialesAdic.get(k));
                                        }

                                        //Ingresa si hubo almuerzo
                                        /*System.out.println("Realizó almuerzo? (Y/N): ");
                                        String confirmacion = sc.nextLine();
                                        if (confirmacion.equals("Y")) {
                                            System.out.println("Almuerzo cargado");
                                            reparacion.setAlmuerzo(true);
                                        } else {
                                            System.out.println("No se realizo almuerzo");
                                            reparacion.setAlmuerzo(false);
                                        }*/
                                        reparacion.setAlmuerzo(almuerzo.equals("Si"));

                                        //Indica si compro combustible
                                        /* System.out.println("Compro combustible? (Y/N): ");
                                        confirmacion = sc.nextLine();
                                        if (confirmacion.equals("Y")) {
                                            System.out.println("Ingrese los litros cúbicos cargados: ");
                                            double costoCombustible = ingresarDouble() * this.compania.getPrecioCombustible();
                                            reparacion.setCombustible(costoCombustible);
                                        } else {
                                            System.out.println("No se realizo compra de combustible");
                                        }*/
                                        reparacion.setCombustible(Double.parseDouble(combustible));

                                        //Calcula tiempo trabajado
                                        //while (true) {
                                        //System.out.println("Ingrese la cantidad de tiempo trabajado (en min): ");
                                        //int horaFin = ingresarEntero();
                                        if (Integer.parseInt(tiempoTrabajado) > 29) {
                                            reparacion.calcularTiempoTrabajado(Integer.parseInt(tiempoTrabajado),nroTecnico);

                                            System.out.println("DATOS CARGADOS");
                                            reparacion.finalizarServicio();
                                            JOptionPane.showMessageDialog(null,"Datos cargados con exito","Datos NO cargados",JOptionPane.INFORMATION_MESSAGE);

                                            break;
                                        } else {
                                            System.out.println("Tiempo trabajado incorrecto");
                                            JOptionPane.showMessageDialog(null,"Debe ingresar tiempo trabajado mayor o igual a 30 minutos","Tiempo trabajado incorrecto",JOptionPane.ERROR_MESSAGE);
                                        }
                                        //}
                                    }
                                } else {
                                    System.out.println("No existen Reparaciones a finalizar");
                                    JOptionPane.showMessageDialog(null,"No existen Reparaciones a finalizar","Datos cargados",JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                                JOptionPane.showMessageDialog(null,"No existen Reparaciones a finalizar","Datos cargados",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                    case "Instalacion":
                        //Cargar datos INSTALACIONES
                        for (Instalacion instalacion : this.compania.getInstalaciones()) {
                            System.out.println("Ingrese su numero de tecnico: ");
                            //int nroTecnico = ingresarEntero();
                            for (Tecnico tecnicoInstalacion : instalacion.getTecnicos()) {
                                if (tecnicoInstalacion.getNroTécnico() == nroTecnico) {
                                    //serviciosAsignados();
                                    //System.out.println("Ingrese el numero de Instalacion a cargar datos: ");
                                    if (instalacion.getIdServicio() == nroServicio) {

                                        //Ingresa materiales usados
                                        for (int k = 0 ; k < materiales.size() ; k+=2){
                                            /*
                                            System.out.println("Utilizó "+articulo.getArticulo()+" (Y/N): ");
                                            String opcion = sc.nextLine();
                                            if (opcion.equals("Y")){
                                                System.out.println("Que cantidad?: ");
                                                int cantidad = ingresarEntero();
                                                instalacion.addMaterial(articulo,cantidad);
                                                this.compania.getStock().getArticulo(articulo.getArticulo()).agregarCantidadArticulos(-cantidad);
                                            }*/
                                            for (Articulo articulo : this.compania.getStock().getStockArticulos()) {
                                                if (String.valueOf(articulo.getArticulo()).equals(materiales.get(k))){
                                                    instalacion.addMaterial(articulo,Integer.valueOf(materiales.get(k+1)));
                                                }
                                            }
                                        }

                                        //Ingresa materiales adicionales
                                        /*while (true) {
                                            System.out.println("Ingrese el nombre del material adicional (vacio para no ingresar mas): ");
                                            String material = sc.nextLine();
                                            if (!material.equals("")) {
                                                instalacion.setMaterialesAdicionales(material);
                                                System.out.println("Ingrese el costo del " + material + ": ");
                                                double costo = ingresarDouble();
                                                instalacion.setCostoMaterialesAdicionales(costo);
                                                sc.nextLine();
                                            } else {
                                                System.out.println("No se ingresan materiales adicionales");
                                                break;
                                            }
                                        }*/
                                        for (int k = 0 ; k < materialesAdic.size() ; k+=2) {
                                            double costo = Double.valueOf(materialesAdic.get(k+1));
                                            instalacion.setCostoMaterialesAdicionales(costo);
                                            instalacion.setMaterialesAdicionales(materialesAdic.get(k));
                                        }

                                        //Ingresa si hubo almuerzo
                                        /*System.out.println("Realizó almuerzo? (Y/N): ");
                                        String confirmacion = sc.nextLine();
                                        if (confirmacion.equals("Y")) {
                                            System.out.println("Almuerzo cargado");
                                            instalacion.setAlmuerzo(true);
                                        } else {
                                            System.out.println("No se realizo almuerzo");
                                            instalacion.setAlmuerzo(false);
                                        }*/
                                        instalacion.setAlmuerzo(almuerzo.equals("Si"));

                                        //Indica si compro combustible
                                        /*System.out.println("Compro combustible? (Y/N): ");
                                        confirmacion = sc.nextLine();
                                        if (confirmacion.equals("Y")) {
                                            System.out.println("Ingrese los litros cúbicos cargados: ");
                                            double costoCombustible = ingresarDouble() * this.compania.getPrecioCombustible();
                                            instalacion.setCombustible(costoCombustible);
                                        } else {
                                            System.out.println("No se realizo compra de combustible");
                                        }*/
                                        instalacion.setCombustible(Double.parseDouble(combustible));

                                        //Calcula tiempo trabajado
                                        //while (true) {
                                            //System.out.println("Ingrese la cantidad de tiempo trabajado (en min): ");
                                            //int horaFin = ingresarEntero();
                                            if (Integer.parseInt(tiempoTrabajado) > 29) {
                                                instalacion.calcularTiempoTrabajado(Integer.parseInt(tiempoTrabajado),nroTecnico);

                                                System.out.println("DATOS CARGADOS");
                                                instalacion.finalizarServicio();
                                                JOptionPane.showMessageDialog(null,"Datos cargados con exito","Datos cargados",JOptionPane.INFORMATION_MESSAGE);

                                                break;
                                            } else {
                                                System.out.println("Tiempo trabajado incorrecto");
                                                JOptionPane.showMessageDialog(null,"Debe ingresar tiempo trabajado mayor o igual a 30 minutos","Tiempo trabajado incorrecto",JOptionPane.ERROR_MESSAGE);
                                            }
                                        }
                                    //}
                                } else {
                                    System.out.println("No existen Instalaciones a finalizar");
                                    JOptionPane.showMessageDialog(null,"No existen Instalaciones a finalizar","Datos NO cargados",JOptionPane.ERROR_MESSAGE);
                                    break;
                                }
                                JOptionPane.showMessageDialog(null,"No existen Instalaciones a finalizar","Datos NO cargados",JOptionPane.ERROR_MESSAGE);
                            }
                        }
                        break;
                    default:
                        System.out.println("No se ingreso una opcion correcta");
                }
            }
        //}

    public static int ingresarEntero() {
        boolean repetir;
        int n = 100;
        do {
            repetir = false;
            try {
                n = sc.nextInt();
                return n;
            }
            catch (InputMismatchException exception) {
                System.out.println("ERROR. El valor no corresponde a un Entero. Volver a ingresar: ");
                repetir = true;
            }
            finally {
                sc.nextLine();
            }
        } while (repetir);
        return n;
    }

    public static double ingresarDouble() {
        boolean repetir;
        double n = 100.0;
        do {
            repetir = false;
            try {
                n = sc.nextDouble();
                return n;
            }
            catch (InputMismatchException exception) {
                System.out.println("ERROR. El valor no corresponde a un Número con Decimales. Volver a ingresar: ");
                repetir = true;
            }
            finally {
                sc.nextLine();
            }
        } while (repetir);
        return n;
    }
}
