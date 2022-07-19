package GUI;

import Controladores.ControllerAdministrativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModCombustible extends JPanel implements ActionListener {

    JLabel lblCombustible;
    JTextField fldValor;
    JButton btnGuardar;

    public PanelModCombustible(){

        this.setBackground(new Color(107,108,109));
        this.setBounds(0, 200,900,250);
        this.setPreferredSize(new Dimension(900, 250));

        lblCombustible = new JLabel("Ingrese el combustible utilizado: ");
        fldValor = new JTextField(5);
        btnGuardar = new JButton("Actualizar valor");
        btnGuardar.addActionListener(this);

        this.add(lblCombustible);
        this.add(fldValor);
        this.add(btnGuardar);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnGuardar){
            Double combustible = 0.0;
            try{
                combustible = Double.parseDouble(fldValor.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor ingresado inválido");
                return;
            }
            if(combustible < 0.0){
                JOptionPane.showMessageDialog(null, "Valor ingresado inválido.");
                return;
            }
            if(!ControllerAdministrativo.getInstance().verificarSeleccion()){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio");
            } else {
                ControllerAdministrativo.getInstance().actualizarCombustible(combustible);
                JOptionPane.showMessageDialog(null, "Se actualizó el valor correctamente.");
            }
        }
    }
}
