package Interfaz;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MeanInterfaz extends JFrame {

	private OptionPanel options;

	public MeanInterfaz() {
		setTitle("Lab1 MiguelRomero y Jonathan Arenas");

		options = new OptionPanel(this);
		add(options);

		pack();

	}

	public void ReadNumbersFile(String link, char typeElement) {
		JFileChooser windows = new JFileChooser(link);
		int option = windows.showOpenDialog(this);

		switch (option) {
		case JFileChooser.APPROVE_OPTION:

			File a = windows.getSelectedFile();

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
		MeanInterfaz All = new MeanInterfaz();
		All.setVisible(true);
	}

}
