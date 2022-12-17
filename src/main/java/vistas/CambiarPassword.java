package vistas;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import controladores.*;

public class CambiarPassword extends JFrame{

    private JPanel contentPane;
    private static JPasswordField textoPassword;
    private static CambiarPassword miCambiarPassword;

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


    contentPane.add(this.getNuevaPassword());


    //Botones

    JButton continuarbtn = new JButton();
    continuarbtn.setText("Cambiar");
    continuarbtn.setBounds(170,93,100,23);
    contentPane.add(continuarbtn);
    continuarbtn.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());


    JButton atrasbtn = new JButton();
    atrasbtn.setText("Atras");
    atrasbtn.setBounds(170,127,100,23);
    contentPane.add(atrasbtn);
    atrasbtn.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());

            
    }

    public static CambiarPassword getMicCambiarPassword()
    {
        if(miCambiarPassword == null)
        {
          miCambiarPassword = new CambiarPassword();
        }
        return miCambiarPassword;
    }

    public  JPasswordField getNuevaPassword() {
		if (textoPassword == null) {
			textoPassword = new JPasswordField();
      textoPassword.setBounds(152,62,140,23);
		}
		return textoPassword;
}

    
}
