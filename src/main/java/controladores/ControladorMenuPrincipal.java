package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.zetcode.Juego;
import com.zetcode.Tetris;

import vistas.CambiarPassword;
import vistas.IntPersonalizar;
import vistas.MenuAdmin;
import vistas.MenuIdentificacion;
import vistas.MenuRankings;
import vistas.Sonido;

public class ControladorMenuPrincipal implements ActionListener{

private static ControladorMenuPrincipal miControladorMenuPrincipal = null;
private String usuario;
	
	
	
	private ControladorMenuPrincipal() {
		
	}
	
	public static ControladorMenuPrincipal getControladorMenuPrincipal() {
		if (miControladorMenuPrincipal == null) {
			miControladorMenuPrincipal = new ControladorMenuPrincipal();
		}
		return ControladorMenuPrincipal.miControladorMenuPrincipal;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		// botones menu principal rankings
		if (e.getActionCommand().equals("Jugar")) { // comenzar una partida
			Sonido.getMiSonido().reproducirSondoEnLoop("/audios/" + Juego.getMiJuego().getSonido(usuario));
			Tetris partidaNueva = new Tetris(usuario);
			partidaNueva.setVisible(true);
		}
		if (e.getActionCommand().equals("Cargar Partida")) { // cargar partida guardada
			Tetris partidaCargada = new Tetris(usuario,true);
			partidaCargada.setVisible(true);
		}
		if (e.getActionCommand().equals("Elegir Nivel")) { // abrir elegir nivel

		}
		if (e.getActionCommand().equals("Personalizar")) { // abrir la personalización de partidas
			IntPersonalizar.getMiIntPersonalizar(usuario).setVisible(true);
		}
		if (e.getActionCommand().equals("Consultar Ranking")) { // abrir el consultor de rankings
			MenuRankings menuRank = new MenuRankings(usuario);
			menuRank.setVisible(true);
		}
		if (e.getActionCommand().equals("Cambiar Contraseña")) { // abrir vista cambiar contraseña		
			CambiarPassword.getMicCambiarPassword().setVisible(true);;
		}
		if (e.getActionCommand().equals("Cambiar")) { // pulsa cambiar contraseña	
			String nuevaPassword =CambiarPassword.getMicCambiarPassword().getNuevaPassword().getText();	
			Juego.getMiJuego().cambiarPassword(usuario,nuevaPassword);
		}

		if (e.getActionCommand().equals("Atras")) { // Atras en cambiar contraseña
			CambiarPassword.getMicCambiarPassword().setVisible(false);;

		}
		if (e.getActionCommand().equals("Cerrar Sesion")) { // cerrar sesion

			//MenuPrincipal.getMiMenuPrincipal().dispose();
			Juego.getMiJuego().cerrarSesion();
			MenuIdentificacion.getMiMenuIdentificacion().setVisible(true);
			MenuAdmin.getMiMenuAdmin().dispose();

		}
	}
	
	public void setUsuarioIdentificado(String pUsu) {
		this.usuario = pUsu;
	}
}
