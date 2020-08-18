package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.geometry.Insets;

import java.util.Vector;

import javafx.collections.FXCollections;
import javafx.event.*;



public class ControllerCreateDFA {
	
	
	 @FXML
	 TextField setOfAllStates;
	
	 @FXML
	 TextField setOfAllSigma;
	 
	 @FXML
	 Label setOfAllStatesLabel;
	 
	 @FXML
	 Button deltaTableButton;
	
	 Vector<String> setOfStatesVec;
	 
	 Vector<String> setOfSigmaVec;
	 
	 int numOfStates;
	 
	 int numOfSigma;
	 
	
	 @FXML
	 BorderPane myBorderPane;
	 
	 @FXML
	 Button myButton;
	 
	 @FXML
	 VBox vboxLabels;
	
	 
	public void handleCloseButtonClick() {
		System.out.println("you have exited the application");
	
		System.exit(0);
	}
	
	public void handleCreateDFAButton() {
		
		
		String setStates = setOfAllStates.getText();	
		if (!validateStates(setStates)) {
			System.out.println("error");
		}
		String setSigma = setOfAllSigma.getText();
		if (!validateSigma(setSigma)) {
			System.out.println("error");
		}
		
		
	}
	
	
	public boolean validateSigma(String name) {
		int tempIndex = 0;
		int firstIndex;
		String temp;
		setOfSigmaVec = new Vector<String>();
		numOfSigma = 0;
		
		while(true) {
		firstIndex = name.indexOf(',',tempIndex+1);
		if (firstIndex == -1) {
			numOfSigma++;
			setOfSigmaVec.add(name.substring(tempIndex+1));
			break;
		}
		if (tempIndex==0) {
			setOfSigmaVec.add(name.substring(tempIndex, firstIndex));
			numOfSigma++;
			
			tempIndex = firstIndex;
			continue;
		}
		temp = name.substring(tempIndex+1, firstIndex);
		setOfSigmaVec.add(temp);
		numOfSigma++;
	
		tempIndex = firstIndex;
		
		}
		
		return true;	
	}
	
	// information alerts for user responses 
	@FXML
	private void alertInfo (ActionEvent event) {
		Alert a1 = new Alert(Alert.AlertType.INFORMATION);
		a1.setTitle("Listing States");
		a1.setContentText("Make sure to separate your states with commas ");
		a1.setHeaderText(null);
		a1.show();
	}
	
	public boolean validateStates(String name) {
			
		int tempIndex = 0;
		int firstIndex;
		String temp;
		setOfStatesVec = new Vector<String>();
		numOfStates = 0;
		
		while(true) {
	
		firstIndex = name.indexOf(',',tempIndex+1);
		if (firstIndex == -1) {
			numOfStates++;
			setOfStatesVec.add(name.substring(tempIndex+1));
			break;
		}
		if (tempIndex==0) {
			setOfStatesVec.add(name.substring(tempIndex, firstIndex));
			numOfStates++;
			
			tempIndex = firstIndex;
			continue;
		}
		temp = name.substring(tempIndex+1, firstIndex);
		setOfStatesVec.add(temp);
		numOfStates++;
	
		tempIndex = firstIndex;
		
		}
		
		return true;
		
	}

	public void handleDeltaTableButton() {
		try {
			Stage deltaTableWindow = new Stage();
			
			deltaTableWindow.setTitle("Enter the Transitions");
			
			deltaTableWindow.initModality(Modality.APPLICATION_MODAL);  // block other user interactions
			deltaTableWindow.setResizable(false); // this will not allow the user the resize the window/stage
			
			
			GridPane grid = new GridPane();
			
			Label label = new Label();
			
			ChoiceBox<String> choiceBox;
			
			grid.setPadding(new Insets(20,20,20,20));
			
			grid.setVgap(0);
			grid.setHgap(0);
			
			grid.setGridLinesVisible(true);
			
			for (int i = 1; i <= setOfStatesVec.size(); i++) {
				label = new Label(" "+ setOfStatesVec.elementAt(i-1)+ " ");	
				label.setStyle("-fx-font: 18 arial;");
				GridPane.setConstraints(label, 0, i);			
				grid.getChildren().add(0, label);
			}
			
			for (int i = 1; i <= setOfSigmaVec.size(); i++) {
				label = new Label(" "+ setOfSigmaVec.elementAt(i-1)+ " ");	
				label.setStyle("-fx-font: 18 arial;");
				GridPane.setConstraints(label, i,0);		
				grid.getChildren().add(0, label);
			}
	
			
			
			for (int i = 1; i <= setOfStatesVec.size(); i++)
				for (int j = 1; j <= setOfSigmaVec.size(); j++) {
					choiceBox = new ChoiceBox<>();
					choiceBox.getItems().addAll(setOfStatesVec);
					GridPane.setConstraints(choiceBox, j,i);
					grid.getChildren().add(0, choiceBox);
				}
			
			
		
			Scene scene = new Scene(grid,110+(40*(setOfSigmaVec.size())),110+(40*(setOfStatesVec.size())));
			deltaTableWindow.setScene(scene);
			
		
			
			deltaTableWindow.showAndWait();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
