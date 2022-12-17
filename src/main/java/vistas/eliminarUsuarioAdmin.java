package vistas;

import java.awt.*;
import javax.swing.border.EmptyBorder;
import javax.swing.*;

import controladores.*;



public class eliminarUsuarioAdmin extends JFrame{
        
    private JPanel contentPane;
    private static eliminarUsuarioAdmin miEliminarUsuarioAdmin;
    private static JTextField textoNombre;
   
    public eliminarUsuarioAdmin(){

        setTitle("Eliminar Usuario");
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


       

        JButton eliminar = new JButton("Eliminar");
        eliminar.setBounds(170,190,100,23);
        contentPane.add(eliminar);
        eliminar.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());



        JButton atrasbtn = new JButton("Volver");
        atrasbtn.setBounds(170,220,100,23);
        contentPane.add(atrasbtn);
        atrasbtn.addActionListener(ControladorMenuIdentificacion.getControladorMenuIdentificacion());


        setVisible(true);

    }
    public static eliminarUsuarioAdmin getMiEliminar()
    {
        if(miEliminarUsuarioAdmin == null)
        {
            miEliminarUsuarioAdmin = new eliminarUsuarioAdmin();
        }
        return miEliminarUsuarioAdmin;
    }

    public  JTextField getNombreUsuario() {
		if (textoNombre == null) {
			textoNombre = new JTextField();
            textoNombre.setBounds(152,115,140,23);
		}
		return textoNombre;
}

}
