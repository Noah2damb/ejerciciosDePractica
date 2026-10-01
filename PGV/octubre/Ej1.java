public class Ej1 {

    public static void main(String[] args) {
        
        try {
        Process p = Runtime.getRuntime().exec("ls", "/home/noah");
        int codigo = p.waitFor();         
        System.out.println("Termino con codigo " + codigo);
        } catch (Exception error){
            System.out.println("Error inesperado");
        }
        }
        
    }
