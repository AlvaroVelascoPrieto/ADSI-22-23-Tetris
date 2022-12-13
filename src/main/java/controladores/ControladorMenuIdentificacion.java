package controladores;

import com.zetcode.Tetris;

import vistas.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class ControladorMenuIdentificacion implements ActionListener{
private static ControladorMenuIdentificacion miControladorMenuIdentificacion = null;


private ControladorMenuIdentificacion(){

}

public static ControladorMenuIdentificacion getControladorMenuIdentificacion() {
    if (miControladorMenuIdentificacion == null) {
        miControladorMenuIdentificacion = new ControladorMenuIdentificacion();
    }
    return ControladorMenuIdentificacion.miControladorMenuIdentificacion;

}

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Iniciar Sesión")) { // iniciar sesion
            MenuIdentificacion.getMiMenuIdentificacion().setVisible(false);
            IniciarSesion.getMiInicioSesion();
            IniciarSesion.getMiInicioSesion().setVisible(true); 
        }
        if (e.getActionCommand().equals("Atras")) { // Atras
            // IniciarSesion.getMiInicioSesion().dispose();
            // IniciarSesion.getMiInicioSesion().setVisible(false);
            // IniciarSesion.getMiInicioSesion().setVisible(false);
            
            IniciarSesion.getMiInicioSesion().setVisible(false);
            MenuIdentificacion.getMiMenuIdentificacion().setVisible(true);
    
            }   
        
        
        
    /*
       //System.out.println(e.getActionCommand());
        // botones menu principal rankings
        if (e.getActionCommand().equals("Iniciar Sesión")) { // iniciar sesion
            MenuIdentificacion.getMiMenuIdentificacion().dispose();
            IniciarSesion inises = new IniciarSesion();
            inises.setVisible(true);     


        }
        if (e.getActionCommand().equals("Registrarse")) { // registrarse
            MenuIdentificacion.getMiMenuIdentificacion().dispose();
            Registro registro = new Registro();
            registro.setVisible(true);

        }
        if (e.getActionCommand().equals("Recuperar Contraseña")) { // recordar contraseña
            RecuperarPassword recpass = new RecuperarPassword();
            recpass.setVisible(true);   
        }
        if (e.getActionCommand().equals("Atras")) { // Atras
            IniciarSesion.getMiInicioSesion().dispose();;
            Registro.getMiRegistro().setVisible(false);
            MenuIdentificacion menuIdentificacion = new MenuIdentificacion();
            menuIdentificacion.setVisible(true);
            
               
        }
         */

    

    }
}
       


