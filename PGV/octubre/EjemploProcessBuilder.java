import java.io.*;
public class EjemploProcessBuilder {
    public static void main(String[] args) {
        try {
            // Crear un proceso que ejecute "cmd /c dir"
            ProcessBuilder pb = new ProcessBuilder("gnome-terminal", "ls -la", "/home/noah/repositorios");
            pb.redirectErrorStream(true); // Combinar errores con salida estándar
            
            Process proceso = pb.start();
            // Leer la salida del proceso
            BufferedReader lector = new BufferedReader(
                new InputStreamReader(proceso.getInputStream())
            );
            String linea;
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
            }
            proceso.waitFor();
            System.out.println("Comando ejecutado con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
