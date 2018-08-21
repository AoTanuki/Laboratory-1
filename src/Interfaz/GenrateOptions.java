package Interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class GenrateOptions extends JFrame implements ActionListener {

	public final static String ACCEPT = "ac";

	private JLabel questionData;
	private JCheckBox integer;
	private JCheckBox floats;
	private JLabel repeatedQuestion;
	private JCheckBox yes;
	private JCheckBox no;
	private JLabel IntervalQuestion;
	private JLabel lowerLimit;
	private JTextField textLower;
	private JLabel UpperLimit;
	private JTextField textUperLimit;
	private JLabel ElementsSortedQuestion;
	private JCheckBox sorted;
	private JCheckBox converseleySorted;
	private JCheckBox percentage;
	private JButton Acept;
	private JLabel size;
	private JTextField numbers;
	private MainInterfaz inter;

	public GenrateOptions(MainInterfaz in) {

		inter = in;

		setLayout(new GridLayout(13, 2));
		setTitle("Generation Menu");
		setBackground(Color.blue);
	
		questionData = new JLabel("What type of data?");
		questionData.setHorizontalAlignment(JLabel.CENTER);
		add(questionData);

		JLabel empty = new JLabel();
		add(empty);
		integer = new JCheckBox("Integers");
		integer.setHorizontalAlignment(JCheckBox.CENTER);
		add(integer);
		floats = new JCheckBox("Floats");
		floats.setHorizontalAlignment(JCheckBox.LEFT);
		add(floats);
		repeatedQuestion = new JLabel("Do you want the numbers to be repated?");
		repeatedQuestion.setHorizontalAlignment(JLabel.CENTER);
		add(repeatedQuestion);
		JLabel empty1 = new JLabel();
		add(empty1);
		yes = new JCheckBox("Yes");
		yes.setHorizontalAlignment(JCheckBox.CENTER);
		add(yes);
		no = new JCheckBox("No");
		add(no);

		IntervalQuestion = new JLabel("What Interval do you want?");
		IntervalQuestion.setHorizontalAlignment(JLabel.CENTER);
		add(IntervalQuestion);
		JLabel empty2 = new JLabel();
		add(empty2);
		lowerLimit = new JLabel("Lower Limit:");
		lowerLimit.setHorizontalAlignment(JLabel.CENTER);
		add(lowerLimit);
		textLower = new JTextField();
		add(textLower);

		UpperLimit = new JLabel("Upper Limit:");
		UpperLimit.setHorizontalAlignment(JLabel.CENTER);
		add(UpperLimit);
		textUperLimit = new JTextField();
		add(textUperLimit);

		size = new JLabel("How many numbers would you like to be sorted?");
		add(size);

		numbers = new JTextField();
		add(numbers);

		ElementsSortedQuestion = new JLabel("How would you like the elements to be sorted?");
		add(ElementsSortedQuestion);

		JLabel empty3 = new JLabel();
		add(empty3);

		sorted = new JCheckBox("Sorted");
		sorted.setHorizontalAlignment(JCheckBox.LEFT);
		add(sorted);
		JLabel empty4 = new JLabel();
		add(empty4);

		converseleySorted = new JCheckBox("Conversely Ordered");
		converseleySorted.setHorizontalAlignment(JCheckBox.LEFT);
		add(converseleySorted);

		JLabel empty5 = new JLabel();
		add(empty5);

		percentage = new JCheckBox("Not sorted in a percentage");
		percentage.setHorizontalAlignment(JCheckBox.LEFT);
		add(percentage);

		Acept = new JButton("Accept");
		Acept.addActionListener(this);
		Acept.setActionCommand(ACCEPT);
		add(Acept);

		pack();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case ACCEPT:

			try {
				char numbertype = integer.isSelected() ? 'I' : 'f';
				int startInterval = Integer.parseInt(textLower.getText());
				int endInterval = Integer.parseInt(textUperLimit.getText());
				char cloneNumber = yes.isSelected() ? 'Y' : 'N';
				int size = Integer.parseInt(numbers.getText());

				if (percentage.isSelected()) {
					String percentage = JOptionPane.showInputDialog("Percentage");
					int randomPercentage = Integer.parseInt(percentage);
					inter.generateElementsTwo(size, startInterval, endInterval, cloneNumber, numbertype,
							randomPercentage);
				}

				else {
					inter.generateElements(size, startInterval, endInterval, cloneNumber, numbertype);
				}
			}

			catch (Exception a) {
				JOptionPane.showMessageDialog(this, "Could you please check if you have filled up everything right?");
			}

			break;

		default:

		}

	}

}
