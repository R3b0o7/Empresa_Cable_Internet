package GUI;

import Clases.Compania;
import Controladores.ControllerLogin;

public class MainGUI {
    public static void main(String[] args) {
        ControllerLogin login = ControllerLogin.getInstance();
        Compania compania = Compania.getInstance();
        VentanaLogin ventanaLogin = new VentanaLogin();
    }
}
