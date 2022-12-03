package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuRankings extends JFrame {

	private JPanel menu;
	private Controler controler = null;
	private JButton persNiv;
	private JButton persAbs;
	private JButton globNiv;
	private JButton globAbs;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuRankings frame = new MenuRankings();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuRankings() {
		setTitle("Rankings");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		menu = new JPanel();
		menu.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(menu);
		menu.setLayout(new GridLayout(5, 1, 0, 0));
		
		JLabel tit = new JLabel("Elige el ranking que deseas consultar");
		tit.setHorizontalAlignment(SwingConstants.CENTER);
		menu.add(tit);
		
		persNiv = new JButton("Ranking personal por niveles");
		menu.add(persNiv);
		persNiv.addActionListener(getControler());
		
		persAbs = new JButton("Ranking personal absoluto");
		menu.add(persAbs);
		persAbs.addActionListener(getControler());
		
		globNiv = new JButton("Ranking global por niveles");
		menu.add(globNiv);
		globNiv.addActionListener(getControler());
		
		globAbs = new JButton("Ranking global absoluto");
		menu.add(globAbs);
		globAbs.addActionListener(getControler());
	}
	
	private Controler getControler() {
		if (controler == null) {
			controler = new Controler();
		}
		return controler;
	}
	
	private class Controler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if (e.getSource().equals(persNiv)) { //abrir el ranking personal por niveles
				RankPersNiv rPersNiv = new RankPersNiv();
				rPersNiv.setVisible(true);
			}
			if (e.getSource().equals(persAbs)) { // abrir el ranking personal absoluto
				RankPersAbs rPersAbs = new RankPersAbs();
				rPersAbs.setVisible(true);
			}
			if (e.getSource().equals(globNiv)) { // abrir el ranking global por niveles
				RankGlobNiv rGlobNiv = new RankGlobNiv();
				rGlobNiv.setVisible(true);
			}
			if (e.getSource().equals(globAbs)) { // abrir el ranking global absoluto
				RankGlobAbs rGlobAbs  = new RankGlobAbs();
				rGlobAbs.setVisible(true);
			}
			
		}
		
	}

}
