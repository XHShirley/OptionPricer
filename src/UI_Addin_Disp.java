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


/**
 * 
 * @author Yiming
 *
 */
public class UI_Addin_Disp{
	
	private JFrame frmOptionPricer;
	private ArrayList<JLabel> labelList=new ArrayList<JLabel>();
	private ArrayList<JTextField> textFieldList=new ArrayList<JTextField>();
	private String option="Options";
	private String algorithm="Algorithms";
	private ArrayList<String> optionList;
	private ArrayList<String> algorithmList;
	private HashMap<String, String> parameterMap;
	private double S, K, R, T, V, optionPrice;
	private JTextField textField_Price;
	private JTextField Results;
	String folderPath;
	String inputFile;

	

	
	public UI_Addin_Disp(String folderPath,String inputFile) {
		this.folderPath=folderPath;
		this.inputFile=inputFile;
		initialize();
		frmOptionPricer.setVisible(true);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		optionList=new ArrayList<>();
		ExcelReader.readOption(optionList,inputFile);	//@yiming	
		
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
		panel_1.setBounds(438, 337, 279, 66);
		frmOptionPricer.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		Results = new JTextField();
		Results.setBounds(20, 18, 230, 31);
		panel_1.add(Results);
		Results.setColumns(10);
		
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				frmOptionPricer.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnNewButton.setBackground(SystemColor.controlHighlight);
		btnNewButton.setBounds(451, 458, 105, 23);
		frmOptionPricer.getContentPane().add(btnNewButton);
		
		//@yiming 0314
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				parameterMap=new HashMap<String, String>();
				ExcelReader.readParameter(algorithm, parameterMap,inputFile);
				String ErrorMsg=ValidityCheck.checkOptionAlgorithm(option, algorithm);
				if (!ErrorMsg.equals("0"))	{
					JOptionPane.showMessageDialog(null, ErrorMsg);					
				}
				else{
					ErrorMsg=ValidityCheck.check(textFieldList, parameterMap);
					if (!ErrorMsg.equals("0"))	{
						JOptionPane.showMessageDialog(null, ErrorMsg);			
					}
					else{
						double result = calculate();
						System.out.println(Double.toString(result));	
						Results.setText(Double.toString(result));
						}
				}
								
				
			}
		});
		
		btnCalculate.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnCalculate.setBackground(SystemColor.controlHighlight);
		btnCalculate.setBounds(438, 234, 118, 23);
		frmOptionPricer.getContentPane().add(btnCalculate);
		
		JButton btnVolatilitySmile = new JButton("Volatility Smile");
		btnVolatilitySmile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				parameterMap=new HashMap<String, String>();
				ExcelReader.readParameter(algorithm, parameterMap,inputFile);
				String ErrorMsg=ValidityCheck.checkOptionAlgorithm(option, algorithm);
				if (!ErrorMsg.equals("0"))	{
					JOptionPane.showMessageDialog(null, ErrorMsg);					
				}
				else{
					ErrorMsg=ValidityCheck.check(textFieldList, parameterMap);
					if (!ErrorMsg.equals("0"))	{
						JOptionPane.showMessageDialog(null, ErrorMsg);			
					}
					else{
						displayVolatitlity();
						}
				}				
								
			}
		});
		btnVolatilitySmile.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		btnVolatilitySmile.setBackground(SystemColor.controlHighlight);
		btnVolatilitySmile.setBounds(438, 282, 118, 23);
		frmOptionPricer.getContentPane().add(btnVolatilitySmile);
		
		//@yijming 0314
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
		
		//@yiming 0314
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				option=(String)comboBox.getSelectedItem();
				algorithmList=new ArrayList<>();
				ExcelReader.readAlgorithm(option, algorithmList,inputFile);
				comboBox_1.setModel(new DefaultComboBoxModel(algorithmList.toArray()));
				//System.out.println(optionType);
			}
		});
		
		//@yiming 0314
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				panel.removeAll();
				frmOptionPricer.getContentPane().repaint();
				algorithm=(String)comboBox_1.getSelectedItem();
				parameterMap=new HashMap<String, String>();
				
				panel.repaint();
				ExcelReader.readParameter(algorithm, parameterMap,inputFile);
				drawParameter(parameterMap,panel);				
				System.out.println(option);
				System.out.println(algorithm);								
				
			}
		});
		
		//@yiming 0314
						
		JLabel lblResults = new JLabel("Results:");
		lblResults.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblResults.setBounds(438, 314, 81, 16);
		frmOptionPricer.getContentPane().add(lblResults);
		frmOptionPricer.setTitle("Option Pricer");
		frmOptionPricer.setBounds(100, 100, 771, 685);
		frmOptionPricer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//@yiming 0314
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
	
	public String getOption() {
		return option;
	}


	public String getAlgorithm() {
		return algorithm;
	}
	

	public String getFolderPath() {
		return folderPath;
	}

	public HashMap<String, String> getParameterMap() {
		return parameterMap;
	}
	
	private double calculate(){
		Controller con = new Controller(this.getFolderPath(), this.getOption(),this.getAlgorithm(),this.getParameterMap());
		double result = con.calculate();
		return result;
		}
	
	private void displayVolatitlity(){
		Controller con = new Controller(this.getFolderPath(), this.getOption(),this.getAlgorithm(),this.getParameterMap());
		con.displayVolatilitySmile();
		}


}
