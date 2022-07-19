package GUI;

import Interfaz.ControllerCallCenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListarServicios extends JPanel implements ActionListener {

    JPanel panel1;
    JPanel panel2;
    JLabel lblEstado;
    JComboBox comboEstado;
    JButton btnVerListado;
    JList listaServicios;
    JScrollPane scrollListaServicios;

    public  MenuListarServicios(){
        this.setBackground(new Color(107,108,109));
        this.setBounds(0, 50,900,400);

        //creo objetos
        panel1 = new JPanel();
        panel1.setBackground(new Color(107,108,109));
        panel1.setBounds(0, 50,900,50);
        panel1.setPreferredSize(new Dimension(900, 50));

        panel2 = new JPanel();
        panel2.setBackground(new Color(107,108,90));
        panel2.setBounds(0, 100,900,200);
        panel1.setPreferredSize(new Dimension(900, 200));

        //panel1
        lblEstado = new JLabel("Seleccione estado a visualizar");

        String[] opcionesEstado = {"PROGRAMADO", "EN CURSO", "CANCELADO", "FINALIZADO"};
        comboEstado = new JComboBox(opcionesEstado);

        btnVerListado = new JButton("Ver Listado");
        btnVerListado.addActionListener(this);

        panel1.add(lblEstado);
        panel1.add(comboEstado);
        panel1.add(btnVerListado);
        panel1.setVisible(true);

        //panel2
        listaServicios = new JList();
        listaServicios.setVisibleRowCount(10);
        listaServicios.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        listaServicios.setAlignmentY(JPanel.TOP_ALIGNMENT);
        scrollListaServicios = new JScrollPane(listaServicios);
        scrollListaServicios.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollListaServicios.setPreferredSize(new Dimension(800, 150));

        panel2.add(scrollListaServicios);
        panel2.setVisible(true);

        this.add(panel1);
        this.add(panel2);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnVerListado){
            listaServicios.setModel(ControllerCallCenter.getInstance().listModelServicios(comboEstado.getSelectedIndex()));
        }
    }
}
