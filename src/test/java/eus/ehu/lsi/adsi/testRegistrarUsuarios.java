package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zetcode.Board;
import com.zetcode.Juego;
import com.zetcode.Jugador;
import com.zetcode.ListaJugadores;

public class testRegistrarUsuarios {
    

    @Test
    public void testRegistrarUsuarios(){

        // Caso 1 Intentamos registrar a un usuario sin rellenar algun campo

            // Caso 1.1 Todos los campos rellenados y comprobamos que se añaden
            Juego.getMiJuego().registrarJugador("iufg@gmail.com", "paco", "paco");
            assertEquals(1,ListaJugadores.getMiListaJugadores().getNumeroDeJugadores());


            //assertEquals("error",Juego.getMiJuego().registrarJugador("iufg@gmail.com", "paco", null));







 
    }
     
    
}
