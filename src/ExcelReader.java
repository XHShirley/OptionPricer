

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeSet;

import javax.swing.JOptionPane;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * 
 * @author Yiming
 *
 */

public class ExcelReader {
	
	public static void readOption(ArrayList<String> optionList, String inputFile){
		       
        File inputWorkbook = new File(inputFile);
        Workbook w;        
        try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(0);
	        for (int i = 0; i < sheet.getRows(); i++){
	        Cell cell= sheet.getCell(0, i);
	        optionList.add(cell.getContents());
	        }
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Format Error: OptionAlgorithm.xlsx File ");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Fatal Error OptionAlgorithm.xlsx File missing");

		}
               
	}
	
	public static void readAlgorithm(String option, ArrayList<String> algorithmList,String inputFile) {
		       
        File inputWorkbook = new File(inputFile);
        algorithmList.add("Algorithms");
        Workbook w;        
        try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(0);
			for (int i = 0; i < sheet.getRows(); i++){
				Cell cell_option= sheet.getCell(0, i);
				if (cell_option.getContents().equals(option)){
					for (int j=1;j<sheet.getColumns();j++){
						Cell cell_algorithm=sheet.getCell(j, i);
						if(cell_algorithm.getContents().equals("")){}
						else{algorithmList.add(cell_algorithm.getContents());}	        		
					}
	        	}
			}
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Format Error: OptionAlgorithm.xlsx File ");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Fatal Error: OptionAlgorithm.xlsx File missing");
			//e.printStackTrace();
		}       
		
	}
	
	public static void readParameter(String algorithm, HashMap<String, String> parameterMap, String inputFile) {
		      
        File inputWorkbook = new File(inputFile);
        Workbook w;        
        try {
			w = Workbook.getWorkbook(inputWorkbook);
			Sheet sheet = w.getSheet(1);
			for (int i = 0; i < sheet.getRows(); i++){
				Cell cell_algorithm= sheet.getCell(0, i);
				if (cell_algorithm.getContents().equals(algorithm)){
					Cell cell_parameter=sheet.getCell(1, i);
					Cell cell_parameterType=sheet.getCell(2, i);
						if(cell_parameter.getContents().equals("")){}
						else{parameterMap.put(cell_parameter.getContents(),cell_parameterType.getContents());
						}	        		
					}
	        	}
			
		} catch (BiffException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Format Error: OptionAlgorithm.xlsx File ");
			//e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Fatal Error: OptionAlgorithm.xlsx File missing");
			//e.printStackTrace();
		}       
		
	}
	
	
}
