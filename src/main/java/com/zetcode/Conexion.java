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
                int anchura = partidas.getInt("anchura");
                int altura = partidas.getInt("altura");
                int puntuacion = partidas.getInt("puntuacion");
                int nivel = partidas.getInt("nivel");
                //falta añadir los bloques de cada partida
                Board parAcabada = new Board(idPartida, anchura, altura, puntuacion, nivel);
                j.anadirPartidaAcabada(parAcabada);
            }
            
            if (parSinFin!=null) {
	            //anadir partida sin finalizar 
	            PreparedStatement preparedStatement3 = con.prepareStatement("SELECT * FROM partida where id_partida=?");
	            preparedStatement3.setString(1, parSinFin);
	            ResultSet parGuardada = preparedStatement3.executeQuery();
	            rs.next();
                int idPartida = partidas.getInt("id_partida");
                int anchura = partidas.getInt("anchura");
                int altura = partidas.getInt("altura");
                int puntuacion = partidas.getInt("puntuacion");
                int nivel = partidas.getInt("nivel");
                Board parAcabada = new Board(idPartida, anchura, altura, puntuacion, nivel);
                j.guardarPartida(parAcabada);

            }
            
            //añadir la personalizacion
            
            PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM personalizacion where id_personalizacion=?");
            preparedStatement4.setInt(1, idpersonalizacion);
            ResultSet personalizacion = preparedStatement4.executeQuery();
            rs.next();//obtener resultado de select --> personalizacion
            String colorFondo = personalizacion.getString("colorFondo");
            String colorBloques = personalizacion.getString("colorBloques");
            String sonido = personalizacion.getString("sonido");
            Personalizacion personalizacionJ = new Personalizacion(colorFondo, colorBloques, sonido);
            j.setPersonalizacion(personalizacionJ);
            
            //añadir jugador a la lista de jugadores
            ListaJugadores.getMiListaJugadores().anadirJugador(j);
        }
    } catch (SQLException e) {
    	System.out.println("ha habido algun error al crear los jugadores");
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
			PreparedStatement preparedStatement = con.prepareStatement("");
			for(int i = 0; i < listaJugadores.size(); i++)
			{
				String usuario = listaJugadores.get(i).getUsuario().toString();
				String correo = listaJugadores.get(i).getCorreo();
				String contrasena = listaJugadores.get(i).getContrasena();
				int idPersonalizacion = i;
				int idPartidaSF = i;
			}
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
	                int anchura = partidas.getInt("anchura");
	                int altura = partidas.getInt("altura");
	                int puntuacion = partidas.getInt("puntuacion");
	                int nivel = partidas.getInt("nivel");
	                //falta añadir los bloques de cada partida
	                Board parAcabada = new Board(idPartida, anchura, altura, puntuacion, nivel);
	                j.anadirPartidaAcabada(parAcabada);
	            }
	            
	            if (parSinFin!=null) {
		            //anadir partida sin finalizar 
		            PreparedStatement preparedStatement3 = con.prepareStatement("SELECT * FROM partida where id_partida=?");
		            preparedStatement3.setString(1, parSinFin);
		            ResultSet parGuardada = preparedStatement3.executeQuery();
		            rs.next();
	                int idPartida = partidas.getInt("id_partida");
	                int anchura = partidas.getInt("anchura");
	                int altura = partidas.getInt("altura");
	                int puntuacion = partidas.getInt("puntuacion");
	                int nivel = partidas.getInt("nivel");
	                Board parAcabada = new Board(idPartida, anchura, altura, puntuacion, nivel);
	                j.guardarPartida(parAcabada);

	            }
	            
	            //añadir la personalizacion
	            
	            PreparedStatement preparedStatement4 = con.prepareStatement("SELECT * FROM personalizacion where id_personalizacion=?");
	            preparedStatement4.setInt(1, idpersonalizacion);
	            ResultSet personalizacion = preparedStatement4.executeQuery();
	            rs.next();//obtener resultado de select --> personalizacion
	            String colorFondo = personalizacion.getString("colorFondo");
	            String colorBloques = personalizacion.getString("colorBloques");
	            String sonido = personalizacion.getString("sonido");
	            Personalizacion personalizacionJ = new Personalizacion(colorFondo, colorBloques, sonido);
	            j.setPersonalizacion(personalizacionJ);
	            
	            //añadir jugador a la lista de jugadores
	            ListaJugadores.getMiListaJugadores().anadirJugador(j);
	        }
	    } catch (SQLException e) {
	    	System.out.println("ha habido algun error al crear los jugadores");
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
