package Test;

import GUI.MyFrame;
import Interfaz.ControllerCallCenter;
import Interfaz.ControllerLogin;

public class TestMainV1 {

    public static void main(String[] args) {
        ControllerLogin login = ControllerLogin.getInstance();
        login.main();
    }
}
