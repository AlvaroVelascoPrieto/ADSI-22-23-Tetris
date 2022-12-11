package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.GridLayout;
import java.awt.ScrollPane;

import javax.swing.JLabel;

public class RankGlobAbs extends JFrame {
	private DefaultTableModel model;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankGlobAbs frame = new RankGlobAbs();
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
	public RankGlobAbs() {
		setTitle("Ranking global absoluto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JScrollPane panel = new JScrollPane();
		getContentPane().add(panel);
		//panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable(); 
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Jugador");
		model.addColumn("Puntuacion");
		model.addColumn("Nivel");
		
		panel.setViewportView(table);
	}
	
	public void mostrarRanking(JsonArray datos) {
		//borrar los datos que hubiese anteriormente
				model.setRowCount(0);
		// puntuacion jugador y nivel
		for (JsonElement partida : datos) {
			JsonObject datosPartida = partida.getAsJsonObject();
			Object[] fila =new Object[3];
			fila[0] = datosPartida.get("Nombre").getAsString();
			fila[1] = datosPartida.get("Puntuacion").getAsInt();
			fila[2] = datosPartida.get("Nivel").getAsInt();
			model.addRow(fila);
		}
	}

}
