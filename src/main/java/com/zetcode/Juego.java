package com.zetcode;

import java.awt.*;

import java.util.Observable;

import javax.swing.JOptionPane;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zetcode.Shape.Tetrominoe;

import vistas.*;

public class Juego extends Observable {
	private static Juego miJuego;
	private static String nombreJugador;
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
		//si realmente existía esa partida, se carga. Si no, se muestra un mensaje de error.
		if(b != null)
		{
			//creamos un JsonArray que contendrá las propiedades de la partida + otro JsonArray de bloques.
			JsonArray jsonA = new JsonArray();
			//insertamos las propiedades de la partida en un json para dárselo al JsonArray
			JsonObject json1 = new JsonObject();
			json1.addProperty("Anchura", b.getAnchura());
			json1.addProperty("Altura", b.getAltura());
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
				String forma = "NoShape";
				if(numForma == 0)
				{
					forma = "NoShape";
				}
				else if(numForma == 1)
				{
					forma = "ZShape";
				}
				else if(numForma == 2)
				{
					forma = "SShape";
				}
				else if(numForma == 3)
				{
					forma = "LineShape";
				}
				else if(numForma == 4)
				{
					forma = "TShape";
				}
				else if(numForma == 5)
				{
					forma = "SquareShape";
				}
				else if(numForma == 6)
				{
					forma = "LShape";
				}
				else if(numForma == 7)
				{
					forma = "MirroredLShape";
				}

				JsonObject jsonB = new JsonObject();
				jsonB.addProperty("nombreForma", forma);
				jsonBloques.add(jsonB);
			}

			jsonA.add(jsonBloques);

