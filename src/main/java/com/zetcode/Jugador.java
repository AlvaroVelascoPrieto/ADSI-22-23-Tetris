package com.zetcode;

import java.util.ArrayList;

public class Jugador {
	private String usuario;
	private String correo;
	private String contrasena;
	private Board partidaJugada;
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
	
}
