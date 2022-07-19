package GUI;

import Excepciones.GenericException;
import Controladores.ControllerCallCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.util.Calendar.DAY_OF_WEEK;

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
    JList listaTecnicosSeleccionados;
    JScrollPane scrollTecnicosDisponibles;
    JScrollPane scrollTecnicosSeleccionados;
    JButton btnVerificarDisponibilidad;
    JButton btnAgregarTecnico;
    public JButton btnLimpiar;
    JLabel lblPrecioServicio;
    JButton btnGuardarServicio;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;

    public PanelReservarServicio(){

        this.setBackground(new Color(100, 100, 100));
        this.setBounds(0, 200,900,200);
        this.setPreferredSize(new Dimension(900, 300));

        //instancion objetos
        panel1 = new JPanel();
        panel1.setBackground(new Color(107,108,109));
        panel1.setBounds(0, 50,900,50);
        panel1.setPreferredSize(new Dimension(900, 50));

        panel2 = new JPanel();
        panel2.setBackground(new Color(107,108,109));
        panel2.setBounds(0, 100,900,50);
        panel2.setPreferredSize(new Dimension(900, 150));
        panel2.setLayout(new GridLayout(0, 2));

        panel3 = new JPanel();
        panel3.setBackground(new Color(107,108,109));
        panel3.setBounds(0, 250,900,150);
        panel3.setPreferredSize(new Dimension(900, 150));
        panel3.setLayout(new GridLayout(0, 2));

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

        btnAgregarTecnico = new JButton("Agregar tecnico");
        btnAgregarTecnico.addActionListener(this);

        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.addActionListener(this);

        lblPrecioServicio = new JLabel("");

        listaTecnicosDisponibles = new JList();
        listaTecnicosDisponibles.setVisibleRowCount(5);
        listaTecnicosDisponibles.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        listaTecnicosDisponibles.setAlignmentY(JPanel.TOP_ALIGNMENT);
        scrollTecnicosDisponibles = new JScrollPane(listaTecnicosDisponibles);

        listaTecnicosSeleccionados = new JList();
        listaTecnicosSeleccionados.setVisibleRowCount(5);
        listaTecnicosSeleccionados.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        listaTecnicosSeleccionados.setAlignmentY(JPanel.TOP_ALIGNMENT);
        scrollTecnicosSeleccionados = new JScrollPane(listaTecnicosSeleccionados);

        panel2.add(btnVerificarDisponibilidad);
        panel2.add(scrollTecnicosDisponibles);
        panel2.add(btnAgregarTecnico);
        panel2.add(listaTecnicosSeleccionados);
        panel2.add(btnLimpiar);
        panel2.add(lblPrecioServicio);

        //panel3
        btnGuardarServicio = new JButton("Guardar Servicio");
        btnGuardarServicio.addActionListener(this);

        panel3.add(btnGuardarServicio);

        this.add(panel1);
        this.add(panel2);
        this.add(btnGuardarServicio);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Date fecha = new Date();
        if(e.getSource()==btnElegirFecha){
            fldFecha.setText(new DatePick(new JFrame()).Set_Picked_Date());
        }
        if(e.getSource()==btnVerificarDisponibilidad){
            SimpleDateFormat sdfInicio = new SimpleDateFormat("dd/MM/yyyy");
            try {
                fecha = sdfInicio.parse(this.fldFecha.getText());
            } catch (ParseException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
                return;
            }
            try {
                Date fechaactual = new Date(System.currentTimeMillis());
                if(fecha.before(fechaactual)) {
                    JOptionPane.showMessageDialog(null, "Atención!! La fecha deber ser posterior al día actual.");
                    return;
                }
                Calendar c = Calendar.getInstance();
                c.setTime(fecha);
                int day = c.get(DAY_OF_WEEK);
                if (day == 1 || (day == 7 && comboTurno.getSelectedIndex() == 1)) {
                    JOptionPane.showMessageDialog(null, "Domingos y sábados por la tarde no se presta servicio.");
                    return;
                }
                DefaultListModel<String> listModel = ControllerCallCenter.getInstance().listModelTecnicosDisponibles(
                        this.comboTurno.getSelectedItem().toString(),
                        fecha,
                        this.listaHorario.getSelectedItem().toString(),
                        comboTipoServicio.getSelectedItem().toString());
                if(listModel.getSize()==0){
                    listModel.add(0,"No existen técnicos disponibles");
                }
                listaTecnicosDisponibles.setModel(listModel);
                comboTurno.setEnabled(false);
                comboTipoServicio.setEnabled(false);
                listaHorario.setEnabled(false);
            } catch (GenericException exc){
                JOptionPane.showMessageDialog(null, exc.getMessage());
                return;
            }
        }
        if(e.getSource() == btnAgregarTecnico){
            int nroTecnico = 0;
            if(listaTecnicosDisponibles.getSelectedValue() == null){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un técnico");
            } else {
                try {
                    nroTecnico = Integer.parseInt(listaTecnicosDisponibles.getSelectedValue().toString().substring(0, 1));
                } catch (Exception exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage());
                }
                SimpleDateFormat sdfInicio = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    fecha = sdfInicio.parse(this.fldFecha.getText());
                } catch (ParseException exc){
                    JOptionPane.showMessageDialog(null, exc.getMessage());
                    return;
                }
                ControllerCallCenter.getInstance().seleccionarTecnico(nroTecnico);
                listaTecnicosSeleccionados.setModel(ControllerCallCenter.getInstance().listModelTecnicosSeleccionados());
                Double precioInicial = ControllerCallCenter.getInstance().obtenerPrecioInicialServicio(fecha, listaHorario.getSelectedItem().toString(), comboTipoServicio.getSelectedItem().toString());
                lblPrecioServicio.setText("Precio Inicial: $"+precioInicial);
                btnVerificarDisponibilidad.doClick();
            }
        }
        if(e.getSource()==btnLimpiar){
            ControllerCallCenter.getInstance().reiniciarListadoTecnicos();
            listaTecnicosDisponibles.setModel(new DefaultListModel());
            listaTecnicosSeleccionados.setModel(new DefaultListModel());
            lblPrecioServicio.setText("");
            comboTurno.setEnabled(true);
            comboTipoServicio.setEnabled(true);
            listaHorario.setEnabled(true);
        }
        if(e.getSource()==btnGuardarServicio){
            if(listaTecnicosSeleccionados.getModel().getSize() == 0){
                JOptionPane.showMessageDialog(null, "Debe seleccionar al menos un técnico");
                return;
            }
            int confirma = JOptionPane.showConfirmDialog(null, "Confirma el alta del servicio?", "Confirmación", 1);
            if(confirma == 0) {
                try {
                    ControllerCallCenter.getInstance().guardarServicio();
                } catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, exc.getMessage());
                    return;
                }
            }
        }
    }
}
