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
import java.sql.SQLException;

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
			e.printStackTrace();
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
