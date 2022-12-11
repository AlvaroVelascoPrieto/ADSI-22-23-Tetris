package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTable;

public class RankPersAbs extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankPersAbs frame = new RankPersAbs();
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
	public RankPersAbs() {
		setTitle("Ranking personal absoluto");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		/*JPanel texto = new JPanel();
		contentPane.add(texto);
		texto.setLayout(new GridLayout(1, 0, 0, 0));*/
		
		/*JLabel texto1 = new JLabel("Puntuaciones");
		texto.add(texto1);
		
		JLabel texto2 = new JLabel("Nivel");
		texto.add(texto2);*/
		
		JScrollPane puntuaciones = new JScrollPane();
		contentPane.add(puntuaciones);
		//puntuaciones.setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Puntuacion");
		model.addColumn("Nivel");
		puntuaciones.setViewportView(table);
		
	}
	public void mostrarRanking(JsonArray datos) {
		//borrar los datos que hubiese anteriormente
				model.setRowCount(0);
		//datos --> json array con nombre puntuacion y nivel
		
		for (JsonElement partida : datos) {
			JsonObject datosPartida = partida.getAsJsonObject();
			Object[] fila =new Object[2];
			fila[0] = datosPartida.get("Puntuacion").getAsInt();
			fila[1] = datosPartida.get("Nivel").getAsInt();
			model.addRow(fila);
		}
			
		
			
		
		
		/*
		 datos = datos.substring(1, datos.length()-1); //para quitar los corchetes
		String[] partidas = datos.split(","); //guardar las partidas separadas
		String[] datosPartida;
		for (String partida : partidas) {
			partida = partida.substring(1, partida.length()-1); //para quitar las llaves
			datosPartida = partida.split(","); // separar nombre puntuacion y nivel
			Object[] fila =new Object[2];
			fila[0] = datosPartida[1];
			fila[1] = datosPartida[2];
			model.addRow(fila);
		 */
		
		
	}

}
