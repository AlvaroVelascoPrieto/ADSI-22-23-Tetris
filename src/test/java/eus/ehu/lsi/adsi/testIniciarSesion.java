package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zetcode.Board;
import com.zetcode.Juego;
import com.zetcode.Jugador;
import com.zetcode.ListaJugadores;

public class testIniciarSesion {

    @Test
    public void testIniciarSesion(){

        // Caso 1 Inicia Sesión un usuario previamente registrado

        Jugador paco = new Jugador("paco", "paco@gmail.com", "paco");
        ListaJugadores.getMiListaJugadores().anadirJugador(paco);
        assertEquals("paco", Juego.getMiJuego().inicioSesion("paco", "paco"));
       // assertEquals("paco", Juego.getMiJuego().inicioSesion("paco", "drthy"));


       // Caso 2 Inicia Sesión un usuario SIN REGISTRAR
       
       //Mismo nombre pero contraseña distinta
       assertNotEquals("paco", Juego.getMiJuego().inicioSesion("paco", "1234"));

       //Misma conmtraseña pero nombre distinto
       assertNotEquals("paco", Juego.getMiJuego().inicioSesion("luis", "paco"));

       //nombre y contraseña distintos
       assertNotEquals("paco", Juego.getMiJuego().inicioSesion("luis", "ewd"));



 
    }
     
    
}
