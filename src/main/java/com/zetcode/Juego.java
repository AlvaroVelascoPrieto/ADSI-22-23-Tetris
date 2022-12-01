package com.zetcode;

public class Juego {
	private static Juego miJuego;
	private Juego() {
		
	}
	
	public static Juego getMiJuego() {
		if(miJuego == null) {
			miJuego = new Juego();
		}
		return miJuego;
	}
}
