package com.zetcode;

import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class Jugador {
	private String usuario;
	private String correo;
	private String contrasena;
	private Board partidaGuardada;
	private ArrayList<Board> lPartidasTerminadas;
	//private ArrayList<Premio> lPremios;
	private Personalizacion personalizacion;
	
	public Jugador(String pUsuario, String pCorreo, String pContrasena) {
		usuario = pUsuario;
		correo = pCorreo;
		contrasena = pContrasena;
		lPartidasTerminadas = new ArrayList<Board>();
		//lPremios = new ArrayList<Premio>();
		personalizacion = new Personalizacion("Blanco", "Default", "default");
	}

	public String getNombreUsuario(){
		return this.usuario;
	}
	public String getPassword(){
		return this.contrasena;
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
	
	public boolean esJugador(String pUsuario) {
		return usuario.equals(pUsuario);
	}
	public void cambiarPassword(String nuevaPassword) {
		this.contrasena=nuevaPassword;
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
			jsonNombreInfoPartida.addProperty("Nombre", usuario);
			jsonNombreInfoPartida.addProperty("Puntuacion", partida.getPuntuacion());
			jsonNombreInfoPartida.addProperty("Nivel", partida.getNivel());
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
				jsonNombreInfoPartida.addProperty("Nombre", usuario);
				jsonNombreInfoPartida.addProperty("Puntuacion", partida.getPuntuacion());
				jsonNombreInfoPartida.addProperty("Nivel", nivelP);
				
				json3.add(jsonNombreInfoPartida);
				
				
			}
			
		}
		return json3;
	}

	public void anadirPartidaAcabada(Board parAcabada) {
		lPartidasTerminadas.add(parAcabada);
		
	}
	
	public void setPersonalizacion (Personalizacion pPersonalizacion) {
		personalizacion = pPersonalizacion;
	}
	
	public String getCorreo()
	{
		return this.correo;
	}
	
	public String getContrasena()
	{
		return this.contrasena;
	}
	
	public ArrayList<Board> getPartidasAcabadas()
	{
		return this.lPartidasTerminadas;
	}
	
}
