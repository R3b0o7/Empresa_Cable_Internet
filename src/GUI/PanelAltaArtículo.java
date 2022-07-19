package GUI;

import Enumeraciones.Articulos;
import Excepciones.GenericException;
import Interfaz.ControllerAdministrador;

import javax.naming.ldap.Control;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltaArtículo extends JPanel implements ActionListener {

    private final JComboBox<String> comboArticulo;
    //private final JTextField fldPrecio;
    JTextField cantidad;
    JButton buttonGrabarArticulo;
    JComboBox comboAltaBaja;

    public PanelAltaArtículo(){

        this.setBackground(Color.lightGray);
        this.setBounds(0, 380,300,120);
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        this.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        this.setLayout(new GridLayout(0, 2));

        cantidad = new JTextField();
        cantidad.setPreferredSize(new Dimension(100, 20));

        //fldPrecio = new JTextField();
        cantidad.setPreferredSize(new Dimension(100, 20));

        JLabel lblCantidad = new JLabel("Cantidad a modificar:   ");
        lblCantidad.setHorizontalAlignment(SwingConstants.RIGHT);
        JLabel lblArticulo = new JLabel("Articulo:   ");
        lblArticulo.setHorizontalAlignment(SwingConstants.RIGHT);
        //JLabel lblPrecio = new JLabel("Precio");

        buttonGrabarArticulo = new JButton("Guardar cambio");
        buttonGrabarArticulo.addActionListener(this);

        String[] opcionesArticulo = ControllerAdministrador.getInstance().listadoArticulosToCombo();
        this.comboArticulo = new JComboBox<String>(opcionesArticulo);

        String[] opcionesAltaBaja = {"Alta", "Baja"};
        this.comboAltaBaja = new JComboBox<String>(opcionesAltaBaja);

        this.add(lblArticulo);
        this.add(comboArticulo);
        this.add(lblCantidad);
        this.add(cantidad);
        //this.add(lblPrecio);
        //this.add(fldPrecio);
        this.add(comboAltaBaja);
        this.add(buttonGrabarArticulo);
        this.setVisible(false);
        this.setEnabled(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.buttonGrabarArticulo){
            int cantidadF = 0;
            try {
                //System.out.println(this.cantidad.getText());
                cantidadF = Integer.parseInt(this.cantidad.getText());
                if(cantidadF<0){
                    JOptionPane.showMessageDialog(null, "El valor debe ser positivo");
                    return;
                }
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "El valor debe ser un número entero.");
                return;
            }
            //double precio = 0;
            //try {
            //    precio = Double.parseDouble(this.fldPrecio.getText());
            //} catch (Exception exc){
            //    JOptionPane.showMessageDialog(null, "Valor incorrecto para precio");
            //    return;
            //}
            Articulos articulo = Articulos.Cable;
            switch(this.comboArticulo.getSelectedItem().toString()){
                case "Cable":
                    articulo = Articulos.Cable;
                    break;
                case "Conector_coaxial_RG6":
                    articulo = Articulos.Conector_coaxial_RG6;
                    break;
                case "Decodificador":
                    articulo = Articulos.Decodificador;
                    break;
                case "Modem"   :
                    articulo = Articulos.Modem;
                    break;
                case "Divisor":
                    articulo = Articulos.Divisor;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + this.comboArticulo.getSelectedItem().toString());
            }
            int confirma = JOptionPane.showConfirmDialog(null, "Confirma la actualización del artículo?", "Confirmación", 1);
            if(confirma == 0) {
                if(this.comboAltaBaja.getSelectedItem().toString().equals("Alta")) {
                    ControllerAdministrador.getInstance().altaDeStock(articulo, cantidadF);
                    //ControllerAdministrador.getInstance().modificarPrecioArticulo(articulo, precio);
                    JOptionPane.showMessageDialog(null, "El artículo fue actualizado correctamente");
                    this.setVisible(false);
                } else {
                    try {
                        ControllerAdministrador.getInstance().bajaDeStock(articulo, cantidadF);
                        JOptionPane.showMessageDialog(null, "El artículo fue cargado correctamente");
                        this.setVisible(false);
                        this.setEnabled(false);
                    } catch (GenericException exc){
                        JOptionPane.showMessageDialog(null, exc.getMessage());
                    }
                }
            }
            this.setVisible(false);
            this.setEnabled(false);

        }
    }

}
