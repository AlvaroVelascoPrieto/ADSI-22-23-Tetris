package vistas;
import controladores.ControladorMenuIdentificacion;
import controladores.ControladorMenuPrincipal;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.EmptyBorder;

import com.zetcode.Conexion;

import javax.swing.*;

public class MenuAdmin extends JFrame {    
    private JPanel contentPane;
    private static MenuAdmin miMenuAdmin;
    
    

    


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

    public MenuAdmin(){
        setTitle("Menu Administrador");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton eliminar = new JButton("Eliminar Usuario");
        eliminar.setBounds(152, 127, 200, 23);
        contentPane.add(eliminar);
        eliminar.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());


        JButton cerrarSesion = new JButton("Cerrar Sesion");
        cerrarSesion.setBounds(152, 161, 200, 23);
        contentPane.add(cerrarSesion);
		cerrarSesion.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());

        setVisible(true);
        
        this.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            
	        	Conexion.getMiConexion().guardarDatos();
	            System.out.println("Estoy cerrando");
	        }
	 });
    }
    
    public static MenuAdmin getMiMenuAdmin()
    {
        if(miMenuAdmin == null)
        {
            miMenuAdmin = new MenuAdmin();
        }
        return miMenuAdmin;
    }






}