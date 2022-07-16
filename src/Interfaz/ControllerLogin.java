package Interfaz;

import Clases.*;
import GUI.VentanaAdministrador;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class ControllerLogin {
    JOptionPane mensajeError = new JOptionPane();
    private Compania compania;
    private static ControllerLogin controladorLogin;
    private ControllerCallCenter controladorCallCenter;
    private ControllerAdministrativo controladorAdministrativo;
    private ControllerAdministrador controladorAdministrador;
    private ControllerTecnico controladorTecnico;
    private String perfil;

    private ControllerLogin(){
    }

    public static ControllerLogin getInstance(){
        if(controladorLogin == null){
            controladorLogin = new ControllerLogin();
        }
        return controladorLogin;
    }


    public void main(){

        //Genero los objetos base
        this.compania = Clases.Compania.getInstance();
        String usuario = "";

        //ejecución login
        usuario = login(usuario);

        //obtengo perfil del usuario
        if (usuario != ""){obtenerPerfil(usuario);}
    }

    public boolean validarCredenciales(String usuario, String contraseña){
        if(Compania.getInstance().getContraseña(usuario) != null){
            return Compania.getInstance().getContraseña(usuario).equals(contraseña);
        }
        else{
            JOptionPane.showMessageDialog(mensajeError, "Datos ingresados incorrectos");
            return false;
        }
    }

    private String login(String usuario){
        Scanner sc = new Scanner(System.in);
        boolean run = true;
        while (run) {
            System.out.println("Ingrese nombre de usuario (usrAdministrador / usrAdministrativo / usrCallCenter / usrTecnico / vacio para terminar): ");
            usuario = sc.nextLine();

            //Finalizar el sistema
            if (usuario == ""){
                System.out.println("Cierre del sistema");
                run = false;
                break;
            }

            System.out.println("Ingrese contraseña (admin): ");
            String contraseña = sc.nextLine();

            //valido credenciales
            if(!this.validarCredenciales(usuario, contraseña)){
                System.out.println("Error de login");
            } else {
                break;
            }
        }
        return usuario;
    }

    public void obtenerPerfil(String usuario){
        boolean run = true;
        this.perfil = compania.getPerfil(usuario);
        while (run){
            switch(perfil) {
                case "callCenter":
                    this.controladorCallCenter = ControllerCallCenter.getInstance();
                    //controladorCallCenter.menuInicial();
                    new VentanaAdministrador();
                    run = false;
                    break;
                case "tecnico":
                    this.controladorTecnico = ControllerTecnico.getInstance();
                    //controladorTecnico.menuInicial();
                    run = false;
                    break;
                case "administrador":
                    this.controladorAdministrador = ControllerAdministrador.getInstance();
                    //controladorAdministrador.menuInicial();
                    new VentanaAdministrador();
                    run = false;
                    break;
                case "administrativo":
                    this.controladorAdministrativo = ControllerAdministrativo.getInstance();
                    //controladorAdministrativo.menuInicial();
                    run = false;
                    break;
            }
            break;
        }
        //usuario = login("");
        //if (usuario != ""){obtenerPerfil(usuario);}
    }
}
