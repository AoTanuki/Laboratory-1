package Interfaz;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import model.FileWithNoSetSizeException;
import model.FileWithNotNumbersSet;
import model.Model;

public class MainInterfaz extends JFrame {

	private OptionPanel options;
	private Model model; 
	
	public MainInterfaz() {
		setTitle("Lab1 MiguelRomero y Jonathan Arenas");

		options = new OptionPanel(this);
		add(options);

		model =  new Model();
		
		pack();

	}

	public void ReadNumbersFile(String link, char typeElement) {
		JFileChooser windows = new JFileChooser(link);
		int option = windows.showOpenDialog(this);

		switch (option) {
		case JFileChooser.APPROVE_OPTION:

			File a = windows.getSelectedFile();
			try {
				model.readNumbersFile(a, typeElement);
			} catch (NumberFormatException | IOException | FileWithNoSetSizeException | FileWithNotNumbersSet e) {
				// TODO Auto-generated catch block
				System.out.println(e.getMessage());
			}

			break;

		default:

		}

	}
	
	public void generateElements(int Size, int startInterval, int endInterval,char cloneNumber, char numberType )
	{
		
		
		
		
		
	}
	
	public void generateElementsTwo(int Size, int startInterval, int endInterval,char cloneNumber, char numberType, int randomPercentage )
	{
		
		
		
		
		
	}
	
	
	
	
	
	

	public static void main(String[] arg) {
		MainInterfaz All = new MainInterfaz();
		All.setVisible(true);
	}

}
