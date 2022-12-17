package controladores;

import com.zetcode.Tetris;
import com.zetcode.enviarCorreo;

import vistas.*;
import javax.swing.JOptionPane;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.zetcode.ListaJugadores;
import com.zetcode.Juego;
import com.zetcode.Jugador;

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
            System.out.println(ListaJugadores.getMiListaJugadores().getNumeroDeJugadores());
            MenuIdentificacion.getMiMenuIdentificacion().setVisible(false);
            RecuperarPassword.getMiRecuperarPassword();
            RecuperarPassword.getMiRecuperarPassword().setVisible(true);   
        }    
        if (e.getActionCommand().equals("Continuar")) {
            IniciarSesion.getMiInicioSesion().setVisible(false);
            Juego.getMiJuego().inicioSesion();

        }

        if (e.getActionCommand().equals("Listo")) {
           Registro.getMiRegistro().setVisible(false);
           Juego.getMiJuego().registrarJugador();

        }
        if (e.getActionCommand().equals("Recuperar")) {
            Juego.getMiJuego().recuperarPassword();
         }
        if (e.getActionCommand().equals("Eliminar Usuario")) {
            MenuAdmin.getMiMenuAdmin().setVisible(false);
            eliminarUsuarioAdmin.getMiEliminar().setVisible(true);
        }
        if (e.getActionCommand().equals("Eliminar")) {
            Juego.getMiJuego().eliminarUsuario();


        }
        if (e.getActionCommand().equals("Volver")) {
            eliminarUsuarioAdmin.getMiEliminar().dispose();;
            MenuAdmin.getMiMenuAdmin().setVisible(true);

        }


        }

    }

       


