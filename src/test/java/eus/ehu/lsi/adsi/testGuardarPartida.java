package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.zetcode.Juego;
import com.zetcode.Jugador;
import com.zetcode.ListaJugadores;
import com.zetcode.Tetris;

public class testGuardarPartida {

	Jugador j1 = new Jugador("kiko", "kiko.matamoros@gmail.com", "1234");
	Jugador j2 = new Jugador("belén","belén.esteban@gmail.com","1234");
	Jugador j3 = new Jugador("maria","maria.patiño@gmail.com","1234");
	//insertamos los jugadores de prueba en la lista de jugadores sólo para hacer las pruebas
	
	
	
	@Test
	public void testGuardarPartida() {
		//Caso 1: se pulsa el botón de guardar y no hay una partida guardada previamente
		ListaJugadores listaJ = ListaJugadores.getMiListaJugadores();
		listaJ.anadirJugador(j1);
		Tetris t1 = new Tetris("kiko");
		t1.getPartida().guardarPartida("kiko");
		
		assertNotNull(listaJ.buscarJugador("kiko").getPartida());
		assertEquals(listaJ.buscarJugador("kiko").getPartida(), t1.getPartida());
		
		//Caso 2: se pulsa el botón de guardar y ya había una partida guardada previamente (en este caso ya tenemos la anterior partida guardada en "juan")
		Tetris t2 = new Tetris("kiko");
		t2.getPartida().guardarPartida("kiko");
		
		assertNotEquals(listaJ.buscarJugador("kiko").getPartida(), t1.getPartida());
		assertNotNull(listaJ.buscarJugador("kiko").getPartida());
		assertEquals(listaJ.buscarJugador("kiko").getPartida(), t2.getPartida());
		
		//Caso 3: se pulsa el botón de guardar cuando el juego no está corriendo
		/*
		 * técnicamente para que el botón de guardar funciona (el botón 'g' del teclado) 
		 * el juego tiene que estar corriendo. Esta funcionalidad se ha comprobado en ejecución
		 * tanto cuando no se ha iniciado una partida aún como cuando la partida ha finalizado.
		 */
		
		
	}
	
	@Test
	public void testCargarPartida(){
		//Caso 1: se pulsa el botón de cargar sin que haya una partida cargada
		ListaJugadores listaJ = ListaJugadores.getMiListaJugadores();
		listaJ.anadirJugador(j2);
		
		JsonArray json1 = Juego.getMiJuego().cargarPartida("belén");
		assertNull(json1); //no debería devolver nada porque no hay nada guardado
		
		//Caso 2: se pulsa el botón de cargar habiendo guardado una partida previamente
		listaJ.anadirJugador(j1);
		Tetris t1 = new Tetris("kiko");
		t1.getPartida().guardarPartida("kiko");
		json1 = Juego.getMiJuego().cargarPartida("kiko");
		assertNotNull(json1);
	}

}
