package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class controladorPersonalizacion implements ActionListener {
	private static controladorPersonalizacion miControladorPersonalizacion;
	private ArrayList<JButton> botonesAplicar;
	private ArrayList<JComboBox> cuadrosTexto;

	private controladorPersonalizacion() {
		botonesAplicar = new ArrayList<JButton>();
		cuadrosTexto = new ArrayList<JComboBox>();
	}

	public static controladorPersonalizacion getMiControlador() {
		if (miControladorPersonalizacion==null) {
			miControladorPersonalizacion = new controladorPersonalizacion();
		}
		return miControladorPersonalizacion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(botonesAplicar.get(0))) {
			//Aplicar fondo
		}
		else if (e.getSource().equals(botonesAplicar.get(1))) {
			//Aplicar bloques
		}
		else if (e.getSource().equals(botonesAplicar.get(2))) {
			//Aplicar sonido
		}
		else if (e.getSource().equals(cuadrosTexto.get(0))) {
			//Actualizar seleccion fondo
		}
		else if (e.getSource().equals(cuadrosTexto.get(1))) {
			//Actualizar seleccion bloque
		}
		else if (e.getSource().equals(cuadrosTexto.get(2))){
			//Actualizar seleccion sonido
		}
		else {
			//Salir
		}
	}
	
	public void anadirBotonAplicar(JButton pBoton) {
		this.botonesAplicar.add(pBoton);
	}
	
	public void anadirCuadroTexto(JComboBox pOpciones) {
		this.cuadrosTexto.add(pOpciones);
	}

}
