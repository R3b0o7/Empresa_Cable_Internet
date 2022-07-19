package GUI;

import Controladores.ControllerAdministrativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModAlmuerzo extends JPanel implements ActionListener {

    JLabel lblCostoMat;
    JComboBox comboAlmuerzo;
    JButton btnGuardar;

    public PanelModAlmuerzo(){

        this.setBackground(new Color(107,108,109));
        this.setBounds(0, 200,900,250);
        this.setPreferredSize(new Dimension(900, 250));

        lblCostoMat = new JLabel("Seleccione el valor para almuerzo: ");
        String[] opciones = {"SI", "NO"};
        comboAlmuerzo = new JComboBox<>(opciones);
        btnGuardar = new JButton("Actualizar valor");
        btnGuardar.addActionListener(this);

        this.add(lblCostoMat);
        this.add(comboAlmuerzo);
        this.add(btnGuardar);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnGuardar){
            try{
                switch (comboAlmuerzo.getSelectedIndex()){
                    case 0:
                        ControllerAdministrativo.getInstance().actualizarAlmuerzo(true);
                        break;
                    case 1:
                        ControllerAdministrativo.getInstance().actualizarAlmuerzo(false);
                }
                JOptionPane.showMessageDialog(null, "Se actualizó el valor correctamente.");
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "No se seleccionó valor.");
            }
        }
    }
}
