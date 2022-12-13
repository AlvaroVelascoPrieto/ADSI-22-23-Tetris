package com.zetcode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zetcode.Shape.Tetrominoe;

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
	
	public JsonArray cargarPartida(String pUsuario)
	{
		Jugador j = ListaJugadores.getMiListaJugadores().buscarJugador(pUsuario);
		Board b = j.getPartida();
		//creamos un JsonArray que contendrá las propiedades de la partida + otro JsonArray de bloques.
		JsonArray jsonA = new JsonArray();
		//insertamos las propiedades de la partida en un json para dárselo al JsonArray
		JsonObject json1 = new JsonObject();
		json1.addProperty("Puntuacion", b.getPuntuacion());
		json1.addProperty("Puntuacion", b.getPuntuacion());
		json1.addProperty("Nivel", b.getNivel());
		
		jsonA.add(json1);
		
		//creamos un JsonArray que contendrá Jsons sobre las propiedades de cada bloque
		JsonArray jsonBloques = new JsonArray();
		//para cada bloque creamos un Json que contenga únicamente la forma de la posición i del array que expresa el tablero.
		Tetrominoe[] listaBloques = b.getBloques();
		for(int i = 0; i < listaBloques.length; i++)
		{
			int numForma = listaBloques[i].ordinal();
			String nombreForma;
			switch(numForma) {
			case 0:
				nombreForma = "NoShape";
	    	case 1:
	    		nombreForma = "ZShape";
	    	case 2:
	    		nombreForma = "SShape";
	    	case 3:
	    		nombreForma = "LineShape";
	    	case 4:
	    		nombreForma = "TShape";
	    	case 5:
	    		nombreForma = "SquareShape";
	    	case 6:
	    		nombreForma = "LShape";
	    	case 7:
	    		nombreForma = "MirroredShape";
	    	default:
	    			nombreForma = "NoShape";
	    	}
			JsonObject jsonB = new JsonObject();
			jsonB.addProperty("nombreForma", nombreForma);
			jsonBloques.add(jsonB);
		}
		
		jsonA.add(jsonBloques);
		
		return jsonA;
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
	
	///////  RANKINGS ////////////////////////////////
	public JsonArray obtRankAbsPers(String usuario) {
		Jugador jugador = ListaJugadores.getMiListaJugadores().buscarJugador(usuario);
		//suponemos que el jugador existe ya que esta iniciado sesion
		return ListaJugadores.getMiListaJugadores().obtRankAbsPers(jugador);
	}
	public JsonArray obtRankPersNiv(String usuario, int nivel) {
		Jugador jugador = ListaJugadores.getMiListaJugadores().buscarJugador(usuario);
		//suponemos que el jugador existe ya que esta iniciado sesion
		return ListaJugadores.getMiListaJugadores().obtRankPersNiv(jugador, nivel);
	}
	public JsonArray obtRankAbs() {
		return ListaJugadores.getMiListaJugadores().obtRankAbs();
	}
	
	public JsonArray obtRankNiv(int niv) {
		return ListaJugadores.getMiListaJugadores().obtRankNiv(niv);
	}
}
