package application;

//a change from the feature branch
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.Parent;


public class Main extends Application {
	
	
	 Button button;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Finite Automata Simulator");
			
			Parent root = FXMLLoader.load(getClass().getResource("Sample.fxml")); 	
			Scene scene = new Scene(root,600,600);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
