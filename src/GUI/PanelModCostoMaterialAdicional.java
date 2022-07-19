package GUI;

import Interfaz.ControllerAdministrativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModCostoMaterialAdicional extends JPanel implements ActionListener {

    JLabel lblCostoMat;
    JTextField fldValor;
    JButton btnGuardar;

    public PanelModCostoMaterialAdicional(){

        this.setBackground(new Color(100, 100, 10));
        this.setBounds(0, 200,900,250);
        this.setPreferredSize(new Dimension(900, 250));

        lblCostoMat = new JLabel("Ingrese el costo de materiales a actualizar: ");
        fldValor = new JTextField(5);
        btnGuardar = new JButton("Actualizar valor");
        btnGuardar.addActionListener(this);

        this.add(lblCostoMat);
        this.add(fldValor);
        this.add(btnGuardar);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnGuardar){
            Double costo = 0.0;
            try{
                costo = Double.parseDouble(fldValor.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor ingresado inválido");
                return;
            }
            if(costo < 0.0){
                JOptionPane.showMessageDialog(null, "Valor ingresado inválido.");
                return;
            }
            if(!ControllerAdministrativo.getInstance().verificarSeleccion()){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio");
            } else {
                ControllerAdministrativo.getInstance().actualizarCostoMatAd(costo);
                JOptionPane.showMessageDialog(null, "Se actualizó el valor correctamente.");
            }
        }
    }
}
