package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.*;
import javafx.geometry.Insets;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
	 
	 Vector<Vector<String>> stateTransition;
	 
	 int numOfStates;
	 
	 int numOfSigma;
	  
	 Queue<ChoiceBox<String>> transitionQueue;
	 
	
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
			
			Button addTransitions = new Button("Add the Transitions");
			
			VBox layout = new VBox(10);
			
			GridPane grid = new GridPane();
			
			
			Label label = new Label();
			
			ChoiceBox<String> choiceBox;
			
			transitionQueue = new LinkedList<ChoiceBox<String>>();
			
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
					choiceBox.getItems().add("null");
					
					//set a Default value to null
					choiceBox.setValue("null");
					
					transitionQueue.add(choiceBox);
					
					GridPane.setConstraints(choiceBox, j,i);
					grid.getChildren().add(0, choiceBox);
				}
			
		
			VBox.setMargin(addTransitions, new Insets(10,10,10,100)); 
			
			layout.getChildren().addAll(grid, addTransitions);
			
			
			addTransitions.setOnAction(e -> getChoice(deltaTableWindow));
		
			Scene scene = new Scene(layout,100+(50*(setOfSigmaVec.size())),100+(35*(setOfStatesVec.size())));
			deltaTableWindow.setScene(scene);
			
		
			
			deltaTableWindow.showAndWait();
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getChoice(Stage deltaTableWindow) {
		
		stateTransition = new Vector<Vector<String>>();
		ChoiceBox<String> tempBox= new ChoiceBox<String>();
		
		for (int i = 0; i < setOfStatesVec.size(); i++)
			for (int j = 0; j < setOfSigmaVec.size(); j++) {
				tempBox = transitionQueue.remove();
				System.out.println(" " +tempBox.getValue() + " ");
				stateTransition.add(new Vector<String>());
				(stateTransition.elementAt(i)).add(j, tempBox.getValue());
			}
		deltaTableWindow.close();
	}
	
}
	
