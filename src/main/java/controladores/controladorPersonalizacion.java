package controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;


public class controladorPersonalizacion implements ActionListener {
	private controladorPersonalizacion miControladorPersonalizacion;
	private ArrayList<JButton> botonesAplicar;
	private ArrayList<> cuadrosTexto;

	private controladorPersonalizacion() {
		botonesAplicar = new ArrayList<JButton>();
		cuadrosTexto = new ArrayList<JButton>();
	}

	public static controladorPersonalizacion getMiControlador() {
		if (miControladorPersonalizacion==null) {
			miControladorPersonalizacion = new controladorPersonalizacion();
		}
		return miControladorPersonalizacion;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public anadirBotonAplicar(JButton pBoton) {
		this.botonesAplicar.add(pBoton);
	}
	
	public anadirCuadroTexto() {
		
	}

}
