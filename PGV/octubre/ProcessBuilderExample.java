import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessBuilderExample {
    public static void main(String[] args) {
        try {
            // Crear un ProcessBuilder para ejecutar el comando "ping google.com"
            ProcessBuilder processBuilder = new ProcessBuilder("ping", "google.com");
            
            // Iniciar el proceso
            Process process = processBuilder.start();
            
            // Leer la salida del proceso
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
            reader.close();
            
            // Esperar a que el proceso termine
            process.waitFor();
            System.out.println("Proceso finalizado con código: " + process.exitValue());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
