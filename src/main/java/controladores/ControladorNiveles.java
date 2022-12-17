package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.zetcode.Juego;

import vistas.ElegirNivel;
import vistas.IntPersonalizar;

public class ControladorNiveles implements ActionListener{
	private static ControladorNiveles miControladorNiveles = null;
	private String usuario;
	private int nivel;
	private ElegirNivel interfaz;
	private int dif=0;
	
	private ControladorNiveles() {
		
	}
	
	public static ControladorNiveles getControladorNiveles() {
		if (miControladorNiveles == null) {
			miControladorNiveles = new ControladorNiveles();
		}
		return ControladorNiveles.miControladorNiveles;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		// botones menu niveles
		if (e.getActionCommand().equals("Facil")) { // dificultad fácil
			dif = 0;
		}
		if (e.getActionCommand().equals("Medio")) { // dificultad medio
			dif = 1;
		}
		if (e.getActionCommand().equals("Dificil")) { // dificultad dificil
			dif = 2;
		}
		if (e.getActionCommand().equals("Guardar")) { // guardar cambios
				Juego.getMiJuego().cambiarNivel(dif,usuario);
				interfaz.setVisible(false);
		}
		if (e.getActionCommand().equals("Cancelar")) { // descartar cambios
			interfaz.setVisible(false);
		}
	}
	
	public void setUsuarioIdentificado(String pUsuario) {usuario=pUsuario;}
	
	public void setVista(ElegirNivel pInterfaz){
		interfaz=pInterfaz;
	}

}
