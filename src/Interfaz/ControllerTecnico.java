package Interfaz;

import Clases.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerTecnico extends Usuario{
    Scanner sc = new Scanner(System.in);
    private Compania compania;

    public void menuInicial() {
        // TODO Auto-generated method stub

        //Genero los objetos base
        this.compania = Clases.Compania.getInstance();

        //ejecución menu principal
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            this.imprimirMenuInicial();
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    this.serviciosAsignados();
                    break;
                case 2:
                    this.cargarDatosServicio();
                    break;
                case 0:
                    run = false;
                    break;
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
        System.out.println("");
        System.out.println("");
        for(int i = 0; i < menu.length; i++ ) {
            System.out.print(menu[i]);
            if(i == menu.length-1) {
                break;
            }
            System.out.print(" > ");
        }
        System.out.print("\n");
        System.out.println("##################################");
    }

    public void serviciosAsignados(){
        System.out.println("REPARACIONES: ");
        if (this.compania.getReparaciones().size()==0){
            System.out.println("No existen reparaciones");
        } else {
            for (Reparacion reparacion : this.compania.getReparaciones()){
                for(Tecnico tecnicoReparacion : reparacion.getTecnicos()) {
                    for (Tecnico tecnicoUsuario : this.compania.getTecnicos()) {
                        if (tecnicoReparacion.getNroTécnico() == tecnicoUsuario.getNroTécnico()) {
                            this.compania.getReparacion(reparacion.getIdServicio());
                            System.out.println(reparacion);
                        }
                    }
                }
            }
        }
        System.out.println("");
        System.out.println("INSTALACIONES: ");
        if (this.compania.getInstalaciones().size()==0){
            System.out.println("No existen instalaciones");
        } else{
            for (Instalacion instalacion : this.compania.getInstalaciones()){
                for (Tecnico tecnicoInstalacion : instalacion.getTecnicos()){
                    for (Tecnico tecnicoUsuario : this.compania.getTecnicos()){
                        if (tecnicoInstalacion.getNroTécnico() == tecnicoUsuario.getNroTécnico()){
                            this.compania.getInstalacion(instalacion.getIdServicio());
                            System.out.println(instalacion);
                        }
                    }
                }
            }
        }
        System.out.println("");
    }

    public void cargarDatosServicio(){
        System.out.println("REPARACIONES: ");
        if (this.compania.getReparaciones().size()==0){
            System.out.println("No existen reparaciones");
        } else {
            for (Reparacion reparacion : this.compania.getReparaciones()) {
                for (Tecnico tecnicoReparacion : reparacion.getTecnicos()) {
                    for (Tecnico tecnicoUsuario : this.compania.getTecnicos()) {
                        if (tecnicoReparacion.getNroTécnico() == tecnicoUsuario.getNroTécnico()) {
                            System.out.println(reparacion);
                            System.out.println("Ingrese el numero de Servicio a cargar datos: ");
                            if (reparacion.getIdServicio() ==  sc.nextInt()) {

                                //Calcula tiempo trabajado
                                System.out.println("Ingrese la hora de inicio: ");
                                int horaInicio = sc.nextInt();
                                System.out.println("Ingrese la hora de finalizacion: ");
                                int horaFin = sc.nextInt();
                                //reparacion.calcularTiempoTrabajado(horaInicio, horaFin);

                                //Ingresa el costo del viaje
                                System.out.println("Ingrese el costo del viaje: ");
                                //reparacion.setCostoDeViaje(sc.nextDouble());

                                //Ingresa si hubo almuerzo
                                System.out.println("Realizó almuerzo (Y/N): ");
                                if (sc.nextLine().equals("Y")){
                                    System.out.println("Y");
                                    reparacion.setAlmuerzo(true);
                                } else {
                                    System.out.println("N");
                                    reparacion.setAlmuerzo(false);
                                }

                                //Ingresa materiales adicionales
                                while (true){
                                    System.out.println("Ingrese el nombre del material adicional (vacio para no ingresar mas): ");
                                    if (sc.nextLine().equals("")){
                                        reparacion.setMaterialesAdicionales(sc.nextLine());
                                    } else {
                                        System.out.println("Ingrese el no");
                                        break;
                                    }
                                }

                                System.out.println("Ingrese el costo del combustible: ");
                                reparacion.setCombustible(sc.nextDouble());

                                reparacion.calcularCostoReal(compania);

                                //reparacion.calcularGastos();

                            }
                        }
                    }
                }
            }
        }
    }
}
