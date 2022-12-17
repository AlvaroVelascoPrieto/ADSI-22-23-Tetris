package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.zetcode.Conexion;

import controladores.ControladorMenuPrincipal;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private static MenuPrincipal miMenuPrincipal;
	private String usuario;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal.getMiMenuPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public MenuPrincipal(String pUsuario) {
		
		usuario = pUsuario;
		ControladorMenuPrincipal.getControladorMenuPrincipal().setUsuarioIdentificado(pUsuario);
		
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		jugar.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());
		
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


		JButton cerrarSesion = new JButton("Cerrar Sesion");
		cerrarSesion.setBounds(152, 229, 119, 23);
		contentPane.add(cerrarSesion);
		cerrarSesion.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());
		
		JButton cambiarContrasena = new JButton("Cambiar Contraseña");
		cambiarContrasena.setBounds(10, 227, 130, 23);
		contentPane.add(cambiarContrasena);
		cambiarContrasena.addActionListener(ControladorMenuPrincipal.getControladorMenuPrincipal());
		
		setVisible(true);
		
		this.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            
	        	Conexion.getMiConexion().guardarDatos();
	            System.out.println("Estoy cerrando");
	        }
	 });
		
		/* //codigo para que realice una accion al cerrar
		// |-> para utilizarlo para guardar en la base de datos los objetos 
		
		
		this.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            //Hacer lo que yo quiero
	        	//TODO llamada al metodo para volcar objetos en la bd
	            System.out.println("Estoy cerrando");
	        }
	 }); */
	}
	public static MenuPrincipal getMiMenuPrincipal(String pNombreUsuario)
    {
        if(miMenuPrincipal == null)
        {
            miMenuPrincipal = new MenuPrincipal(pNombreUsuario);
        }
        return miMenuPrincipal;
    }

}
