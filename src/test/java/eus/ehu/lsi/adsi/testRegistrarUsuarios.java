package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;


import com.zetcode.Juego;
import com.zetcode.ListaJugadores;

public class testRegistrarUsuarios {
    

    @Test
    public void testRegistrarUsuarios(){

        // Caso 1 Intentamos registrar a un usuario sin rellenar algun campo

            // Caso 1.1 Todos los campos rellenados y comprobamos que se añaden
            Juego.getMiJuego().registrarJugador("iufg@gmail.com", "paco", "paco");
            assertEquals(1,ListaJugadores.getMiListaJugadores().getNumeroDeJugadores());

            // Caso 1.2 Un  campo sin rellenar
            assertEquals("error",Juego.getMiJuego().registrarJugador("iufg@gmail.com", "paco", ""));

            // Caso 1.3 Dos campos sin rellenar
            assertEquals("error",Juego.getMiJuego().registrarJugador("iufg@gmail.com", "", ""));

            // Caso 1.4 Ningun campo rellenado    
            assertEquals("error",Juego.getMiJuego().registrarJugador("","", ""));

            // Comprobamos que solo hay un usuario
            assertEquals(1,ListaJugadores.getMiListaJugadores().getNumeroDeJugadores());
    }
     
    
}
