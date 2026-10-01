/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package noah.randomaccessejemplo;

/**
 *
 * @author 2damb
 */
public class Empleado {
    
    public int id;
    public String nombre;
    public String apellido;
    public double salario;
    public String puesto;
    
    public int NOM_LEN = 10;
    public int APE_LEN = 20;
    public double SAL_MAX = 999999.99;
    public int PUE_MAX = 10;
    
    
    public Empleado(int id, String nombre, String apellido, double salario, String puesto){
        
        if (validarEntrada(id, nombre, apellido, salario, puesto)){
            
            this.id = id;
            this.nombre = nombre;
            this.apellido = apellido;
            this.salario = salario;
            this.puesto = puesto;
        }
        else {
            System.err.println("Los datos ingresados no son válidos. No se han guardado los datos.");
        }
    }
    
    private boolean validarEntrada(int id, String nombre, String apellido, double salario, String puesto){
        
        boolean esCorrecto = true;
        
        if (id < 1 || nombre.trim().length() > NOM_LEN || nombre.trim().length() < 1
                || apellido.trim().length() > APE_LEN || apellido.trim().length() < 1
                || salario > SAL_MAX || salario < 1
                || puesto.trim().length() > PUE_MAX || puesto.trim().length() < 1){
            
            esCorrecto = false;
        }
        
        return esCorrecto;
    }
    
    public String leerEmpleado(int id){
        return null;
    }

    @Override
    public String toString() {
        
        String empleado;
        
        empleado = "%-".formatted(this.id, this.nombre, this.apellido, this.salario, this.puesto);
        
        return empleado;
    }
    
    
}
