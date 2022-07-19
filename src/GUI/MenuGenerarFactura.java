package GUI;

import Controladores.ControllerAdministrativo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuGenerarFactura extends JPanel implements ActionListener {

    JPanel panel1;
    JButton btnListarServicios;
    JList listaServiciosMod;
    JScrollPane scrollServiciosMod;
    JTextArea texarDetalle;
    JButton btnActualizar;
    JPanel panel2;
    JButton btnFacturar;
    JButton btnImprimirFactura;
    JPanel panel3;
    JTextArea texarFactura;


    public MenuGenerarFactura(){

        this.setBackground(new Color(107,108,109));
        this.setBounds(0, 50,900,400);

        //creo objetos
        panel1 = new JPanel();
        panel1.setBackground(new Color(107,108,109));
        panel1.setBounds(0, 50,900,300);
        panel1.setPreferredSize(new Dimension(900, 109));

        panel2 = new JPanel();
        panel2.setBackground(new Color(107,108,109));
        panel2.setBounds(0, 160,900,40);
        panel2.setPreferredSize(new Dimension(900, 40));

        panel3 = new JPanel();
        panel3.setBackground(new Color(107,108,109));
        panel3.setBounds(0, 200,900,40);
        panel3.setPreferredSize(new Dimension(900, 200));



        //panel1
        btnListarServicios = new JButton("Listar Servicios");
        btnListarServicios.addActionListener(this);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.addActionListener(this);

        listaServiciosMod = new JList();
        listaServiciosMod.setVisibleRowCount(5);
        listaServiciosMod.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        listaServiciosMod.setAlignmentY(JPanel.TOP_ALIGNMENT);
        scrollServiciosMod = new JScrollPane(listaServiciosMod);
        scrollServiciosMod.setPreferredSize(new Dimension(100, 90));
        listaServiciosMod.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    ControllerAdministrativo.getInstance().setServicioSeleccionado((Integer) listaServiciosMod.getSelectedValue());
                    texarDetalle.setText(ControllerAdministrativo.getInstance().getDetalleServicioSeleccionado());
                    btnImprimirFactura.setOpaque(true);
                    btnImprimirFactura.setEnabled(false);
                } catch (Exception exc){

                }
            }
        });

        texarDetalle = new JTextArea();
        texarDetalle.setPreferredSize(new Dimension(500, 90));
        texarDetalle.setAlignmentX(LEFT_ALIGNMENT);
        texarDetalle.setLineWrap(true);

        panel1.add(btnListarServicios);
        panel1.add(btnActualizar);
        panel1.add(scrollServiciosMod);
        panel1.add(texarDetalle);

        //panel 2
        btnFacturar = new JButton("Facturar");
        btnFacturar.addActionListener(this);

        btnImprimirFactura = new JButton("Imprimir factura");
        btnImprimirFactura.addActionListener(this);
        btnImprimirFactura.setOpaque(true);
        btnImprimirFactura.setEnabled(false);

        panel2.add(btnFacturar);

        //panel 3
        texarFactura = new JTextArea();
        panel3.add(texarFactura);

         //agreupo
        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
        this.setVisible(false);
        this.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== btnListarServicios){
            ListModel<Integer> listModel= ControllerAdministrativo.getInstance().listModelServiciosFinalizados();
            if(listModel.getSize()==0){
                DefaultListModel<String> listModelAlt = new DefaultListModel<String>();
                listModelAlt.add(0, "Vacio");
                listaServiciosMod.setModel(listModelAlt);
            }
            listaServiciosMod.setModel(listModel);
        }
        if(e.getSource()==btnActualizar){
            texarDetalle.setText(ControllerAdministrativo.getInstance().getDetalleServicioSeleccionado());
        }
        if(e.getSource()==btnFacturar){
            texarFactura.setText("");
            if(!ControllerAdministrativo.getInstance().verificarSeleccion()){
                JOptionPane.showMessageDialog(null, "Debe seleccionar un servicio");
            } else {
                int confirma = JOptionPane.showConfirmDialog(null, "Confirma la generación de la factura?", "Confirmación", 1);
                if(confirma == 0) {
                    int nroFactura = 0;
                    try {
                        nroFactura = ControllerAdministrativo.getInstance().facturar();
                    } catch (Exception exc){
                        JOptionPane.showMessageDialog(null, exc.getMessage());
                        return;
                    }
                    JOptionPane.showMessageDialog(null, "Se generó correctamente la factura.");
                    texarFactura.setText(ControllerAdministrativo.getInstance().getPrintFactura());
                    int imprime = JOptionPane.showConfirmDialog(null, "Desea emitir la factura?", "Confirmación", 1);
                    if(imprime==0){
                        ControllerAdministrativo.getInstance().imprimirFactura(nroFactura);
                    }
                    texarFactura.setText("");
                    btnListarServicios.doClick();
                } else {
                    return;
                }
            }
        }
        if(e.getSource()==btnActualizar){
            texarDetalle.setText(ControllerAdministrativo.getInstance().getDetalleServicioSeleccionado());
        }
    }
}
