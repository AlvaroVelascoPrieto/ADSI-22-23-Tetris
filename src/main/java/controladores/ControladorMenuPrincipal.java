package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.zetcode.Tetris;

import vistas.IntPersonalizar;
import vistas.MenuPrincipal;
import vistas.MenuRankings;

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
			Tetris partidaNueva = new Tetris(usuario);
			partidaNueva.setVisible(true);
		}
		if (e.getActionCommand().equals("Cargar Partida")) { // cargar partida guardada
			Tetris partidaCargada = new Tetris(usuario);
			partidaCargada.setVisible(true);
		}
		if (e.getActionCommand().equals("Elegir Nivel")) { // abrir elegir nivel

		}
		if (e.getActionCommand().equals("Personalizar")) { // abrir la personalización de partidas
			IntPersonalizar menuPers = new IntPersonalizar(usuario);
			menuPers.setVisible(true);
		}
		if (e.getActionCommand().equals("Consultar Ranking")) { // abrir el consultor de rankings
			MenuRankings menuRank = new MenuRankings(usuario);
			menuRank.setVisible(true);
		}
		if (e.getActionCommand().equals("Cambiar Contraseña")) { // cambiar contraseña

		}
	}
	
	public void setUsuarioIdentificado(String pUsu) {
		this.usuario = pUsu;
	}
}
