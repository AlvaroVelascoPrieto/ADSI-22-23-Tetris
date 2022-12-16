package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zetcode.Board;
import com.zetcode.Jugador;

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
		Board partida3 = new Board(2, 1);
		Board partida4 = new Board(2, 2);
		juan.anadirPartidaAcabada(partida3);
		juan.anadirPartidaAcabada(partida4);
		
		
		// TEST 1 ///////////////////////////////////
		//
		// TEST 2 ///////////////////////////////////
		//
		// TEST 2.1 /////////////////////////////////
		//consultar ranking personal facil
		
		// TEST 2.2 /////////////////////////////////
		//consultar ranking personal medio
		
		// TEST 2.3 /////////////////////////////////
		//consultar ranking personal dificil
		
		// TEST 3 ///////////////////////////////////
		//consultar ranking personal absoluto
		
		// TEST 4 ///////////////////////////////////
		//
		
		// TEST 4.1 /////////////////////////////////
		//consultar ranking personal medio
		
		// TEST 4.2 /////////////////////////////////
		//consultar ranking personal dificil
		
		// TEST 4.3 /////////////////////////////////
		//consultar ranking personal dificil
		
		// TEST 5 ///////////////////////////////////
		//consultar ranking personal dificil
		
	}

	@Test
	public void testObtRankAbsPers() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtRankPersNiv() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtRankAbs() {
		fail("Not yet implemented");
	}

	@Test
	public void testObtRankNiv() {
		fail("Not yet implemented");
	}

}
