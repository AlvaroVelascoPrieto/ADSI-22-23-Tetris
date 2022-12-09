package com.zetcode;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Jugador {
	private String usuario;
	private String correo;
	private String contrasena;
	private Board partidaJugada;
	private Board partidaGuardada;
	private ArrayList<Board> lPartidasTerminadas;
	private ArrayList<Premio> lPremios;
	private Personalizacion personalizacion;
	
	public Jugador(String pUsuario, String pCorreo, String pContrasena) {
		usuario = pUsuario;
		correo = pCorreo;
		contrasena = pContrasena;
		lPartidasTerminadas = new ArrayList<Board>();
		lPremios = new ArrayList<Premio>();
		personalizacion = new Personalizacion("Blanco", "Default", "Default");
	}

	public Personalizacion getPersonalizacion() {
		return this.personalizacion;
	}

	public Object getUsuario() {
		return this.usuario;
	}
	
	public void guardarPartida(Board pPartida)
	{
		this.partidaGuardada = pPartida;
	}
	
	public Board getPartida()
	{
		return this.partidaGuardada;
	}
	
	public boolean esJugador(String usuario) {
		return usuario.equals(usuario);
	}
	
	private Iterator<Board> getIterador(){
		return lPartidasTerminadas.iterator();
	}
	
	public JsonArray obtInfoPartidas() {
		//el json tiene nombre, puntucacion y nivel
		JsonArray json1 = new JsonArray();
		Iterator<Board> it = getIterador();
		Board partida;
		
		while (it.hasNext()) {
		//guardar los datos de cada partida en el json
			partida = it.next();
			
			JsonObject jsonNombreInfoPartida = new JsonObject();
			jsonNombreInfoPartida.addProperty("nombre", usuario);
			jsonNombreInfoPartida.addProperty("puntuacion", partida.getPuntuacion());
			jsonNombreInfoPartida.addProperty("nivel", partida.getNivel());
			json1.add(jsonNombreInfoPartida);
		}
		return json1;
	}

	public JsonArray obtInfoPartidasNiv(int nivel) {
		//el json tiene nombre, puntucacion y nivel (del nivel dado)
		JsonArray json3 = new JsonArray();
		Iterator<Board> it = getIterador();
		Board partida;
		
		while (it.hasNext()) {
		//guardar los datos de cada partida en el json
			partida = it.next();
			int nivelP = partida.getNivel();
			if (nivelP == nivel) {
				JsonObject jsonNombreInfoPartida = new JsonObject();
				jsonNombreInfoPartida.addProperty("nombre", usuario);
				jsonNombreInfoPartida.addProperty("puntuacion", partida.getPuntuacion());
				jsonNombreInfoPartida.addProperty("nivel", nivelP);
				
				json3.add(jsonNombreInfoPartida);
				
				
			}
			
		}
		return json3;
	}
}
