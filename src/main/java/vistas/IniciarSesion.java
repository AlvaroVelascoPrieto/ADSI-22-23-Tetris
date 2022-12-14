package vistas;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import controladores.*;



public class IniciarSesion extends JFrame{
        
    private JPanel contentPane;
    private static IniciarSesion miInicioSesion;
    private static JTextField textoNombre;
    private static JPasswordField textoPassword;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    IniciarSesion.getMiInicioSesion();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    
}
   
    public IniciarSesion(){

        setTitle("Iniciar Sesión");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);


        //Nombre usuario
        JLabel nombreLabel = new JLabel();
        nombreLabel.setText("Nombre de usuario: ");
        nombreLabel.setBounds(152, 93, 200, 23);
        contentPane.add(nombreLabel);


        contentPane.add(this.getNombreUsuario());


        //Contraseña

        JLabel passwordLabel = new JLabel();
        passwordLabel.setText("Contraseña: ");
        passwordLabel.setBounds(152, 140, 200, 23);
        contentPane.add(passwordLabel);

       
        contentPane.add(this.getPassworField());


        //Botones

        JButton continuarbtn = new JButton();
        continuarbtn.setText("Continuar");
        continuarbtn.setBounds(170,190,100,23);
        contentPane.add(continuarbtn);
        continuarbtn.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());



        JButton atrasbtn = new JButton("Atras");
        //atrasbtn.setText("Atras");
        atrasbtn.setBounds(170,220,100,23);
        contentPane.add(atrasbtn);
        atrasbtn.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());


        setVisible(true);

    }
    public static IniciarSesion getMiInicioSesion()
    {
        if(miInicioSesion == null)
        {
            miInicioSesion = new IniciarSesion();
        }
        return miInicioSesion;
    }

    public  JTextField getNombreUsuario() {
		if (textoNombre == null) {
			textoNombre = new JTextField();
            textoNombre.setBounds(152,115,140,23);
		}
		return textoNombre;
}
    public  JTextField getPassworField() {
        if (textoPassword == null) {
            textoPassword = new JPasswordField();
            textoPassword.setBounds(152,162,140,23);
        }
        return textoPassword;
    }
}
