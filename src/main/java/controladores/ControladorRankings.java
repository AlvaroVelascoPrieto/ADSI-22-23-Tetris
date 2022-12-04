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
		// TODO Auto-generated method stub
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
		
	}
		
	
}
