package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zetcode.Conexion;

import controladores.ControladorRankings;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuRankings extends JFrame {

	private JPanel menu;

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
		
		JButton persNiv = new JButton("Ranking personal por niveles");
		menu.add(persNiv);
		persNiv.addActionListener(ControladorRankings.getControladorRankings());
		
		JButton persAbs = new JButton("Ranking personal absoluto");
		menu.add(persAbs);
		persAbs.addActionListener(ControladorRankings.getControladorRankings());
		
		JButton globNiv = new JButton("Ranking global por niveles");
		menu.add(globNiv);
		globNiv.addActionListener(ControladorRankings.getControladorRankings());
		
		JButton globAbs = new JButton("Ranking global absoluto");
		menu.add(globAbs);
		globAbs.addActionListener(ControladorRankings.getControladorRankings());
		
		Conexion.getMiConexion().crearDB();
		Conexion.getMiConexion().conectar();
	}
	

}
