package eus.ehu.lsi.adsi;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zetcode.Jugador;

public class testGuardarPartida {

	Jugador j1 = new Jugador("juan", "juan@gmail.com", "1234");
	@Test
	public void testGuardarPartida() {
		//Caso 1: se pulsa el botón de guardar y no hay una partida guardada previamente
		
		//Caso 2: se pulsa el botón de guardar y ya hay una partida guardada previamente
		
		//Caso 3: se pulsa el botón de guardar cuando la partida está finalizada o cuando no se está jugando
	}
	
	public void testCargarPartida(){
		fail("Not yet implemented");
	}

}
