package com.zetcode;

import java.util.Observable;

import org.json.JSONObject;

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
	
	public JSONObject cargarPartida(String pUsuario)
	{
		Jugador j = ListaJugadores.getMiListaJugadores().buscarJugador(pUsuario);
		Board b = j.getPartida();
		//Convertimos "b" en un JSONObject
		JSONObject json1 = new JSONObject();
		return json1;
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
	public String obtRankAbsPers(String usuario) {
		Jugador jugador = ListaJugadores.getMiListaJugadores().buscarJugador(usuario);
		//suponemos que el jugador existe ya que esta iniciado sesion
		return ListaJugadores.getMiListaJugadores().obtRankAbsPers(jugador).toString();
	}
	public String obtRankPersNiv(String usuario, int nivel) {
		Jugador jugador = ListaJugadores.getMiListaJugadores().buscarJugador(usuario);
		//suponemos que el jugador existe ya que esta iniciado sesion
		return ListaJugadores.getMiListaJugadores().obtRankPersNiv(jugador, nivel).toString();
	}
	public String obtRankAbs() {
		return ListaJugadores.getMiListaJugadores().obtRankAbs().toString();
	}
	
	public String obtRankNiv(int niv) {
		return ListaJugadores.getMiListaJugadores().obtRankNiv(niv).toString();
	}
}
