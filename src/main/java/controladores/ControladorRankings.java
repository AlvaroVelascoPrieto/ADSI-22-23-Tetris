package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.google.gson.JsonArray;
import com.zetcode.Juego;

import vistas.RankGlobAbs;
import vistas.RankGlobNiv;
import vistas.RankPersAbs;
import vistas.RankPersNiv;


public class ControladorRankings implements ActionListener{
	private static ControladorRankings miControladorPersonalizacion = null;
	private RankPersNiv rPersNiv;
	private RankPersAbs rPersAbs;
	private RankGlobNiv rGlobNiv;
	private RankGlobAbs rGlobAbs;
	private ControladorRankings() {
		
	}
	
	public static ControladorRankings getControladorRankings() {
		if (ControladorRankings.miControladorPersonalizacion == null) {
			ControladorRankings.miControladorPersonalizacion = new ControladorRankings();
		}
		return ControladorRankings.miControladorPersonalizacion;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		// botones menu principal rankings
		if (e.getActionCommand().equals("Ranking personal por niveles")) { //abrir el ranking personal por niveles
			JsonArray datos = Juego.getMiJuego().obtRankPersNiv(null, 0);//por defecto abrir el nivel facil
			rPersNiv = new RankPersNiv();
			rPersNiv.setVisible(true);
			
		}
		if (e.getActionCommand().equals("Ranking personal absoluto")) { // abrir el ranking personal absoluto
			JsonArray datos = Juego.getMiJuego().obtRankAbsPers(null);
			rPersAbs = new RankPersAbs();
			rPersAbs.mostrarRanking(datos);
			rPersAbs.setVisible(true);
		}
		if (e.getActionCommand().equals("Ranking global por niveles")) { // abrir el ranking global por niveles
			JsonArray datos = Juego.getMiJuego().obtRankNiv(0);// por defecto abrir el nivel favil
			rGlobNiv = new RankGlobNiv();
			rGlobNiv.mostrarRanking(datos);
			rGlobNiv.setVisible(true);
		}
		if (e.getActionCommand().equals("Ranking global absoluto")) { // abrir el ranking global absoluto
			JsonArray datos = Juego.getMiJuego().obtRankAbs();
			rGlobAbs  = new RankGlobAbs();
			rGlobAbs.mostrarRanking(datos);
			rGlobAbs.setVisible(true);
		}
		
		//botones para elegir dificultad
		if (e.getActionCommand().equals("FacilGlob")) {
			JsonArray datos = Juego.getMiJuego().obtRankNiv(0);
			rGlobNiv.mostrarRanking(datos);
		}
		if (e.getActionCommand().equals("MedioGlob")) {
			JsonArray datos = Juego.getMiJuego().obtRankNiv(1);
			rGlobNiv.mostrarRanking(datos);
		}
		if (e.getActionCommand().equals("DificilGlob")) {
			JsonArray datos = Juego.getMiJuego().obtRankNiv(2);
			rGlobNiv.mostrarRanking(datos);
		}
		if (e.getActionCommand().equals("FacilPers")) {
			JsonArray datos = Juego.getMiJuego().obtRankPersNiv(null, 0);
			rPersNiv.mostrarRanking(datos);
		}
		if (e.getActionCommand().equals("MedioPers")) {
			JsonArray datos = Juego.getMiJuego().obtRankPersNiv(null, 1);
			rPersNiv.mostrarRanking(datos);
		}
		if (e.getActionCommand().equals("DificilPers")) {
			JsonArray datos = Juego.getMiJuego().obtRankPersNiv(null, 2);
			rPersNiv.mostrarRanking(datos);
		}
	}
		
	
}
