 
package application;
<<<<<<< HEAD
    
=======


>>>>>>> branch 'master' of https://github.com/Nima-Faraji/Finite-Automata-Simulator
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
<<<<<<< HEAD
 
=======
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.Parent;


>>>>>>> branch 'master' of https://github.com/Nima-Faraji/Finite-Automata-Simulator
public class Main extends Application {
<<<<<<< HEAD
    @Override
    public void start(Stage primaryStage) {
        try {
            BorderPane root = new BorderPane();
            Scene scene = new Scene(root,400,400);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
=======
	
	Button button;
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Finite Automata Simulator");
			
			
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml")); 	
			Scene scene = new Scene(root,400,400);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
>>>>>>> branch 'master' of https://github.com/Nima-Faraji/Finite-Automata-Simulator
}
 