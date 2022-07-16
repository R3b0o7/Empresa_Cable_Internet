package Test;

import GUI.PanelAltaTecnico;

import javax.swing.*;

public class TestSwing {

    public static void main(String[] args) {
             JFrame f = new JFrame();
             JPanel p = new PanelAltaTecnico();
             f.add(p);
             f.setVisible(true);
    }
}
