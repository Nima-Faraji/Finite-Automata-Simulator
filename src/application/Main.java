 
package application;
<<<<<<< HEAD
    
=======


>>>>>>> branch 'master' of https://github.com/Nima-Faraji/Finite-Automata-Simulator
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
<<<<<<< HEAD
 
=======
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;


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
			
			BorderPane root = new BorderPane();
			
			
			button = new Button();
			button.setText("Click Me");
			
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			StackPane layout = new StackPane();
			layout.getChildren().add(button);
			
			Scene scene = new Scene(layout,400,400);
			
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
 