package Interfaz;

import Clases.*;

import java.util.Scanner;

public class ControllerAdministrador extends Usuario{

    private Compania compania;

    public void menuInicial() {

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
                    this.abmTecnico();
                    break;
                case 2:
                    this.ambArticulo();
                    break;
                case 3:
                    this.configurarParametros();
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
        System.out.println("1. ABM de tecnicos");
        System.out.println("2. ABM de artículos");
        System.out.println("3. Configurar parámetros");
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

    public void abmTecnico(){
        //ejecución menu del ABM
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println();
            System.out.println("Opciones ABM de técnicos");
            System.out.println("---------------------------------");
            System.out.println("1. Alta de técnico");
            System.out.println("2. Baja de técnico");
            System.out.println("3. Modificación de técnico");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            System.out.println();
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    //Alta de técnico
                    System.out.println("Técnicos en la compania: ");
                    for (Tecnico tecnico : compania.getTecnicos()) {
                        System.out.println("Técnico Nro " + tecnico.getNroTécnico() + " ; DNI: " + tecnico.getDni());
                    }
                    break;
                case 2: //Dar de baja servicios asosciados
                    //Baja de técnico
                    break;
                case 3:
                    //Modificación de técnico
                    break;
                case 0:
                    run = false;
                    break;
            }
        }

    }

    public void ambArticulo(){

    }

    public void configurarParametros(){

    }

}
