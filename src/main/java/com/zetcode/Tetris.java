package com.zetcode;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.zetcode.Shape.Tetrominoe;

import vistas.IntPersonalizar;

/*
Java Tetris game clone

Author: Jan Bodnar
Website: https://zetcode.com
 */
public class Tetris extends JFrame {
	
	private static final Logger logger = LogManager.getLogger(Tetris.class);
    private JLabel statusbar;
    private String usuario;
    private Board partida;
    


    public Tetris(String pUsuario) {
        usuario=pUsuario;
        initUI();
        this.addWindowListener(new WindowAdapter() {
	        @Override
	        public void windowClosing(WindowEvent e) {
	            
	        	partida.pause();
	            System.out.println("Partida cerrada");
	        }
	 });
    }
    
    public Tetris(String pUsuario,boolean cargar)
    {
    	usuario = pUsuario;
    	JsonArray jsonA = Juego.getMiJuego().cargarPartida(usuario);
    	if(jsonA != null)
    	{
    		initUI(jsonA);
        	this.addWindowListener(new WindowAdapter() {
    	        @Override
    	        public void windowClosing(WindowEvent e) {
    	            
    	        	partida.pause();
    	            System.out.println("Partida cerrada");
    	        }
    	 });
    	}
    	else
    	{
    		JOptionPane.showMessageDialog(null, "No hay una partida guardada", "Error", JOptionPane.WARNING_MESSAGE);
    	}
    }

    private void initUI() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);
        System.out.println(usuario);
        var board = new Board(this, usuario);
        add(board);
        board.start();
        board.setBackground(Juego.getMiJuego().getColorFondo(usuario));
        setTitle("Tetris");
        setSize(200, 400);
        this.partida = board;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    private void initUI(JsonArray jsonA)
    {
    	statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this, usuario);
        //establecemos los datos básicos de la partida
        JsonObject json1 = jsonA.get(0).getAsJsonObject();
        board.setDatosBasicos(json1.get("Anchura").getAsInt(), json1.get("Altura").getAsInt(), json1.get("Puntuacion").getAsInt(), json1.get("Nivel").getAsInt());
        add(board);
        //cargamos finalmente los bloques de la partida
        JsonArray jsonBloques = jsonA.get(1).getAsJsonArray();
        Tetrominoe[] listaBloques = new Tetrominoe[json1.get("Anchura").getAsInt() * json1.get("Altura").getAsInt()];
        for(int i = 0; i < jsonBloques.size(); i++)
        {
        	JsonObject jsonB = jsonBloques.get(i).getAsJsonObject();
        	String nombreForma = jsonB.get("nombreForma").getAsString();
        	switch(nombreForma)
        	{
        	case "NoShape":
        		listaBloques[i] = Tetrominoe.NoShape;
        		break;
        	case "ZShape":
        		listaBloques[i] = Tetrominoe.ZShape;
        		break;
        	case "SShape":
        		listaBloques[i] = Tetrominoe.SShape;
        		break;
        	case "LineShape":
        		listaBloques[i] = Tetrominoe.LineShape;
        		break;
        	case "TShape":
        		listaBloques[i] = Tetrominoe.TShape;
        		break;
        	case "SquareShape":
        		listaBloques[i] = Tetrominoe.SquareShape;
        		break;
        	case "LShape":
        		listaBloques[i] = Tetrominoe.LShape;
        		break;
        	case "MirroredLShape":
        		listaBloques[i] = Tetrominoe.MirroredLShape;
        		break;
        	default:
        		listaBloques[i] = Tetrominoe.NoShape;
        	}
        }
        board.start(listaBloques);
        board.setBackground(Juego.getMiJuego().getColorFondo(usuario));

        setTitle("Tetris");
        setSize(200, 400);
        this.partida = board;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    JLabel getStatusBar() {

        return statusbar;
    }
    
    public Board getPartida()
    {
    	return this.partida;
    }

    
}