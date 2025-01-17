package vistas;

import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zetcode.Juego;

import controladores.ControladorMenuIdentificacion;
import controladores.controladorPersonalizacion;

public class IntPersonalizar extends JFrame implements Observer {
	private JPanel contentPanel;
	private JPanel panelFondo;
	private JPanel panelLadrillo;
	private JPanel panelSonido;
	private JButton aplicarFondo;
	private JButton aplicarBloque;
	private JButton aplicarSonido;
	private JComboBox opcionesFondo;
	private JComboBox opcionesBloque;
	private JComboBox opcionesSonido;
	private String[] optFondo = { "Blanco", "Negro", "Azul", "Verde", "Naranja" };
	private String[] optBloques = { "Default", "Retro", "Modern", "Cool" };
	private String[] optSonido = { "default", "animado", "PanteraRosa", "retro", "StarWars"};
	private JButton salir;
	private String usuario;
	private static IntPersonalizar miIntPersonalizar;
	
	private IntPersonalizar(String pUsuario) {
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		inicializar();
		setVisible(true);
		Juego.getMiJuego().addObserver(this);
		usuario = pUsuario;
		controladorPersonalizacion.getMiControlador().setUsuarioIdentificado(usuario);
		controladorPersonalizacion.getMiControlador().setVista(this);
	}

	public static IntPersonalizar getMiIntPersonalizar(String pUsuario){
		if (miIntPersonalizar == null) {
			miIntPersonalizar = new IntPersonalizar(pUsuario);
		}
		return miIntPersonalizar;
	}
	
	public void inicializar(){
		//Inicializar ventana,paneles y opciones
		setSize(1080,1080);
		contentPanel = new JPanel();
		setContentPane(contentPanel);
		setTitle("Hundir la flota");
		contentPanel.setLayout(new GridLayout(4,2,100,100));
		panelFondo = new JPanel();
		panelLadrillo = new JPanel();
		panelSonido = new JPanel();
		panelFondo.setLayout(new GridLayout(2,1,0,0));
		panelLadrillo.setLayout(new GridLayout(2,1,0,0));
		panelSonido.setLayout(new GridLayout(2,1,0,0));
		aplicarFondo = new JButton("Aplicar");
		aplicarBloque = new JButton("Aplicar");
		aplicarSonido = new JButton("Aplicar");
		opcionesFondo = new JComboBox(optFondo);
		opcionesBloque = new JComboBox(optBloques);
		opcionesSonido = new JComboBox(optSonido);
		salir = new JButton("Salir");
			
		//Tamano Botones
		
		
		//Anadir elementos al controlador
		controladorPersonalizacion.getMiControlador().anadirBotonAplicar(aplicarFondo);
		controladorPersonalizacion.getMiControlador().anadirBotonAplicar(aplicarBloque);
		controladorPersonalizacion.getMiControlador().anadirBotonAplicar(aplicarSonido);
		controladorPersonalizacion.getMiControlador().anadirBotonAplicar(salir);
		controladorPersonalizacion.getMiControlador().anadirCuadroTexto(opcionesFondo);
		controladorPersonalizacion.getMiControlador().anadirCuadroTexto(opcionesBloque);
		controladorPersonalizacion.getMiControlador().anadirCuadroTexto(opcionesSonido);
		aplicarFondo.addActionListener(controladorPersonalizacion.getMiControlador());
		aplicarBloque.addActionListener(controladorPersonalizacion.getMiControlador());
		aplicarSonido.addActionListener(controladorPersonalizacion.getMiControlador());
		salir.addActionListener(controladorPersonalizacion.getMiControlador());
		
		//Anadir elementos a la vista
		panelFondo.add(new JLabel("Color fondo: "));
		panelFondo.add(opcionesFondo);
		contentPanel.add(panelFondo);
		contentPanel.add(aplicarFondo);
		panelLadrillo.add(new JLabel("Color bloques: "));
		panelLadrillo.add(opcionesBloque);
		contentPanel.add(panelLadrillo);
		contentPanel.add(aplicarBloque);
		panelSonido.add(new JLabel("Sonido: "));
		panelSonido.add(opcionesSonido);
		contentPanel.add(panelSonido);
		contentPanel.add(aplicarSonido);
		contentPanel.add(salir);
		
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}
