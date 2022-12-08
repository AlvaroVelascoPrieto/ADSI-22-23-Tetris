package com.zetcode;

import java.util.ArrayList;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

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
	
	public JSONArray obtInfoPartidas() {
		//el json tiene nombre, puntucacion y nivel
		JSONArray json1 = new JSONArray();
		Iterator<Board> it = getIterador();
		Board partida;
		
		while (it.hasNext()) {
		//guardar los datos de cada partida en el json
			partida = it.next();
			
			JSONObject jsonNombreInfoPartida = new JSONObject();
			jsonNombreInfoPartida.put("nombre", usuario);
			jsonNombreInfoPartida.put("puntuacion", partida.getPuntuacion());
			jsonNombreInfoPartida.put("nivel", partida.getNivel());
			json1.put(jsonNombreInfoPartida);
		}
		return json1;
	}

	public JSONArray obtInfoPartidasNiv(int nivel) {
		//el json tiene nombre, puntucacion y nivel (del nivel dado)
		JSONArray json3 = new JSONArray();
		Iterator<Board> it = getIterador();
		Board partida;
		
		while (it.hasNext()) {
		//guardar los datos de cada partida en el json
			partida = it.next();
			int nivelP = partida.getNivel();
			if (nivelP == nivel) {
				JSONObject jsonNombreInfoPartida = new JSONObject();
				jsonNombreInfoPartida.put("nombre", usuario);
				jsonNombreInfoPartida.put("puntuacion", partida.getPuntuacion());
				jsonNombreInfoPartida.put("nivel", nivelP);
				
				json3.put(jsonNombreInfoPartida);
				
				
			}
			
		}
		return json3;
	}
}
