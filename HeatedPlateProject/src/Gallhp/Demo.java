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

				// TODO - Add error handling for invalid input values

				// Show error to user
				JOptionPane.showMessageDialog(null, "Error");


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

}