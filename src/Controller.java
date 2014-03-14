/**
 * 
 */

/**
 * @version 1.0
 * @author Shirley Yang
 *1/3/2014
 */
public class Controller {
	
	
//	public Contrller(Parameter para, Algorithm alg){
//		
//		alg.put(para);
//		
//	}
	
//	public double calculatePutValue()
	
	public static void main(String[] args){
		ParaOfBinomial paraBin = new ParaOfBinomial(50, 40, 0.1, 0.4,
				0.4167,500);
		AlgoBinomialTree algBin = new AlgoBinomialTree(paraBin);
		System.out.println("American or European: "+ algBin.put());
		
		ParaOfSimulation paraSim = new ParaOfSimulation(50, 40, 0.1, 0.4,1.0,500,100000);
		AlgoSimulation algSim = new AlgoSimulation(paraSim);
		System.out.println("Asian: "+ algSim.put());
		
		
		Class<?> c=Class.forName("AmericanPutBinomialTreeFactory");
		try{
		Option op = c.newInstance().createOption();
		}
		catch(Exception ex){
			throw ex;
		}
		

	}

}
