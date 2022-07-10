package Interfaz;

import Clases.*;
import Enumeraciones.TipoTecnico;

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
        System.out.println("---------------------------------");
    }

    public void abmTecnico(){
        //ejecución menu del ABM
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        String[] menu = {"EMPRESA DE CABLE", "ABM DE TÉCNICOS"};
        this.imprimirEncabezado(menu);

        while (run) {
            System.out.println("1. Alta de técnico");
            System.out.println("2. Baja de técnico");
            System.out.println("3. Modificación de técnico");
            System.out.println("0. Volver");
            System.out.print("Elija una opción: ");
            System.out.println();
            int opcion = sc.nextInt();
            switch(opcion) {
                case 1:
                    //Alta de técnico
                    Tecnico tecnico;
                    System.out.println("Ingrese DNI del Técnico: ");
                    int dni = sc.nextInt();
                    if (this.compania.getTecnicos() != null) {
                       System.out.println("El Técnico ya existe.");
                       return;
                    }
                    sc.nextLine(); //leer salto de linea
                    System.out.println("Ingrese nombre del Técnico: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese direccion del Técnico: ");
                    String direccion = sc.nextLine();
                    System.out.println("Ingrese el turno (MAÑANA/TARDE) del Técnico: ");
                    String turno = sc.nextLine();

                    System.out.println("Se creará el siguiente Técnico:");
                    System.out.println("DNI: " + dni);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Direccion: " + direccion);
                    System.out.println("Tipo de Técnico: " + "Junior"); //CORREGIR CUANDO AGREGUE OPCIONES
                    System.out.println("Turno: " + turno);
                    System.out.println("¿Confirma el alta? Y/n :");
                    String confirma = sc.nextLine();
                    if(confirma.equals("Y")){
                        tecnico = new Tecnico(dni, nombre, direccion, TipoTecnico.Junior,turno); //VER DE SELLECCIONAR ESTO
                        compania.guardarTecnico(tecnico);
                        System.out.println("El Técnico se guardó correctamente.");
                        System.out.println();
                    } else {
                        System.out.println("Se canceló la operación");
                        System.out.println();
                    }

                    break;
                case 2: //Dar de baja servicios asosciados
                    //Baja de técnico
                    System.out.println("Técnicos activos de la compania: ");
                    for (Tecnico tec : compania.getTecnicos()) {
                        if (tec.getEstado()){ //Muesta solo los tecnicos que no fueron dados de baja -> estado = true
                            System.out.println("Técnico Nro " + tec.getNroTécnico() + " ; DNI: " + tec.getDni());
                        }

                    }
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
