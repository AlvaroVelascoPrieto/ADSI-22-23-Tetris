package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class RankPersAbs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankPersAbs frame = new RankPersAbs();
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
	public RankPersAbs() {
		setTitle("Ranking personal absoluto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel texto = new JPanel();
		contentPane.add(texto);
		texto.setLayout(new GridLayout(1, 0, 0, 0));
		
		JLabel texto1 = new JLabel("Puntuaciones");
		texto.add(texto1);
		
		JLabel texto2 = new JLabel("Nivel");
		texto.add(texto2);
		
		JPanel puntuaciones = new JPanel();
		contentPane.add(puntuaciones);
		puntuaciones.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
