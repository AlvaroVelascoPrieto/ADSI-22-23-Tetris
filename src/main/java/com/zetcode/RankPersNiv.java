package com.zetcode;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class RankPersNiv extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankPersNiv frame = new RankPersNiv();
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
	public RankPersNiv() {
		setTitle("Ranking personal por niveles");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel text1 = new JLabel("Elige el nivel");
		contentPane.add(text1);
		
		JLabel text2 = new JLabel("Puntuaciones");
		text2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(text2);
		
		JPanel botones = new JPanel();
		contentPane.add(botones);
		botones.setLayout(new GridLayout(3, 1, 0, 0));
		
		JRadioButton facil = new JRadioButton("Nivel facil");
		buttonGroup.add(facil);
		botones.add(facil);
		
		JRadioButton medio = new JRadioButton("Nivel medio");
		buttonGroup.add(medio);
		botones.add(medio);
		
		JRadioButton dificil = new JRadioButton("Nivel dificil");
		buttonGroup.add(dificil);
		botones.add(dificil);
		
		JPanel puntuaciones = new JPanel();
		contentPane.add(puntuaciones);
	}

}
