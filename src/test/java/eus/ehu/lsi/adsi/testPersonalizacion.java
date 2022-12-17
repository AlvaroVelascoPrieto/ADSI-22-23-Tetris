package eus.ehu.lsi.adsi;

import com.zetcode.Juego;
import com.zetcode.Jugador;
import com.zetcode.ListaJugadores;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class testPersonalizacion {
	
	@Test
	public void testCambiarColorFondo() {
		Color Blanco = new Color(255, 255, 255);
		Color Negro = new Color(0, 0, 0);
		Color Azul = new Color(0, 128, 255);
		Color Verde = new Color(102, 204, 102);
		Color Naranja = new Color(255, 141, 0);

		Jugador paco = new Jugador("paco", "paco@gmail.com", "paco");
		ListaJugadores.getMiListaJugadores().anadirJugador(paco);
		Juego.getMiJuego().cambiarColorFondo("Azul","paco");
		Assert.assertEquals(Azul, Juego.getMiJuego().getColorFondo("paco"));
		Juego.getMiJuego().cambiarColorFondo("Verde","paco");
		Assert.assertEquals(Verde, Juego.getMiJuego().getColorFondo("paco"));
		Assert.assertNotEquals(Azul,Juego.getMiJuego().getColorFondo("paco"));
		Jugador juan = new Jugador("juan", "juan@gmail.com", "juan");
		ListaJugadores.getMiListaJugadores().anadirJugador(juan);
		Assert.assertNotEquals(Verde,Juego.getMiJuego().getColorFondo("juan"));
		Assert.assertEquals(Blanco, Juego.getMiJuego().getColorFondo("juan"));
		Juego.getMiJuego().cambiarColorFondo("Naranja","juan");
		Assert.assertEquals(Naranja,Juego.getMiJuego().getColorFondo("juan"));
		Juego.getMiJuego().cambiarColorFondo("Negro","juan");
		Assert.assertEquals(Negro,Juego.getMiJuego().getColorFondo("juan"));
	}

	@Test
	public void testColorLadrillo() {
		Color Default[] = {new Color(0, 0, 0), new Color(204, 102, 102),
					new Color(102, 204, 102), new Color(102, 102, 204),
					new Color(204, 204, 102), new Color(204, 102, 204),
					new Color(102, 204, 204), new Color(218, 170, 0)
		};
		Color Retro[] = {new Color(229, 210, 141), new Color(77, 72, 69),
					new Color(255, 135, 0), new Color(0, 0, 0),
					new Color(77, 65, 4), new Color(73, 70, 70),
					new Color(73, 39, 24), new Color(0, 0, 0)
		};
		Color Modern[] = {new Color(229, 210, 141), new Color(229, 210, 141),
					new Color(229, 210, 141), new Color(229, 210, 141),
					new Color(229, 210, 141), new Color(229, 210, 141),
					new Color(229, 210, 141), new Color(229, 210, 141)
		};
		Color Cool[] = {new Color(0, 205, 255), new Color(0, 255, 77),
					new Color(165, 156, 215), new Color(102, 102, 204),
					new Color(171, 104, 222), new Color(204, 102, 204),
					new Color(0, 180, 255), new Color(160, 229, 141)
		};
		Jugador paco = new Jugador("paco", "paco@gmail.com", "paco");
		ListaJugadores.getMiListaJugadores().anadirJugador(paco);
		Juego.getMiJuego().cambiarColorLadrillo("Modern","paco");
		Assert.assertEquals(Modern,Juego.getMiJuego().getColorBloques("paco"));
		Assert.assertNotEquals(Retro,Juego.getMiJuego().getColorBloques("paco"));
		Juego.getMiJuego().cambiarColorLadrillo("Retro","paco");
		Assert.assertEquals(Retro,Juego.getMiJuego().getColorBloques("paco"));
		Jugador juan = new Jugador("juan", "juan@gmail.com", "juan");
		ListaJugadores.getMiListaJugadores().anadirJugador(juan);
		Assert.assertEquals(Default,Juego.getMiJuego().getColorBloques("juan"));
		Juego.getMiJuego().cambiarColorLadrillo("Cool","juan");
		Assert.assertEquals(Cool,Juego.getMiJuego().getColorBloques("juan"));

	}

	@Test
	public void testCambiarSonido() {
		Jugador paco = new Jugador("paco", "paco@gmail.com", "paco");
		ListaJugadores.getMiListaJugadores().anadirJugador(paco);
		Juego.getMiJuego().cambiarSonido("animado","paco");
		Assert.assertEquals("animado.wav",Juego.getMiJuego().getSonido("paco"));
		Assert.assertNotEquals("PanteraRosa.wav",Juego.getMiJuego().getSonido("paco"));
		Juego.getMiJuego().cambiarSonido("PanteraRosa","paco");
		Assert.assertEquals("PanteraRosa.wav",Juego.getMiJuego().getSonido("paco"));
		Jugador juan = new Jugador("juan", "juan@gmail.com", "juan");
		ListaJugadores.getMiListaJugadores().anadirJugador(juan);
		Assert.assertEquals("default.wav",Juego.getMiJuego().getSonido("juan"));
		Juego.getMiJuego().cambiarSonido("retro","juan");
		Assert.assertEquals("retro.wav",Juego.getMiJuego().getSonido("juan"));
		Juego.getMiJuego().cambiarSonido("StarWars","juan");
		Assert.assertEquals("StarWars.wav",Juego.getMiJuego().getSonido("juan"));
	}

}
