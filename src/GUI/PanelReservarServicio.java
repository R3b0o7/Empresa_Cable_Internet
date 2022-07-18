package GUI;

import Enumeraciones.TipoServicio;
import Excepciones.GenericException;
import Interfaz.ControllerCallCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelReservarServicio extends JPanel implements ActionListener {

    JLabel lblTipoServicio;
    JComboBox comboTipoServicio;
    JLabel lblTurno;
    JComboBox comboTurno;
    JComboBox listaHorario;
    JLabel lblFecha;
    JTextField fldFecha;
    JButton btnElegirFecha;
    DatePick calendario;
    JList listaTecnicosDisponibles;
    JScrollPane scrollTecnicosDisponibles;
    JButton btnVerificarDisponibilidad;
    JButton btnAgregarTecnico;
    JButton btnGuardarServicio;
    JPanel panel1;
    JPanel panel2;

    public PanelReservarServicio(){

        this.setBackground(new Color(100, 100, 100));
        this.setBounds(0, 200,900,200);
        this.setPreferredSize(new Dimension(900, 200));

        //instancion objetos
        panel1 = new JPanel();
        panel1.setBackground(new Color(240, 0, 18));
        panel1.setBounds(0, 50,900,50);
        panel1.setPreferredSize(new Dimension(900, 50));

        panel2 = new JPanel();
        panel2.setBackground(new Color(100, 0, 200));
        panel2.setBounds(0, 100,900,50);
        panel2.setPreferredSize(new Dimension(900, 150));

        //panel1
        lblTipoServicio = new JLabel("Tipo de servicio:");
        lblTurno = new JLabel("Turno: ");

        String[] opcionesServicio = {"INSTALACION", "REPARACION"};
        comboTipoServicio = new JComboBox(opcionesServicio);

        String[] opcionesHorarioMañana = {"8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30"};
        listaHorario = new JComboBox(opcionesHorarioMañana);

        String[] opcionesTurno = {"Mañana", "Tarde"};
        comboTurno = new JComboBox(opcionesTurno);
        comboTurno.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    System.out.println("accede");
                    String[] opcionesHorarioMañana = {"8:00","8:30","9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","13:00","13:30"};
                    String[] opcionesHorarioTarde = {"14:00","14:30","15:00","15:30","16:00","16:30","17:00","17:30","18:00","18:30","19:00","19:30"};
                    if(comboTurno.getSelectedIndex() == 0){
                        System.out.println("accede1");
                        ComboBoxModel<String> model = new DefaultComboBoxModel<>(opcionesHorarioMañana);
                        listaHorario.setModel(model);
                    } else {
                        System.out.println("accede2");
                        ComboBoxModel<String> model = new DefaultComboBoxModel<>(opcionesHorarioTarde);
                        listaHorario.setModel(model);
                    }
                }
            }
        });



        //calendario
        lblFecha = new JLabel("Fecha: ");
        fldFecha = new JTextField(20);
        btnElegirFecha = new JButton("Elegir fecha: ");
        btnElegirFecha.addActionListener(this);

        panel1.add(lblTipoServicio);
        panel1.add(comboTipoServicio);
        panel1.add(lblTurno);
        panel1.add(comboTurno);
        panel1.add(listaHorario);
        panel1.add(lblFecha);
        panel1.add(fldFecha);
        panel1.add(btnElegirFecha);

        //panel2
        btnVerificarDisponibilidad = new JButton("Ver Tecnicos disponibles");
        btnVerificarDisponibilidad.addActionListener(this);


        listaTecnicosDisponibles = new JList();
        listaTecnicosDisponibles.setVisibleRowCount(5);
        listaTecnicosDisponibles.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        listaTecnicosDisponibles.setAlignmentY(JPanel.TOP_ALIGNMENT);
        scrollTecnicosDisponibles = new JScrollPane(listaTecnicosDisponibles);

        panel2.add(btnVerificarDisponibilidad);
        panel2.add(scrollTecnicosDisponibles);

        this.add(panel1);
        this.add(panel2);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnElegirFecha){
            fldFecha.setText(new DatePick(new JFrame()).Set_Picked_Date());
        }
        if(e.getSource()==btnVerificarDisponibilidad){
            Date fecha = new Date();
            SimpleDateFormat sdfInicio = new SimpleDateFormat("dd/MM/yyyy");
            try {
                fecha = sdfInicio.parse(this.fldFecha.getText());
            } catch (ParseException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
                return;
            }
            try {
                listaTecnicosDisponibles.setModel(ControllerCallCenter.getInstance().listModelTecnicosDisponibles(
                        this.comboTurno.getSelectedItem().toString(),
                        fecha,
                        this.listaHorario.getSelectedItem().toString(),
                        comboTipoServicio.getSelectedItem().toString()
                ));
            } catch (GenericException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
                return;
            }
        }
    }
}