			return jsonA;
		}
		else
		{
			return null;
		}
		
	}

	public void cambiarColorFondo(String pColor, String pUsuario) {
		Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(pUsuario);
		Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		laPersonalizacion.setColorFondo(pColor);
	}

	public void cambiarColorLadrillo(String pColor, String pUsuario) {
		Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(pUsuario);
		Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		laPersonalizacion.setColorBloques(pColor);
	}

	public void cambiarSonido(String pSonido, String pUsuario) {
		Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(pUsuario);
		Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		laPersonalizacion.setSonido(pSonido);
	}

	public Color getColorFondo(String pUsuario) {
		Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(pUsuario);
		Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		String color = laPersonalizacion.getColorFondo();
		if(color=="Blanco"){
			return new Color(255, 255, 255);
		}
		else if(color=="Negro"){
			return new Color(0, 0, 0);
		}
		else if (color=="Azul"){
			return new Color(0, 128, 255);
		}
		else if (color=="Verde"){
			return new Color(102, 204, 102);
		}
		else{
			return new Color(255, 141, 0);
		}
	}

	public Color[] getColorBloques(String pUsuario) {
		Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(pUsuario);
		Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		String color = laPersonalizacion.getColorBloques();
		if (color=="Default") {
			Color colors[] = {new Color(0, 0, 0), new Color(204, 102, 102),
					new Color(102, 204, 102), new Color(102, 102, 204),
					new Color(204, 204, 102), new Color(204, 102, 204),
					new Color(102, 204, 204), new Color(218, 170, 0)
			};
			return colors;
		}
		else if (color=="Retro"){
			Color colors[] = {new Color(229, 210, 141), new Color(77, 72, 69),
					new Color(255, 135, 0), new Color(0, 0, 0),
					new Color(77, 65, 4), new Color(73, 70, 70),
					new Color(73, 39, 24), new Color(0, 0, 0)
			};
			return colors;
		}
		else if (color == "Modern") {
			Color colors[] = {new Color(229, 210, 141), new Color(229, 210, 141),
					new Color(229, 210, 141), new Color(229, 210, 141),
					new Color(229, 210, 141), new Color(229, 210, 141),
					new Color(229, 210, 141), new Color(229, 210, 141)
			};
			return colors;
		}
		else{
			Color colors[] = {new Color(0, 205, 255), new Color(0, 255, 77),
					new Color(165, 156, 215), new Color(102, 102, 204),
					new Color(171, 104, 222), new Color(204, 102, 204),
					new Color(0, 180, 255), new Color(160, 229, 141)
			};
			return colors;
		}
	}

	public String getSonido(String pUsuario){
		Jugador elJugador = ListaJugadores.getMiListaJugadores().buscarJugador(pUsuario);
		Personalizacion laPersonalizacion = ListaJugadores.getMiListaJugadores().getPersonalizacion(elJugador);
		String color = laPersonalizacion.getSonido();
		return color + ".wav";

	}

	///////  Iniciar Sesión ////////////////////////////////
	public String inicioSesion(String inputNombre,String inputpassword){
		int i=0;
		boolean enc=false;
		while (!enc&& i<ListaJugadores.getMiListaJugadores().getNumeroDeJugadores()){

			if (ListaJugadores.getMiListaJugadores().buscarJugador(inputNombre) != null){
				Jugador jugador = ListaJugadores.getMiListaJugadores().buscarJugador(inputNombre);
				if(jugador.getPassword().equals(inputpassword)){
					if(inputNombre.equals("admin")){
						MenuAdmin.getMiMenuAdmin().setVisible(true);
					}
					else{
						MenuPrincipal.getMiMenuPrincipal(inputNombre).setVisible(true);
						//MenuPrincipal menuPrincipal = new MenuPrincipal(inputNombre);
						//menuPrincipal.setVisible(true);
						nombreJugador=inputNombre;
					}
					MenuIdentificacion.getMiMenuIdentificacion().setVisible(false);

					enc=true;
				}
			}
			
			i=i+1;


		} 
		if (enc==false){
			JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error Inicio de Sesión", JOptionPane.WARNING_MESSAGE);
			IniciarSesion.getMiInicioSesion().setVisible(true);
			inputNombre="error";
		} 

		return inputNombre;

	}
	///////  Registrar Jugador ////////////////////////////////

	public String registrarJugador(String inputCorreoR, String inputNombreR, String inputPassR){


		if (inputCorreoR.equals("") || inputNombreR.equals("")|| inputPassR.equals("")){

			JOptionPane.showMessageDialog(null, "Debe rellenar todos los campos", "Error al registrar el usuario", JOptionPane.WARNING_MESSAGE);
			Registro.getMiRegistro().setVisible(true);
			inputNombreR="error"; 
		}
		else{
			Jugador j = new Jugador(inputNombreR, inputCorreoR, inputPassR);
			ListaJugadores.getMiListaJugadores().anadirJugador(j);
			//MenuPrincipal menuPrincipal = new MenuPrincipal(inputNombreR);
			//menuPrincipal.setVisible(true);		
			MenuIdentificacion.getMiMenuIdentificacion().setVisible(true);
			System.out.println(ListaJugadores.getMiListaJugadores().getNumeroDeJugadores());
		}
		return inputNombreR;
		
	}

		///////  Recuperar Password ////////////////////////////////

		public String recuperarPassword(String inputCorreo, String inputNombre){
			String rdo="error";
			int i=0;
			boolean enc=false;
			while (!enc&& i<ListaJugadores.getMiListaJugadores().getNumeroDeJugadores()){
				if (ListaJugadores.getMiListaJugadores().buscarJugador(inputNombre) != null){
					Jugador jugador = ListaJugadores.getMiListaJugadores().buscarJugador(inputNombre);
					if(jugador.getCorreo().equals(inputCorreo)){
						enc=true;
						String miPasswordjugador = jugador.getContrasena();
						RecuperarPassword.getMiRecuperarPassword().setVisible(false);
						MenuIdentificacion.getMiMenuIdentificacion().setVisible(true);
						enviarCorreo.enviarCorreo(inputCorreo, "Contraseña de la cuenta", "Su contraseña es: " + miPasswordjugador);
						System.out.println("Gmail enviado correctamente a el correo: " + inputCorreo);
						rdo="correcto";
		
					}
				}	
				i=i+1;
			} 
			if (enc==false){
				JOptionPane.showMessageDialog(null, "Usuario o Correo incorrectos", "Error al recuperar la contraseña", JOptionPane.WARNING_MESSAGE);
				RecuperarPassword.getMiRecuperarPassword().setVisible(true);
			} 	
			return rdo;
		}

	///////  Cambiar Password ////////////////////////////////

	public String cambiarPassword(String nombreUsuario, String nuevaPassword){
		String rdo="correcto";
		if (nuevaPassword.equals("")){
			JOptionPane.showMessageDialog(null, "Debe rellenar el campo mostrado", "Error al cambiar la contraseña", JOptionPane.WARNING_MESSAGE);
			rdo="error";
		}
		else{
			Jugador jugador = ListaJugadores.getMiListaJugadores().buscarJugador(nombreUsuario);
			System.out.println("La contraseña antigua era: " + jugador.getContrasena());
			jugador.cambiarPassword(nuevaPassword);
			System.out.println("La contraseña nueva es: " + jugador.getContrasena());
			JOptionPane.showMessageDialog(null, "Contraseña cambiado correctamente");
			CambiarPassword.getMicCambiarPassword().setVisible(false);
		}
		return rdo;
	}



		///////  Cerrar sesion ////////////////////////////////

		public void cerrarSesion(){
			MenuPrincipal.getMiMenuPrincipal(nombreJugador).setVisible(false);
		}

		///////  Eliminar usuario ////////////////////////////////

		public void eliminarUsuario(){
			String nombreBorrar = eliminarUsuarioAdmin.getMiEliminar().getNombreUsuario().getText();
			boolean esta = ListaJugadores.getMiListaJugadores().eliminarJugador(nombreBorrar);
			if (esta==true && !nombreBorrar.equals("admin")){
				JOptionPane.showMessageDialog(null, "Usuario eliminado correctamente");
				eliminarUsuarioAdmin.getMiEliminar().dispose();
				MenuAdmin.getMiMenuAdmin().setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(null, "Usuario no encontrado", "Error al eliminar usuario", JOptionPane.WARNING_MESSAGE);

			}
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
