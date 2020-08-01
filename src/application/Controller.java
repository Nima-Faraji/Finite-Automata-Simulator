package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.Parent;


public class Controller  {
	
	Stage infoWindow;
	
	public Button close;
	public Button about;
	
	public void handleButtonClick() {
		
//		if(close.isArmed())
//		{
			System.out.println("you have exited the application");
			System.exit(0);
//		}
//		else if(about.isPressed()) {
//			System.out.println("you have selected to know more about the application");
//		}
//		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
}
