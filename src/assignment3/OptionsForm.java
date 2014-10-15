package assignment3;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton; 
import javax.swing.JLabel; 
import javax.swing.JPanel;
import javax.swing.JCheckBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;



/**
 * Options form to change the options of the game
 * Changeable settings include the number of turns allowed,
 * the size of the code, and the number of colors used in the code
 * @author Robert Syvarth
 * @version 1
 */

public class OptionsForm extends JPanel  { 
	private static final long serialVersionUID = 1L;
	private JLabel codeLabel, colorLabel, turnLabel;
	private JSpinner codeSpinner, colorSpinner, turnSpinner;
	private JCheckBox revealBox;
	private int code, color, turn;
	private boolean spoil = false;
	
	private static final int GAP = 3;
	private static final Insets LABEL_INSETS = new Insets(GAP, GAP, GAP, 15);
	private static final Insets TEXTFIELD_INSETS = new Insets(GAP, GAP, GAP, GAP);
	
	/**
	 * Options form to change the options of the game
	 * Changeable settings include the number of turns allowed,
	 * the size of the code, and the number of colors used in the code
	 * @param codeSize The size of the code as an int
	 * @param numColors The number of colors to be used in the code as an int
	 * @param numTurns The number of turns the player has in the game as an int
	 * @param reveal Boolean - True: show the secret code; False: hide the secret code
	 */
	public void start(int codeSize, int numColors, int numTurns, boolean reveal)
	{ 
		codeLabel = new JLabel("Code Size :"); 
		SpinnerModel codeModel = new SpinnerNumberModel(codeSize, 1, 15, 1); 
		codeSpinner = new JSpinner(codeModel);
		
		colorLabel = new JLabel("Number of colors :"); 
		SpinnerModel colorModel = new SpinnerNumberModel(numColors, 1, 10, 1); 
		colorSpinner = new JSpinner(colorModel);
		
		turnLabel = new JLabel("Number of turns :"); 
		SpinnerModel turnModel = new SpinnerNumberModel(numTurns, 1, 100, 1); 
		turnSpinner = new JSpinner(turnModel);
		
		revealBox = new JCheckBox("Reveal the secret?", reveal);
		
		JButton button = new JButton();
		button.setText("Save Settings");
		
		setLayout(new GridBagLayout());
		
		addLabel(codeLabel,0);
		addSpinnerField(codeSpinner,0);

		addLabel(colorLabel,1);
		addSpinnerField(colorSpinner,1);
		
		addLabel(turnLabel,2);
		addSpinnerField(turnSpinner,2);

		GridBagConstraints gbc = new GridBagConstraints();
	      gbc.gridwidth = 1;
	      gbc.gridheight = 1;
	      gbc.gridx = 0;
	      gbc.gridy = 3;
	      gbc.anchor = GridBagConstraints.EAST;
	      gbc.fill = GridBagConstraints.HORIZONTAL;
	      gbc.insets = TEXTFIELD_INSETS;
	      gbc.weightx = 1.0;
	      gbc.weighty = 1.0;
		add(revealBox, gbc);
	}
	
	/**
	 * Gets all of the inputs for the game options.
	 * Input options: code size, number of colors, number of turns, and option to display secret code
	 */	
	public void getInputs()
	{
		code = (int) codeSpinner.getValue();
		color = (int) colorSpinner.getValue();
		turn = (int) turnSpinner.getValue();
		spoil = revealBox.isSelected();
	}
	
	/**
	 * Returns the size used for the code, which is
	 * set either by default or through game options
	 * @return int value of the code size
	 */	
	public int getCodeSize() 
	{
		return code;
	}
	
	/**
	 * Returns the number of colors used for the code.
	 * This is set either by default or through game options.
	 * @return int value of the number of colors used in the code
	 */	
	public int getColors() 
	{
		return color;
	}
	
	/**
	 * Returns the size used for the code, which is
	 * set either by default or through game options
	 * @return int value of the code size
	 */	
	public int getTurns() 
	{
		return turn;
	}
	
	/**
	 * Returns the value of the option to show the secret code.
	 * This is set to false by default, but can be changed to True through the game options.
	 * @return boolean True if spoil secret box was selected. False otherwise
	 */	
	public boolean spoilSecret() 
	{
		return spoil;
	}

	//adds a spinner field to the main options form
	private void addSpinnerField(JSpinner field, int row) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 1;
		gbc.gridy = row;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.insets = TEXTFIELD_INSETS;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		add(field, gbc);
	}

	//s a label to the main options form
	private void addLabel(JLabel text, int row) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		gbc.gridx = 0;
		gbc.gridy = row;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets = LABEL_INSETS;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		add(text, gbc);
	}
}