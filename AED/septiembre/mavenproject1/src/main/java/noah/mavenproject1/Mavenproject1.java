/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package noah.mavenproject1;

/**
 *
 * @author 2damb
 */
public class Mavenproject1 {

    public static void main(String[] args) {
        AnalizadorFichero programa = new AnalizadorFichero("./src/main/java/noah/mavenproject1/archivo.html");
        programa.mostrarInfo();
        try {
        Process p = Runtime.getRuntime().exec("firefox ./src/main/java/noah/mavenproject1/archivo.html");
        int codigo = p.waitFor();         
        System.out.println("Termino con codigo " + codigo);
        } catch (Exception error){
            System.out.println("Error inesperado");
        }
        
    }
}
