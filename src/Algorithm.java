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
	protected double result;
	protected double varVolatility;
	protected double[][] volatilities;
	protected static final double CHANGE_RATE = 0.2;
	protected static final int VOLATILITY_NUMBER= 9;

	public Algorithm(Parameters paras) {
		AlgoName = "NoSpecificAlgorithm";
		this.paras = paras;
		this.varVolatility=((ParaDouble)paras.getParas().get("volatility")).getValue();
		this.volatilities = new double[VOLATILITY_NUMBER][2];
	}

	protected abstract void calculate(double v);
	
	protected abstract double getResult();
	
	public int getVolatilityNumber(){
		return VOLATILITY_NUMBER;
	}
	
	public double[][] getVolatilities(){
		this.calculateVolatility();
		return volatilities;
	}
//	private void setVarVolatility(double v){
//		varVolatility = v;
//	}
	
	private void calculateVolatility(){
		double n = varVolatility;
		double interval=(CHANGE_RATE*n)/((VOLATILITY_NUMBER-1)/2);
		for (int i=(VOLATILITY_NUMBER-1)/2;i >= 0; i--){
			volatilities[i][0]=n;
			System.out.println(n);
			this.calculate(n);
			System.out.println(this.getResult());
			volatilities[i][1]=this.getResult();
			n=n-interval;
		}
		n = varVolatility;
		for (int i=(VOLATILITY_NUMBER-1)/2+1;i <VOLATILITY_NUMBER ; i++){
			n=n+interval;
			System.out.println(n);
			volatilities[i][0]=n;
			this.calculate(n);
			System.out.println(this.getResult());
			volatilities[i][1]=this.getResult();
		}
	}

}
