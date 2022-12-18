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

import java.awt.Window.Type;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;

public class RankPersNiv extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankPersNiv frame = new RankPersNiv();
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
	public RankPersNiv() {
		setTitle("Ranking personal por niveles");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel text1 = new JLabel("Elige el nivel");
		contentPane.add(text1);
		
		JPanel botones = new JPanel();
		contentPane.add(botones);
		botones.setLayout(new GridLayout(3, 1, 0, 0));
		
		JRadioButton facil = new JRadioButton("Nivel facil");
		buttonGroup.add(facil);
		botones.add(facil);
		facil.addActionListener(ControladorRankings.getControladorRankings());
		facil.setActionCommand("FacilPers");
		
		JRadioButton medio = new JRadioButton("Nivel medio");
		buttonGroup.add(medio);
		botones.add(medio);
		medio.addActionListener(ControladorRankings.getControladorRankings());
		medio.setActionCommand("MedioPers");
		
		JRadioButton dificil = new JRadioButton("Nivel dificil");
		buttonGroup.add(dificil);
		botones.add(dificil);
		dificil.addActionListener(ControladorRankings.getControladorRankings());
		dificil.setActionCommand("DificilPers");
		
		JScrollPane puntuaciones = new JScrollPane();
		contentPane.add(puntuaciones);
		//puntuaciones.setLayout(new GridLayout(1, 0, 0, 0));
		
		table = new JTable();
		model = new DefaultTableModel();
		table.setModel(model);
		//model.addColumn("Puntuacion");
		model.addColumn("Puntuaciones");
		puntuaciones.setViewportView(table);	}
	
	public void mostrarRanking(JsonArray datos) {
		//borrar los datos que hubiese anteriormente
				model.setRowCount(0);
		//datos --> json array con nombre puntuacion y nivel
		
		for (JsonElement partida : datos) {
			JsonObject datosPartida = partida.getAsJsonObject();
			Object[] fila =new Object[1];
			fila[0] = datosPartida.get("Puntuacion").getAsInt();
			//fila[1] = datosPartida.get("Nivel").getAsInt();
			model.addRow(fila);
		}
	}
	

	

}
