package application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.fxml.*;

import java.util.Vector;

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
			
			deltaTableWindow.setTitle("Transitions");
			
			deltaTableWindow.initModality(Modality.APPLICATION_MODAL);  // block other user interactions
			
			Parent root = FXMLLoader.load(getClass().getResource("deltaTable.fxml")); 	
			Scene scene = new Scene(root,300,300);
			deltaTableWindow.setResizable(false); // this will not allow the user the resize the window/stage
			
			deltaTableWindow.setScene(scene);
			deltaTableWindow.showAndWait();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
