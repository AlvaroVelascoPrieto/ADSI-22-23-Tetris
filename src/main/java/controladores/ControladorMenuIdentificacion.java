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

        if (e.getActionCommand().equals("Iniciar Sesión")) { // Iniciar sesion
            MenuIdentificacion.getMiMenuIdentificacion().setVisible(false);
            IniciarSesion.getMiInicioSesion();
            IniciarSesion.getMiInicioSesion().setVisible(true); 
        }
        if (e.getActionCommand().equals("Atras")) { // Atras
            
            IniciarSesion.getMiInicioSesion().setVisible(false);
            Registro.getMiRegistro().setVisible(false);
            RecuperarPassword.getMiRecuperarPassword().setVisible(false);
            MenuIdentificacion.getMiMenuIdentificacion().setVisible(true);
    
        }        


         if (e.getActionCommand().equals("Registrarse")) { // Registrarse
             MenuIdentificacion.getMiMenuIdentificacion().setVisible(false);
             Registro.getMiRegistro();
             Registro.getMiRegistro().setVisible(true);

         }

         if (e.getActionCommand().equals("Recuperar Contraseña")) { // Recuperar contraseña
            MenuIdentificacion.getMiMenuIdentificacion().setVisible(false);
            RecuperarPassword.getMiRecuperarPassword();
            RecuperarPassword.getMiRecuperarPassword().setVisible(true);   
        }    

    }
}
       


