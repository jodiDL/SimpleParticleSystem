package physicsfx;

import gui.MainScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jodi
 */
public class PhysicsFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        MainScreen root = new MainScreen(this);
        
        Scene scene = new Scene(root, 800, 600);
        
        primaryStage.setTitle("PhysX");
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
        
        primaryStage.setOnCloseRequest(e -> {root.stopGameLoop(); });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
