/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noah.binaryoperations;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author 2damb
 */
public class Factura {
    
    private String articulo;
    private int unidades;
    private double precio;
    
    
    public Factura(String articulo, int unidades, double precio){
        this.articulo = articulo;
        this.unidades = unidades;
        this.precio = precio;
    }
    
    public void escribirFactura(String fichero){
        
        try (DataOutputStream out = new DataOutputStream(
                new BufferedOutputStream(new FileOutputStream(fichero)))) {
        
            out.writeUTF(this.articulo);
            out.writeChar(':');
            out.writeInt(this.unidades);
            out.writeChar(':');
            out.writeDouble(precio);
            out.writeChar('\n');
        }
        catch (IOException error){
            System.err.println("Ha sucedido un error inesperado, inténtelo de nuevo.");
        }
        
    }

    public String getArticulo() {
        return articulo;
    }

    public int getUnidades() {
        return unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    @Override
    public String toString() {
        return super.toString(); 
    }
    
    
}
