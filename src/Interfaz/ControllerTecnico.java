package Interfaz;

import Clases.*;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerTecnico extends Usuario {

    static Scanner sc = new Scanner(System.in);
    private Compania compania;
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
                    this.cargarDatosServicio();
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

    public void serviciosAsignados(String nroTecnico) {
        this.compania = Clases.Compania.getInstance();
        System.out.println("REPARACIONES: ");
        if (this.compania.getReparaciones().size() == 0) {
            System.out.println("No existen reparaciones");
        } else {
            for (Reparacion reparacion : this.compania.getReparaciones()) {
                System.out.println("Ingrese su numero de tecnico: "+nroTecnico);
                //int nroTecnico = ingresarEntero();
                for (Tecnico tecnicoReparacion : reparacion.getTecnicos()) {
                    try {
                        if (tecnicoReparacion.getNroTécnico() == Integer.valueOf(nroTecnico)) {
                            System.out.println("ID Reparacion: " + reparacion.getIdServicio() +
                                    "\nFecha: " + reparacion.getFecha() +
                                    "\nHorario: " + reparacion.getHora() +
                                    "\nTecnicos: " + reparacion.getTecnicos() +
                                    "\nCliente: " + reparacion.getCliente().getNombreApellido() +
                                    "\nDNI cliente: " + reparacion.getCliente().getDni() +
                                    "\nTECNICO: " + Integer.valueOf(nroTecnico));
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
                for (Tecnico tecnicoInstalacion : instalacion.getTecnicos()) {
                    try {
                        if (tecnicoInstalacion.getNroTécnico() == Integer.valueOf(nroTecnico)) {
                            System.out.println("ID Instalacion: " + instalacion.getIdServicio() +
                                    "\nFecha: " + instalacion.getFecha() +
                                    "\nHorario: " + instalacion.getHora() +
                                    "\nTecnicos: " + instalacion.getTecnicos() +
                                    "\nCliente: " + instalacion.getCliente().getNombreApellido() +
                                    "\nDNI cliente: " + instalacion.getCliente().getDni());
                        } else {
                            System.out.println("No existen Instalaciones asignadas");
                        }
                    } catch (NumberFormatException exception){}
                }
            }
        }
    }

    public void cargarDatosServicio() {
        boolean run = true;
        while (run) {
            System.out.println("Desea cargar datos de 1-REPARACIONES / 2-INSTALACIONES / 0-SALIR: ");
            int res = ingresarEntero();
                switch (res) {
                    case 0:
                        System.out.println("Saliendo");
                        run = false;
                        break;
                    case 1: //Cargar datos REPARACIONES
                        for (Reparacion reparacion : this.compania.getReparaciones()) {
                            System.out.println("Ingrese su numero de tecnico: ");
                            int nroTecnico = ingresarEntero();
                            for (Tecnico tecnicoReparacion : reparacion.getTecnicos()) {
                                if (tecnicoReparacion.getNroTécnico() == nroTecnico) {
                                    //serviciosAsignados();
                                    System.out.println("Ingrese el numero de Reparacion a cargar datos: ");
                                    if (reparacion.getIdServicio() == ingresarEntero()) {

                                        //Ingresa materiales usados
                                        for (Articulo articulo : this.compania.getStock().getStockArticulos()) {
                                            System.out.println("Utilizó " + articulo.getArticulo() + " (Y/N): ");
                                            String opcion = sc.nextLine();
                                            if (opcion.equals("Y")) {
                                                System.out.println("Que cantidad?: ");
                                                int cantidad = ingresarEntero();
                                                reparacion.addMaterial(articulo, cantidad);
                                                this.compania.getStock().getArticulo(articulo.getArticulo()).agregarCantidadArticulos(-cantidad);
                                            }
                                        }

                                        //Ingresa materiales adicionales
                                        while (true) {
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
                                        }

                                        //Ingresa si hubo almuerzo
                                        System.out.println("Realizó almuerzo? (Y/N): ");
                                        String confirmacion = sc.nextLine();
                                        if (confirmacion.equals("Y")) {
                                            System.out.println("Almuerzo cargado");
                                            reparacion.setAlmuerzo(true);
                                        } else {
                                            System.out.println("No se realizo almuerzo");
                                            reparacion.setAlmuerzo(false);
                                        }

                                        //Indica si compro combustible

                                        System.out.println("Compro combustible? (Y/N): ");
                                        confirmacion = sc.nextLine();
                                        if (confirmacion.equals("Y")) {
                                            System.out.println("Ingrese los litros cúbicos cargados: ");
                                            double costoCombustible = ingresarDouble() * this.compania.getPrecioCombustible();
                                            reparacion.setCombustible(costoCombustible);
                                        } else {
                                            System.out.println("No se realizo compra de combustible");
                                        }
                                        System.out.println("DATOS CARGADOS");

                                        //Calcula tiempo trabajado
                                        while (true) {
                                            System.out.println("Ingrese la cantidad de tiempo trabajado (en min): ");
                                            int horaFin = ingresarEntero();
                                            if (horaFin > 30) {
                                                reparacion.calcularTiempoTrabajado(horaFin,nroTecnico);
                                                break;
                                            } else {
                                                System.out.println("Tiempo trabajado incorrecto");
                                            }
                                        }
                                        reparacion.finalizarServicio();
                                    }
                                } else {
                                    System.out.println("No existen Reparaciones a finalizar");
                                }
                            }
                        break;
                        }
                    case 2: //Cargar datos INSTALACIONES
                        for (Instalacion instalacion : this.compania.getInstalaciones()) {
                            System.out.println("Ingrese su numero de tecnico: ");
                            int nroTecnico = ingresarEntero();
                            for (Tecnico tecnicoInstalacion : instalacion.getTecnicos()) {
                                if (tecnicoInstalacion.getNroTécnico() == nroTecnico) {
                                    //serviciosAsignados();
                                    System.out.println("Ingrese el numero de Instalacion a cargar datos: ");
                                    if (instalacion.getIdServicio() == ingresarEntero()) {
                                        //Ingresa materiales usados
                                        for (Articulo articulo : this.compania.getStock().getStockArticulos()){
                                            System.out.println("Utilizó "+articulo.getArticulo()+" (Y/N): ");
                                            String opcion = sc.nextLine();
                                            if (opcion.equals("Y")){
                                                System.out.println("Que cantidad?: ");
                                                int cantidad = ingresarEntero();
                                                instalacion.addMaterial(articulo,cantidad);
                                                this.compania.getStock().getArticulo(articulo.getArticulo()).agregarCantidadArticulos(-cantidad);
                                            }
                                        }

                                        //Ingresa materiales adicionales
                                        while (true) {
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
                                        }

                                        //Ingresa si hubo almuerzo
                                        System.out.println("Realizó almuerzo? (Y/N): ");
                                        String confirmacion = sc.nextLine();
                                        if (confirmacion.equals("Y")) {
                                            System.out.println("Almuerzo cargado");
                                            instalacion.setAlmuerzo(true);
                                        } else {
                                            System.out.println("No se realizo almuerzo");
                                            instalacion.setAlmuerzo(false);
                                        }

                                        //Indica si compro combustible
                                        System.out.println("Compro combustible? (Y/N): ");
                                        confirmacion = sc.nextLine();
                                        if (confirmacion.equals("Y")) {
                                            System.out.println("Ingrese los litros cúbicos cargados: ");
                                            double costoCombustible = ingresarDouble() * this.compania.getPrecioCombustible();
                                            instalacion.setCombustible(costoCombustible);
                                        } else {
                                            System.out.println("No se realizo compra de combustible");
                                        }
                                        System.out.println("DATOS CARGADOS");

                                        //Calcula tiempo trabajado
                                        while (true) {
                                            System.out.println("Ingrese la cantidad de tiempo trabajado (en min): ");
                                            int horaFin = ingresarEntero();
                                            if (horaFin > 30) {
                                                instalacion.calcularTiempoTrabajado(horaFin,nroTecnico);
                                                break;
                                            } else {
                                                System.out.println("Tiempo trabajado incorrecto");
                                            }
                                        }
                                        instalacion.finalizarServicio();
                                    }
                                } else {
                                    System.out.println("No existen Instalaciones a finalizar");
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("No se ingreso una opcion correcta");
                }
            }
        }

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
