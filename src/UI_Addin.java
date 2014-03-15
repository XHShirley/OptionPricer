import java.awt.EventQueue;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


/**
 * 
 * @author Yiming
 *
 */

public class UI_Addin extends JFrame{

	
	private JTextField textField;
	UI_Addin window;
	String folderPath;
	String inputFile;

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UI_Addin window = new UI_Addin();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UI_Addin() {
		setTitle("Add-in");
		initialize();
		
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		this.setBounds(100, 100, 450, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(45, 86, 346, 27);
		this.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnBrowse = new JButton("Browse");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 JFileChooser fileChooser = new JFileChooser();
				 fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			     fileChooser.setAcceptAllFileFilterUsed(false);
			     if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			    	 textField.setText(fileChooser.getSelectedFile().getAbsolutePath());
			          folderPath = textField.getText();
			          inputFile=folderPath+"\\OptionAlgorithm.xls";
			          System.out.println(folderPath);
			          System.out.println(inputFile);
			        }
			}
		});
		
		btnBrowse.setBounds(45, 145, 93, 23);
		this.getContentPane().add(btnBrowse);
		
		JButton btnUpload = new JButton("Update");
		btnUpload.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UI_Addin_Disp ui=new UI_Addin_Disp(folderPath, inputFile);
			}
		});
		btnUpload.setBounds(170, 145, 93, 23);
		this.getContentPane().add(btnUpload);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancel.setBounds(298, 145, 93, 23);
		this.getContentPane().add(btnCancel);
	}
	
	
}
