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
    
    public String nombre;
    public String apellido;
    public double salario;
    public int departamento;
    public String puesto;
    
    public int NOM_LEN = 10;
    public int APE_LEN = 20;
    public int SAL_MAX = 9;
    public int DEP_MAX = 2;
    public int PUE_MAX = 10;
    
    
    public Empleado(String nombre, String apellido, double salario, int departamento, String puesto){
        
        if (validarEntrada(nombre, apellido, salario, departamento, puesto)){
            this.nombre = nombre;
            this.apellido = apellido;
            this.salario = salario;
            this.departamento = departamento;
            this.puesto = puesto;
        }
        else {
            System.err.println("Los datos ingresados no son válidos. No se han guardado los datos.");
        }
    }
    
    private boolean validarEntrada(String nombre, String apellido, double salario, int departamento, String puesto){
        boolean esCorrecto = true;
        
        if (nombre.trim().length() > NOM_LEN || apellido.trim().length() > APE_LEN || String.valueOf(salario).length() > SAL_MAX 
                || String.valueOf(departamento).length() > DEP_MAX || puesto.trim().length() > PUE_MAX){
            esCorrecto = false;
        }
        else if (salario < 0 || salario > 999999.99 || departamento < 1 || departamento > 99) {
            esCorrecto = false;
        }
        
        return esCorrecto;
    }
}
