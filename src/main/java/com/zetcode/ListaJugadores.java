package com.zetcode;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
	public JSONArray obtRankAbsPers(Jugador elJugador) {
		return elJugador.obtInfoPartidas();
	}
	
	public JSONArray obtRankPersNiv(Jugador elJugador, int nivel) {
		return elJugador.obtInfoPartidasNiv(nivel);
	}

	public JSONArray obtRankAbs() {
		Iterator<Jugador> it = getIterador();
		Jugador j;
		JSONArray json5 = new JSONArray();
		while (it.hasNext()) {
			j = it.next();
			json5.put(j.obtInfoPartidas());
		}
		return json5;
	}

	public Object obtRankNiv(int niv) {
		Iterator<Jugador> it = getIterador();
		Jugador j;
		JSONArray json6 = new JSONArray();
		while (it.hasNext()) {
			j = it.next();
			json6.put(j.obtInfoPartidasNiv(niv));
		}
		return json6;
	}
}
