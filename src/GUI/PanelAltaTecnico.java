package GUI;

import Enumeraciones.TipoTecnico;
import Interfaz.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PanelAltaTecnico extends JPanel implements ActionListener {

    JTextField fieldNroDoc;
    JTextField fieldNombre;
    JTextField fieldDomicilio;
    JComboBox<String> tipoTecnico;
    JComboBox<String> comboTurno;
    JButton buttonGrabarTecnico;
    
    public PanelAltaTecnico(){
        
        this.setBackground(Color.lightGray);
        this.setBounds(0, 380,300,120);
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        this.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        this.setLayout(new GridLayout(0, 2));
        
        //armado de panel de altaTecnico
        fieldNroDoc = new JTextField();
        fieldNroDoc.setPreferredSize(new Dimension(100, 20));

        fieldNombre = new JTextField();
        fieldNombre.setPreferredSize(new Dimension(200, 20));

        fieldDomicilio = new JTextField();
        fieldDomicilio.setPreferredSize(new Dimension(200, 20));

        buttonGrabarTecnico = new JButton("Guardar Tecnico");
        buttonGrabarTecnico.addActionListener(this);

        JLabel lblNroDoc = new JLabel("Número de documento");
        JLabel lblNombre = new JLabel("Nombre");
        JLabel lblDom = new JLabel("Domicilio");

        String[] opciones = {TipoTecnico.Junior.toString(), TipoTecnico.Semi_senior.toString(), TipoTecnico.Senior.toString()};
        tipoTecnico = new JComboBox<String>(opciones);
        String[] opcionesTurno = {"Mañana", "Tarde"};
        this.comboTurno = new JComboBox<String>(opcionesTurno);

        this.add(lblNroDoc);
        this.add(fieldNroDoc);
        this.add(lblNombre);
        this.add(fieldNombre);
        this.add(lblDom);
        this.add(fieldDomicilio);
        this.add(comboTurno);
        this.add(tipoTecnico);
        this.add(buttonGrabarTecnico);
        this.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.buttonGrabarTecnico){
            int nroDoc = 0;
            try {
                System.out.println(this.fieldNroDoc.getText());
                nroDoc = Integer.parseInt(this.fieldNroDoc.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "El dni debe ser un número entero.");
                return;
            }
            int confirma = JOptionPane.showConfirmDialog(null, "Confirma el alta del técnico?", "Confirmación", 1);
            TipoTecnico tipo = TipoTecnico.Senior;
            switch(this.tipoTecnico.getSelectedItem().toString()){
                case "Junior":
                    tipo = TipoTecnico.Junior;
                    break;
                case "Semi_senior":
                    tipo = TipoTecnico.Semi_senior;
                    break;
                case "Senior":
                    tipo = TipoTecnico.Senior;
                    break;
            }
            if(confirma == 0) {
                ControllerAdministrador.getInstance().darDeAltaTecnico(nroDoc,
                        this.fieldNombre.getText(),
                        this.fieldDomicilio.getText(),
                        tipo,
                        (String) this.comboTurno.getSelectedItem());
                JOptionPane.showMessageDialog(null, "El Técnico fue dado de alta correctamente");
            }
        }
    }

}
