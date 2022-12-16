package vistas;
//import controladores.ControladorMenuPrincipal;

import controladores.ControladorMenuIdentificacion;


import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.EmptyBorder;

import com.zetcode.Conexion;

import javax.swing.*;

public class MenuIdentificacion extends JFrame{
    
    private JPanel contentPane;
    private static MenuIdentificacion miMenuIdentificacion;
    
    

    


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   MenuIdentificacion.getMiMenuIdentificacion();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuIdentificacion(){
        setTitle("Menu Identificación");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton iniciarSes = new JButton("Iniciar Sesión");
        iniciarSes.setBounds(152, 93, 200, 23);
        contentPane.add(iniciarSes);
        iniciarSes.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());

        JButton registrarse = new JButton("Registrarse");
        registrarse.setBounds(152, 127, 200, 23);
        contentPane.add(registrarse);
        registrarse.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());

        JButton recuperarPwd = new JButton("Recuperar Contraseña");
        recuperarPwd.setBounds(152, 161, 200, 23);
        contentPane.add(recuperarPwd);
        recuperarPwd.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());


        setVisible(true);
        
        this.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            
	        	Conexion.getMiConexion().guardarDatos();
	            System.out.println("Estoy cerrando");
	        }
	 });
    }
    
    public static MenuIdentificacion getMiMenuIdentificacion()
    {
        if(miMenuIdentificacion == null)
        {
            miMenuIdentificacion = new MenuIdentificacion();
        }
        return miMenuIdentificacion;
    }






}