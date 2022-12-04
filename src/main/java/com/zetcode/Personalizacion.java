package com.zetcode;

public class Personalizacion {
	private String colorFondo;
	private String colorBloques;
	private String sonido;
	
	public Personalizacion(String pColorFondo, String pColorBloques, String pSonido) {
		colorFondo = pColorFondo;
		colorBloques = pColorBloques;
		sonido = pSonido;
	}
	
	public void setColorFondo(String pColor) {
		colorFondo = pColor;
	}
	
	public void setColorBloques(String pColor) {
		colorBloques = pColor;
	}
	
	public void setSonido(String pSonido) {
		sonido = pSonido;
	}
	
}
