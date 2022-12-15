package controladores;

import com.zetcode.Juego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;


public class controladorPersonalizacion implements ActionListener {
	private static controladorPersonalizacion miControladorPersonalizacion;
	private ArrayList<JButton> botonesAplicar;
	private ArrayList<JComboBox> cuadrosTexto;
	private String usuario;

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
			Juego.getMiJuego().cambiarColorFondo(cuadrosTexto.get(0).getSelectedItem().toString(),usuario);

		}
		else if (e.getSource().equals(botonesAplicar.get(1))) {
			Juego.getMiJuego().cambiarColorLadrillo(cuadrosTexto.get(1).getSelectedItem().toString(),usuario);
		}
		else if (e.getSource().equals(botonesAplicar.get(2))) {
			//Aplicar sonido
			Juego.getMiJuego().cambiarSonido(cuadrosTexto.get(2).getSelectedItem().toString(),usuario);
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

	public void setUsuarioIdentificado(String pUsuario){this.usuario=pUsuario;}

}
