package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zetcode.Board;
import com.zetcode.Conexion;
import com.zetcode.Jugador;
import com.zetcode.ListaJugadores;

import controladores.ControladorRankings;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MenuRankings extends JFrame {
	private String usuario;
	private JPanel menu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuRankings frame = new MenuRankings(null);
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
	public MenuRankings(String pUsuario) {
		/////////////////////////anadir jugadores y partidas para comprobar que funciona bien//////////////
		/*Jugador j1 = new Jugador("Juan", "correo", "contraseña");
		Jugador j2 = new Jugador("juana", "correo", "contraseña");
		Jugador j3 = new Jugador("paco", "correo", "contraseña");
		
		j1.anadirPartidaAcabada(new Board(1, 1, 1, 1, 0));
		j1.anadirPartidaAcabada(new Board(1, 1, 1, 2, 0));
		j1.anadirPartidaAcabada(new Board(1, 1, 1, 1, 1));
		
		j2.anadirPartidaAcabada(new Board(1, 1, 1, 1, 2));
		
		j3.anadirPartidaAcabada(new Board(1, 1, 1, 2, 2));
		
		ListaJugadores.getMiListaJugadores().anadirJugador(j1);
		ListaJugadores.getMiListaJugadores().anadirJugador(j2);
		ListaJugadores.getMiListaJugadores().anadirJugador(j3);
		
		*/
		//////////////////////////////////////////////////////////////////////////////////////////////////////
		
		usuario = pUsuario;
		ControladorRankings.getControladorRankings().setUsuarioIdentificado(pUsuario);
		
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
		Conexion.getMiConexion().cargarJugadores();
		System.out.println("jugadores cargados");
		System.out.println(usuario);
		//Conexion.getMiConexion().conectar();
	}
	

}
