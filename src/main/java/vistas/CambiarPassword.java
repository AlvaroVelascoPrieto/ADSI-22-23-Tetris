package vistas;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import controladores.*;

public class CambiarPassword extends JFrame{

    private JPanel contentPane;

    public CambiarPassword(){

    setTitle("Cambiar Contraseña");
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

    setContentPane(contentPane);
    contentPane.setLayout(null);


    //Nueva contraseña
    JLabel newPasswordLabel = new JLabel();
    newPasswordLabel.setText("Nueva Contraseña: ");
    newPasswordLabel.setBounds(152, 40, 200, 23);
    contentPane.add(newPasswordLabel);

    JTextField textoNewPassword = new JTextField();
    textoNewPassword.setBounds(152,62,140,23);
    contentPane.add(textoNewPassword);


    //Botones

    JButton continuarbtn = new JButton();
    continuarbtn.setText("Continuar");
    continuarbtn.setBounds(170,93,100,23);
    contentPane.add(continuarbtn);


    JButton atrasbtn = new JButton();
    atrasbtn.setText("Atras");
    atrasbtn.setBounds(170,127,100,23);
    contentPane.add(atrasbtn);
    atrasbtn.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());

            
    }
    
}
