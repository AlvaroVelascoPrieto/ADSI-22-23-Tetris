package vistas;
//import controladores.ControladorMenuPrincipal;

import controladores.ControladorMenuIdentificacion;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

public class MenuIdentificacion extends JFrame{
    
    private JPanel contentPane;
    


    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuIdentificacion frame = new MenuIdentificacion();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuIdentificacion(){
        setTitle("Menu Identificación");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

        JButton recordarPwd = new JButton("Recordar contraseña");
        recordarPwd.setBounds(152, 161, 200, 23);
        contentPane.add(recordarPwd);
        recordarPwd.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());


    }



}