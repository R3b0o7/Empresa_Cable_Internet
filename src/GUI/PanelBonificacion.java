package GUI;

import Interfaz.ControllerAdministrativo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelBonificacion extends JPanel implements ActionListener {

    JLabel lblBonificacion;
    JComboBox comboBonificacion;
    JButton btnGuardar;

    public PanelBonificacion(){
        this.setBackground(new Color(107,108,109));
        this.setBounds(0, 200,900,250);
        this.setPreferredSize(new Dimension(900, 250));

        lblBonificacion = new JLabel("Seleccione el porcentaje a bonificar: ");
        String[] opciones = {"10%", "20%"};
        comboBonificacion = new JComboBox<>(opciones);
        btnGuardar = new JButton("Aplicar bonificacion");
        btnGuardar.addActionListener(this);

        this.add(lblBonificacion);
        this.add(comboBonificacion);
        this.add(btnGuardar);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnGuardar){
            try{
                switch (comboBonificacion.getSelectedIndex()){
                    case 0:
                        ControllerAdministrativo.getInstance().aplicarBonificacion(0.1f);
                        break;
                    case 1:
                        ControllerAdministrativo.getInstance().aplicarBonificacion(0.2f);
                }
                JOptionPane.showMessageDialog(null, "Se aplicó la bonificación.");
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "No se seleccionó valor.");
            }
        }
    }
}
