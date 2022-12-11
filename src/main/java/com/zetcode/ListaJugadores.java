package com.zetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
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
	
	public void anadirJugador(Jugador pJugador) {
		lJugadores.add(pJugador);
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
		JsonArray ranking = elJugador.obtInfoPartidas();
		return ordenarJsonArrayPuntuacion(ranking);

	}
	
	public JsonArray obtRankPersNiv(Jugador elJugador, int nivel) {
		JsonArray ranking =  elJugador.obtInfoPartidasNiv(nivel);
		return ordenarJsonArrayPuntuacion(ranking);
	}

	public JsonArray obtRankAbs() {
		Iterator<Jugador> it = getIterador();
		Jugador j;
		JsonArray json5 = new JsonArray();
		while (it.hasNext()) {
			j = it.next();
			json5.addAll(j.obtInfoPartidas());
		}
		return ordenarJsonArrayPuntuacion(json5);
	}

	public JsonArray obtRankNiv(int niv) {
		Iterator<Jugador> it = getIterador();
		Jugador j;
		JsonArray json6 = new JsonArray();
		while (it.hasNext()) {
			j = it.next();
			json6.addAll(j.obtInfoPartidasNiv(niv));
		}
		return ordenarJsonArrayPuntuacion(json6);
	}
	
	private JsonArray ordenarJsonArrayPuntuacion(JsonArray json) {
		
		//de jsonarray a list
		List<JsonElement> lista = json.asList();
		//ordenar la lista
		Collections.sort(lista, new Comparator<JsonElement>(){
			//indicar la logica de comparacion
			@Override
			public int compare(JsonElement o1, JsonElement o2) {
				int p1 = ((JsonObject) o1).get("Puntuacion").getAsInt();
				int p2 = ((JsonObject) o2).get("Puntuacion").getAsInt();
				if (p1>p2) {return -1;}
				else if (p1<p2) {return 1;}
				else {return 0;}
			}
		});
		
		//pasar de la lista a jsonarray para devolver el resultado
		JsonArray jsonOrdenado = (JsonArray) new Gson().toJsonTree(lista);
		return jsonOrdenado;
	}
}
