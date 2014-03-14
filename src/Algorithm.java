/**
 * 
 */

/**
 * @version 1.0
 * @author Shirley Yang 
 * 1/3/2014
 *
 */
public abstract class Algorithm {
	
	String AlgoName;
	Parameters paras;
	private static final double CHANGE_RATE = 0.2;
	private static final int VOLATILITY_NUMBER= 9;

	public Algorithm(Parameters paras) {
		AlgoName = "NoSpecificAlgorithm";
		this.paras = paras;
	}

	public double calculate(){
		// To be continued...
		return 0;
	}
	
	public double[][] calculateVolatility(){
		double[][] volatility = new double[VOLATILITY_NUMBER][2];
		double v = 0.2; //for experiment
		double n = v;		
		for (int i=(VOLATILITY_NUMBER+1)/2;i >= 0; i--){
			volatility[i][0]=n;
			volatility[i][1]=calculate();
			n=n*(1-CHANGE_RATE);
		}
		for (int i=(VOLATILITY_NUMBER+1)/2+1;i <=VOLATILITY_NUMBER ; i++){
			v=v*(1+CHANGE_RATE);
			volatility[i][0]=v;
			volatility[i][1]=calculate();
		}
		return volatility;
	}

}
