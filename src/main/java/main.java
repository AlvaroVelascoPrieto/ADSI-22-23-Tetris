import vistas.MenuIdentificacion;

import java.awt.EventQueue;

import com.zetcode.Conexion;
import com.zetcode.ListaJugadores;

public class main {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                   MenuIdentificacion.getMiMenuIdentificacion();
                   Conexion.getMiConexion().crearDB();
                   Conexion.getMiConexion().cargarJugadores();
                   ListaJugadores.getMiListaJugadores().anadirAdmin();
                   //TODO BORRAR ESTO DESPUES
                   //Conexion.getMiConexion().guardarDatos();
                   
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
