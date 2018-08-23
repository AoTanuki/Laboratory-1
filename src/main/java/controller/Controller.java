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
import javafx.scene.input.MouseEvent;
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
			if (combTypeNumber.valueProperty().getValue() != null
					&& !combTypeNumber.valueProperty().getValue().isEmpty()) {

				char numberType = (combTypeNumber.valueProperty().getValue().equalsIgnoreCase("float")) ? Model.INTEGERS
						: Model.FLOAT;

				try {
					model.readNumbersFile(file, numberType);

					String message = "";

					if (numberType == Model.FLOAT) {
						for (int i = 0; i < model.getFloatList().length; i++) {
							message += model.getFloatList()[i] + " - ";
						}
						model.setIntegerList(null);
					} else {
						for (int i = 0; i < model.getIntegerList().length; i++) {
							message += model.getIntegerList()[i] + " - ";
						}
						model.setFloatList(null);
					}
					txtNonSortNumbers.setText(message);
				} catch (NumberFormatException | FileWithNoSetSizeException | FileWithNotNumbersSet e) {

					JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

				} catch (IOException e) {

					JOptionPane.showMessageDialog(null, "an error appear when we tryed to read your file", "Error",
							JOptionPane.ERROR_MESSAGE);

				}
			} else {
				JOptionPane.showMessageDialog(null, "You did not choose a number type ", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}

	}

	@FXML
	void toSort(ActionEvent event) {

		if (model.getFloatList() != null) {
			Object[] performance = model.sortPerformance(Model.FLOAT);

			txtRunTime.setText((long) performance[0] + "");
			txtAlgorithm.setText((String) performance[1] + "");
			txtOutputSize.setText(model.getFloatList().length + "");

			String message = "";
			for (int i = 0; i < model.getFloatSortedlist().length; i++) {
				message += model.getFloatSortedlist()[i] + " - ";
			}
			txtSortedNumbers.setText(message);

			model.setIntegerSortedList(null);
		}

		if (model.getIntegerList() != null) {
			Object[] performance = model.sortPerformance(Model.INTEGERS);

			txtRunTime.setText((long) performance[0] + "");
			txtAlgorithm.setText((String) performance[1] + "");
			txtOutputSize.setText(model.getFloatList().length + "");

			String message = "";
			for (int i = 0; i < model.getIntegerSortedList().length; i++) {
				message += model.getIntegerSortedList()[i] + " - ";
			}
			txtSortedNumbers.setText(message);

			model.setFloatSortedList(null);
		}

	}

	@FXML
	void toGenerate(ActionEvent event) {

		char cloneNumber = 0, numberType = 0, generateType = 0;
		int size = 0, endInterval = 0, startInterval = 0;

		// ------------------
		try {
			size = Integer.parseInt(txtInputSize.getText());
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please check size field", "error", JOptionPane.ERROR_MESSAGE);
		}

		// ------
		try {
			startInterval = Integer.parseInt(txtStartInterval.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please, check the first field of interval", "error",
					JOptionPane.ERROR_MESSAGE);
		}

		// ----------
		try {
			endInterval = Integer.parseInt(txtEndInterval.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Please, check the second field of interval", "error",
					JOptionPane.ERROR_MESSAGE);
		}

		// ----------------
		if (checkCloneNumberNo.isSelected() && checkCloneNumberYes.isSelected()) {
			JOptionPane.showMessageDialog(null, "Please, only select one option by Clone number", "error",
					JOptionPane.ERROR_MESSAGE);
		} else if (!checkCloneNumberNo.isSelected() && !checkCloneNumberYes.isSelected()) {
			JOptionPane.showMessageDialog(null, "Please, select one option by Clone number", "error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (checkCloneNumberNo.isSelected()) {
				cloneNumber = Model.NO_CLONE_NUMBERS;
			} else {
				cloneNumber = Model.CLONE_NUMBERS;
			}
		}

		// ------------
		if (checkNumberTypeFloat.isSelected() && checkNumberTypeInteger.isSelected()) {
			JOptionPane.showMessageDialog(null, "Please, only select one option by Number Type", "error",
					JOptionPane.ERROR_MESSAGE);
		} else if (!checkNumberTypeFloat.isSelected() && !checkNumberTypeInteger.isSelected()) {
			JOptionPane.showMessageDialog(null, "Please, select one option by Numbers type", "error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (checkNumberTypeFloat.isSelected()) {
				numberType = Model.FLOAT;
			} else {
				numberType = Model.INTEGERS;
			}
		}

		// -------

		int selectOptions = 0;
		if (checkGenerationSorted.isSelected())
			selectOptions++;
		if (checkGenerationInverted.isSelected())
			selectOptions++;
		if (checkGenerationComplety.isSelected())
			selectOptions++;
		if (checkGenerationPercent.isSelected())
			selectOptions++;

		if (selectOptions > 1) {
			JOptionPane.showMessageDialog(null, "Please, only select one option by Generation type", "error",
					JOptionPane.ERROR_MESSAGE);
		} else if (selectOptions == 0) {
			JOptionPane.showMessageDialog(null, "Please, select one option by Generation type", "error",
					JOptionPane.ERROR_MESSAGE);
		} else {
			if (checkGenerationSorted.isSelected())
				generateType = Model.SORT_GENERATION;
			if (checkGenerationInverted.isSelected())
				generateType = Model.INVERSAL_SORT_GENERATION;
			if (checkGenerationComplety.isSelected())
				generateType = Model.COMPLETLY_RANDOM_GENERATION;
			if (checkGenerationPercent.isSelected())
				generateType = Model.PERCENT_RANDOM_GENERATION;
		}

		if (generateType == Model.PERCENT_RANDOM_GENERATION) {
			try {
				double randomPorcentage = Double.parseDouble(txtGeneratonPercent.getText());
				
				if(!(size<endInterval-startInterval))
				{
					model.generateElements(size, startInterval, endInterval, cloneNumber, numberType, randomPorcentage);
				}else{
					JOptionPane.showMessageDialog(null, "Interval can't be less than size", "error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Please, check porcentage field ", "error",
						JOptionPane.ERROR_MESSAGE);
			}
		} else {

			try {
				if(!(size<endInterval-startInterval))
				{
				model.generateElements(size, startInterval, endInterval, cloneNumber, generateType, numberType);
				}else{
					JOptionPane.showMessageDialog(null, "Interval can't be less than size", "error",
							JOptionPane.ERROR_MESSAGE);
				}
			} catch (IOException e) {

				JOptionPane.showMessageDialog(null, "We're sorry, we had a problem writting the file", "error",
						JOptionPane.ERROR_MESSAGE);
			}
		}

		String message = "";
		if (numberType == Model.FLOAT && model.getFloatList()!= null) {
			for (int i = 0; i < model.getFloatList().length; i++) {
				message += model.getFloatList()[i] + " - ";
			}
			model.setIntegerList(null);
		} else if(numberType == Model.INTEGERS && model.getIntegerList()!= null){
			for (int i = 0; i < model.getIntegerList().length; i++) {
				message += model.getIntegerList()[i] + " - ";
			}
			model.setFloatList(null);
		}
		txtNonSortNumbers.setText(message);

	}

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ObservableList<String> typeNumbers = FXCollections.observableArrayList("Floats", "Integers");
		combTypeNumber.setItems(typeNumbers);
		model = new Model();
	}

	@FXML
	void disCheckNumberType(MouseEvent event) {

	}

	@FXML
	void disCheckCloneNumber(MouseEvent event) {
	
		
	}
}
