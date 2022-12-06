package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controladores.ControladorMenuPrincipal;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
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
	public MenuPrincipal() {
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TETRIS");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(152, 11, 130, 25);
		contentPane.add(lblNewLabel);
		
		JButton jugar = new JButton("Jugar");
		jugar.setBounds(152, 59, 119, 23);
		contentPane.add(jugar);
		
		JButton cargarPartida = new JButton("Cargar Partida");
		cargarPartida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		cargarPartida.setBounds(152, 93, 119, 23);
		contentPane.add(cargarPartida);
		cargarPartida.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());
		
		JButton elegirNivel = new JButton("Elegir Nivel");
		elegirNivel.setBounds(152, 127, 119, 23);
		contentPane.add(elegirNivel);
		elegirNivel.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());
		
		JButton personalizar = new JButton("Personalizar");
		personalizar.setBounds(152, 161, 119, 23);
		contentPane.add(personalizar);
		personalizar.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());
		
		JButton consultarRanking = new JButton("Consultar Ranking");
		consultarRanking.setBounds(152, 195, 119, 23);
		contentPane.add(consultarRanking);
		consultarRanking.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());
		
		JButton cambiarContrasena = new JButton("Cambiar Contraseña");
		cambiarContrasena.setBounds(10, 227, 130, 23);
		contentPane.add(cambiarContrasena);
		cambiarContrasena.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());
	}
}
