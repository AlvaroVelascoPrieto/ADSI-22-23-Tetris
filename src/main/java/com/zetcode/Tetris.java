package com.zetcode;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

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
    
    public Tetris() {
        initUI();
    }
    
    public Tetris(String usuario)
    {
    	JsonArray jsonA = Juego.getMiJuego().cargarPartida(usuario);
    	initUI(jsonA);
    }

    private void initUI() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();
        board.setBackground(Juego.getMiJuego().getColorFondo());
        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        
    }
    
    private void initUI(JsonArray jsonA)
    {
    	statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
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
        	case "ZShape":
        		listaBloques[i] = Tetrominoe.ZShape;
        	case "SShape":
        		listaBloques[i] = Tetrominoe.SShape;
        	case "LineShape":
        		listaBloques[i] = Tetrominoe.LineShape;
        	case "TShape":
        		listaBloques[i] = Tetrominoe.TShape;
        	case "SquareShape":
        		listaBloques[i] = Tetrominoe.SquareShape;
        	case "LShape":
        		listaBloques[i] = Tetrominoe.LShape;
        	case "MirroredLShape":
        		listaBloques[i] = Tetrominoe.MirroredLShape;
        	default:
        		listaBloques[i] = Tetrominoe.NoShape;
        	}
        }
        board.start(listaBloques);

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    JLabel getStatusBar() {

        return statusbar;
    }

    public static void main(String[] args) {

    	logger.info("Playing");
        EventQueue.invokeLater(() -> {

            var game = new Tetris();
            game.setVisible(true);
        });
    }
    
}