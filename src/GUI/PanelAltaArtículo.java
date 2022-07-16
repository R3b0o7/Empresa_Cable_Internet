package GUI;

import Enumeraciones.TipoTecnico;
import Interfaz.ControllerAdministrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelAltaArtículo extends JPanel implements ActionListener {

    private final JComboBox<String> comboArticulo;
    JTextField cantidad;
    JButton buttonGrabarArticulo;

    public PanelAltaArtículo(){

        this.setBackground(Color.lightGray);
        this.setBounds(0, 380,300,120);
        this.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        this.setAlignmentY(JPanel.BOTTOM_ALIGNMENT);
        this.setLayout(new GridLayout(0, 2));

        cantidad = new JTextField();
        cantidad.setPreferredSize(new Dimension(100, 20));

        JLabel lblCantidad = new JLabel("Cantidad a ingresar");

        buttonGrabarArticulo = new JButton("Guardar stock");
        buttonGrabarArticulo.addActionListener(this);

        String[] opcionesArticulo = ControllerAdministrador.getInstance().listadoArticulosToCombo();
        this.comboArticulo = new JComboBox<String>(opcionesArticulo);

        this.add(lblCantidad);
        this.add(cantidad);
        this.add(comboArticulo);
        this.add(buttonGrabarArticulo);
        this.setVisible(false);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==this.buttonGrabarArticulo){
            int cantidadF = 0;
            try {
                System.out.println(this.cantidad.getText());
                cantidadF = Integer.parseInt(this.cantidad.getText());
                if(cantidadF<0){
                    JOptionPane.showConfirmDialog(null, "El valor debe ser positivo");
                    return;
                }
            } catch (Exception exc){
                JOptionPane.showMessageDialog(null, "El valor debe ser un número entero.");
                return;
            }
//
//            switch(this.tipoTecnico.getSelectedItem().toString()){
//                case "Junior":
//                    tipo = TipoTecnico.Junior;
//                    break;
//                case "Semi_senior":
//                    tipo = TipoTecnico.Semi_senior;
//                    break;
//                case "Senior":
//                    tipo = TipoTecnico.Senior;
//                    break;
//            }

            int confirma = JOptionPane.showConfirmDialog(null, "Confirma el ingreso de articulos?", "Confirmación", 1);
            if(confirma == 0) {
                JOptionPane.showMessageDialog(null, "El Técnico fue dado de alta correctamente");
            }
        }
    }

}
