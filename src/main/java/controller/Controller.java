package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import interfaz.Frame;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import model.FileWithNoSetSizeException;
import model.FileWithNotNumbersSet;
import model.Model;

public class Controller implements Initializable {

	private Model model;

	// Buttons
	@FXML
	private Button btnSearchFile;

	@FXML
	private Button btnToGenerate;

	@FXML
	private Button btnToSort;

	// TextFields
	@FXML
	private TextField txtLink;

	@FXML
	private TextField txtInputSize;

	@FXML
	private TextField txtStartInterval;

	@FXML
	private TextField txtEndInterval;

	@FXML
	private TextField txtGeneratonPercent;

	@FXML
	private TextField txtAlgorithm;

	@FXML
	private TextField txtRunTime;

	@FXML
	private TextField txtOutputSize;

	// CheckBoxes
	@FXML
	private CheckBox checkCloneNumberYes;

	@FXML
	private CheckBox checkCloneNumberNo;

	@FXML
	private CheckBox checkNumberTypeFloat;

	@FXML
	private CheckBox checkNumberTypeInteger;

	@FXML
	private CheckBox checkGenerationSorted;

	@FXML
	private CheckBox checkGenerationInverted;

	@FXML
	private CheckBox checkGenerationComplety;

	@FXML
	private CheckBox checkGenerationPercent;

	// TextAreas
	@FXML
	private TextArea txtNonSortNumbers;

	@FXML
	private TextArea txtSortedNumbers;

	// Combo boxes
	@FXML
	private ComboBox<String> combTypeNumber;

	// onAction
	@FXML
	void searchFile(ActionEvent event) {
		FileChooser chooser = new FileChooser();
		chooser.setInitialDirectory(new File("./data/numbersets"));
		File file = chooser.showOpenDialog(null);

		if (file != null) {
			txtLink.setText(file.getAbsolutePath());
			if (combTypeNumber.valueProperty().getValue() != null&& !combTypeNumber.valueProperty().getValue().isEmpty()) {
				
				char numberType = (combTypeNumber.valueProperty().getValue().equalsIgnoreCase("float"))? Model.INTEGERS: Model.FLOAT;
			
				try {
					model.readNumbersFile(file, numberType);
					
					String message = "";
					
					if(numberType == Model.FLOAT)
					{
						for (int i = 0; i < model.getFloatList().length; i++) {
							message += model.getFloatList()[i]+ " - ";
						}
						
					}else{
						for (int i = 0; i < model.getIntegerList().length; i++) {
							message += model.getIntegerList()[i]+ " - ";
						}
					}
					txtNonSortNumbers.setText(message);
				} catch (NumberFormatException | FileWithNoSetSizeException | FileWithNotNumbersSet e) {
					
					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					
				} catch (IOException e) {
					
					JOptionPane.showMessageDialog(null, "an error appear when we tryed to read your file", "Error", JOptionPane.ERROR_MESSAGE);
					
				} 
			} else
			{
				JOptionPane.showMessageDialog(null, "You did not choose a number type ", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			
			
	}

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> typeNumbers = FXCollections.observableArrayList("Floats", "Integers");
		combTypeNumber.setItems(typeNumbers);
		model = new Model();
	}

}
