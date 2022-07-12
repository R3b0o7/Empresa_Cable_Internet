package Interfaz;

import Clases.*;
import Excepciones.GenericException;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerTecnico extends Usuario {
    Scanner sc = new Scanner(System.in);
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
        this.compania = Clases.Compania.getInstance();

        //ejecución menu principal
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            this.imprimirMenuInicial();
            String opcion = sc.nextLine();
            switch (opcion) {
                case "1":
                    this.serviciosAsignados();
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

    public void serviciosAsignados() {
        System.out.println("REPARACIONES: ");
        if (this.compania.getReparaciones().size() == 0) {
            System.out.println("No existen reparaciones");
        } else {
            for (Reparacion reparacion : this.compania.getReparaciones()) {
                for (Tecnico tecnicoReparacion : reparacion.getTecnicos()) {
                    System.out.println("Ingrese su numero de tecnico: ");
                    int nroTecnico = sc.nextInt();
                    if (tecnicoReparacion.getNroTécnico() == nroTecnico) {
                        System.out.println("ID Reparacion: " + reparacion.getIdServicio() +
                                "\nFecha: " + reparacion.getFecha() +
                                "\nHorario: " + reparacion.getHora() +
                                "\nTecnicos: " + reparacion.getTecnicos() +
                                "\nCliente: " + reparacion.getCliente().getNombreApellido() +
                                "\nDNI cliente: " + reparacion.getCliente().getDni());
                    } else {
                        System.out.println("No existen Reparaciones asignadas");
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
                for (Tecnico tecnicoInstalacion : instalacion.getTecnicos()) {
                    System.out.println("Ingrese su numero de tecnico: ");
                    int nroTecnico = sc.nextInt();
                    if (tecnicoInstalacion.getNroTécnico() == nroTecnico) {
                        System.out.println("ID Reparacion: " + instalacion.getIdServicio() +
                                "\nFecha: " + instalacion.getFecha() +
                                "\nHorario: " + instalacion.getHora() +
                                "\nTecnicos: " + instalacion.getTecnicos() +
                                "\nCliente: " + instalacion.getCliente().getNombreApellido() +
                                "\nDNI cliente: " + instalacion.getCliente().getDni());
                    } else {
                        System.out.println("No existen Instalaciones asignadas");
                    }
                }
            }
        }
    }

    public void cargarDatosServicio() {
        boolean run = true;
        while (run) {
            System.out.println("Desea cargar datos de 1-REPARACIONES / 2-INSTALACIONES / 0-SALIR: ");
            try {
                int res = sc.nextInt();
                switch (res) {
                    case 0:
                        System.out.println("Saliendo");
                        run = false;
                        break;
                    case 1:
                        for (Reparacion reparacion : this.compania.getReparaciones()) {
                            for (Tecnico tecnicoReparacion : reparacion.getTecnicos()) {
                                for (Tecnico tecnicoUsuario : this.compania.getTecnicos()) {
                                    if (tecnicoReparacion.getNroTécnico() == tecnicoUsuario.getNroTécnico()) {
                                        serviciosAsignados();
                                        System.out.println("Ingrese el numero de Reparacion a cargar datos: ");
                                        if (reparacion.getIdServicio() == sc.nextInt()) {
                                            //Calcula tiempo trabajado
                                            while (true) {
                                                System.out.println("Ingrese la hora de inicio: ");
                                                int horaInicio = sc.nextInt();
                                                System.out.println("Ingrese la hora de finalizacion: ");
                                                int horaFin = sc.nextInt();
                                                if (horaInicio < horaFin && horaInicio < 23 && horaFin > 1) {
                                                    //reparacion.calcularTiempoTrabajado(horaInicio, horaFin);
                                                    break;
                                                } else {
                                                    System.out.println("Tiempo trabajado incorrecto");
                                                }
                                            }

                                            //Ingresa materiales usados
                                            System.out.println("Ingrese los materiales utilizados: ");
                                            reparacion.addMaterial(sc.nextLine());

                                            //Ingresa materiales adicionales
                                            sc.nextLine();
                                            while (true) {
                                                System.out.println("Ingrese el nombre del material adicional (vacio para no ingresar mas): ");
                                                String material = sc.nextLine();
                                                if (!material.equals("")) {
                                                    reparacion.setMaterialesAdicionales(material);
                                                    System.out.println("Ingrese el costo del " + material + ": ");
                                                    double costo = sc.nextDouble();
                                                    reparacion.setCostoMaterialesAdicionales(costo);
                                                    sc.nextLine();
                                                } else {
                                                    System.out.println("No se ingresan materiales adicionales");
                                                    break;
                                                }
                                            }

                                            //Ingresa el costo del viaje
                                            //reparacion.setCostoDeViaje(this.compania.getCostoDeViaje());

                                            //Ingresa si hubo almuerzo
                                            System.out.println("Realizó almuerzo? (Y/N): ");
                                            sc.nextLine();
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
                                            sc.nextLine();
                                            if (confirmacion.equals("Y")) {
                                                System.out.println("Y");
                                                System.out.println("Ingrese los litros cúbicos cargados: ");
                                                double costoCombustible = sc.nextDouble() * this.compania.getPrecioCombustible();
                                                reparacion.setCombustible(costoCombustible);
                                            } else {
                                                System.out.println("No se realizo compra de combustible");
                                            }

                                            System.out.println("DATOS CARGADOS");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    case 2:
                        for (Instalacion instalacion : this.compania.getInstalaciones()) {
                            for (Tecnico tecnicoInstalacion : instalacion.getTecnicos()) {
                                for (Tecnico tecnicoUsuario : this.compania.getTecnicos()) {
                                    if (tecnicoInstalacion.getNroTécnico() == tecnicoUsuario.getNroTécnico()) {
                                        serviciosAsignados();
                                        System.out.println("Ingrese el numero de Reparacion a cargar datos: ");
                                        if (instalacion.getIdServicio() == sc.nextInt()) {
                                            //Calcula tiempo trabajado
                                            while (true) {
                                                System.out.println("Ingrese la hora de inicio: ");
                                                int horaInicio = sc.nextInt();
                                                System.out.println("Ingrese la hora de finalizacion: ");
                                                int horaFin = sc.nextInt();
                                                if (horaInicio < horaFin && horaInicio < 23 && horaFin > 1) {
                                                    //instalacion.calcularTiempoTrabajado(horaInicio, horaFin);
                                                    break;
                                                } else {
                                                    System.out.println("Tiempo trabajado incorrecto");
                                                }
                                            }

                                            //Ingresa materiales usados
                                            System.out.println("Ingrese los materiales utilizados: ");
                                            instalacion.addMaterial(sc.nextLine());

                                            //Ingresa materiales adicionales
                                            sc.nextLine();
                                            while (true) {
                                                System.out.println("Ingrese el nombre del material adicional (vacio para no ingresar mas): ");
                                                String material = sc.nextLine();
                                                if (!material.equals("")) {
                                                    instalacion.setMaterialesAdicionales(material);
                                                    System.out.println("Ingrese el costo del " + material + ": ");
                                                    double costo = sc.nextDouble();
                                                    instalacion.setCostoMaterialesAdicionales(costo);
                                                    sc.nextLine();
                                                } else {
                                                    System.out.println("No se ingresan materiales adicionales");
                                                    break;
                                                }
                                            }

                                            //Ingresa el costo del viaje
                                            //instalacion.setCostoDeViaje(this.compania.getCostoDeViaje());

                                            //Ingresa si hubo almuerzo
                                            System.out.println("Realizó almuerzo? (Y/N): ");
                                            sc.nextLine();
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
                                            sc.nextLine();
                                            if (confirmacion.equals("Y")) {
                                                System.out.println("Y");
                                                System.out.println("Ingrese los litros cúbicos cargados: ");
                                                double costoCombustible = sc.nextDouble() * this.compania.getPrecioCombustible();
                                                instalacion.setCombustible(costoCombustible);
                                            } else {
                                                System.out.println("No se realizo compra de combustible");
                                            }
                                            System.out.println("DATOS CARGADOS");
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    default:
                        System.out.println("No se ingreso una opcion correcta");
                }
            } catch (Exception e) {
                System.out.println("No se ingreso un numero");
                sc.nextLine();
            }
        }
    }
}
