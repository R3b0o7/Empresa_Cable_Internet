package GUI;

import Clases.Compania;
import Clases.Tecnico;
import Enumeraciones.TipoTecnico;
import Interfaz.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelModificarTecnico extends JPanel implements ActionListener {
    Compania compania = Compania.getInstance();
    JComboBox<String> tipoTecnico;
    JComboBox<String> comboTurno;
    JTextField idTec;
    JButton buttonGrabarTecnico;

    public PanelModificarTecnico() {

        this.setBackground(Color.lightGray);
        this.setBounds(0, 380,400,120);
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        this.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        this.setLayout(new GridLayout(0, 2));

        JLabel idTecText = new JLabel("ID Técnico:   ");
        idTecText.setHorizontalAlignment(SwingConstants.RIGHT);

        idTec = new JTextField();
        idTec.setPreferredSize(new Dimension(250, 20));

        String[] opciones = {TipoTecnico.Junior.toString(), TipoTecnico.Semi_senior.toString(), TipoTecnico.Senior.toString()};
        tipoTecnico = new JComboBox<String>(opciones);
        String[] opcionesTurno = {"Mañana", "Tarde"};
        this.comboTurno = new JComboBox<String>(opcionesTurno);

        buttonGrabarTecnico = new JButton("Guardar Tecnico");
        buttonGrabarTecnico.addActionListener(this);

        this.add(idTecText);
        this.add(idTec);
        this.add(tipoTecnico);
        this.add(comboTurno);
        this.add(buttonGrabarTecnico);
        this.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.buttonGrabarTecnico){
            int tecNro = 0;
            try {
                //System.out.println(this.idTec.getText());
                tecNro = Integer.parseInt(this.idTec.getText());
                /**
                try{
                    for(Tecnico tecnico: compania.getTecnicos()){
                        if(tecnico.getNroTécnico()==tecNro){
                            tecNro = Integer.parseInt(this.idTec.getText());
                        }
                        else{
                            JOptionPane.showMessageDialog(null, "El Id del técnico no existe.");
                            return;
                        }
                    }
                }
                catch (Exception exc){
                    JOptionPane.showMessageDialog(null, "El Id del técnico no existe.");
                    return;
                }
                 */
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "El Id del técnico debe ser un número entero.");
                return;
            }

            int confirma = JOptionPane.showConfirmDialog(null, "Confirmar modificación del técnico?", "Confirmación", 1);
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
                ControllerAdministrador.getInstance().modificarTecnico(tecNro,tipo,(String) this.comboTurno.getSelectedItem());
                JOptionPane.showMessageDialog(null, "El Técnico fue actualizado correctamente");


                //ControllerAdministrador.getInstance().darDeAltaTecnico(tecNro,
                //        this.fieldNombre.getText(),
                //        this.fieldDomicilio.getText(),
                //        tipo,
                //        (String) this.comboTurno.getSelectedItem());
                //JOptionPane.showMessageDialog(null, "El Técnico fue dado de alta correctamente");
            }
        }
    }
}
