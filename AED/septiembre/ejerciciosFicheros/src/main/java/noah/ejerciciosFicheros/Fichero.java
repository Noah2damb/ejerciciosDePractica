/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noah.ejerciciosFicheros;

import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author 2damb
 */
public class Fichero {
    
    public Fichero(String ruta){
        
        mostrarContenido(ruta);
        contarLineasYEspacios(ruta);
        
    }
    
    /**
     * AC1.5.
     * Recibe un string con la ruta a un fichero y muestra por pantalla su contenido
     * carácter por carácter.
     * @param ruta - localización del fichero
     */
    private void mostrarContenido(String ruta){
        
        int caracter;
        
        try (FileReader lector = new FileReader(ruta)){
            
            //mientras no llegue al final del fichero imprime el siguiente carácter
            while ((caracter = lector.read()) != -1){
                System.out.print((char)caracter);
            }
            
        } catch (IOException error){
            System.err.println("No se pudo manejar el fichero");
        }
        
    }
    
    /**
     * AC1.6.
     * Cuenta el numero de lineas de un fichero, y tambien sus espacios en blanco.
     * @param ruta 
     */
    private void contarLineasYEspacios(String ruta){
        
        int caracter;
        int numLineas = 0;
        int numEspacios = 0;
        
        try (FileReader lector = new FileReader(ruta)){
           
            while ((caracter = lector.read()) != -1){
                if (caracter == ' '){
                    numEspacios++;
                }
                else if (caracter == '\n'){
                    numLineas++;
                }
            }
            
            if (numLineas > 0){
                numLineas++;
            }
            System.out.printf("El fichero tiene %d líneas y %d espacios en blanco.", numLineas, numEspacios);
            
        } catch (IOException error){
            System.err.println("No se pudo manejar el fichero");
        }
    }

}
