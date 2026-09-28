package avancesdad_noah;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Button;

public class HelloFX extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // 1. Crear componentes
        BorderPane panel = new BorderPane();
        Button boton = new Button("Click me!");

        // 2. Agregar el botón al centro del panel
        panel.setCenter(boton);

        // 3. Crear la escena asociando el panel y definiendo dimensiones (ancho, alto)
        Scene scene = new Scene(panel, 400, 300);

        // 4. Configurar y mostrar la ventana (Stage)
        stage.setTitle("Hola JavaFX");
        stage.setScene(scene);
        stage.show();
    }
}