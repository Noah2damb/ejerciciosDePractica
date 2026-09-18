/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noah.mavenproject1;

import java.io.File;

/**
 *
 * @author 2damb
 */
public class AnalizadorFichero {
    
    private String ruta = null;
    private File archivo = null;
    
    private String nombre;
    private boolean existe;
    private String rutaAbsoluta;
    private boolean permisoEscritura;
    private boolean permisoLectura;
    private long tamanio;
    private boolean esDirectorio;
    private boolean esFichero;
    
    public AnalizadorFichero(String ruta){
        this.ruta = ruta;
        if (ruta != null){
            archivo = new File(ruta);
        }
        existe = false;
        rutaAbsoluta = null;
        permisoEscritura = false;
        permisoLectura = false;
        tamanio = 0;
        esDirectorio = false;
        esFichero = false;
    }
    
    public void analizar(){
                
        if (archivo.exists()){
            
            setNombre(archivo.getName());
            setExiste(true);
            
            try {
                setRutaAbsoluta(archivo.getAbsolutePath());
                setPermisoEscritura(archivo.canWrite());
                setPermisoLectura(archivo.canRead());
                setTamanio(archivo.length());
                setEsDirectorio(archivo.isDirectory());
                setEsFichero(archivo.isFile());
                
            } catch (SecurityException error){
                System.out.println("Hubo un error con respecto a los permisos...");
            }
            
            setPermisoEscritura(archivo.canWrite());
        }
    }
    
    public void mostrarInfo(){
        
        String info = null;
        
        analizar();
        
        info = """
                      --- Información del fichero: %s
                      El fichero existe:    %b
                      Ruta absoluta:        %s
                      Se puede leer:        %b
                      Se puede escribir:    %b
                      Tamaño del fichero:   %d
                      Es un directorio:     %b
                      Es un fichero:        %b
                      """.formatted(nombre, existe, rutaAbsoluta, permisoLectura,
                              permisoEscritura, tamanio, esDirectorio, esFichero);
       
        
        System.out.println(info);
    }
    
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    
    public void setExiste (boolean existe ){
        this.existe = existe;
    }
    
    public void setRutaAbsoluta (String rutaAbsoluta){
        this.rutaAbsoluta = rutaAbsoluta;
    }
    
    public void setPermisoEscritura (boolean permisoEscritura){
        this.permisoEscritura = permisoEscritura;
    }
    
    public void setPermisoLectura (boolean permisoLectura ){
        this.permisoLectura =  permisoLectura;
    }
    
    public void setTamanio (long tamanio ){
        this.tamanio = tamanio;
    }
    
    public void setEsDirectorio (boolean esDirectorio ){
        this.esDirectorio = esDirectorio;
    }
    
    public void setEsFichero (boolean esFichero ){
        this.esFichero = esFichero;
    }
    
}
