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
public class Directorio {
    
    private File[] archivos = null;
    public String nombre = null;
    private String datos = "";
    
    public Directorio(String ruta){
        
        File dir = new File(ruta);
       
        if (dir.exists()){
            nombre = dir.getName();
            analizarBasico(dir);
        }
        else {
            System.out.println("El directorio %s no existe".formatted(ruta));
        }
    }
    
    private void analizarBasico(File dir){
        
        if (dir.isDirectory()){
            
            archivos = dir.listFiles();
            datos += "\nContenido del directorio %s:".formatted(nombre);
            
            for (File elemento : archivos){
                if (elemento.isDirectory()){
                    datos += "\n|---->Directorio: " + elemento.getName();
                }
                else {
                    datos += "\n|---->Fichero: " + elemento.getName();
                }
            }
        }
        else {
            System.out.println("%s no es un directorio.".formatted(nombre));
        }
    }
    
    public void mostrarAnalisisRecursivo(String ruta, int numTabs){
        
        File dir = new File(ruta);
        
        if (dir.isDirectory()){
            
            archivos = dir.listFiles();
            
            if (archivos == null){
                System.out.println("  ".repeat(numTabs) + "Este directorio está vacío");
                return ;
            }
            
            for (File elemento : archivos){
                
                if (elemento.isDirectory()){
                    System.out.println("  ".repeat(numTabs) + "|---->Directorio: " + elemento.getName());
                    mostrarAnalisisRecursivo(elemento.getPath(), numTabs + 1);
                }
                else {
                    System.out.println("  ".repeat(numTabs) + "o---->Fichero: " + elemento.getName());
                }
            }
        }
        else {
            System.out.println("%s no es un directorio.".formatted(nombre));
        }
    }
    
    public void mostrarInfo(){
        System.out.println(datos);
    }
}
