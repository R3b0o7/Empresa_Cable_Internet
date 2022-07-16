package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ErrorMSG extends JFrame { //implements ActionListener {

    JButton ok;

    public ErrorMSG(){
        this.setTitle("");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());

        this.getContentPane().setBackground(new Color(107,108,109));

        JLabel msg = new JLabel("Entrada Invalida");
        msg.setHorizontalAlignment(JLabel.CENTER);
        msg.setVerticalTextPosition(JLabel.TOP);
        msg.setPreferredSize(new Dimension(200, 30));
        msg.setFont(new Font("Consolas",Font.BOLD, 15));

        ok = new JButton("Ok");
        ok.setHorizontalAlignment(JLabel.CENTER);
        ok.setVerticalAlignment(JLabel.BOTTOM);
        ok.setBackground(Color.lightGray);
        ok.addActionListener(e -> this.dispose());

        this.add(msg);
        this.add(ok);

        //Propiedades de la ventana

        this.setSize(200,120);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==ok){
            //this.dispose();
            VentanaLogin.getInstance();
        }
    }
    */
}
