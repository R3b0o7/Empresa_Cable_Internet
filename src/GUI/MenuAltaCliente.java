package GUI;

import Clases.Compania;
import Interfaz.ControllerCallCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuAltaCliente extends JPanel implements ActionListener {

    JLabel lblDNI;
    JLabel lblNombre;
    JLabel lblDireccion;
    JTextField fldDNI;
    JTextField fldNombre;
    JTextField fldDireccion;
    JButton btnGuardar;
    JButton btnRefrescar;
    JList listaClientes;
    JScrollPane scroll;
    JPanel panel1;
    JPanel panel2;

    public MenuAltaCliente(){

        this.setBackground(new Color(192, 18, 18));
        this.setBounds(0, 50,900,450);

        //instancio objetos
        panel1 = new JPanel();
        this.setBackground(new Color(100, 100, 18));
        this.setBounds(0, 50,900,100);

        panel2 = new JPanel();
        this.setBackground(new Color(100, 100, 100));
        this.setBounds(0, 50,900,300);

        lblDNI = new JLabel("DNI");
        lblNombre = new JLabel("Nombre y apellido");
        lblDireccion = new JLabel("Dirección");

        fldDNI = new JTextField();
        fldDNI.setPreferredSize(new Dimension(100, 20));

        fldNombre = new JTextField();
        fldNombre.setPreferredSize(new Dimension(100, 20));

        fldDireccion = new JTextField();
        fldDireccion.setPreferredSize(new Dimension(100, 20));

        listaClientes = new JList();
        listaClientes.setVisibleRowCount(5);
        listaClientes.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        listaClientes.setAlignmentY(JPanel.TOP_ALIGNMENT);
        listaClientes.setModel(ControllerCallCenter.getInstance().listModelClientes());
        scroll = new JScrollPane(listaClientes);

        btnGuardar = new JButton("Guardar cliente");
        btnGuardar.addActionListener(this);

        btnRefrescar = new JButton("Refrescar");
        btnRefrescar.addActionListener(this);

        //agrego objetos
        panel1.add(lblDNI);
        panel1.add(fldDNI);
        panel1.add(lblNombre);
        panel1.add(fldNombre);
        panel1.add(lblDireccion);
        panel1.add(fldDireccion);
        panel1.add(btnGuardar);
        panel2.add(scroll);
        panel2.add(btnRefrescar);
        this.add(panel1);
        this.add(panel2);
        this.setVisible(false);
        this.setEnabled(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnGuardar){
            int v_dni = 0;
            try{
                v_dni = Integer.parseInt(this.fldDNI.getText());
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Valor ingresado inválido");
                return;
            }
            if(Compania.getInstance().getCliente(v_dni) != null){
                JOptionPane.showMessageDialog(null, "El cliente ya existe");
                return;
            } else {
                int confirma = JOptionPane.showConfirmDialog(null, "Confirma el alta del cliente?", "Confirmación", 1);
                if(confirma == 0) {
                    ControllerCallCenter.getInstance().altaCliente(v_dni, this.fldNombre.getText(), this.fldDireccion.getText());
                    JOptionPane.showMessageDialog(null, "El cliente se creo correctamente");
                    listaClientes.setModel(ControllerCallCenter.getInstance().listModelClientes());
                } else {
                    return;
                }
            }
        }
    }
}
