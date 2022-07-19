package GUI;

import Controladores.ControllerAdministrativo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuListarFacturas extends JPanel implements ActionListener {

    JPanel panel1;
    JButton btnListarFacturas;
    JList listaFacturas;
    JScrollPane scrollFacturas;
    JButton btnActualizar;
    JTextArea texarDetalle;
    JPanel panel2;
    JButton btnImprimirFactura;


    public MenuListarFacturas(){

        this.setBackground(new Color(107,108,109));
        this.setBounds(0, 50,900,400);

        //creo objetos
        panel1 = new JPanel();
        panel1.setBackground(new Color(107,108,109));
        panel1.setBounds(0, 50,900,300);
        panel1.setPreferredSize(new Dimension(900, 200));

        panel2 = new JPanel();
        panel2.setBackground(new Color(107,108,109));
        panel2.setBounds(0, 250,900,40);
        panel2.setPreferredSize(new Dimension(900, 40));

        //panel1
        btnListarFacturas = new JButton("Listar Facturas");
        btnListarFacturas.addActionListener(this);

        btnActualizar = new JButton("Ver detalle");
        btnActualizar.addActionListener(this);

        listaFacturas = new JList();
        listaFacturas.setVisibleRowCount(5);
        listaFacturas.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        listaFacturas.setAlignmentY(JPanel.TOP_ALIGNMENT);
        scrollFacturas = new JScrollPane(listaFacturas);
        scrollFacturas.setPreferredSize(new Dimension(100, 90));
        listaFacturas.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    ControllerAdministrativo.getInstance().setFacturaSeleccionada((Integer) listaFacturas.getSelectedValue());
                    btnActualizar.doClick();
                    btnImprimirFactura.setOpaque(false);
                    btnImprimirFactura.setEnabled(true);
                } catch (Exception exc){

                }
            }
        });

        texarDetalle = new JTextArea();
        texarDetalle.setPreferredSize(new Dimension(500, 200));
        texarDetalle.setAlignmentX(LEFT_ALIGNMENT);
        texarDetalle.setLineWrap(true);

        panel1.add(btnListarFacturas);
        panel1.add(btnActualizar);
        panel1.add(scrollFacturas);
        panel1.add(texarDetalle);

        //panel 2
        btnImprimirFactura = new JButton("Imprimir factura");
        btnImprimirFactura.addActionListener(this);
        btnImprimirFactura.setOpaque(true);
        btnImprimirFactura.setEnabled(false);

        panel2.add(btnImprimirFactura);


        //agreupo
        this.add(panel1);
        this.add(panel2);
        this.setVisible(false);
        this.setVisible(false);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnListarFacturas){
            ListModel<Integer> listModel= ControllerAdministrativo.getInstance().listModelFacturas();
            if(listModel.getSize()==0){
                DefaultListModel<String> listModelAlt = new DefaultListModel<String>();
                listModelAlt.add(0, "Vacio");
                listaFacturas.setModel(listModelAlt);
            } else {
                listaFacturas.setModel(listModel);
            }
        }
        if(e.getSource()==btnActualizar){
            texarDetalle.setText(ControllerAdministrativo.getInstance().getDetalleServicioSeleccionado());
        }
        if(e.getSource()==btnImprimirFactura){
            try {
                ControllerAdministrativo.getInstance().imprimirFactura((Integer) listaFacturas.getSelectedValue());
                texarDetalle.setText("");
                btnImprimirFactura.setOpaque(true);
                btnImprimirFactura.setEnabled(false);
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "Debe seleccionar una factura");
            }
        }
        if(e.getSource()==btnActualizar){
            texarDetalle.setText(ControllerAdministrativo.getInstance().getDetalleFacturaSeleccioanda());
        }
    }

}
