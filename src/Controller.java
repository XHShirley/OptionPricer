import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


/**
 * 
 */

/**
 * @version 1.0
 * @author Shirley Yang
 *1/3/2014
 */
public class Controller {
	
	String optionName;
	String algoName;
	String className;
	Parameters paras;
	
	
//	public static void main(String[] args){
		
	/**
	 * 
	 */
	public Controller(String option, String algorithm, HashMap<String,String> paraUI) {

		this.optionName = option;
		this.algoName = algoName;
		this.className = option.trim().concat(algorithm).concat("Factory");

		ArrayList<Parameter> paraTemp = new ArrayList(length);
		Iterator iterator = paraUI.entrySet().iterator();
		while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry) iterator.next();
            try{
            	int value = Integer.parseInt(entry.getValue().toString());
            	ParaInteger p = new ParaInteger(entry.getKey().toString(),value);
            	paraTemp.add(p);
            }catch(Exception e1){
            	try{
            		double value = Double.parseDouble(entry.getValue().toString());
            		ParaDouble p = new ParaDouble(entry.getKey().toString(),value);
            		paraTemp.add(p);
            	}catch(Exception e2){
            		e2.printStackTrace();
            		System.out.println("Invalid Type of Number!");
            	}
            }
        }
		
		this.paras = new Parameters(paraTemp);
	}
		
	public double calculate(){
		try {
			Class algoMatch = Class.forName(this.className);
			AlgorithmFactory af = (AlgorithmFactory) algoMatch.newInstance();
			Option op = af.createOption(this.optionName, paras);
			Algorithm al = af.createAlgorithm(paras);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}


}
