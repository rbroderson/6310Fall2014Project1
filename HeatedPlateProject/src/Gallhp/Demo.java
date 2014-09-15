package Gallhp;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Demo extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int TYPE_FLOAT = 0;
	private static final int TYPE_DOUBLE = 1;

	// - Combo box to display a list of programs
	private JComboBox cbPrograms;

	// - Text box to display results
	private JTextArea taResults;

	// - Text fields for input parameters
	private JTextField txtDimensions;
	private JTextField txtTop;
	private JTextField txtBottom;
	private JTextField txtLeft;
	private JTextField txtRight;

	// - Button to execute selected program
	private JButton btnExecute;

	public Demo() {

		initUI();

	}	

	public static void main(String[] args) {

		// Ensure UI updates are concurrencty-safe
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				Demo gui = new Demo();
				gui.setVisible(true);
			}
		});
	}

	public void populateComboBox() {

		cbPrograms.addItem("Tpdahp");
		cbPrograms.addItem("Tpfahp");
		cbPrograms.addItem("Twfahp");
		cbPrograms.addItem("Tpdohp");

	}

	private void initUI() {

		// Setup window
		setupWindow();

		// Setup combobox
		cbPrograms = new JComboBox();	
		cbPrograms.setBounds(110, 50, 100, 25);		
		populateComboBox();			

		// Setup textArea
		taResults = new JTextArea();
		taResults.setEditable(false);
		taResults.setBounds((this.getWidth()/2) + 10, 10, (this.getWidth()/2) - 35 , this.getHeight() - 55);	

		// Setup labels
		addLabels();

		// Setup text fields
		addTextFields();

		// Set textArea contents with name in combo box on change (FOR TESTING)
		cbPrograms.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				taResults.setText(cbPrograms.getSelectedItem().toString());					
			}				
		});		

		// Setup button
		btnExecute = new JButton("Execute");	
		btnExecute.setBounds(250, 50, 120, 25);
		btnExecute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				if(cbPrograms.getSelectedItem().toString().equals("Tpdahp")) {

					if(checkValidInput(TYPE_DOUBLE)) {
						
						Tpdahp.Demo.main(getArgumentStringArray());
					}

				}
				else if(cbPrograms.getSelectedItem().toString().equals("Tpfahp")) {

					if(checkValidInput(TYPE_FLOAT)) {
						
						Tpfahp.Demo.main(getArgumentStringArray());
					}

				}
				else if(cbPrograms.getSelectedItem().toString().equals("Twfahp")) {

					if(checkValidInput(TYPE_FLOAT)) {
						
						Twfahp.Demo.main(getArgumentStringArray());
					}

				}
				else if(cbPrograms.getSelectedItem().toString().equals("Tpdohp")) {

					if(checkValidInput(TYPE_DOUBLE)) {

						Tpdohp.Demo.main(getArgumentStringArray());
					}

				}

			}

		});

		// Add UI elements to GUI
		getContentPane().add(cbPrograms);
		getContentPane().add(taResults);
		getContentPane().add(btnExecute);

	}

	private void setupWindow() {

		// Use no layout manager (absolute positions for elements)
		getContentPane().setLayout(null);				

		// Set title
		setTitle("Gallhp");

		// Set location and size
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	
		setSize(800, 600);
		setResizable(false);

	}

	private void addLabels() {

		JLabel lblProgram = new JLabel("Program:");
		JLabel lblDimensions = new JLabel("Dimensions:");
		JLabel lblTop = new JLabel("Top:");
		JLabel lblBottom = new JLabel("Bottom:");
		JLabel lblLeft = new JLabel("Left:");
		JLabel lblRight = new JLabel("Right:");

		lblProgram.setBounds(10, 50, 90, 16);
		lblDimensions.setBounds(10, 100, 90, 16);
		lblTop.setBounds(10, 150, 90, 16);
		lblBottom.setBounds(10, 200, 90, 16);
		lblRight.setBounds(10, 250, 90, 16);
		lblLeft.setBounds(10, 300, 90, 16);

		getContentPane().add(lblProgram);
		getContentPane().add(lblDimensions);
		getContentPane().add(lblTop);
		getContentPane().add(lblBottom);
		getContentPane().add(lblLeft);
		getContentPane().add(lblRight);
	}

	private void addTextFields() {

		txtDimensions = new JTextField();
		txtTop = new JTextField();
		txtBottom = new JTextField();
		txtLeft = new JTextField();
		txtRight = new JTextField();

		txtDimensions.setBounds(110, 100, 50, 25);
		txtTop.setBounds(110, 150, 50, 25);
		txtBottom.setBounds(110, 200, 50, 25);
		txtLeft.setBounds(110, 250, 50, 25);
		txtRight.setBounds(110, 300, 50, 25);

		txtDimensions.setText("0");
		txtTop.setText("0");
		txtBottom.setText("0");
		txtLeft.setText("0");
		txtRight.setText("0");

		getContentPane().add(txtDimensions);
		getContentPane().add(txtTop);
		getContentPane().add(txtBottom);
		getContentPane().add(txtLeft);
		getContentPane().add(txtRight);
	}

	private boolean checkValidInput(int type) {

		if(!isValidInt(txtDimensions.getText())) {
			JOptionPane.showMessageDialog(null, "Dimensions must be a valid integer value");
			 return false;
		}
		else {

			if(Integer.parseInt(txtDimensions.getText()) <= 0) {
				JOptionPane.showMessageDialog(null, "Dimensions must be greater than 0");
				return false;
			}
		}

		if(type == TYPE_FLOAT) {

			if(!isValidFloat(txtTop.getText())) {
				JOptionPane.showMessageDialog(null, "Top edge temperature must be a valid float value");
				return false;
			}
			else {

				float top = Float.parseFloat(txtTop.getText());

				if(top < 0 || top > 100) {
					JOptionPane.showMessageDialog(null, "Top edge temperature must be between 0 and 100 inclusive");
					return false;
				}
			}

			if(!isValidFloat(txtBottom.getText())) {
				JOptionPane.showMessageDialog(null, "Bottom edge temperature must be a valid float value");
				return false;
			}
			else {

				float bottom = Float.parseFloat(txtBottom.getText());

				if(bottom < 0 || bottom > 100) {
					JOptionPane.showMessageDialog(null, "Bottom edge temperature must be between 0 and 100 inclusive");
					return false;
				}
			}

			if(!isValidFloat(txtLeft.getText())) {
				JOptionPane.showMessageDialog(null, "Left edge temperature must be a valid float value");
				return false;
			}
			else {

				float left = Float.parseFloat(txtLeft.getText());

				if(left < 0 || left > 100) {
					JOptionPane.showMessageDialog(null, "Left edge temperature must be between 0 and 100 inclusive");
					return false;
				}
			}

			if(!isValidFloat(txtRight.getText())) {
				JOptionPane.showMessageDialog(null, "Right edge temperature must be a valid float value");
				return false;
			}
			else {

				float right = Float.parseFloat(txtRight.getText());

				if(right < 0 || right > 100) {
					JOptionPane.showMessageDialog(null, "Right edge temperature must be between 0 and 100 inclusive");
					return false;
				}
			}

		}
		else if(type == TYPE_DOUBLE) {

			if(!isValidDouble(txtTop.getText())) {
				JOptionPane.showMessageDialog(null, "Top edge temperature must be a valid float value");
				return false;
			}
			else {

				double top = Double.parseDouble(txtTop.getText());

				if(top < 0 || top > 100) {
					JOptionPane.showMessageDialog(null, "Top edge temperature must be between 0 and 100 inclusive");
					return false;
				}
			}

			if(!isValidDouble(txtBottom.getText())) {
				JOptionPane.showMessageDialog(null, "Bottom edge temperature must be a valid float value");
				return false;
			}
			else {

				double bottom = Double.parseDouble(txtBottom.getText());

				if(bottom < 0 || bottom > 100) {
					JOptionPane.showMessageDialog(null, "Bottom edge temperature must be between 0 and 100 inclusive");
					return false;
				}
			}

			if(!isValidDouble(txtLeft.getText())) {
				JOptionPane.showMessageDialog(null, "Left edge temperature must be a valid float value");
				return false;
			}
			else {

				double left = Double.parseDouble(txtLeft.getText());

				if(left < 0 || left > 100) {
					JOptionPane.showMessageDialog(null, "Left edge temperature must be between 0 and 100 inclusive");
					return false;
				}
			}

			if(!isValidDouble(txtRight.getText())) {
				JOptionPane.showMessageDialog(null, "Right edge temperature must be a valid float value");
				return false;
			}
			else {

				double right = Double.parseDouble(txtRight.getText());

				if(right < 0 || right > 100) {
					JOptionPane.showMessageDialog(null, "Right edge temperature must be between 0 and 100 inclusive");
					return false;
				}
			}
		}

		return true;
	}
	
	private String[] getArgumentStringArray() {
		
		String dimensions = txtDimensions.getText();
		String top = txtTop.getText();
		String bottom = txtBottom.getText();
		String left = txtLeft.getText();
		String right = txtRight.getText();

		String[] args = new String[10];
		args[0] = "-d";
		args[1] = dimensions;
		args[2] = "-t";
		args[3] = top;
		args[4] = "-b";
		args[5] = bottom;
		args[6] = "-l";
		args[7] = left;
		args[8] = "-r";
		args[9] = right;
		
		return args;
	}

	private boolean isValidInt(String intString) {

		try {
			Integer.parseInt(intString);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	private boolean isValidFloat(String floatString) {

		try {
			Float.parseFloat(floatString);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

	private boolean isValidDouble(String doubleString) {

		try {
			Double.parseDouble(doubleString);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}

}