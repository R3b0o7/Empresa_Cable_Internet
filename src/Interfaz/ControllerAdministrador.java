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
                    this.abmArticulo();
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
                case 1: //Alta de técnico

                    System.out.println();
                    System.out.println("ALTA DE TÉCNICO");
                    System.out.println("---------------------------------");
                    Tecnico tecnico;

                    // Ingresar primero el DNI para corroborar si existe el técnico a asociar.
                    System.out.println("Ingrese DNI del Técnico: ");
                    int dni = sc.nextInt();
                    // Validar si existe el técnico antes de crearlo
                    /** NO SE POR QUE NO FUNCIONA
                    if (this.compania.getTecnicos() != null) {
                        System.out.println("El Técnico ya existe.");
                        return;
                    }
                    */
                    // Ingresar el resto de los datos del técnico
                    sc.nextLine();
                    System.out.println("Ingrese nombre del Técnico: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese direccion del Técnico: ");
                    String direccion = sc.nextLine();

                    //Selecciona turno validando que solo puedan ser las opciones mostradas
                    String turno = "";
                    boolean run2 = true;
                    while (run2){
                        System.out.println("Ingrese el turno del Técnico: ");
                        System.out.println("1.Mañana");
                        System.out.println("2.Tarde");
                        int opcion2 = sc.nextInt();
                        switch (opcion2) {
                            case 1:
                                turno = "Mañana";
                                run2 = false;
                                break;
                            case 2:
                                turno = "Tarde";
                                run2 = false;
                                break;
                        }
                    }

                    //Selecciona el tipo de técnico validando que solo puedan ser las opciones mostradas
                    TipoTecnico tipoTecnico = TipoTecnico.Junior;
                    boolean run3 = true;
                    while (run3){
                        System.out.println("Tipo Técnico: ");
                        System.out.println("1. Junior");
                        System.out.println("2. Semi senior");
                        System.out.println("3. Senior");
                        int opcion3 = sc.nextInt();
                        switch (opcion3) {
                            case 1:
                                tipoTecnico = TipoTecnico.Junior;
                                run3 = false;
                                break;
                            case 2:
                                tipoTecnico = TipoTecnico.Semi_senior;
                                run3 = false;
                                break;
                            case 3:
                                tipoTecnico = TipoTecnico.Senior;
                                run3 = false;
                                break;
                        }
                    }

                    //Se muestran los datos ingresados antes de confirmar la creación
                    System.out.println();
                    System.out.println("Se creará el siguiente Técnico:");
                    System.out.println("DNI: " + dni);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Direccion: " + direccion);
                    System.out.println("Tipo de Técnico: " + tipoTecnico);
                    System.out.println("Turno: " + turno);
                    System.out.println("¿Confirma el alta? y/n :");
                    sc.nextLine();

                    //Confirmación de guardado
                    String confirma = sc.nextLine();
                    if (confirma.equals("y")) {
                        tecnico = new Tecnico(dni, nombre, direccion, tipoTecnico, turno);
                        compania.guardarTecnico(tecnico);
                        System.out.println("El Técnico se guardó correctamente con el número " + tecnico.getNroTécnico());
                        System.out.println();
                    } else {
                        System.out.println("Se canceló la operación");
                        System.out.println();
                    }
                    break;

                case 2: //Baja de técnico
                    //Pasar a estado = false
                    System.out.println();
                    System.out.println("BAJA DE TÉCNICO");
                    System.out.println("---------------------------------");
                    System.out.println("Técnicos activos de la compania: ");
                    for (Tecnico tec : compania.getTecnicos()) {
                        if (tec.getEstado()) { //Muesta solo los tecnicos que no fueron dados de baja -> estado = true
                            System.out.println("Técnico Nro " + tec.getNroTécnico() + " ; DNI: " + tec.getDni());
                        }
                    }
                    System.out.println("---------------------------------");
                    System.out.println();
                    System.out.println("Seleccione el numero de técncio que desa dar de baja: ");
                    sc.nextLine();
                    int nroTecnico = sc.nextInt();
                    for (Tecnico tec2 : compania.getTecnicos()){
                        if (tec2.getNroTécnico() == nroTecnico && tec2.getEstado() == true){
                            compania.getTecnico(nroTecnico).setEstado(false);
                            System.out.println("El Técnico Nro " + nroTecnico + " fué dado de baja de manera exitosa.");
                            System.out.println();
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

    public void abmArticulo(){

    }

    public void configurarParametros(){

    }

}
