package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import com.zetcode.ListaJugadores;

import controladores.ControladorNiveles;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElegirNivel extends JFrame{
	private String usuario = null;

	private static ElegirNivel miElegirNivel;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ElegirNivel window = new ElegirNivel();
//					window.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public ElegirNivel(String pUsuario) {
		usuario = pUsuario;
		ControladorNiveles.getControladorNiveles().setUsuarioIdentificado(usuario);
		ControladorNiveles.getControladorNiveles().setVista(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setResizable(false);
		setTitle("Nivel");
		setBounds(100, 100, 450, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Selecciona un nivel de dificultad:");
		lblNewLabel.setBounds(36, 40, 166, 14);
		getContentPane().add(lblNewLabel);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Facil");
		rdbtnNewRadioButton.setBounds(36, 77, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		if(ListaJugadores.getMiListaJugadores().buscarJugador(usuario).getDificultad()==0)
			rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.addActionListener(ControladorNiveles.getControladorNiveles());
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Medio");
		rdbtnNewRadioButton_1.setBounds(36, 103, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		if(ListaJugadores.getMiListaJugadores().buscarJugador(usuario).getDificultad()==1)
			rdbtnNewRadioButton_1.setSelected(true);
		rdbtnNewRadioButton_1.addActionListener(ControladorNiveles.getControladorNiveles());
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Dificil");
		rdbtnNewRadioButton_2.setBounds(36, 129, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_2);
		if(ListaJugadores.getMiListaJugadores().buscarJugador(usuario).getDificultad()==2)
			rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.addActionListener(ControladorNiveles.getControladorNiveles());
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(rdbtnNewRadioButton);
		grupo.add(rdbtnNewRadioButton_1);
		grupo.add(rdbtnNewRadioButton_2);
		
		JButton btnNewButton = new JButton("Guardar");
		btnNewButton.setBounds(36, 203, 89, 23);
		getContentPane().add(btnNewButton);
		btnNewButton.addActionListener(ControladorNiveles.getControladorNiveles());
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.setBounds(299, 203, 89, 23);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(ControladorNiveles.getControladorNiveles());
		
		setVisible(true);
	}

}
