package controladores;

import com.zetcode.Tetris;

import vistas.*;
import javax.swing.JOptionPane;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.zetcode.ListaJugadores;
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
            Jugador jugador = new Jugador("pepe","pepe@gmail.com", "1234");
            ListaJugadores listaJ= ListaJugadores.getMiListaJugadores();
            System.out.println(listaJ.getNumeroDeJugadores());
            listaJ.anadirJugador(jugador);
            System.out.println(listaJ.getNumeroDeJugadores());

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

        if (e.getActionCommand().equals("Continuar")) { // Continuar
            MenuIdentificacion.getMiMenuIdentificacion().setVisible(false);
            Registro.getMiRegistro().setVisible(false);
            IniciarSesion.getMiInicioSesion().setVisible(false);
            //boolean correcto=false;
            String inputNombre=IniciarSesion.getMiInicioSesion().getNombreUsuario().getText();
            String inputpassword=IniciarSesion.getMiInicioSesion().getPassworField().getText();
            int i=0;
            boolean enc=false;

            while (!enc&& i<ListaJugadores.getMiListaJugadores().getNumeroDeJugadores()){
                System.out.println("hola");
                if (ListaJugadores.getMiListaJugadores().buscarJugador(inputNombre) == null){
                    
                }
                else{
                   Jugador jugador = ListaJugadores.getMiListaJugadores().buscarJugador(inputNombre);
                    if(jugador.getPassword().equals(inputpassword) && jugador.getNombreUsuario().equals(inputNombre)){
                        System.out.println("BIENVENIDO");
                        MenuPrincipal.getMiMenuPrincipal();
                        MenuPrincipal.getMiMenuPrincipal().setVisible(true);
                        enc=true;

                    }

                }
                i=i+1;


            } 
            if (enc==false){
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error Inicio de Sesión", JOptionPane.WARNING_MESSAGE);
                IniciarSesion.getMiInicioSesion().setVisible(true);
            }/* 
            if(!correcto){

                MenuPrincipal.getMiMenuPrincipal();
                MenuPrincipal.getMiMenuPrincipal().setVisible(true);    
            }
            */


        }

    }
}
       


