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
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jxl.read.biff.BiffException;


public class UI {

	private JFrame frmOptionPricer;
	private ArrayList<JLabel> labelList=new ArrayList<JLabel>();
	private ArrayList<JTextField> textFieldList=new ArrayList<JTextField>();
	private String option;
	private String algorithm;
	private ArrayList<String> optionList;
	private ArrayList<String> algorithmList;
	private HashMap<String, String> parameterMap;
	private double S, K, R, T, V, optionPrice;
	private JTextField textField_Price;

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
		
		optionList=new ArrayList<>();
		ExcelReader.readOption(optionList);	//@yiming	
		
		frmOptionPricer = new JFrame();
		frmOptionPricer.getContentPane().setBackground(Color.WHITE);
		frmOptionPricer.getContentPane().setLayout(null);
		
		JLabel lblOptionPricer = new JLabel("OPTION PRICER");
		lblOptionPricer.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		lblOptionPricer.setBounds(190, 28, 126, 15);
		frmOptionPricer.getContentPane().add(lblOptionPricer);
		
		JLabel lblParameters = new JLabel("Parameters");
		lblParameters.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblParameters.setBounds(43, 123, 81, 16);
		frmOptionPricer.getContentPane().add(lblParameters);
		
		final JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 196));
		panel.setBounds(50, 149, 369, 332);
		frmOptionPricer.getContentPane().add(panel);
		panel.setLayout(null);			
				
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(224, 255, 255));
		panel_1.setBounds(438, 337, 126, 66);
		frmOptionPricer.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		
		JButton btnNewButton = new JButton("Advanced");
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setBounds(524, 514, 87, 23);
		frmOptionPricer.getContentPane().add(btnNewButton);
		
		//@yiming
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i=0;
				for (String k: parameterMap.keySet()){
					parameterMap.put(k, textFieldList.get(i).getText());
					i++;	
					System.out.println(k);
					System.out.println(parameterMap.get(k));
				}
				
				
			}
		});
		btnCalculate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCalculate.setBackground(SystemColor.controlHighlight);
		btnCalculate.setBounds(438, 234, 118, 23);
		frmOptionPricer.getContentPane().add(btnCalculate);
		
		JButton btnVolatilitySmile = new JButton("Volatility Smile");
		btnVolatilitySmile.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnVolatilitySmile.setBackground(SystemColor.controlHighlight);
		btnVolatilitySmile.setBounds(438, 282, 118, 23);
		frmOptionPricer.getContentPane().add(btnVolatilitySmile);
		
		//@yijming
		JButton button = new JButton("Clear");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i=0;i<textFieldList.size();i++){
					textFieldList.get(i).setText("");
				}
			}
		});
		button.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(451, 66, 68, 23);
		frmOptionPricer.getContentPane().add(button);
		
		JButton btnHelp = new JButton("Exit\r\n");
		btnHelp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnHelp.setBackground(SystemColor.controlHighlight);
		btnHelp.setBounds(426, 514, 68, 23);
		frmOptionPricer.getContentPane().add(btnHelp);
		
		JButton button_1 = new JButton("Help");
		button_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(318, 514, 81, 23);
		frmOptionPricer.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("Product Type (P):");
		lblNewLabel.setBounds(43, 66, 99, 14);
		frmOptionPricer.getContentPane().add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		JLabel lblAlgorithm = new JLabel("Algorithm (A):");
		lblAlgorithm.setBounds(43, 95, 87, 14);
		frmOptionPricer.getContentPane().add(lblAlgorithm);
		lblAlgorithm.setFont(new Font("Times New Roman", Font.BOLD, 12));
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(170, 63, 190, 20);
		frmOptionPricer.getContentPane().add(comboBox);
		comboBox.setBackground(Color.WHITE);
		comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox.setModel(new DefaultComboBoxModel(optionList.toArray(new String[0])));	//@yiming	
		
		final JComboBox comboBox_1 = new JComboBox();
		
		comboBox_1.setBounds(170, 92, 190, 20);
		frmOptionPricer.getContentPane().add(comboBox_1);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Algorithms"}));
		comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		comboBox_1.setBackground(Color.WHITE);
		
		//@yiming
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option=(String)comboBox.getSelectedItem();
				algorithmList=new ArrayList<>();
				ExcelReader.readAlgorithm(option, algorithmList);
				comboBox_1.setModel(new DefaultComboBoxModel(algorithmList.toArray()));
				//System.out.println(optionType);
			}
		});
		
		//@yiming
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				frmOptionPricer.getContentPane().repaint();
				algorithm=(String)comboBox_1.getSelectedItem();
				parameterMap=new HashMap<String, String>();
				
				panel.repaint();
				ExcelReader.readParameter(algorithm, parameterMap);
				drawParameter(parameterMap,panel);				
				System.out.println(option);
				System.out.println(algorithm);								
				
			}
		});
		
		//@yiming
						
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblResults.setBounds(438, 314, 81, 16);
		frmOptionPricer.getContentPane().add(lblResults);
		frmOptionPricer.setTitle("Option Pricer");
		frmOptionPricer.setBounds(100, 100, 771, 685);
		frmOptionPricer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//@yiming
	private void drawParameter(HashMap<String, String> parameterMap, JPanel panel){	
		
		textFieldList=new ArrayList<JTextField>();
		Iterator it=parameterMap.keySet().iterator();
		int y=25;
		while (it.hasNext()){
			String parameterName=(String) it.next();
			System.out.println(parameterName);
			JLabel lbl= new JLabel(parameterName);
			lbl.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 12));
			lbl.setBounds(22, y, 111, 14);
			panel.add(lbl);	
			/*panel.revalidate();
			panel.repaint();*/
			
			JTextField textField = new JTextField();
			textField.setBounds(149, y, 192, 21);			
			textField.setColumns(10);
			textFieldList.add(textField);
			
			panel.add(textField);
			panel.revalidate();
			panel.repaint();
			y+=30;
		}
		
		
	}
	
}
