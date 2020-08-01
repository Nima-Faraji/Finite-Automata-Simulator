package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.Parent;


public class Controller  {
	
	
	
	public MenuItem close;
	public MenuItem createDFA;
	
	public void handleCloseButtonClick() {
		System.out.println("you have exited the application");
	
		System.exit(0);
	}
	public void handleCreateDFA() {
		try {
			Stage createDFAWindow = new Stage();
			
			createDFAWindow.setTitle("Create a New DFA");
			
			createDFAWindow.initModality(Modality.APPLICATION_MODAL);  // block other user interactions
			
			Parent root = FXMLLoader.load(getClass().getResource("CreateDFA.fxml")); 	
			Scene scene = new Scene(root,400,400);
			
			createDFAWindow.setScene(scene);
			createDFAWindow.showAndWait();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
