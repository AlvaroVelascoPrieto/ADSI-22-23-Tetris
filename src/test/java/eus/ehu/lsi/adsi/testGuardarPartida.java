package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zetcode.Jugador;
import com.zetcode.ListaJugadores;
import com.zetcode.Tetris;

public class testGuardarPartida {

	Jugador j1 = new Jugador("juan", "juan@gmail.com", "1234");
	//insertamos los jugadores de prueba en la lista de jugadores sólo para hacer las pruebas
	
	
	
	@Test
	public void testGuardarPartida() {
		//Caso 1: se pulsa el botón de guardar y no hay una partida guardada previamente
		ListaJugadores listaJ = ListaJugadores.getMiListaJugadores();
		listaJ.anadirJugador(j1);
		Tetris t1 = new Tetris("juan");
		
		//Caso 2: se pulsa el botón de guardar y ya había una partida guardada previamente
		
		//Caso 3: se pulsa el botón de guardar cuando la partida está finalizada o cuando no se está jugando
	}
	
	public void testCargarPartida(){
		//Caso 1: se pulsa el botón de cargar sin que haya una partida cargada
		
		//Caso 2: se pulsa el botón de cargar habiendo guardado una partida previamente
	}

}
