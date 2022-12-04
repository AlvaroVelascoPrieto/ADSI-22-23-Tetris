package com.zetcode;

import java.util.ArrayList;
import java.util.Iterator;

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

	public Jugador buscarJugador(String pUsuario) {
		Iterator<Jugador> itr = this.getIterador();
		Jugador act;
		while(itr.hasNext()) {
			act = itr.next();
			if(act.getUsuario().equals(pUsuario)) {
				return act;
			}
		}
		return null;
	}
	
	public Personalizacion getPersonalizacion(Jugador elJugador) {
		return elJugador.getPersonalizacion();
	}
	
	private Iterator<Jugador> getIterador(){
		return this.lJugadores.iterator();
	}
}
