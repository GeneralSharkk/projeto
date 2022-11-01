package JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * AppStart do JavaFX
 * 
 * @author henri
 */
public class JavaFXStart extends Application {

    /**
     * Método para iniciar a stage principal.
     * 
     * @param primaryStage stage
     * @throws Exception e
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = new Scene(new RegisterMenu(), 450, 310);
        primaryStage.setTitle("Register Menu");
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        // AdminMenu 850 240
        // ManagerMenu 630 180
        // UserMenu 620 140
        // RegisterMenu 450 310
        // LoginMenu 300 180
    }

    /**
     * Main do JavaFx
     * 
     * @param args args
     */
    public static void main(String[] args) {
        launch(args);
    }

}