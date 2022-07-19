package GUI;

import Clases.Cliente;
import Clases.Compania;
import Controladores.ControllerCallCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.JOptionPane.*;

public class MenuReservarServicio extends JPanel implements ActionListener {

    JLabel lblDNI;
    JTextField fldDNI;
    JButton btnBuscarCliente;
    JButton btnReservarServicio;
    JList listaCliente;
    JLabel lblSeleccionarCliente;
    JPanel panel1;
    JPanel panel2;
    JPanel pnlReservaServicio;


    public MenuReservarServicio(){


        this.setBackground(new Color(107,108,109));
        this.setBounds(0, 50,900,400);

        //creo objetos
        panel1 = new JPanel();
        panel1.setBackground(new Color(107,100,150));
        panel1.setBounds(0, 50,900,100);
        panel1.setPreferredSize(new Dimension(900, 50));

        panel2 = new JPanel();
        panel2.setBackground(new Color(107,108,120));
        panel2.setBounds(0, 100,900,100);
        panel1.setPreferredSize(new Dimension(900, 50));

        pnlReservaServicio = new PanelReservarServicio();

        lblDNI = new JLabel("Ingrese DNI a buscar:");
        fldDNI = new JTextField();
        fldDNI.setPreferredSize(new Dimension(100, 20));
        lblSeleccionarCliente = new JLabel("Seleccione el cliente: ");

        btnBuscarCliente = new JButton("Buscar cliente");
        btnBuscarCliente.addActionListener(this);

        btnReservarServicio = new JButton("Reservar servicio");
        btnReservarServicio.addActionListener(this);

        //Listas

        listaCliente = new JList();
        listaCliente.setVisibleRowCount(1);
        listaCliente.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
        listaCliente.setAlignmentY(JPanel.TOP_ALIGNMENT);
        listaCliente.setVisible(true);

        //agrego los objetos al panel
        panel1.add(lblDNI);
        panel1.add(fldDNI);
        panel1.add(btnBuscarCliente);
        panel2.add(lblSeleccionarCliente);
        panel2.add(listaCliente);
        panel2.add(btnReservarServicio);
        this.add(panel1);
        this.add(panel2);
        this.add(pnlReservaServicio);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnBuscarCliente){
            int v_dni = 0;
            try{
                v_dni = Integer.parseInt(this.fldDNI.getText());
            } catch (Exception exc){
                showMessageDialog(null, "El valor ingresado es inválido");
                return;
            }
            if(Compania.getInstance().getCliente(v_dni) == null){
                showMessageDialog(null, "El cliente no existe");
                this.setVisible(false);
                this.setEnabled(false);
                VentanaCallCenter.mostrarAltaCliente();
            } else {
                this.listaCliente.setModel(ControllerCallCenter.getInstance().listModelCliente(v_dni));
            }
        }
        if(e.getSource()==btnReservarServicio){
            if(this.listaCliente.getSelectedValue() != null) {
                Cliente cliente = ControllerCallCenter.getInstance().getClienteSeleccionado();
                if(ControllerCallCenter.getInstance().validarClienteConReserva(cliente.getDni()) != 0){
                    showMessageDialog(null, "El cliente no puede tener más de un turno reservado.\nID servicio "+ControllerCallCenter.getInstance().validarClienteConReserva(cliente.getDni()));
                    return;
                } else {
                    this.pnlReservaServicio.setVisible(true);
                    this.pnlReservaServicio.setEnabled(true);
                }
            } else {
                showMessageDialog(null, "Debe seleccionar el cliente de la lista.");
            }
        }
    }
}
