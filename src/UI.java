import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.BoxLayout;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.border.EtchedBorder;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.AbstractListModel;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;


public class UI {

	private JFrame frmOptionPricer;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI window = new UI();
					window.frmOptionPricer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOptionPricer = new JFrame();
		frmOptionPricer.getContentPane().setBackground(Color.WHITE);
		frmOptionPricer.getContentPane().setLayout(null);
		
		JLabel lblOptionPricer = new JLabel("OPTION PRICER");
		lblOptionPricer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblOptionPricer.setBounds(190, 28, 126, 15);
		frmOptionPricer.getContentPane().add(lblOptionPricer);
		
		JLabel lblParameters = new JLabel("Parameters");
		lblParameters.setFont(new Font("SimSun", Font.PLAIN, 14));
		lblParameters.setBounds(60, 53, 81, 16);
		frmOptionPricer.getContentPane().add(lblParameters);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setBounds(43, 75, 387, 240);
		frmOptionPricer.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Product Type (P):");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblNewLabel.setBounds(20, 22, 99, 14);
		panel.add(lblNewLabel);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"European Call", "European Put", "American Call", "American Put", "Asian Call", "Asian Put"}));
		comboBox.setBounds(147, 19, 190, 20);
		panel.add(comboBox);
		
		JLabel lblAlgorithm = new JLabel("Algorithm (A):");
		lblAlgorithm.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblAlgorithm.setBounds(20, 51, 87, 14);
		panel.add(lblAlgorithm);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Closed-form solution", "Black-Scholes", "Binomial trees", "Numerical integration", "Simulation"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(147, 48, 190, 20);
		panel.add(comboBox_1);
		
		JLabel lblRiskFreeRate = new JLabel("Risk Free Rate (R):");
		lblRiskFreeRate.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblRiskFreeRate.setBounds(20, 79, 111, 14);
		panel.add(lblRiskFreeRate);
		
		textField = new JTextField();
		textField.setBounds(147, 75, 192, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblCurrentPrices = new JLabel("Current Price (S):");
		lblCurrentPrices.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblCurrentPrices.setBounds(20, 107, 111, 14);
		panel.add(lblCurrentPrices);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(147, 103, 192, 21);
		panel.add(textField_1);
		
		JLabel lblStrikePricek = new JLabel("Strike Price (K):");
		lblStrikePricek.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblStrikePricek.setBounds(20, 135, 111, 14);
		panel.add(lblStrikePricek);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(147, 131, 192, 21);
		panel.add(textField_2);
		
		JLabel lblTimeToMaturity = new JLabel("Time to Maturity (T):");
		lblTimeToMaturity.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblTimeToMaturity.setBounds(20, 161, 123, 14);
		panel.add(lblTimeToMaturity);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(147, 157, 192, 21);
		panel.add(textField_3);
		
		JLabel lblVolatilityv = new JLabel("Volatility (V):");
		lblVolatilityv.setFont(new Font("Times New Roman", Font.BOLD, 12));
		lblVolatilityv.setBounds(19, 190, 123, 14);
		panel.add(lblVolatilityv);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(146, 186, 192, 21);
		panel.add(textField_4);
		
		JButton btnNewButton = new JButton("Advanced");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setBounds(43, 373, 98, 23);
		frmOptionPricer.getContentPane().add(btnNewButton);
		
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCalculate.setBackground(SystemColor.controlHighlight);
		btnCalculate.setBounds(454, 234, 118, 23);
		frmOptionPricer.getContentPane().add(btnCalculate);
		
		JButton btnVolatilitySmile = new JButton("Volatility Smile");
		btnVolatilitySmile.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnVolatilitySmile.setBackground(SystemColor.controlHighlight);
		btnVolatilitySmile.setBounds(454, 282, 118, 23);
		frmOptionPricer.getContentPane().add(btnVolatilitySmile);
		
		JButton button = new JButton("Clear");
		button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(454, 75, 68, 23);
		frmOptionPricer.getContentPane().add(button);
		
		JButton btnHelp = new JButton("Exit\r\n");
		btnHelp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnHelp.setBackground(SystemColor.controlHighlight);
		btnHelp.setBounds(454, 373, 118, 23);
		frmOptionPricer.getContentPane().add(btnHelp);
		
		JButton button_1 = new JButton("Help");
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(190, 373, 98, 23);
		frmOptionPricer.getContentPane().add(button_1);
		frmOptionPricer.setTitle("Option Pricer");
		frmOptionPricer.setBounds(100, 100, 615, 507);
		frmOptionPricer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
