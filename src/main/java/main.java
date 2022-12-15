import vistas.IntPersonalizar;
import vistas.MenuIdentificacion;
import vistas.MenuPrincipal;

import java.awt.EventQueue;

public class main {
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
}
