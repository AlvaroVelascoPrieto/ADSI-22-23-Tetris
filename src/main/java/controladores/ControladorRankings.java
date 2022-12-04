package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vistas.RankGlobAbs;
import vistas.RankGlobNiv;
import vistas.RankPersAbs;
import vistas.RankPersNiv;


public class ControladorRankings implements ActionListener{
	private static ControladorRankings miControladorPersonalizacion = null;
	
	
	
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
			RankPersNiv rPersNiv = new RankPersNiv();
			rPersNiv.setVisible(true);
		}
		if (e.getActionCommand().equals("Ranking personal absoluto")) { // abrir el ranking personal absoluto
			RankPersAbs rPersAbs = new RankPersAbs();
			rPersAbs.setVisible(true);
		}
		if (e.getActionCommand().equals("Ranking global por niveles")) { // abrir el ranking global por niveles
			RankGlobNiv rGlobNiv = new RankGlobNiv();
			rGlobNiv.setVisible(true);
		}
		if (e.getActionCommand().equals("Ranking global absoluto")) { // abrir el ranking global absoluto
			RankGlobAbs rGlobAbs  = new RankGlobAbs();
			rGlobAbs.setVisible(true);
		}
		
		//botones para elegir dificultad
		if (e.getActionCommand().equals("FacilGlob")) {
			//TODO llamada a rank glob facil
		}
		if (e.getActionCommand().equals("MedioGlob")) {
			//TODO llamada a rank glob medio
		}
		if (e.getActionCommand().equals("DificilGlob")) {
			//TODO llamada a rank glob dificil
		}
		if (e.getActionCommand().equals("FacilPers")) {
			//TODO llamada a rank pers facil
		}
		if (e.getActionCommand().equals("MedioPers")) {
			//TODO llamada a rank pers medio
		}
		if (e.getActionCommand().equals("DificilPers")) {
			//TODO llamada a rank pers dificil
		}
	}
		
	
}
