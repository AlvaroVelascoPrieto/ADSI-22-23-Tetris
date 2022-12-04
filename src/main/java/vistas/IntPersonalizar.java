package vistas;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controladores.controladorPersonalizacion;
import packModelo.GestorJuego;

public class IntPersonalizar extends JFrame implements Observer {
	private JPanel contentPanel;
	private JButton aplicarFondo;
	private JButton aplicarBloque;
	private JButton aplicarSonido;
	private JComboBox opcionesFondo;
	private JComboBox opcionesBloque;
	private JComboBox opcionesSonido;

	public InterfazJuego() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		inicializar();
		setVisible(true);
		controladorPersonalizacion.getMiControlador().addObserver(this);
	}
	
	public void inicializar(){
		setSize(1080,1080);
		contentPanel = new JPanel();
		contentPanel.setLayout(new GridLayout(4,2,0,0));
		aplicarFondo = new JButton("Aplicar");
		aplicarBloque = new JButton("Aplicar");
		aplicarSonido = new JButton("Aplicar");
		opcionesFondo = new JComboBox();
		
	}
	
	
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}


}
