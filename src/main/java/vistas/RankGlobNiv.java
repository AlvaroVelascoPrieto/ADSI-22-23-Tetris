package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RankGlobNiv extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankGlobNiv frame = new RankGlobNiv();
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
	public RankGlobNiv() {
		setTitle("Ranking global por niveles");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 2, 0, 0));
		
		JLabel text1 = new JLabel("Elige el nivel");
		contentPane.add(text1);
		
		JLabel text2 = new JLabel("Puntuaciones | Jugador");
		contentPane.add(text2);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton facil = new JRadioButton("Nivel facil");
		buttonGroup.add(facil);
		panel.add(facil);
		
		JRadioButton medio = new JRadioButton("Nivel medio");
		buttonGroup.add(medio);
		panel.add(medio);
		
		JRadioButton dificil = new JRadioButton("Nivel dificil");
		buttonGroup.add(dificil);
		panel.add(dificil);
		
		JPanel putuaciones = new JPanel();
		contentPane.add(putuaciones);
		putuaciones.setLayout(new GridLayout(1, 0, 0, 0));
	}

}
