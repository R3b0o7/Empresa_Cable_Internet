package Interfaz;

import Clases.*;

import java.util.Scanner;

public class ControllerLogin {

    private Compania compania;
    private ControllerCallCenter controladorCallCenter;
    private ControllerAdministrativo controladorAdministrativo;
    private ControllerAdministrador controladorAdministrador;
    private ControllerTecnico controladorTecnico;
    private String perfil;

    public void main(){

        //Genero los objetos base
        this.compania = Clases.Compania.getInstance();
        String usuario = "";

        //ejecución login
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Ingrese nombre de usuario:");
            usuario = sc.nextLine();

            //Finalizar el sistema
            if (usuario == "a"){
                System.out.println("Error de login");
            }

            System.out.println("Ingrese contraseña: ");
            String contraseña = sc.nextLine();

            //valido credenciales
            if(!this.validarCredenciales(usuario, contraseña)){
                System.out.println("Error de login");
            } else {
                break;
            }
        }

        //obtengo perfil del usuario
        this.perfil = compania.getPerfil(usuario);
        while (run){
            switch(perfil) {
                case "callCenter":
                    this.controladorCallCenter = new ControllerCallCenter();
                    controladorCallCenter.menuInicial();
                    run = false;
                    break;
                case "tecnico":
                    this.controladorTecnico = new ControllerTecnico();
                    controladorTecnico.menuInicial();
                    run = false;
                    break;
                case "administrador":
                    this.controladorAdministrador = new ControllerAdministrador();
                    controladorAdministrador.menuInicial();
                    run = false;
                    break;
                case "administrativo":
                    this.controladorAdministrativo = new ControllerAdministrativo();
                    controladorAdministrativo.menuInicial();
                    run = false;
                    break;
            }
            break;
        }
    }

    private boolean validarCredenciales(String usuario, String contraseña){
        if(this.compania.getContraseña(usuario) != null){
            return this.compania.getContraseña(usuario).equals(contraseña);
        }
        return false;
    }

}
