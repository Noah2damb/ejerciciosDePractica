/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package avancesdad_noah;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileReader;
import java.sql.*;

/**
 *
 * @author noah
 */
public class BaseDeDatos {
    
    private static Connection con = null;
    private static String rutaMaquina;
    private static String usuario;
    private static String clave;
    
    public static String[] obtenerDatosConexion(){
        
        String[] datos = new String[3];
       
        String ruta = "./ConexionBD.txt";
        

        try (BufferedReader buf = new BufferedReader(new FileReader(ruta))){
            
            for (int i = 0; i < 3; i++){
                
                String linea = buf.readLine();
                
                if (linea != null && linea.contains("=")) {
                    datos[i] = linea.substring(linea.indexOf("=") + 1).trim();
                
                } else {
                    System.err.println("Error: El archivo de configuración no tiene las 3 líneas"
                            + "requeridas con el formato 'clave=valor'.");
                    return null;
                }
            }
            
        } catch (FileNotFoundException error1){
                System.err.println("Error: el archivo de configuración (para conectar con la BDD) no existe.");
                datos = null;
        
        } catch (IOException error2){
            System.err.println("Error: ha ocurrido un error inesperado respecto a la recogida"
                    + "de datos del archivo de configuración para conectar con la BDD.");
            datos = null;
        }
        
        return datos;
    }
    
    public static void conectarConBD(){
        
        String[] datos = obtenerDatosConexion();
        
        if (datos != null){
            
            rutaMaquina = datos[0];
            usuario = datos[1];
            clave = datos[2];
            
            try {
            
                con = DriverManager.getConnection(rutaMaquina, usuario, clave);

                System.out.println("Conexiónn exitosa con la base de datos.");

            } catch (SQLException error){
                System.err.println("Error: no se pudo conectar con la base de datos indicada.");
            }
        }
        
    }
    
    public static boolean estaConectado(){
        
        boolean conectado = false;
        
        try {
            if (con != null && !con.isClosed()){
                conectado = true;
            }
            
        } catch (SQLException error){
            System.err.println("Error: ha ocurrido un error inesperado relacionado con"
                    + "revisar si la conexión con la BDD está activa.");
            
        }
        

        return conectado;
    }
    
    public static void desconectarDeLaBD(){
        
        if (estaConectado()){
            try {
                con.close();
                con = null;
                System.out.println("Desconexión exitosa de la base de datos.");
            }
            catch (SQLException error){
                System.err.println("Error: no se pudo cerrar la conexión actual con la base de datos.");
            }
        }
        
    }
    
    public static Connection getCon(){
        return con;
    }
}
