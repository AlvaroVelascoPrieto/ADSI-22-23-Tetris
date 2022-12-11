package controladores;

import com.zetcode.Tetris;
import vistas.IntPersonalizar;
import vistas.MenuRankings;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        System.out.println(e.getActionCommand());
        // botones menu principal rankings
        if (e.getActionCommand().equals("Iniciar Sesión")) { // iniciar sesion

        }
        if (e.getActionCommand().equals("Registrarse")) { // registrarse

        }
        if (e.getActionCommand().equals("Recordar Contraseña")) { // recordar contraseña
        }

    }

}
