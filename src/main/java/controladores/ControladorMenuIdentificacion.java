package controladores;

import com.zetcode.Tetris;

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
           // Jugador jugador = new Jugador("pepe","pepe@gmail.com", "1234");
           // ListaJugadores listaJ= ListaJugadores.getMiListaJugadores();
          //  listaJ.anadirJugador(jugador);


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
        if (e.getActionCommand().equals("Continuar")) {
            String nombreUsuario = Juego.getMiJuego().nombreJugador();
            MenuPrincipal menuPrincipal= new MenuPrincipal(nombreUsuario);


        }


        }

    }

       


