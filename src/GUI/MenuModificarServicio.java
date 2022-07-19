package GUI;

import Interfaz.ControllerAdministrativo;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class MenuModificarServicio extends JPanel implements ActionListener {

    JPanel panel1;
    JButton btnListarServiciosMod;
    JList listaServiciosMod;
    JScrollPane scrollServiciosMod;
    JTextArea texarDetalle;
    JButton btnActualizar;
    JPanel panel2;
    JButton btnModCostoMaterialesAd;
    JButton btnModCombustible;
    JButton btnModAlmuerzo;
    JButton btnBonificacion;
    JPanel pnlModCostoMaterialAd;
    JPanel pnlModCombustible;
    JPanel pnlModAlmuerzo;
    JPanel pnlBonificacion;

    public MenuModificarServicio(){
        this.setBackground(new Color(107,108,0));
        this.setBounds(0, 50,900,400);

        //creo objetos
        panel1 = new JPanel();
        panel1.setBackground(new Color(0,100,150));
        panel1.setBounds(0, 50,900,300);
        panel1.setPreferredSize(new Dimension(900, 100));

        panel2 = new JPanel();
        panel2.setBackground(new Color(107,108,120));
        panel2.setBounds(0, 160,900,40);
        panel2.setPreferredSize(new Dimension(900, 40));

        //panel1
        btnListarServiciosMod = new JButton("Listar Servicios");
        btnListarServiciosMod.addActionListener(this);

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
                } catch (Exception exc){

                }
            }
        });

        texarDetalle = new JTextArea();
        texarDetalle.setPreferredSize(new Dimension(500, 90));
        texarDetalle.setAlignmentX(LEFT_ALIGNMENT);
        texarDetalle.setLineWrap(true);

        panel1.add(btnListarServiciosMod);
        panel1.add(btnActualizar);
        panel1.add(scrollServiciosMod);
        panel1.add(texarDetalle);

        //panel 2
        btnModCostoMaterialesAd = new JButton("Modificar Material adicional");
        btnModCostoMaterialesAd.addActionListener(this);

        btnModCombustible = new JButton("Modificar Combustible");
        btnModCombustible.addActionListener(this);

        btnModAlmuerzo = new JButton("Modificar Alrmuerzo");
        btnModAlmuerzo.addActionListener(this);

        btnBonificacion = new JButton("Cargar bonificacion");
        btnBonificacion.addActionListener(this);

        panel2.add(btnModCostoMaterialesAd);
        panel2.add(btnModCombustible);
        panel2.add(btnModAlmuerzo);
        panel2.add(btnBonificacion);

        //paneles submenu
        pnlModCostoMaterialAd = new PanelModCostoMaterialAdicional();
        pnlModCombustible = new PanelModCombustible();
        pnlModAlmuerzo = new PanelModAlmuerzo();
        pnlBonificacion = new PanelBonificacion();

        //agrego paneles
        this.add(panel1);
        this.add(panel2);
        this.add(pnlBonificacion);
        this.add(pnlModAlmuerzo);
        this.add(pnlModCombustible);
        this.add(pnlModCostoMaterialAd);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnListarServiciosMod){
            ListModel<Integer> listModel= ControllerAdministrativo.getInstance().listModelServiciosFinalizados();
            if(listModel.getSize()==0){
                DefaultListModel<String> listModelAlt = new DefaultListModel<String>();
                listModelAlt.add(0, "Vacio");
                listaServiciosMod.setModel(listModelAlt);
            }
            listaServiciosMod.setModel(listModel);
        }
        if(e.getSource()==btnModCostoMaterialesAd){
            pnlBonificacion.setVisible(false);
            pnlBonificacion.setEnabled(false);
            pnlModCombustible.setVisible(false);
            pnlModCombustible.setEnabled(false);
            pnlModAlmuerzo.setVisible(false);
            pnlModAlmuerzo.setEnabled(false);
            pnlModCostoMaterialAd.setVisible(true);
            pnlModCostoMaterialAd.setEnabled(true);
        }
        if(e.getSource()==btnModCombustible){
            pnlBonificacion.setVisible(false);
            pnlBonificacion.setEnabled(false);
            pnlModCombustible.setVisible(true);
            pnlModCombustible.setEnabled(true);
            pnlModAlmuerzo.setVisible(false);
            pnlModAlmuerzo.setEnabled(false);
            pnlModCostoMaterialAd.setVisible(false);
            pnlModCostoMaterialAd.setEnabled(false);
        }
        if(e.getSource()==btnModAlmuerzo){
            pnlBonificacion.setVisible(false);
            pnlBonificacion.setEnabled(false);
            pnlModCombustible.setVisible(false);
            pnlModCombustible.setEnabled(false);
            pnlModAlmuerzo.setVisible(true);
            pnlModAlmuerzo.setEnabled(true);
            pnlModCostoMaterialAd.setVisible(false);
            pnlModCostoMaterialAd.setEnabled(false);
        }
        if(e.getSource()==btnBonificacion){
            pnlBonificacion.setVisible(true);
            pnlBonificacion.setEnabled(true);
            pnlModCombustible.setVisible(false);
            pnlModCombustible.setEnabled(false);
            pnlModAlmuerzo.setVisible(false);
            pnlModAlmuerzo.setEnabled(false);
            pnlModCostoMaterialAd.setVisible(false);
            pnlModCostoMaterialAd.setEnabled(false);
        }
        if(e.getSource()==btnActualizar){
            texarDetalle.setText(ControllerAdministrativo.getInstance().getDetalleServicioSeleccionado());
        }
    }
}
