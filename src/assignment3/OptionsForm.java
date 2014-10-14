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



public class OptionsForm extends JPanel  { 
	/**
	 * Options form to change the options of the game
	 * Changeable settings include the number of turns allowed,
	 * the size of the code, and the number of colors used in the code
	 * @author Robert Syvarth
	 * @version 1
	 */
	private static final long serialVersionUID = 1L;
	JLabel codeLabel, colorLabel, turnLabel, spacer;
	JSpinner codeSpinner, colorSpinner, turnSpinner;
	JCheckBox revealBox;
	int code, color, turn;
	boolean spoil, submitted = false;
	
	private static final int GAP = 3;
	private static final Insets LABEL_INSETS = new Insets(GAP, GAP, GAP, 15);
	private static final Insets TEXTFIELD_INSETS = new Insets(GAP, GAP, GAP, GAP);
	
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

		
	public void getInputs()
	{
		code = (int) codeSpinner.getValue();
		color = (int) colorSpinner.getValue();
		turn = (int) turnSpinner.getValue();
		spoil = revealBox.isSelected();
	}
	
	public int getCodeSize() 
	{
		return code;
	}
	
	
	public int getColors() 
	{
		return color;
	}
	
	
	public int getTurns() 
	{
		return turn;
	}
	
	
	public boolean spoilSecret() 
	{
		return spoil;
	}
}