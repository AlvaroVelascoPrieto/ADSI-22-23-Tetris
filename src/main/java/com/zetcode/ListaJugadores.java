package com.zetcode;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

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
			if(act.esJugador(pUsuario)) {
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
	
	public JsonArray obtRankAbsPers(Jugador elJugador) {
		return elJugador.obtInfoPartidas();
	}
	
	public JsonArray obtRankPersNiv(Jugador elJugador, int nivel) {
		return elJugador.obtInfoPartidasNiv(nivel);
	}

	public JsonArray obtRankAbs() {
		Iterator<Jugador> it = getIterador();
		Jugador j;
		JsonArray json5 = new JsonArray();
		while (it.hasNext()) {
			j = it.next();
			json5.addAll(j.obtInfoPartidas());
		}
		return json5;
	}

	public JsonArray obtRankNiv(int niv) {
		Iterator<Jugador> it = getIterador();
		Jugador j;
		JsonArray json6 = new JsonArray();
		while (it.hasNext()) {
			j = it.next();
			json6.addAll(j.obtInfoPartidasNiv(niv));
		}
		return json6;
	}
}
