package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistas.MenuPrincipal;
import vistas.RankGlobAbs;
import vistas.RankGlobNiv;
import vistas.RankPersAbs;
import vistas.RankPersNiv;

public class ControladorMenuPrincipal implements ActionListener{

private static ControladorMenuPrincipal miControladorMenuPrincipal = null;
	
	
	
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

		}
		if (e.getActionCommand().equals("Cargar Partida")) { // cargar partida guardada

		}
		if (e.getActionCommand().equals("Elegir Nivel")) { // abrir elegir nivel

		}
		if (e.getActionCommand().equals("Personalizar")) { // abrir la personalización de partidas

		}
		if (e.getActionCommand().equals("Consultar Ranking")) { // abrir el consultor de rankings

		}
		if (e.getActionCommand().equals("Cambiar Contraseña")) { // cambiar contraseña

		}
	}
}
