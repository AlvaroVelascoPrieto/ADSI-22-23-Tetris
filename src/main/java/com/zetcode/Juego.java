package com.zetcode;

import java.util.Observable;

public class Juego extends Observable {
	private static Juego miJuego;
	private Juego() {
		
	}
	
	public static Juego getMiJuego() {
		if(miJuego == null) {
			miJuego = new Juego();
		}
		return miJuego;
	}
	
	
	public void cambiarColorFondo(String pColor) {
		//Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(usu);
		//Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		//laPersonalizacion.setColorFondo(pColor);
	}
	
	public void cambiarColorLadrillo(String pColor) {
		//Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(usu);
		//Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		//laPersonalizacion.setColorBloques(pColor);
	}
	
	public void cambiarSonido(String pSonido) {
		//Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(usu);
		//Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		//laPersonalizacion.setSonido(pSonido);
	}
}
