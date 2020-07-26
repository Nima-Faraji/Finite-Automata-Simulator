package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;


public class Main extends Application {
	
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
}
