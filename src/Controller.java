import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
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
	
	private String optionName;
	private String algoName;
	private String filepath;
	private StringBuilder className;
	private Parameters paras;
	private double result;
	
	
//	public static void main(String[] args){
		
	/**
	 * 
	 */
	public Controller(String option, String algorithm, HashMap<String,String> paraUI) {

		this.optionName = option.replace(" ", "");
		this.algoName = algorithm.replace(" ", "");
		this.className = new StringBuilder("");
		this.className.append(this.optionName).append(this.algoName).append("Factory");
		int length = paraUI.size();
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
		this.filepath = "";
	}
	
	public Controller(String filepath, String option, String algorithm, HashMap<String,String> paraUI) {

		this.optionName = option.replace(" ", "");
		this.algoName = algorithm.replace(" ", "");
		this.className = new StringBuilder("");
		this.className.append(this.optionName).append(this.algoName).append("Factory");
		int length = paraUI.size();
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
		this.filepath = filepath;
	}
		
	public double calculate(){
		if(!this.filepath.equals("")){
		try {
			URL classUrl[] = {new URL(this.filepath)};
			URLClassLoader algoMatchLoader = new URLClassLoader(classUrl);
			Class algoMatch = algoMatchLoader.loadClass(this.className.toString());
			AlgorithmFactory af = (AlgorithmFactory) algoMatch.newInstance();
//			Class algoMatch = Class.forName(this.className.toString());
//			AlgorithmFactory af = (AlgorithmFactory) algoMatch.newInstance();
			this.result = af.calculate(this.optionName, paras);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		else{
			try {
				Class algoMatch = Class.forName(this.className.toString());
				AlgorithmFactory af = (AlgorithmFactory) algoMatch.newInstance();
				this.result = af.calculate(this.optionName, paras);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return this.result;
	}
	
	public void displayVolatilitySmile(){
		if(!this.filepath.equals("")){
			try {
				URL classUrl[] = {new URL(this.filepath)};
				URLClassLoader algoMatchLoader = new URLClassLoader(classUrl);
				Class algoMatch = algoMatchLoader.loadClass(this.className.toString());
				AlgorithmFactory af = (AlgorithmFactory) algoMatch.newInstance();
			double[][] vols = af.getVolatilities(this.optionName, paras);
			final VolatilitySmile vs=new VolatilitySmile("Volatility Smile",vols);
				vs.displayChart();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			try {
				Class algoMatch = Class.forName(this.className.toString());
				AlgorithmFactory af = (AlgorithmFactory) algoMatch.newInstance();
				double[][] vols = af.getVolatilities(this.optionName, paras);
				final VolatilitySmile vs=new VolatilitySmile("Volatility Smile",vols);
				vs.displayChart();
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
