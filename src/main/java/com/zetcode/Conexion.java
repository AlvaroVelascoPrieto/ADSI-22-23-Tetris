package com.zetcode;

import java.beans.Statement;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.h2.tools.RunScript;

import com.zetcode.Shape.Tetrominoe;



public class Conexion {
	
	private static Conexion miConexion;

    private Conexion() {
	
	}
    
    public static Conexion getMiConexion() {
    	if (miConexion == null) {
			miConexion = new Conexion();
		}
    	return miConexion;
    }

	public Connection conectar(){
        Connection con = null;
        try{
            Class.forName("org.h2.Driver");
            con = DriverManager.getConnection("jdbc:h2:file:./bd/BDjuego","lasWinxDeADSI","");
            System.out.println("En linea");
        }catch(Exception ex){
            System.out.println("Error "+ex);
        }
        return con;
    }
   
	public void cargarJugadores() {
	
    try (Connection con = conectar();

        PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM jugador");) {
        System.out.println(preparedStatement);
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            //int id = rs.getInt("id");
            String usuario = rs.getString("usuario");
            String correo = rs.getString("correo");
            String contrasena = rs.getString("contrasena");
            int idpersonalizacion = rs.getInt("id_personalizacion");
            String parSinFin = rs.getString("id_partidaSF");
            
            Jugador j = new Jugador(usuario, correo, contrasena);
            
            //añadir las partidas finalizadas al jugador
            
            //buscar las partidas que pertenecen al jugador
            PreparedStatement preparedStatement2 = con.prepareStatement("SELECT * FROM partida where usuario=?");
            preparedStatement2.setString(1, usuario);
            ResultSet partidas = preparedStatement2.executeQuery();
            //crear un objeto por cada partida y añadirla al jugador
            while (partidas.next()) {
                int idPartida = partidas.getInt("id_partida");
                //int anchura = partidas.getInt("anchura");
                //int altura = partidas.getInt("altura");
                int puntuacion = partidas.getInt("puntuacion");
                int nivel = partidas.getInt("nivel");
                //falta añadir los bloques de cada partida
                Board parAcabada = new Board(puntuacion, nivel);
                j.anadirPartidaAcabada(parAcabada);
            }
            
            if (parSinFin!=null) {
	            //anadir partida sin finalizar 
            	
	            PreparedStatement preparedStatement3 = con.prepareStatement("SELECT * FROM partida where id_partida=?");
	            preparedStatement3.setString(1, parSinFin);
	            ResultSet parGuardada = preparedStatement3.executeQuery();
	            parGuardada.next();
                int anchura = parGuardada.getInt("anchura");
                int altura = parGuardada.getInt("altura");
                int puntuacion = parGuardada.getInt("puntuacion");
                int nivel = parGuardada.getInt("nivel");
                Board partidaGuardada = new Board(anchura, altura, puntuacion, nivel);
                
                //añadir los bloques a la partida acabada
                //primero generara array
                PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM bloque where id_partida=?");
                preparedStatement4.setString(1, parSinFin);
                ResultSet bloques = preparedStatement4.executeQuery();
                Tetrominoe[] board = new Tetrominoe[altura * anchura];
                while (bloques.next()) {
					//sacar info de cada bloque y agregarlo a la partida
                	int coord = bloques.getInt("coordenada");
                	String forma = bloques.getString("forma");
                	switch(forma)
                	{
                	case "NoShape":
                		board[coord] = Tetrominoe.NoShape;
                	case "ZShape":
                		board[coord] = Tetrominoe.ZShape;
                	case "SShape":
                		board[coord] = Tetrominoe.SShape;
                	case "LineShape":
                		board[coord] = Tetrominoe.LineShape;
                	case "TShape":
                		board[coord] = Tetrominoe.TShape;
                	case "SquareShape":
                		board[coord] = Tetrominoe.SquareShape;
                	case "LShape":
                		board[coord] = Tetrominoe.LShape;
                	case "MirroredLShape":
                		board[coord] = Tetrominoe.MirroredLShape;
                	default:
                		board[coord] = Tetrominoe.NoShape;
                	}
				}
                partidaGuardada.anadirBloques(board);
                j.guardarPartida(partidaGuardada);
                preparedStatement3.close();
            }
            
            //añadir la personalizacion
            
            PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM personalizacion where id_personalizacion=?");
            preparedStatement4.setInt(1, idpersonalizacion);
            ResultSet personalizacion = preparedStatement4.executeQuery();
            personalizacion.next();//obtener resultado de select --> personalizacion
            String colorFondo = personalizacion.getString("colorFondo");
            String colorBloques = personalizacion.getString("colorBloques");
            String sonido = personalizacion.getString("sonido");
            Personalizacion personalizacionJ = new Personalizacion(colorFondo, colorBloques, sonido);
            j.setPersonalizacion(personalizacionJ);
            
            //añadir jugador a la lista de jugadores
            ListaJugadores.getMiListaJugadores().anadirJugador(j);
            
            preparedStatement2.close();
            
            preparedStatement4.close();
        }
        preparedStatement.close();
       
    } catch (SQLException e) {
    	System.out.println("ha habido algun error al crear los jugadores"+e);
    }
    
}
    
   /*
    private static String leerSqlFile(){
    	
    	//URL path = Conexion.class.getResource("bd.sql"); 
    	//System.out.println(path);
    	//leer el archivo sql
        String filePath = String.format("%s/%s", System.getProperty("user.dir"), "src/main/java/bd.sql");
        System.out.println(filePath);
        byte[] buffer = null;
        //System.out.println(filePath);
        File file = new File(filePath);

        buffer = new byte[(int) file.length()];
        BufferedInputStream f = null;
        try {
            f = new BufferedInputStream(new FileInputStream(filePath));
            f.read(buffer);
        } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
            if (f != null) {
                try {
					f.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        }
        return new String(buffer);
    }*/
	
	public void guardarDatos()
	{
		try (Connection con = conectar()){
			
			ArrayList<Jugador> listaJugadores = ListaJugadores.getMiListaJugadores().getLista();
			PreparedStatement preparedStatement1 = con.prepareStatement("INSERT INTO jugador VALUES (?,?,?,?,?)");
			PreparedStatement preparedStatement2 = con.prepareStatement("INSERT INTO personalizacion VALUES (?,?,?,?)");
			PreparedStatement preparedStatement3 = con.prepareStatement("INSERT INTO partida VALUES (?,?,?,?,?,?)");
			PreparedStatement preparedStatement4 = con.prepareStatement("INSERT INTO bloque VALUES (?,?,?,?)");
			PreparedStatement preparedStatement5 = con.prepareStatement("INSERT INTO partida VALUES (?,?,?,?,?,?)");
			int idBloque = 0;
			int idPartidaAcabada = 0;
			
			//por cada jugador en listajugadores
			for(int i = 0; i < listaJugadores.size(); i++)
			{
				int idPersonalizacion = i;
				int idPartidaGuardada = i;
				
				//insertamos los datos de la personalización
				String colorFondo = listaJugadores.get(i).getPersonalizacion().getColorFondo();
				String colorBloques = listaJugadores.get(i).getPersonalizacion().getColorBloques();
				String sonido = listaJugadores.get(i).getPersonalizacion().getSonido();
				
				preparedStatement2.setInt(1, idPersonalizacion);
				preparedStatement2.setString(2, colorFondo);
				preparedStatement2.setString(3, colorBloques);
				preparedStatement2.setString(4, sonido);
				preparedStatement2.execute();
				
				//insertamos los datos de la partida guardada. Si no la hay, se inventa una vacía.
				if(listaJugadores.get(i).getPartida() != null)
				{
					int anchura = listaJugadores.get(i).getPartida().getAnchura();
					int altura = listaJugadores.get(i).getPartida().getAltura();
					int puntuacion = listaJugadores.get(i).getPartida().getPuntuacion();
					int nivel = listaJugadores.get(i).getPartida().getNivel();
					
					preparedStatement3.setInt(1, idPartidaGuardada);
					preparedStatement3.setInt(2, anchura);
					preparedStatement3.setInt(3, altura);
					preparedStatement3.setInt(4, puntuacion);
					preparedStatement3.setInt(5, nivel);
					preparedStatement3.setString(6, listaJugadores.get(i).getUsuario().toString());
					preparedStatement3.execute();
					
					//por cada bloque en partida guardada
					Tetrominoe[] t = listaJugadores.get(i).getPartida().getBloques();
					for(int j = 0; j < t.length; j++)
					{
						//insertamos los datos de la partida acabada
						String forma;
						switch(t[j])
						{
						case NoShape:
							forma = "NoShape";
						case ZShape:
							forma = "ZShape";
						case SShape:
							forma = "SShape";
						case LineShape:
							forma = "LineShape";
						case TShape:
							forma = "TShape";
						case SquareShape:
							forma = "SquareShape";
						case LShape:
							forma = "LShape";
						case MirroredLShape:
							forma = "MirroredLShape";
						default:
							forma = "NoShape";
						}
						
						preparedStatement4.setInt(1, idBloque);
						preparedStatement4.setString(2, forma);
						preparedStatement4.setInt(3, j);
						preparedStatement4.setInt(4, idPartidaGuardada);
						preparedStatement4.execute();
						
						idBloque += 1;
					}
				}
				else
				{
					preparedStatement3.setInt(1, idPartidaGuardada);
					preparedStatement3.setInt(2, 10);
					preparedStatement3.setInt(3, 22);
					preparedStatement3.setInt(4, 0);
					preparedStatement3.setInt(5, 1);
					preparedStatement3.setString(6, listaJugadores.get(i).getUsuario().toString());
					preparedStatement3.execute();
				}
				
				
				//insertamos los datos del jugador
				String usuario = listaJugadores.get(i).getUsuario().toString();
				String correo = listaJugadores.get(i).getCorreo();
				String contrasena = listaJugadores.get(i).getContrasena();
				
				preparedStatement1.setString(1, usuario);
				preparedStatement1.setString(2, usuario);
				preparedStatement1.setString(3, usuario);
				preparedStatement1.setInt(4, idPersonalizacion);
				preparedStatement1.setInt(5, idPartidaGuardada);
				preparedStatement1.execute();	
				
				ArrayList<Board> listaParAcabadas = listaJugadores.get(i).getPartidasAcabadas();
				//por cada partida acabada en jugador
				for(int j = 0; j < listaParAcabadas.size(); j++)
				{
					//insertamos los datos de la partida acabada
					int puntuacion = listaParAcabadas.get(j).getPuntuacion();
					int nivel = listaParAcabadas.get(j).getNivel();
					
					preparedStatement5.setInt(1, idPartidaAcabada);
					preparedStatement5.setInt(4, puntuacion);
					preparedStatement5.setInt(5, nivel);
					preparedStatement5.setString(6, usuario);
					preparedStatement5.execute();
					
					idPartidaAcabada += 1;
				}
			}

	    } catch (SQLException e) {
	    	System.out.println("ha habido algun error al guardar los datos"+e);
	    }
	}

    public void crearDB(){
        //ejecutamos el script de creacion de la BD
        Connection con = conectar();

    	try {
			RunScript.execute(con, new FileReader("src/main/java/bd.sql"));
		} catch (FileNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("error en la creacion de la bd");
		}
    	//
       /* String createTables = "";
		createTables = leerSqlFile();
        Connection con = conectar();
        
        try{
        	java.sql.Statement statement =con.createStatement();
            statement.execute(createTables);
            statement.close();
        }catch(Exception ex){
            System.err.println("Error "+ex);
        }finally{
            try{
            }catch(Exception ex){
            }
        }
     
        try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    }
}
