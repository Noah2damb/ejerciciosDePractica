/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

/**
 *
 * @author 2damb
 */
public class Proceso {
    
    private final String nombre;
    private final int tamanio;
    private final String[] textos;
    
    public Proceso (String nombre, int tamanio){
        this.nombre = nombre;
        this.tamanio = tamanio;
        textos = new String[tamanio];
        
        String texto = "m";
        int talla;
        
        for (int i = 0; i < tamanio; i++){
            talla = (int) (Math.random() * 10) + 1;
            textos[i] = "\t";
            for (int j = 0; j < talla; j++){
                textos[i] += texto;
            }
        }
    }
    
    public void imprimirTextos(){
        for (int i = 0; i < tamanio; i++){
            System.out.println(nombre + ":\n" + textos[i]);
        }
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
}
