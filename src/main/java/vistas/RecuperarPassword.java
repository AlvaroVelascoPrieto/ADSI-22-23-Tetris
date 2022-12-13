package vistas;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;
import controladores.*;


public class RecuperarPassword extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RecuperarPassword frame = new RecuperarPassword();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    
}

    public RecuperarPassword(){

        setTitle("Recuperar Contraseña");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        //Correo Electrónico
        JLabel correoLabel = new JLabel();
        correoLabel.setText("Correo electrónico: ");
        correoLabel.setBounds(152, 40, 200, 23);
        contentPane.add(correoLabel);

        JTextField textoCorreo = new JTextField();
        textoCorreo.setBounds(152,62,140,23);
        contentPane.add(textoCorreo);


         //Nombre usuario
         JLabel nombreLabel = new JLabel();
         nombreLabel.setText("Nombre de usuario: ");
         nombreLabel.setBounds(152, 93, 200, 23);
         contentPane.add(nombreLabel);
 
         JTextField textoNombre = new JTextField();
         textoNombre.setBounds(152,115,140,23);
         contentPane.add(textoNombre);


        //Botones

        JButton continuarbtn = new JButton();
        continuarbtn.setText("Continuar");
        continuarbtn.setBounds(170,190,100,23);
        contentPane.add(continuarbtn);


        JButton atrasbtn = new JButton();
        atrasbtn.setText("Atras");
        atrasbtn.setBounds(170,220,100,23);
        contentPane.add(atrasbtn);
        atrasbtn.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());

    }
    
}