package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import controladores.ControladorRankings;

import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ButtonGroup;

public class RankGlobNiv extends JFrame {
	private DefaultTableModel model;
	private JTable table;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankGlobNiv frame = new RankGlobNiv();
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
	public RankGlobNiv() {
		setTitle("Ranking global por niveles");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel text1 = new JLabel("Elige el nivel");
		contentPane.add(text1);
		
		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JRadioButton facil = new JRadioButton("Nivel facil");
		buttonGroup.add(facil);
		panel.add(facil);
		facil.addActionListener(ControladorRankings.getControladorRankings());
		facil.setActionCommand("FacilGlob");
		
		JRadioButton medio = new JRadioButton("Nivel medio");
		buttonGroup.add(medio);
		panel.add(medio);
		medio.addActionListener(ControladorRankings.getControladorRankings());
		medio.setActionCommand("MedioGlob");
		
		JRadioButton dificil = new JRadioButton("Nivel dificil");
		buttonGroup.add(dificil);
		panel.add(dificil);
		dificil.addActionListener(ControladorRankings.getControladorRankings());
		dificil.setActionCommand("DificilGlob");
		
		JScrollPane puntuaciones = new JScrollPane();
		contentPane.add(puntuaciones);
		//puntuaciones.setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		model.addColumn("Jugador");
		model.addColumn("Puntuacion");
		//model.addColumn("Nivel");
		puntuaciones.setViewportView(table);
	}
	
	public void mostrarRanking(JsonArray datos) {
		//borrar los datos que hubiese anteriormente
		model.setRowCount(0);
		// puntuacion jugador y nivel
		for (JsonElement partida : datos) {
			JsonObject datosPartida = partida.getAsJsonObject();
			Object[] fila =new Object[2];
			fila[0] = datosPartida.get("Nombre").getAsString();
			fila[1] = datosPartida.get("Puntuacion").getAsInt();
			//fila[2] = datosPartida.get("Nivel").getAsInt();
			model.addRow(fila);
		}
	}
}
