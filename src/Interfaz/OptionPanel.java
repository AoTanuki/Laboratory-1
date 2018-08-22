package Interfaz;

import java.awt.Color;
import java.awt.TrayIcon.MessageType;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OptionPanel extends JPanel implements ActionListener{
	
	public final static String OPENFILE="open";
	public final static String GENERATEFILES="generate";
	
	private JButton openFile;
	private JButton generateFiles;
	private MainInterfaz interfaz;
	
	
	
	
	
	public OptionPanel(MainInterfaz inter)
	{
		openFile= new JButton("Open Elements from Folder");
		openFile.setActionCommand(OPENFILE);
		openFile.addActionListener(this);
		add(openFile);
		
		generateFiles= new JButton("Generate Elements Randomdly");
		generateFiles.addActionListener(this);
		generateFiles.setActionCommand(GENERATEFILES);
		add(generateFiles);
		
		interfaz=inter;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch(e.getActionCommand())
		{
		    case OPENFILE:
		    	String message="What type of element do you want?";
		    	Object[] options= new Object[] {"Integer","Floast"};
		    	int selection=JOptionPane.showOptionDialog(null, message, message, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		    	
		    	if(selection==0)
		    	{
		    		
		    		interfaz.ReadNumbersFile("./", 'a');
		    	}
		    	else {
		    		interfaz.ReadNumbersFile("./", 'a');
		    	}
		    	
		    
			break;
			
		    case GENERATEFILES:
		    	
		    	    GenrateOptions newFrame = new GenrateOptions(interfaz);
		    	    newFrame.setVisible(true);
		    	    newFrame.setBackground(Color.RED);
		    	    newFrame.pack();
		    	
		    	
		    	
		    	break;
		
			}
		
	}
	
	
	
	
	
	
	
	
	
	

}
