package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zetcode.Board;
import com.zetcode.Juego;
import com.zetcode.Jugador;
import com.zetcode.ListaJugadores;

public class testRankings {
	
	@Test
	public void testRankings() {
		//Crear jugadores con partidas para luego hacer comprobaciones
		Jugador paco = new Jugador("paco", "paco@gmail.com", "paco");
		//1 partida de cada nivel
		Board partida1 = new Board(1, 0);
		Board partida2 = new Board(1, 1);
		paco.anadirPartidaAcabada(partida1);
		paco.anadirPartidaAcabada(partida2);

		//otro jugador
		Jugador juan = new Jugador("juan", "juan@gmail.com", "juan");
		//Board partida3 = new Board(2, 1);
		Board partida4 = new Board(2, 2);
		//juan.anadirPartidaAcabada(partida3);
		juan.anadirPartidaAcabada(partida4);
		
		//otro jugador
		Jugador luis = new Jugador("luis", "luis@gmail.com", "luis");
		Board partida5 = new Board(3, 0);
		Board partida6 = new Board(4, 0);
		luis.anadirPartidaAcabada(partida5);
		luis.anadirPartidaAcabada(partida6);
		Board partida7 = new Board(3, 1);
		Board partida8 = new Board(3, 1);
		luis.anadirPartidaAcabada(partida7);
		luis.anadirPartidaAcabada(partida8);
		Board partida9 = new Board(4, 2);
		Board partida10 = new Board(3, 2);
		luis.anadirPartidaAcabada(partida9);
		luis.anadirPartidaAcabada(partida10);
		
		
		//anadir los jugadores a la lista de jugadores 
		ListaJugadores.getMiListaJugadores().anadirJugador(juan);
		ListaJugadores.getMiListaJugadores().anadirJugador(paco);
		ListaJugadores.getMiListaJugadores().anadirJugador(luis);
		
		Juego juego = Juego.getMiJuego();
		
		//PRUEBAS
		
		// TEST 1 ///////////////////////////////////
		//
		// TEST 2 ///////////////////////////////////
		//
			// TEST 2.1 /////////////////////////////////
			//consultar ranking personal facil
			
			//caso 1 --> el jugador tiene al menos una partida
			JsonArray r1 = juego.obtRankPersNiv("paco", 0);
			JsonObject o1 = (JsonObject) r1.get(0);
			assertEquals("paco", o1.get("Nombre").getAsString());//comprueba que el ranking es ddel jugador deseado
			assertEquals(1, o1.get("Puntuacion").getAsInt());
			assertEquals(0, o1.get("Nivel").getAsInt());//comprueba que es del nivel dado
			
			assertEquals(r1.size(), 1);//comprueba que tiene la cantidad de elementos esperada
			
			//caso 2 --> el jugador no tiene ninguna partida
			JsonArray r2 = juego.obtRankPersNiv("juan", 0);
			assertEquals(r2.size(), 0);
			
			//caso 3 --> el jugador tiene varias partidas, se ordenan
			JsonArray r3 = juego.obtRankPersNiv("luis", 0);
			o1 = (JsonObject) r3.get(0);
			JsonObject o2 = (JsonObject) r3.get(1);
			assertTrue(o1.get("Puntuacion").getAsInt()>= o2.get("Puntuacion").getAsInt());//comprueba el metodo de ordenar
			
			assertEquals(r3.size(), 2);
			
			// TEST 2.2 /////////////////////////////////
			//consultar ranking personal medio
			
			//caso 1 --> el jugador tiene al menos una partida
			r1 = juego.obtRankPersNiv("paco", 1);
			o1 = (JsonObject) r1.get(0);
			assertEquals("paco", o1.get("Nombre").getAsString());
			assertEquals(1, o1.get("Puntuacion").getAsInt());
			assertEquals(1, o1.get("Nivel").getAsInt());
			
			assertEquals(r1.size(), 1);
			
			//caso 2 --> el jugador no tiene ninguna partida
			r2 = juego.obtRankPersNiv("juan", 1);
			assertEquals(r2.size(), 0);
			
			//caso 3 --> el jugador tiene varias partidas, se ordenan
			r3 = juego.obtRankPersNiv("luis", 1);
			o1 = (JsonObject) r3.get(0);
			o2 = (JsonObject) r3.get(1);
			assertTrue(o1.get("Puntuacion").getAsInt() >= o2.get("Puntuacion").getAsInt());
			
			assertEquals(r3.size(), 2);
			
			// TEST 2.3 /////////////////////////////////
			//consultar ranking personal dificil
			
			//caso 1 --> el jugador tiene al menos una partida
			r1 = juego.obtRankPersNiv("juan", 2);
			o1 = (JsonObject) r1.get(0);
			assertEquals("juan", o1.get("Nombre").getAsString());
			assertEquals(2, o1.get("Puntuacion").getAsInt());
			assertEquals(2, o1.get("Nivel").getAsInt());
			
			assertEquals(r1.size(), 1);
			
			//caso 2 --> el jugador no tiene ninguna partida
			r2 = juego.obtRankPersNiv("paco", 2);
			assertEquals(r2.size(), 0);
			
			//caso 3 --> el jugador tiene varias partidas, se ordenan
			r3 = juego.obtRankPersNiv("luis", 2);
			o1 = (JsonObject) r3.get(0);
			o2 = (JsonObject) r3.get(1);
			assertTrue(o1.get("Puntuacion").getAsInt()>= o2.get("Puntuacion").getAsInt());
			
			assertEquals(r3.size(), 2);
			
		// TEST 3 ///////////////////////////////////
		//consultar ranking personal absoluto
		
		//comprobar que aparecen todas las partidas de cada jugador
		r1 = juego.obtRankAbsPers("paco");
		assertEquals(2, r1.size());
		r2 = juego.obtRankAbsPers("luis");
		assertEquals(6, r2.size());
		
		// TEST 4 ///////////////////////////////////
		//
		
		// TEST 4.1 /////////////////////////////////
		//consultar ranking global facil
		
		r1 = juego.obtRankNiv(0);
		//comprobar que la cantidad de elementos es la esperada
		assertEquals(r1.size(), 3);
		
		o1 = (JsonObject) r1.get(0);
		//comprobar que son del nivel dado
		assertEquals(0, o1.get("Nivel").getAsInt());
		
		// TEST 4.2 /////////////////////////////////
		//consultar ranking global medio
		
		r1 = juego.obtRankNiv(1);
		//comprobar que la cantidad de elementos es la esperada
		assertEquals(r1.size(), 3);
		
		o1 = (JsonObject) r1.get(0);
		//comprobar que son del nivel dado
		assertEquals(1, o1.get("Nivel").getAsInt());
		
		// TEST 4.3 /////////////////////////////////
		//consultar ranking global dificil
		
		r1 = juego.obtRankNiv(2);
		//comprobar que la cantidad de elementos es la esperada
		assertEquals(r1.size(), 3);
		
		o1 = (JsonObject) r1.get(0);
		//comprobar que son del nivel dado
		assertEquals(2, o1.get("Nivel").getAsInt());
		
		// TEST 5 ///////////////////////////////////
		//consultar ranking global absoluto
		r1 = juego.obtRankAbs();
		assertEquals(9, r1.size());
	}

}
