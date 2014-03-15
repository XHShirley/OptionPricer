import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JTextField;


/**
 * 
 * @author Yiming
 *
 */

public class ValidityCheck {
	
	public static String checkOptionAlgorithm(String option, String algorithm){
		String ErrorMsg="0";
		if (option.equals("Options")) {ErrorMsg+="Choose Option;";}
		if (algorithm.equals("Algorithms")) {ErrorMsg+="Choose Algorithm;";}
		return ErrorMsg;
	}

	public static String check(ArrayList<JTextField> textFieldList, HashMap<String, String> parameterMap){
		
		String ErrorMsg="0";
		int i=0;
		for (String k: parameterMap.keySet()){
			
			switch (parameterMap.get(k)){
			case "d":
				try {
		            Double.parseDouble(textFieldList.get(i).getText()); 
		            Double d=Double.parseDouble(textFieldList.get(i).getText()); // To change integer to double
		            String s=String.valueOf(d);
		            parameterMap.put(k, s);
					i++;
					System.out.println(k);
					System.out.println(parameterMap.get(k));
		        }
		        catch(NumberFormatException e){
		        	ErrorMsg+=k+": Double;";
		        }
				break;
			case "i":
				try {
		            Integer.parseInt(textFieldList.get(i).getText()); 
		            parameterMap.put(k, textFieldList.get(i).getText());
					i++;
					System.out.println(k);
					System.out.println(parameterMap.get(k));
		        }
		        catch(NumberFormatException e){
		        	ErrorMsg+=k+": Integer;";
		        }
				break;
			default:
				break;	
			}
		}
		
		return ErrorMsg;
	}
}
