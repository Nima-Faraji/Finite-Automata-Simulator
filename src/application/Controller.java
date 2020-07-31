package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.Parent;


public class Controller  {
	
	Stage infoWindow;
	
	public Button close;
	
	public void handleButtonClick() {
		System.out.println("you have exited the application");
	
		System.exit(0);
	}
}
