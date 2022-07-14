package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;

public class App extends JFrame implements ActionListener{

    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton enviarButton;
    private JPanel login;

    public App() {


        textField1.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        passwordField1.addInputMethodListener(new InputMethodListener() {
            @Override
            public void inputMethodTextChanged(InputMethodEvent event) {

            }

            @Override
            public void caretPositionChanged(InputMethodEvent event) {

            }
        });
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public JPanel getLogin() {
        return login;
    }

    public static void main(String[] args) {
        //AppPrueba ventanaLogin = new AppPrueba();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("HOLA");
    }
}
