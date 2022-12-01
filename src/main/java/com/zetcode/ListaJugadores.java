package com.zetcode;

import java.util.ArrayList;

public class ListaJugadores {
	private static ListaJugadores miListaJugadores; 
	private ArrayList<Jugador> lJugadores;
	
	private ListaJugadores() {
		lJugadores = new ArrayList<Jugador>();
	}
	
	public static ListaJugadores getMiListaJugadores() {
		if(miListaJugadores == null) {
			miListaJugadores = new ListaJugadores();
		}
		return miListaJugadores;
	}
}
