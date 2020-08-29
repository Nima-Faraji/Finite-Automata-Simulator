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
	 TextField startingState;
	 
	 @FXML
	 TextField setOfAllFinishStates;
	 
	 
	 @FXML
	 Label setOfAllStatesLabel;
	 
	 @FXML
	 Label statesListError;
	 
	 @FXML
	 Label startStateError;
	 
	 @FXML
	 Label finishStateError;
	 
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
		
		// error checking for states
		
		String setStates = setOfAllStates.getText();
		
		if (!validateStates(setStates)) {
			setOfAllStates.setStyle("-fx-background-color: red;"); // the Textfield.setStyle function will change the background color of the text field if there is an error
			statesListError.setText("Fix format"); // text appears next to the text field
			System.out.println("error");
		}
		
		// error checking for starting state
		// note: there should only be one starting state
		
		String startState = startingState.getText();
		
		if (!validateStart(startState)) {
			
			startingState.setStyle("-fx-background-color: red;"); // the Textfield.setStyle function will change the background color of the text field if there is an error
			startStateError.setText("Only 1 starting state"); // text appears next to the text field
			System.out.println("error");
			
		}
		
		
		// error checking for final state
		// note: there can be multiple final states
		
		String finalStates = setOfAllFinishStates.getText();
		
		if (!validateStart(finalStates)) {
			
			setOfAllFinishStates.setStyle("-fx-background-color: red;"); // the Textfield.setStyle function will change the background color of the text field if there is an error
			finishStateError.setText("Fix Format"); // text appears next to the text field
			System.out.println("error");
			
		}
		
		// error checking for sigma
		
		String setSigma = setOfAllSigma.getText();
		
		if (!validateSigma(setSigma)) {
			System.out.println("error");
		}
		
	 
		
		
	}
	
	public boolean validateStart(String name) {
		
		boolean singleStart = true;
		
		// note: in java strings cant be treated as arrays like c++
		
		 // Creating array of string length 
        char[] ch = new char[name.length()]; 
  
        // Copy character by character into array 
        for (int i = 0; i < name.length(); i++) { 
            ch[i] = name.charAt(i); 
        } 
	
        // checking if any character in the array is a comma or a space because that would mean
        // that there is more than one starting state
        
		for(int i = 0; i < name.length(); i++) {
			
			if(ch[i] == ',' || ch[i] == ' ') {
				singleStart = false;
				break;
			}
		}
		
		return singleStart;
		
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
	
	public boolean validateFinishStates(String name) {
		
		// this should be similar to checking the starting states
		
		int tempIndex = 0;
		int firstIndex;
		
		String temp;
		
		setOfStatesVec = new Vector<String>();
		
		numOfStates = 0; // the number of states user wants the FSM to have
		
		while(true) {
	
		firstIndex = name.indexOf(',',tempIndex+1);
		
		if (firstIndex == -1) {
			numOfStates++;
			setOfStatesVec.add(name.substring(tempIndex+1));
			break;
		}
		
		if (tempIndex == 0) {
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
	
	public boolean validateStates(String name) {
			
		int tempIndex = 0;
		int firstIndex;
		
		String temp;
		
		setOfStatesVec = new Vector<String>();
		
		numOfStates = 0; // the number of states user wants the FSM to have
		
		while(true) {
	
		firstIndex = name.indexOf(',',tempIndex+1);
		
		if (firstIndex == -1) {
			numOfStates++;
			setOfStatesVec.add(name.substring(tempIndex+1));
			break;
		}
		
		if (tempIndex == 0) {
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
